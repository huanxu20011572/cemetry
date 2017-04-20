package com.topsuntech.gUnit_gmgl.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @jdk版本:1.5
 * @编码时间:2007-4-12
 * @author BaiWeiMing
 */

public class PageConfig {
	
	static int DEFAULT_PAGE_SIZE = 10;
	static String DEFAULT_PAGE_NAME = "page";
	protected static final Log logger = LogFactory.getLog(PageConfig.class);

	public static Page getPage(HttpServletRequest request) {
		Page page = new Page();
		page.setPagenum(DEFAULT_PAGE_SIZE);
		page.setCurrentPage(getCurrentPage(request));
		return page;
	}

	/**
	 * 生成Page
	 * 
	 * @param request
	 * @param pageSize
	 *            :每页显示数量
	 * @return
	 */
	public static Page getPage(HttpServletRequest request, int pageSize) {
		Page page = new Page();
		if (pageSize > 0) {
			page.setPagenum(pageSize);
		} else {
			page.setPagenum(DEFAULT_PAGE_SIZE);
		}
		page.setCurrentPage(getCurrentPage(request));
		return page;
	}

	/**
	 * 通过页面传参,取当访问的是第几页
	 * 
	 * @param request
	 * @return
	 */
	protected static int getCurrentPage(HttpServletRequest request) {
		Object obj = request.getParameter(DEFAULT_PAGE_NAME);
		if (obj == null || obj.toString().length() <= 0) {
			return 1;
		}
		return Integer.parseInt(obj + "");
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
