package com.topsuntech.gUnit.gEU_dict.utils;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryQuery;

public class WebUtility {

	/**
	 * 字典类型前缀
	 */
	private static String PREFFIX_DICTIONARY  = "dictionary";

	/**
	 * 机构后缀
	 */
	private static String POSTFIX_INSTITUTION = "INSTITUTION";

//	public final static String SCHEMA_NAME_BJBZ = "mjzz";

	/**
	 * 在request中存入某类数据字典列表(根据大类)
	 * 这样就可以在forward返回的jsp页面中就可以使用
	 * @param bigTypeCode 大类代码
	 * @param request
	 */
	public static void saveDictionarysToReq(String bigTypeCode,HttpServletRequest request) throws Exception{
		List re = DictionaryQuery.findDicnyByCode(bigTypeCode,null);
		//System.out.println("\n\n\n-------re:" + re.size());
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * 在request中存入某类数据字典列表(大小类)
	 * @param bigTypeCode 大类代码
	 * @param smallTypeCode 小类代码
	 * @param request
	 */
	public static void saveDictionarysToReq(String bigTypeCode,String smallTypeCode,HttpServletRequest request)throws Exception{
		List re = DictionaryQuery.findDicnyByCodeAndSubCode(bigTypeCode,smallTypeCode,null);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * 在request中存入某类数据字典列表(某机构的数据)
	 * @param bigTypeCode 大类代码
	 * @param institutionsId 机构代码
	 * @param request
	 */
	public static void saveInstDictionarysToReq(String bigTypeCode,String institutionsId,HttpServletRequest request)throws Exception{
		if(institutionsId == null) return;
		List re = DictionaryQuery.findDicnyByCode(bigTypeCode,institutionsId);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * 在request中存入某类数据字典列表(某机构的数据)
	 * @param bigTypeCode 大类代码
	 * @param smallTypeCode 小类代码
	 * @param institutionsId 机构代码
	 * @param request
	 */
	public static void saveInstDictionarysToReq(String bigTypeCode,String smallTypeCode,String institutionsId,HttpServletRequest request)throws Exception{
		if(institutionsId == null) return;
		List re = DictionaryQuery.findDicnyByCodeAndSubCode(bigTypeCode,smallTypeCode,institutionsId);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}




	/**
	 * 打印调试信息
	 * @param code
	 * @param list
	 */
	private static void debugPrint(String code,List list){
		Logger.debug("----debug: [bigTypeCode=" + code +"]列表\n " + list);
	}



}
