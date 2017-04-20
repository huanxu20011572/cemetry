/*
 * Created on 2004-5-20
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.topsuntech.gUnit.gEU_dict.service;

import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;

/**
 * @author ÉÛ¾µÔó
 *
 * @ ApplicationDevelopment@topsunTech.com
 * @ Project No. TP200308
 * @ Version 1.0 
 */
public class DictDAOFactory {
	
	/**
	 * È±Ê¡µÄschemaÃû×Ö
	 */
	public final static String SCHEMA_NAME_DICT = "gos";
	
	private static DictDAOFactory dictDaof = null;
	private DBWrapper db = null;
	private DictDAOFactory() {
	}

	/**
	 *
	 * @return DonationDAOFactory
	 */
	public static DictDAOFactory getInstance() {
		if(dictDaof != null){
			return dictDaof;
		}
			
		return new DictDAOFactory();
	}

	public DBWrapper getDBWrapper() {
		if(db != null)
			return db;
		return DBRegistry.getDBWrapper(SCHEMA_NAME_DICT);
	}
}
