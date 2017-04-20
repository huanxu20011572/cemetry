/*
 * Created on 2005-9-21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.taglib;

/**
 * 
 * 
 * <p>
 * <a href="PageTag.java.html">View Source</a>
 * </p>
 * 
 * @see com.topsuntech.gUnit.gEU_util.taglib.PageTag
 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
 * @since 1.0
 * @version $Id: PageTag.java,v 1.1 2009/04/10 05:26:42 peiguangliang Exp $Revision: 1.1 $
 * 
 */
public class PageTag extends com.topsuntech.gOS.gTaglib.PageTag {

	public String createPageHeader() {
		this.setCanModifyPageSize(true);
		StringBuffer stringbuffer = new StringBuffer();
		stringbuffer.append("<form");
		stringbuffer.append(" name=\"" + p.toString() + "\"");
		stringbuffer.append(" action=\"" + u.toString() + "\" method=\"post\"");
		stringbuffer.append(" onsubmit=\"return f_page_onsubmit(this)\"");
		stringbuffer.append(">\n");
		stringbuffer.append("<td align=\"left\">\n");
		return stringbuffer.toString();
	}

	
	public String createPageScrolling() {
		int i = 0;
		int j = 0;
		if (y != null) {
			i = y.getCurrentPage();
			j = y.getPageCount();
		}

		StringBuffer stringbuffer = new StringBuffer();
		stringbuffer.append("<td align=\"right\">\n");

		int pageSize = y.getPageSize() > 0 ? y.getPageSize() : 0;
		int pageCount = y.getPageCount() > 0 ? y.getPageCount() : 0;
		int totalCount = y.getTotalCount() > 0 ? y.getTotalCount() : 0;

		stringbuffer.append("&nbsp;每页显示&nbsp;<input type='text' name='ps' value='" + pageSize
				+ "' size='4' class='input_txt' onchange='f_change_pageSize("+p+",this.value)'>&nbsp;条,共&nbsp;" + pageCount + "&nbsp;页&nbsp;");
		stringbuffer.append(totalCount + "&nbsp;条");

		if (i > 1) {
			stringbuffer.append("&nbsp;<input type='button' name='first' onclick=\"f_goto_page("
					+ p + ", 'first')\" value='首 页' class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='prev' onclick=\"f_goto_page(" + p
					+ ", 'prev')\" value='上页'  class='input_btn01' >");
		} else {
			stringbuffer.append("&nbsp;<input type='button' name='first' onclick=\"f_goto_page("
					+ p + ", 'first')\" value='首 页' disabled  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='prev' onclick=\"f_goto_page(" + p
					+ ", 'prev')\" value='上页' disabled  class='input_btn01' >");
		}

		if (i == 0) {
			stringbuffer.append("&nbsp;&nbsp;第<input type='text' name='to_page' value=" + i
					+ "  size='4' class='input_txt' disabled >页");
		} else {
			stringbuffer.append("&nbsp;&nbsp;第<input type='text' name='to_page' value=" + i
					+ "  size='4' class='input_txt' >页");
			stringbuffer.append("<button onclick=\"f_goto_page(" + p + ", " + p
					+ ".to_page.value);\" class='input_btn01'>转 到</button>\n");
		} 

		if (i < j) {
			stringbuffer.append("&nbsp;<input type='button' name='next' onclick=\"f_goto_page(" + p
					+ ", 'next')\" value='下 页'  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='last' onclick=\"f_goto_page(" + p
					+ ", 'last')\" value='末 页'  class='input_btn01' >");
		} else {
			stringbuffer.append("&nbsp;<input type='button' name='next' onclick=\"f_goto_page(" + p
					+ ", 'next')\" value='下 页' disabled  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='last' onclick=\"f_goto_page(" + p
					+ ", 'last')\" value='末 页' disabled  class='input_btn01' >");
		}

		stringbuffer.append("</td>\n");
		return stringbuffer.toString();
	}

}
