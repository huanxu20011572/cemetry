/*
 * Created on 2007-11-17
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.framework.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_system.framework.actionforms.SjUserForm;
import com.topsuntech.gUnit.gEU_system.service.UserService;
import com.topsuntech.gUnit.gEU_system.service.vo.UserQueryBean;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

/**
 * @author lixirong
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class SjLoginAction extends DispatchAction {

	/**
	 * �����û��û���������жϣ����û����ĸ��Ż��ģ�Ŀǰ�����Ż��죺 1 �м��Ż� 2 �����Ż� 3 �ֵ��Ż� 4��ҵ�Ż�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryLogin(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// added by pengzuocong 2012-5-30
		// ����ϵͳ�л�����Դ
		String systemFlag = request.getParameter("systemFlag");
		HttpSession session = request.getSession();
		if (systemFlag != null && !"".equals(systemFlag.trim())) {
			// �������µ�ϵͳ��ʶ���滻��ǰ��ϵͳ��ʶ
			session.setAttribute("systemFlag", systemFlag);
		}
		/// session jia zai 
		if(request.getSession().getAttribute("userOpRoleMap") != null){
			request.getSession().removeAttribute("userOpRoleMap");
		}
		
//		if("tjbz".equals(systemFlag.trim())){
//			//��ѯ����Ȩ��
//			UserOpRoleQueryBean uorqb = new UserOpRoleQueryBean();
//			uorqb.setUserid(((User) request.getSession().getAttribute("loginUser")).getId());
//			uorqb.setUse_flag(Constants.USE_FLAG.USE_FLAG_ON.longValue());
//			uorqb.setSysflag(systemFlag);
//			Hashtable<Long, UserOpRole> userOpRoleMap  = TjbzDicts.getUserOpRoleByUserId(uorqb);
//			request.getSession().setAttribute("userOpRoleMap",userOpRoleMap );
//		}
		return actionMapping.findForward("success");
	}

	/**
	 * �û�������ѯ�û��б�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryUser(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		SjUserForm form = (SjUserForm) actionForm;

		UserQueryBean bean = new UserQueryBean();
		PropertyUtils.copyProperties(bean, form);

		List userList = UserService.getUserList(bean);
		request.setAttribute("userList", userList);

		return actionMapping.findForward("success");
	}

	/**
	 * ת���Ż�ҳ��
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward portal(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Office office = UserSession.getUserDept(request);
		if (office != null) {
			if (office.getLevelid() == Constants.AREA_LEVEL.STREET) {
				return actionMapping.findForward("street_portal");
			} else if (office.getLevelid() == Constants.AREA_LEVEL.COUNTRY) {
				return actionMapping.findForward("country_portal");
			} else {
				return actionMapping.findForward("city_portal");
			}
		}
		return null;
	}

}