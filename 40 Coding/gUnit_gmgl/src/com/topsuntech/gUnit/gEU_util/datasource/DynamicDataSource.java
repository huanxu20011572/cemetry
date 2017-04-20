/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.topsuntech.gUnit.gEU_util.holder.DynamicDataSourceHolder;

/**
 * @author zcpeng
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	 * determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DynamicDataSourceHolder.getDataSourceName();
	}

}
