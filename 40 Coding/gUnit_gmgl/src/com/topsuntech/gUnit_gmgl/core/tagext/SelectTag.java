/**
 * SKIP_BODY ： 跳过了开始和结束标签之间的代码,一般是在doStartTag中使用 
 * EVAL_BODY_INCLUDE ：处理嵌套的标签,一般是在doStartTag中使用,由负责处理标签正文的tag接口提供 
 * EVAL_BODY_BUFFERED :对包含的内容进行解析 一般是在doStartTag中使用,由负责处理标签正文的bodyTag接口提供,目的是通知jsp容器作好读取正文的工作(创建一个body-content包装正文和获取存放操作结果的out对象,便于以后的操作和输出). 
 * EVAL_BODY_AGAIN:处理标签正文,嵌套标签的iteratorTag接口的使用 
 * SKIP_PAGE ： 忽略剩下的页面,一般是在doEndTag中使用 
 * EVAL_PAGE ： 继续执行下面的页, 一般是在doEndTag中使用
 */
package com.topsuntech.gUnit_gmgl.core.tagext;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.springframework.web.context.ContextLoader;

import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

/**
 * @author baiweiming
 */
public class SelectTag extends BodyTagSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8560746784103728278L;

	protected static final Log logger = LogFactory.getLog(SelectTag.class);

	// 设置select名称和id
	private String name = null;
	// 设置选中的值
	private Object selected = null;

	private String type;

	private String onchange;
	
	private String selectclass;
	
	private String style; 

	public void setSelectclass(String selectclass) {
		this.selectclass = selectclass;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	public void setOnchange(String onchange){
		this.onchange = onchange;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setSelected(Object selected) throws JspException {
		if (selected != null) {
			this.selected = ExpressionEvaluatorManager.evaluate("selected",
					selected.toString(), Object.class, this, pageContext);
		} else {
			this.selected = selected;
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public int doEndTag() throws JspException {

		if (StringUtils.isNotEmpty(this.type)) {
			StringBuffer buffer = null;
				buffer = getDictionarySelectHtml(this.type);
			try {
				pageContext.getOut().write(buffer.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;
	}

	/**
	 * 获取字典里的内容
	 * 
	 * @param type1
	 * @return
	 */
	private StringBuffer getDictionarySelectHtml(String code) {
		StringBuffer buffer = new StringBuffer();
		// 获取spring配置中当前WebApplicationContext的bean
		DictService dictService = (DictService) ContextLoader.getCurrentWebApplicationContext().getBean(
						"dictService");

		List<Dict> dictionaries = dictService.getDictByCode(code);
		buffer.append("<select name=\"" + name+"\" "); 
		if(StringUtils.isNotEmpty(this.onchange)){
			buffer.append("onchange=\"" + onchange +"\" ");
		}
		if(StringUtils.isNotEmpty(this.selectclass)){
			buffer.append("class=\"" + selectclass+"\" ");
		}
		if(StringUtils.isNotEmpty(this.style)){
			buffer.append("style=\"" + style+"\" ");
		}
		buffer.append("id=\"" + name + "\" >");
		if (bodyContent != null) {
			buffer.append(bodyContent.getString());
		}
		buffer.append("<option value=\"-1\">---请选择---</option>");
		
		// 如果dictionaries有值，则在页面中显示出来
		if (dictionaries !=null && dictionaries.size()>0 && dictionaries.get(0).getChildren() != null) {
			for (Iterator<Dict> iterator = dictionaries.get(0).getChildren().iterator(); iterator
					.hasNext();) {
				Dict dict = (Dict) iterator.next();
				buffer.append("<option value=\"" + dict.getDictCode()+ "\"");
				// 如果selected有值，则在页面中设置选中态状
				if (selected != null
						&& selected.toString().equals(
								dict.getDictCode().toString())) {
					buffer.append(" selected ");
				}
				buffer.append(" >" + dict.getDictName() + "</option>");
			}
		}

		buffer.append("</select>");
		return buffer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;

	}

}
