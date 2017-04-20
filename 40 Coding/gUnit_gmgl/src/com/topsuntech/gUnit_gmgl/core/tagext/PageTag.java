package com.topsuntech.gUnit_gmgl.core.tagext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.topsuntech.gUnit_gmgl.core.Page;

/**
 * @author baiweiming
 */
public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = 2318139887896567285L;

	//from method
	private String method="post";
	
	//form action
	private String action;
	
	//page对象
	private Page page;

	//form name
	private String name ="eightPageForm";

	//form id
	private String id;
	
	//连接样式
	private String linkclass;
	
	//form提交page的名称
	private String pageName="page";

	public Page getPage() {
		return page;
	}

	public void setPage(Page page){
		this.page = page;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getLinkclass() {
		return linkclass;
	}

	public void setLinkclass(String linkclass) {
		this.linkclass = linkclass;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<form method='").append(getMethod()).append("' name='").append(getName()).append("' action='").append(getAction()).append("'>");
			buffer.append(getPageFormScript());
			buffer.append(getPageFormHtml());
			if (bodyContent != null) {
				buffer.append(bodyContent.getString());
			}
			buffer.append("</form>");
			try {
				pageContext.getOut().write(buffer.toString());
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

	private StringBuffer getPageFormScript(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<script>");
		//首页
		buffer.append("function firstpage(){");
		buffer.append("document.").append(getName()).append(".").append(getPageName()).append(".value = 1;");
		buffer.append("document.").append(getName()).append(".submit();");
		buffer.append("};");
		//上一页
		buffer.append("function upperpage(){");
		buffer.append("document.").append(getName()).append(".").append(getPageName()).append(".value = parseInt(document.").append(getName()).append(".").append(getPageName()).append(".value) - 1;");
		buffer.append("document.").append(getName()).append(".submit();");
		buffer.append("};");
		//下一页
		buffer.append("function nextpage(){");
		buffer.append("document.").append(getName()).append(".").append(getPageName()).append(".value = parseInt(document.").append(getName()).append(".").append(getPageName()).append(".value) + 1;");
		buffer.append("document.").append(getName()).append(".submit();");
		buffer.append("};");
		//末页
		buffer.append("function lastpage(){");
		buffer.append("document.").append(getName()).append(".").append(getPageName()).append(".value = ").append(page.getCountPage()).append(";");
		buffer.append("document.").append(getName()).append(".submit();");
		buffer.append("};");
		//跳转
		buffer.append("function gotopage(){");
		buffer.append("document.").append(getName()).append(".").append(getPageName()).append(".value = ").append("document.").append(getName()).append(".").append("pagenum").append(".value").append(";");
		buffer.append("document.").append(getName()).append(".submit();");
		buffer.append("};");
		
		buffer.append("</script>");
		
		return buffer;
	}

	private StringBuffer getPageFormHtml(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<input type='hidden' id='").append(getPageName()).append("' name='").append(getPageName()).append("' value='").append(page.getCurrentPage()).append("' />");
		buffer.append("<a ");
		if(StringUtils.isNotBlank(getLinkclass())){
			buffer.append("class='"+getLinkclass()+"'");
		}
		buffer.append(" href='javascript:firstpage();'>首页</a>");
		buffer.append("&nbsp;&nbsp;");
		buffer.append("<a ");
		if(StringUtils.isNotBlank(getLinkclass())){
			buffer.append("class='"+getLinkclass()+"'");
		}
		buffer.append(" href='javascript:upperpage();'>上一页</a>");
		buffer.append("&nbsp;&nbsp;");
		buffer.append("<a ");
		if(StringUtils.isNotBlank(getLinkclass())){
			buffer.append("class='"+getLinkclass()+"'");
		}
		buffer.append(" href='javascript:nextpage();'>下一页</a>");
		buffer.append("&nbsp;&nbsp;");
		buffer.append("<a ");
		if(StringUtils.isNotBlank(getLinkclass())){
			buffer.append("class='"+getLinkclass()+"'");
		}
		buffer.append(" href='javascript:lastpage();'>末页</a>");
		buffer.append("&nbsp;&nbsp;");
		buffer.append("跳转：");
		buffer.append("<select name='pagenum' id='pagenum' onchange='gotopage()'>");
		for (int i = 1; i <= page.getCountPage(); i++) {
			buffer.append("<option value='"+i+"'");
			if(i == page.getCurrentPage()){
				buffer.append(" selected='selected' ");
			}
			buffer.append(">"+i+"</option>");
		}
		buffer.append("</select>");
		buffer.append("&nbsp;&nbsp;");
		
		return buffer;
	}
}
