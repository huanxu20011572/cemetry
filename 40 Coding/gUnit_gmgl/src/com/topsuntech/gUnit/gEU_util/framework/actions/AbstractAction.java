/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.framework.actions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_system.framework.vo.LoginAttribute;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;
import com.topsuntech.gUnit.gEU_util.vo.AreaInfo;

/**
 * @author zcpeng
 * 
 */
public class AbstractAction extends DispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.execute(mapping, form, request, response);
	}

	/**
	 * ����ת��(String -> String)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected String getString(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null)
			return "";
		else
			return result;
	}

	protected String[] getStrings(HttpServletRequest request, String parameter) {
		return request.getParameterValues(parameter);
	}

	/**
	 * ����ת��(String -> Long)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Long getLong(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null || result.equals(""))
			return new Long(0);
		else
			return new Long(result);
	}

	protected Long[] getLongs(HttpServletRequest request, String parameter) {
		String[] result = request.getParameterValues(parameter);
		if (result != null) {
			Long[] r = new Long[result.length];
			for (int i = 0; i < r.length; i++) {
				if (result[i] == null || result[i].equals(""))
					r[i] = null;
				else
					r[i] = new Long(result[i]);
			}
			return r;
		}
		return null;
	}

	/**
	 * ����ת��(String -> Long) ����null
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Long getLongReturnNull(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null || result.equals("") || result.equals("null"))
			return null;
		else
			return new Long(result);
	}

	/**
	 * ����ת��(String -> Short)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Short getShort(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null)
			return new Short((short) 0);
		else
			return new Short(result);
	}

	/**
	 * ����ת��(String -> Byte)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Byte getByte(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null)
			return new Byte((byte) 0);
		else
			return new Byte(result);
	}

	/**
	 * ����ת��(String -> Double)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Double getDouble(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null || result.equals(""))
			return new Double(0);
		else
			return new Double(result);
	}

	protected Double[] getDoubles(HttpServletRequest request, String parameter) {
		String[] result = request.getParameterValues(parameter);
		if (result != null) {
			Double[] r = new Double[result.length];
			for (int i = 0; i < r.length; i++)
				if (result[i] == null || result[i].equals(""))
					r[i] = null;
				else
					r[i] = new Double(result[i]);
			return r;
		}
		return null;
	}

	/**
	 * ����ת��(String -> Float)
	 * 
	 * @param request
	 * @param parameter
	 * @return
	 */
	protected Float getFloat(HttpServletRequest request, String parameter) {
		String result = request.getParameter(parameter);
		if (result == null)
			return new Float(0);
		else
			return new Float(result);
	}

	/**
	 * ����ת��(String -> Date) yyyy-MM-dd
	 * 
	 * @param request
	 * @param dateStr
	 * @return
	 */
	protected static Date getDate(HttpServletRequest request, String dateStr) {
		String result = request.getParameter(dateStr);
		if (result == null)
			return new Date();
		else {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd");
			try {
				return sdf.parse(result);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	/**
	 * �׳���ʾ��Ϣ
	 * 
	 * @param actionMapping
	 * @param request
	 * @param messageKey
	 *            ��ʾ��Ϣ��ʶ
	 * @param messageForward
	 *            ��ת��ʶ
	 * @param values
	 *            ��ʾ��Ϣ������������Ӧproperties�ļ�����message={0}���������
	 * @return
	 */
	protected ActionForward message(ActionMapping actionMapping, HttpServletRequest request, String messageKey, String messageForward, Object[] values) {
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey, values));
		saveMessages(request, messages);
		return actionMapping.findForward(messageForward);

	}

	/**
	 * ��ҳ���ϵĶ�̬����ȡָ����ֵ,��ֵ�ĸ�ʽΪ'value1,value2,....,valueN'
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	protected List getDynamicFormValue(HttpServletRequest request, String parameterName) {
		String[] values = request.getParameterValues(parameterName);
		if (values != null) {
			List result = new ArrayList();
			for (int i = 0; i < values.length; i++) {
				String[] value = values[i].split(",");
				result.add(value);
			}
			return result;
		}
		return null;
	}

	/**
	 * ���������д����ĸ�����Ϣ
	 * 
	 * @param object
	 * @param user
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected static void setAreaInfo(Object object, AreaInfo areaInfo) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method setProvinceId = object.getClass().getMethod("setProvinceId", new Class[] { Long.class });
		Method setCityId = object.getClass().getMethod("setCityId", new Class[] { Long.class });
		Method setCountyId = object.getClass().getMethod("setCountyId", new Class[] { Long.class });
		Method setStreetId = object.getClass().getMethod("setStreetId", new Class[] { Long.class });
		Method setCommunityId = object.getClass().getMethod("setCommunityId", new Class[] { Long.class });
		setProvinceId.invoke(object, new Object[] { areaInfo.getProvinceId() });
		setCityId.invoke(object, new Object[] { areaInfo.getCityId() });
		setCountyId.invoke(object, new Object[] { areaInfo.getCountyId() });
		setStreetId.invoke(object, new Object[] { areaInfo.getStreetId() });
		setCommunityId.invoke(object, new Object[] { areaInfo.getCommunityId() });
	}

	/*
	 * create_data:20081215 create_user:lxr desc: �ϲ�����ȡ���'baseAction'
	 */

	// ��ȡϵͳ��ʶ
	protected String getSysTemFlag(HttpServletRequest request) throws TSDBException {
		String sysFlag = "";

		Object obj = getSession(request, "sysTemFlag");
		if (obj != null)
			sysFlag = obj.toString();

		return sysFlag;
	}

	/**
	 * ����session
	 * 
	 * @param request
	 * @param objectName
	 * @param obj
	 */
	protected void buildSession(HttpServletRequest request, String objectName, Object obj) {
		request.getSession().setAttribute(objectName, obj);
	}

	/**
	 * ��ȡsession
	 * 
	 * @param request
	 * @param sessionName
	 * @return
	 */
	protected Object getSession(HttpServletRequest request, String sessionName) {
		Object obj = request.getSession().getAttribute(sessionName);
		return obj;
	}

	/**
	 * ���session
	 * 
	 * @param request
	 * @param objSession
	 */
	protected void clearSession(HttpServletRequest request, String objSession) {
		request.getSession().removeAttribute(objSession);
	}

	/**
	 * ��ȡ��ǰ��'��¼�û�'
	 * 
	 * @param request
	 * @return
	 */
	protected User getUser(HttpServletRequest request) {
		User user = UserSession.getUser(request);
		return user;
	}

	/**
	 * ��ȡ��ǰ��'������Ϣ'
	 * 
	 * @param request
	 * @return
	 */
	protected Office getDept(HttpServletRequest request) {
		Office off = UserSession.getUserDept(request);
		return off;
	}

	/**
	 * ��ȡ��ǰ��'��¼��ɫ'
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	protected long getRole(HttpServletRequest request) {
		long role = -1;
		User user = getUser(request);
		if (user != null)
			try {
				role = Dicts.judgeRoleById(user.getDeptid());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return role;
	}

	/**
	 * ��ȡ"ϵͳ��¼��Ϣ"
	 * 
	 * @param request
	 * @return
	 */
	protected LoginAttribute getLoginAttribute(HttpServletRequest request) {
		LoginAttribute att = new LoginAttribute();
		Object obj = getSession(request, "LoginAttribute");
		if (obj != null)
			att = (LoginAttribute) obj;

		return att;
	}

	/**
	 * ��ʾ��ʾ��Ϣ
	 * 
	 * @param actionMapping
	 * @param request
	 * @param errType
	 *            '�������'
	 * @param flag
	 *            ��ʶ��0���ɹ�ҳ����ʾ��1��ʧ��ҳ����ʾ��2��javascript�ű�ʾ��ʾ
	 * @return
	 */
	protected ActionForward turnToMessage(ActionMapping actionMapping, HttpServletRequest request, String errType, long flag) {

		ActionErrors errors = new ActionErrors();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(errType));
		saveErrors(request, errors);

		if (flag == 0)
			return actionMapping.findForward("success");
		else if (flag == 1)
			return actionMapping.findForward("error");
		else
			return actionMapping.findForward("errorRefresh");
	}

}
