/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.framework.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.identity.model.action.ActionHelper;
import com.topsuntech.gOS.priority.PriorityToHTML;
import com.topsuntech.gOS.query.DBUtility;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.en.userext.Userext;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_system.service.RoleService;
import com.topsuntech.gUnit.gEU_system.service.UserService;
import com.topsuntech.gUnit.gEU_util.entity.AjRole;

/**
 * @author Ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SjRoleAction extends DispatchAction {
        
    /**
   * “用户管理”： 显示所有的角色信息
   * @param actionMapping
   * @param actionForm
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ActionForward list(ActionMapping actionMapping, ActionForm actionForm,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String userId = request.getParameter("userId");
      
      RoleService service = new RoleService();
      List roleList = service.getRole(null);   
      request.setAttribute("roleList", roleList);
      
      List userSystemRoleList = UserService.getUserSystemRole(new Long(userId));
      request.setAttribute("userSystemRoleList", userSystemRoleList);    
            
      return actionMapping.findForward("success");
  }
      
  /**
   * “用户管理”： 更新用户的权限信息[systemRole、priority]
   * @param actionMapping
   * @param actionForm
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ActionForward updateUserRight(ActionMapping actionMapping, ActionForm actionForm,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String userId = request.getParameter("userId");
      String systemRole = request.getParameter("systemRole");
      String priorityIdStr = request.getParameter("priorityIdStr");
                  
      RoleService service = new RoleService();
      service.updateUserSystemRole(new Long(userId), systemRole, priorityIdStr);      
      
      return actionMapping.findForward("success");
  }
     
  /**
   * “用户管理”： 显示已选中的角色所对应的权限信息
   * @param actionMapping
   * @param actionForm
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ActionForward showSelectPriority(ActionMapping actionMapping, ActionForm actionForm,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String priorityIdStr = request.getParameter("priorityIdStr");     
      RoleService service = new RoleService();
      List priorityList = service.gettPriorityListByIdStr(priorityIdStr);      
      request.setAttribute("priorityList", priorityList);    
            
      return actionMapping.findForward("success");
  }
  
  /**
   * “角色管理”： 自动更新角色对应的用户权限
   * @param actionMapping
   * @param actionForm
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ActionForward updateUserRole(ActionMapping actionMapping, ActionForm actionForm,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String roleId = request.getParameter("id");
      
      RoleService service = new RoleService();
      service.updateUserPriByRoleId(Long.parseLong(roleId));      
            
      return actionMapping.findForward("success");
  }  
  
  /**
	 * 得到角色列表
	 * @deprecated
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward _getRolelist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String rolename=request.getParameter("rolename");//角色名称
		String roleman=request.getParameter("roleman");//角色创建人
		Page page = PageFactory.getPage(request);
		RoleService service = new RoleService();
		List roleList = service._getRoleList(rolename,roleman,page);		
		request.setAttribute("roleList", roleList);
		 request.setAttribute("dataPage", page);
		return actionMapping.findForward("success");
	}

	private void doRoleList(HttpServletRequest request, Long creatorId) throws TSDBException {
		String roleName = request.getParameter("roleName");// 角色名称
		String desc = request.getParameter("desc");// 角色创建人
//		String category = request.getParameter("category");
		Page page = PageFactory.getPage(request);
		RoleService service = new RoleService();
		List roles = service.getRoleList(roleName, desc,  creatorId, page);
		request.setAttribute("roles", roles);
		request.setAttribute("dataPage", page);
	}
	
	public ActionForward roleList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("rootChildrenPrioritys", RoleService.getRootChildrenPrioritys());
		
		doRoleList(request, null);
		return actionMapping.findForward("success");
	}
	
	public ActionForward subRoleList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("subRoleList", Boolean.TRUE);
		
		Userext userExt = (Userext) DBUtility.load(Userext.class, UserSession.getUser(request).getId());
		request.setAttribute("rootChildrenPrioritys", RoleService.getRootChildrenPrioritysIncludeIds(userExt.getPriority()));
		
		doRoleList(request, UserSession.getUser(request).getId());
		return actionMapping.findForward("success");
	}
	
	private void processPriority(String id, HttpServletRequest request) throws TSDBException, NumberFormatException {
		if (id != null && id.length() != 0) {
			RoleService roleService = new RoleService();
			request.setAttribute("ajRole", roleService.getAjRoleById(Long.valueOf(id)));
		}
	}

	public ActionForward showRole(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		processPriority(id, request);

		request.setAttribute("prioTree", PriorityToHTML.generateByPriority(""));
		request.setAttribute("rootChildrenPrioritys", RoleService.getRootChildrenPrioritys());

		return actionMapping.findForward("success");
	}
	
	public ActionForward showRoleDetail(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("readonly", Boolean.TRUE);
		return showRole(actionMapping, actionForm, request, response);
	}
	
	public ActionForward showSubRole(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("subRole", Boolean.TRUE);
		
		String id = request.getParameter("id");
		processPriority(id, request);
		
		Userext userExt = (Userext) DBUtility.load(Userext.class, UserSession.getUser(request).getId());
		request.setAttribute("prioTree", PriorityToHTML.generateByPriorityAndIds("", userExt.getPriority()));
		request.setAttribute("rootChildrenPrioritys", RoleService.getRootChildrenPrioritysIncludeIds(userExt.getPriority()));
		
		return actionMapping.findForward("success");
	}
	
	public ActionForward showSubRoleDetail(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("readonly", Boolean.TRUE);
		return showSubRole(actionMapping, actionForm, request, response);
	}
	
	public ActionForward saveOrUpdateRole(ActionMapping actionMapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjRole role = null;
		String idStr = request.getParameter("id");

		RoleService roleService = new RoleService();
		if (idStr == null || idStr.length() == 0) {
			role = new AjRole();
			role.setCreateDate(new Date());
			User user = UserSession.getUser(request);
			role.setCreatorId(user.getId());
//			role.setCreatorName(user.getName());
		} else {
			role = roleService.getAjRoleById(Long.valueOf(idStr));
		}

		ActionHelper.inject(role, form, request);
		new RoleService().saveOrUpdateAjRole(role);
		return actionMapping.findForward("success");
	}
	
	public ActionForward deleteRole(ActionMapping actionMapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		new RoleService().deleteAjRoleById(Long.valueOf(id));
		return actionMapping.findForward("success");
	}
}
