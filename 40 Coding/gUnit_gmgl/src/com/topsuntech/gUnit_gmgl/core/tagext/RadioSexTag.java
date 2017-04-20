/**
 * 性别 Radio控件男1，女0
 */
package com.topsuntech.gUnit_gmgl.core.tagext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * @author baiweiming
 */
public class RadioSexTag extends BodyTagSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5385856139916144449L;

	protected static final Log logger = LogFactory.getLog(RadioSexTag.class);

	// 设置select名称和id
	private String name = null;
	// 设置选中的值
	private Object checked = null;


	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(Object checked) throws JspException {
		if (checked != null) {
			this.checked = ExpressionEvaluatorManager.evaluate("checked",
					checked.toString(), Object.class, this, pageContext);
		} else {
			this.checked = checked;
		}
	}

	public int doEndTag() throws JspException {

		try {
			pageContext.getOut().write(getRadioHtml().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 获取性别radio
	 * 
	 * @param type1
	 * @return
	 */
	private StringBuffer getRadioHtml() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<input name=\"" + name + "\" id=\"" + name + "\" type=\"radio\" ");
		if("1".equals(checked)){
			buffer.append("checked =\"checked\" ");
		}
		buffer.append("value=\"1\" />男");
		buffer.append("<input name=\"" + name + "\" id=\"" + name + "\" type=\"radio\"  ");
		if("0".equals(checked)){
			buffer.append("checked =\"checked\" ");
		}
		buffer.append("value=\"0\" />女");
		return buffer;
	}

	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;

	}

}
