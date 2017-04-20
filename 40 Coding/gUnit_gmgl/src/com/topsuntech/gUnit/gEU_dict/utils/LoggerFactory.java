/*
 * @����ʱ��: 2004-6-21
 * @��    ��: ������
 * @��    Ȩ: ����ͬ�пƼ�
 * @��Ŀ����: �������������ϵͳ
 */

package com.topsuntech.gUnit.gEU_dict.utils;

import com.topsuntech.gOS.applog.utility.Logger;
import com.topsuntech.gOS.applog.utility.PlatformID;
import com.topsuntech.gOS.user.session.UserSession;
import javax.servlet.http.HttpServletRequest;

/**
 * ��������: 
 * ������־
 */

public class LoggerFactory {
    
    /**
     * ����һ����־��Ϣ
     * @param modulename String ģ����
     * @param request HttpServletRequest ����ȡ�û�ID��
     * @param operateType int �������� see com.topsuntech.gOS.applog.utility.OperateType
     * @param info String ��־����
     * @return boolean ���ز����Ƿ�ɹ�
     * @see OperateType
     */
    public static boolean insertBzLog(String modulename, HttpServletRequest request,
                                 int operateType, String info) {
        return Logger.insert(PlatformID.BINZANG, modulename,
                             new Long(UserSession.getUserID(request)),
                             operateType, info);
    }
    
    /**
     * ����һ����־��Ϣ
     * @param modulename String ģ����
     * @param request HttpServletRequest ����ȡ�û�ID��
     * @param operateType int �������� see com.topsuntech.gOS.applog.utility.OperateType
     * @param info String ��־����
     * @return boolean ���ز����Ƿ�ɹ�
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
            //TODO  ��Ҫ��appLogger�ж���һ����ʾִ���ĳ���
            return Logger.insert(PlatformID.BINZANG, modulename,
                    new Long(UserSession.getUserID(request)),
                    operateType, info);
        }
        return false;
    }
    

}
