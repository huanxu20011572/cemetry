package com.topsuntech.gUnit_gmgl.core.tagext;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;

import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

/**
 * @author baiweiming
 * 
 */
public class DictTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254747518777347919L;

	protected static final Log logger = LogFactory.getLog(DictTag.class);

	// 获取值
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doEndTag() throws JspException {
		String name = getDictNameByCode();

		try {
			pageContext.getOut().write(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 根据字典Code获取名称
	 * 
	 * @return
	 */
	private String getDictNameByCode() {

		DictService dictService = (DictService) ContextLoader.getCurrentWebApplicationContext().getBean("dictService");
		List<Dict> dict = dictService.getDictByCode(getValue());
		if (dict != null && dict.size()>0) {
			return dict.get(0).getDictName();
		} else {
			return "";
		}
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;

	}

}
