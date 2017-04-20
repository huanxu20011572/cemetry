/**
 *SKIP_BODY ： 跳过了开始和结束标签之间的代码,一般是在doStartTag中使用 
 *EVAL_BODY_INCLUDE ：处理嵌套的标签,一般是在doStartTag中使用,由负责处理标签正文的tag接口提供 
 *EVAL_BODY_BUFFERED :对包含的内容进行解析 一般是在doStartTag中使用,由负责处理标签正文的bodyTag接口提供,目的是通知jsp容器作好读取正文的工作(创建一个body-content包装正文和获取存放操作结果的out对象,便于以后的操作和输出). 
 *EVAL_BODY_AGAIN:处理标签正文,嵌套标签的iteratorTag接口的使用 
 *SKIP_PAGE ： 忽略剩下的页面,一般是在doEndTag中使用 
 *EVAL_PAGE ： 继续执行下面的页, 一般是在doEndTag中使用
 */
package com.topsuntech.gUnit_gmgl.core.tagext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.topsuntech.gUnit_gmgl.core.Page;

/**
 * @author baiweiming
 */
public class PageInfoTag extends BodyTagSupport {

	private static final long serialVersionUID = -8173115481156163324L;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page){
		this.page = page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
			try {
				pageContext.getOut().write(getPageInfo().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		return EVAL_PAGE;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}

	private StringBuffer getPageInfo(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("共");
		buffer.append(page.getTotalCount());
		buffer.append("条记录");
		buffer.append("&nbsp;&nbsp;");
		buffer.append(page.getCurrentPage());
		buffer.append("/");
		buffer.append(page.getCountPage());
		buffer.append("页");
		return buffer;
	}

}
