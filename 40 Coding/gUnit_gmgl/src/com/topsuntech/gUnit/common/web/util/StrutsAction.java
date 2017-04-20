package com.topsuntech.gUnit.common.web.util;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.topsuntech.gUnit.common.web.util.strutsSupport.DateConverter;
import com.topsuntech.gUnit.common.web.util.strutsSupport.StringConverter;

public  class StrutsAction extends DispatchAction {
	static {
		registConverter();
	}	
	public Object getBean(HttpServletRequest request,String name) {
		ApplicationContext ctx = WebApplicationContextUtils
		.getRequiredWebApplicationContext(request.getSession().getServletContext());

		return ctx.getBean(name);
	}
	/**
	 * ����Struts ������<->�ַ���ת�����ַ���Ϊ��ֵʱ,����Ĭ��Ϊnull��������0,�ַ���ת������,�ַ���ת��ʱ���.
	 */
	public static void registConverter() {
		ConvertUtils.register(new StringConverter(), String.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new ByteConverter(null), Byte.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new DateConverter(), Date.class);
		}

	/**
	 * ��FormBean�е�����ͨ��BeanUtils��copyProperties()�󶨵�Object��.
	 * ��ΪBeanUtils������������˳������׸����˷�װ�˺���.
	 */
	protected void bindEntity(ActionForm form, Object object) {
		if (form != null) {
			try {
				BeanUtils.copyProperties(object, form);
			} catch (Exception e) {	
				e.printStackTrace();
				ReflectionUtils.handleReflectionException(e);
				
			}
		}
	}

	/**
	 * ��Object����ͨ��BeanUtils��copyProperties ���Ƶ�FormBean��.
	 * ��ΪBeanUtils������������˳������׸����˷�װ�˺�����
	 */
	protected void bindForm(ActionForm form, Object object) {
		if (object != null) {
			try {
				BeanUtils.copyProperties(form, object);
			} catch (Exception e) {
				ReflectionUtils.handleReflectionException(e);
			}
		}
	}

	
	/**
	 * ֱ�����.
	 * @param contentType
	 *        ���ݵ�����.html,text,xml��ֵ����jsonΪ"text/x-json;charset=UTF-8"
	 */
	protected void render(HttpServletResponse response, String text,
			String contentType) {
		try {
			
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			//log.error(e.getMessage(), e);
		}
	}

	/**
	 * ֱ��������ַ���.
	 */
	protected void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=GBK");
	}
	/**
	 * ֱ��������ַ���.
	 */
	protected void renderJson(HttpServletResponse response, String text) {	
		render(response, text, "text/json;charset=GBK");
	}
	/**
	 * ֱ�������HTML.
	 */
	protected void renderHtml(HttpServletResponse response, String text) {
		render(response, text, "text/html;charset=GBK");
	}

	/**
	 * ֱ�������XML.
	 */
	protected void renderXML(HttpServletResponse response, String text) {
		render(response, text, "text/xml;charset=GBK");
	}
}
