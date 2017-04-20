/*
 * @创建时间: 2004-6-21
 * @作    者: 李星亮
 * @版    权: 北京同尚科技
 * @项目名称: 北京市殡葬管理系统
 */

package com.topsuntech.gUnit.gEU_dict.utils;

import com.topsuntech.gOS.applog.utility.Logger;
import com.topsuntech.gOS.applog.utility.PlatformID;
import com.topsuntech.gOS.user.session.UserSession;
import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述: 
 * 殡葬日志
 */

public class LoggerFactory {
    
    /**
     * 插入一条日志信息
     * @param modulename String 模块名
     * @param request HttpServletRequest 用于取用户ID。
     * @param operateType int 操作类型 see com.topsuntech.gOS.applog.utility.OperateType
     * @param info String 日志内容
     * @return boolean 返回操作是否成功
     * @see OperateType
     */
    public static boolean insertBzLog(String modulename, HttpServletRequest request,
                                 int operateType, String info) {
        return Logger.insert(PlatformID.BINZANG, modulename,
                             new Long(UserSession.getUserID(request)),
                             operateType, info);
    }
    
    /**
     * 插入一条日志信息
     * @param modulename String 模块名
     * @param request HttpServletRequest 用于取用户ID。
     * @param operateType int 操作类型 see com.topsuntech.gOS.applog.utility.OperateType
     * @param info String 日志内容
     * @return boolean 返回操作是否成功
     * @see OperateType
     */
    public static boolean insert(String schema,String modulename, HttpServletRequest request,
                                 int operateType, String info) {
        if("bjbz".equals(schema)){
            return Logger.insert(PlatformID.BINZANG, modulename,
                    new Long(UserSession.getUserID(request)),
                    operateType, info);
        }else if("bjjz".equals(schema)){
            return Logger.insert(PlatformID.JUANZENG, modulename,
                    new Long(UserSession.getUserID(request)),
                    operateType, info);
        }else if("bzzf".equals(schema)){
            //TODO  需要在appLogger中定义一个表示执法的常量
            return Logger.insert(PlatformID.BINZANG, modulename,
                    new Long(UserSession.getUserID(request)),
                    operateType, info);
        }
        return false;
    }
    

}
