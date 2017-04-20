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

		stringbuffer.append("&nbsp;ÿҳ��ʾ&nbsp;<input type='text' name='ps' value='" + pageSize
				+ "' size='4' class='input_txt' onchange='f_change_pageSize("+p+",this.value)'>&nbsp;��,��&nbsp;" + pageCount + "&nbsp;ҳ&nbsp;");
		stringbuffer.append(totalCount + "&nbsp;��");

		if (i > 1) {
			stringbuffer.append("&nbsp;<input type='button' name='first' onclick=\"f_goto_page("
					+ p + ", 'first')\" value='�� ҳ' class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='prev' onclick=\"f_goto_page(" + p
					+ ", 'prev')\" value='��ҳ'  class='input_btn01' >");
		} else {
			stringbuffer.append("&nbsp;<input type='button' name='first' onclick=\"f_goto_page("
					+ p + ", 'first')\" value='�� ҳ' disabled  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='prev' onclick=\"f_goto_page(" + p
					+ ", 'prev')\" value='��ҳ' disabled  class='input_btn01' >");
		}

		if (i == 0) {
			stringbuffer.append("&nbsp;&nbsp;��<input type='text' name='to_page' value=" + i
					+ "  size='4' class='input_txt' disabled >ҳ");
		} else {
			stringbuffer.append("&nbsp;&nbsp;��<input type='text' name='to_page' value=" + i
					+ "  size='4' class='input_txt' >ҳ");
			stringbuffer.append("<button onclick=\"f_goto_page(" + p + ", " + p
					+ ".to_page.value);\" class='input_btn01'>ת ��</button>\n");
		} 

		if (i < j) {
			stringbuffer.append("&nbsp;<input type='button' name='next' onclick=\"f_goto_page(" + p
					+ ", 'next')\" value='�� ҳ'  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='last' onclick=\"f_goto_page(" + p
					+ ", 'last')\" value='ĩ ҳ'  class='input_btn01' >");
		} else {
			stringbuffer.append("&nbsp;<input type='button' name='next' onclick=\"f_goto_page(" + p
					+ ", 'next')\" value='�� ҳ' disabled  class='input_btn01' >");
			stringbuffer.append("&nbsp;<input type='button' name='last' onclick=\"f_goto_page(" + p
					+ ", 'last')\" value='ĩ ҳ' disabled  class='input_btn01' >");
		}

		stringbuffer.append("</td>\n");
		return stringbuffer.toString();
	}

}
