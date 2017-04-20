package com.topsuntech.gUnit.gEU_dict.utils;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryQuery;

public class WebUtility {

	/**
	 * �ֵ�����ǰ׺
	 */
	private static String PREFFIX_DICTIONARY  = "dictionary";

	/**
	 * ������׺
	 */
	private static String POSTFIX_INSTITUTION = "INSTITUTION";

//	public final static String SCHEMA_NAME_BJBZ = "mjzz";

	/**
	 * ��request�д���ĳ�������ֵ��б�(���ݴ���)
	 * �����Ϳ�����forward���ص�jspҳ���оͿ���ʹ��
	 * @param bigTypeCode �������
	 * @param request
	 */
	public static void saveDictionarysToReq(String bigTypeCode,HttpServletRequest request) throws Exception{
		List re = DictionaryQuery.findDicnyByCode(bigTypeCode,null);
		//System.out.println("\n\n\n-------re:" + re.size());
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * ��request�д���ĳ�������ֵ��б�(��С��)
	 * @param bigTypeCode �������
	 * @param smallTypeCode С�����
	 * @param request
	 */
	public static void saveDictionarysToReq(String bigTypeCode,String smallTypeCode,HttpServletRequest request)throws Exception{
		List re = DictionaryQuery.findDicnyByCodeAndSubCode(bigTypeCode,smallTypeCode,null);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * ��request�д���ĳ�������ֵ��б�(ĳ����������)
	 * @param bigTypeCode �������
	 * @param institutionsId ��������
	 * @param request
	 */
	public static void saveInstDictionarysToReq(String bigTypeCode,String institutionsId,HttpServletRequest request)throws Exception{
		if(institutionsId == null) return;
		List re = DictionaryQuery.findDicnyByCode(bigTypeCode,institutionsId);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}

	/**
	 * ��request�д���ĳ�������ֵ��б�(ĳ����������)
	 * @param bigTypeCode �������
	 * @param smallTypeCode С�����
	 * @param institutionsId ��������
	 * @param request
	 */
	public static void saveInstDictionarysToReq(String bigTypeCode,String smallTypeCode,String institutionsId,HttpServletRequest request)throws Exception{
		if(institutionsId == null) return;
		List re = DictionaryQuery.findDicnyByCodeAndSubCode(bigTypeCode,smallTypeCode,institutionsId);
		debugPrint(bigTypeCode,re);
		request.setAttribute((PREFFIX_DICTIONARY + bigTypeCode),re);
	}




	/**
	 * ��ӡ������Ϣ
	 * @param code
	 * @param list
	 */
	private static void debugPrint(String code,List list){
		Logger.debug("----debug: [bigTypeCode=" + code +"]�б�\n " + list);
	}



}
