/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.holder;

/**
 * @author zcpeng
 * 
 */
public class DynamicDataSourceHolder {
	private final static ThreadLocal<String> holder = new ThreadLocal<String>();

	public static String getDataSourceName() {
		return holder.get();
	}

	public static void setDataSourceName(String dataSourceName) {
		holder.set(dataSourceName);
	}
}
