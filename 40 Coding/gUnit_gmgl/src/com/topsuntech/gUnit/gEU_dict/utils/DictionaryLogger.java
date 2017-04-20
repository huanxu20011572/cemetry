/*
 * @创建时间: 2004-6-21
 * @作    者: 邵镜泽
 * @版    权: 北京同尚科技
 * @项目名称: 民政部民间组织网；
 */

package com.topsuntech.gUnit.gEU_dict.utils;

import javax.servlet.http.HttpServletRequest;



/**
 * 功能描述: 
 * 信息发布日志
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
        String moduleName = "数据字典管理模块";
        //栏目名称
        return LoggerFactory.insert(MODULE_TYPE,moduleName,request,operateType,info);
    }
}
