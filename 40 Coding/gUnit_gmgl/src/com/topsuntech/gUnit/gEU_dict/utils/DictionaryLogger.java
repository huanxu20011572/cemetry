/*
 * @����ʱ��: 2004-6-21
 * @��    ��: �۾���
 * @��    Ȩ: ����ͬ�пƼ�
 * @��Ŀ����: �����������֯����
 */

package com.topsuntech.gUnit.gEU_dict.utils;

import javax.servlet.http.HttpServletRequest;



/**
 * ��������: 
 * ��Ϣ������־
 */

public class DictionaryLogger {

    private static final String MODULE_TYPE = "dictionary";
    /**
     * 
     * @author solare
     *
     * TODO To change the template for this generated type comment go to
     * Window - Preferences - Java - Code Style - Code Templates
     */
    public static boolean insertLog(HttpServletRequest request,int operateType,String info){
        String moduleName = "�����ֵ����ģ��";
        //��Ŀ����
        return LoggerFactory.insert(MODULE_TYPE,moduleName,request,operateType,info);
    }
}
