/*
 * Created on 2007-1-11
 *
 */
package com.topsuntech.gUnit.gEU_util.user.framework.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_util.user.services.UserService;

/**
 * @author lixirong
 * 
 */
public class UserAction extends DispatchAction {

	/**
	 * 更新角色所对应的用户角色功能
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateRoles(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String roleId = request.getParameter("roleId");
		if (roleId != null && roleId.trim().length() > 0) {
			UserService service = new UserService();
			service.updateRoles(Long.parseLong(roleId));
		}

		return actionMapping.findForward("success");

	}

	/**
	 * 更新用户的角色
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUserRole(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String roleId = request.getParameter("roleId");

		if (roleId != null && roleId.trim().length() > 0) {
			boolean bu = UserService.updateUserInfoByRightRole(Long
					.parseLong(userId), Long.parseLong(roleId));
			if (bu == true) {
				request.setAttribute("updateFlag", "true");
			}
		}

		return actionMapping.findForward("success");

	}

	/**
	 * 查看用户密码
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward toUpdatePassword(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		User user = UserSession.getUser(request);

		Logger.debug("\n ----user : " + user);

		String password = user.getPassword();
		request.setAttribute("password", password);

		return actionMapping.findForward("success");

	}

	/**
	 * 修改用户密码
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editPassword(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		String password = request.getParameter("password");
		UserService.updateUser(user.getId(), password);
		return actionMapping.findForward("success");
	}

	/**
	 * 修改用户密码
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePassword(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		User user = UserSession.getUser(request);

		Logger.debug("\n ----user : " + user);

		String newPassword = request.getParameter("newPassword");

		Long id = user.getId();
		UserService.updateUserInfo(id.longValue(), newPassword);

		return actionMapping.findForward("success");
	}

}
