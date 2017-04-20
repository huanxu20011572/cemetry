package com.topsuntech.gUnit_gmgl.core;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author BaiWeiMing
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -6177482756023380395L;

	// 每页显示条数
	private int pagenum = 10;

	// 总页数
	private int countPage = 0;

	// 当前页
	private int currentPage = 0;

	// 总条数
	private int totalCount = 0;

	/**
	 * 计算总页数
	 */
	public void buildCountPage() {
		if (totalCount % pagenum == 0) {
			countPage = totalCount / pagenum;
		} else {
			countPage = totalCount / pagenum + 1;
		}
	}

	/**
	 * 
	 * @return the countPage
	 */
	public int getCountPage() {
		return countPage;
	}

	/**
	 * @param countPage
	 *            the countPage to set
	 */
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	/**
	 * 如果当前页超过页数范围，重置当前页数
	 * 
	 */
	public void buildCurrentPage() {
		buildCountPage();
		if (currentPage > countPage) {
			currentPage = countPage;
		} else if (currentPage < 1) {
			currentPage = 1;
		}

	}

	/**
	 * 
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPagenum() {
		return pagenum;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		buildCurrentPage();
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
