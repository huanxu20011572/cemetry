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
	 * 设置Struts 中数字<->字符串转换，字符串为空值时,数字默认为null，而不是0,字符串转换日期,字符串转换时间戳.
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
	 * 将FormBean中的内容通过BeanUtils的copyProperties()绑定到Object中.
	 * 因为BeanUtils中两个参数的顺序很容易搞错，因此封装此函数.
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
	 * 将Object内容通过BeanUtils的copyProperties 复制到FormBean中.
	 * 因为BeanUtils中两个参数的顺序很容易搞错，因此封装此函数。
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
	 * 直接输出.
	 * @param contentType
	 *        内容的类型.html,text,xml的值见后，json为"text/x-json;charset=UTF-8"
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
	 * 直接输出纯字符串.
	 */
	protected void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=GBK");
	}
	/**
	 * 直接输出纯字符串.
	 */
	protected void renderJson(HttpServletResponse response, String text) {	
		render(response, text, "text/json;charset=GBK");
	}
	/**
	 * 直接输出纯HTML.
	 */
	protected void renderHtml(HttpServletResponse response, String text) {
		render(response, text, "text/html;charset=GBK");
	}

	/**
	 * 直接输出纯XML.
	 */
	protected void renderXML(HttpServletResponse response, String text) {
		render(response, text, "text/xml;charset=GBK");
	}
}
