/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.framework.actions;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.jdom.Element;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.identity.model.tree.TreeNode;
import com.topsuntech.gOS.identity.office.service.AbsOfficeTreeViewCreator;
import com.topsuntech.gOS.identity.office.service.OfficeFinder;
import com.topsuntech.gOS.identity.user.dao.UserDao;
import com.topsuntech.gOS.identity.util.BeanFactoryUtil;
import com.topsuntech.gOS.identity.util.PageBean;
import com.topsuntech.gOS.identity.util.PageUtil;
import com.topsuntech.gOS.priority.PriorityToHTML;
import com.topsuntech.gOS.priority.PriorityValidator;
import com.topsuntech.gOS.query.DBUtility;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.sso.crypto.FormCrypto;
import com.topsuntech.gOS.user.actions.AESUtil;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.en.userext.Userext;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_dict.service.DynamicSelectDao;
import com.topsuntech.gUnit.gEU_system.framework.vo.UserProList;
import com.topsuntech.gUnit.gEU_system.service.RoleService;
import com.topsuntech.gUnit.gEU_system.service.UserService;
import com.topsuntech.gUnit.gEU_system.service.vo.UserQueryBean;
import com.topsuntech.gUnit.gEU_util.entity.AjRole;
import com.topsuntech.gUnit.gEU_util.entity.AjUser;




/**
 * @author Ibm
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class SjUserAction extends DispatchAction {

	/**
	 * “用户管理”： '查询'相应的用户信息
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward list(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// SjDeptForm form = (SjDeptForm)actionForm;
		//        
		// SjDept dept = new SjDept();
		// PropertyUtils.copyProperties(dept, form);
		// dept.setRoleLev(dept.getLevelId());
		// dept.setCreateDate(new Date());
		// DeptService.insertDept(dept);
		//        
		// request.setAttribute("action", "add");

		return actionMapping.findForward("success");
	}

	public ActionForward listAllUser(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = PageFactory.getPage(request);

		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String quId = request.getParameter("quId");
		String streetId = request.getParameter("streetId");
		String deptid = request.getParameter("deptid");
		String deptName = request.getParameter("dept");
		String roleId = request.getParameter("roleId");
		String quanxianid = request.getParameter("quanxianid");
		String quanxian = request.getParameter("quanxian");
		String chuliquanxian = "";
		if (quanxianid != null && !quanxianid.equals("")) {
			chuliquanxian = "," + quanxianid + ",";
		} else {
			chuliquanxian = quanxianid;
		}

		// 得到所有角色列表
		RoleService roleService = new RoleService();
		List roleList = roleService.getRole(null);

		UserQueryBean bean = new UserQueryBean();
		bean.setName(name);
		bean.setQuId(quId);
		bean.setStreetId(streetId);
		bean.setLoginId(loginId);
		bean.setRoleId(roleId);
		bean.setQuanxianid(chuliquanxian);
		if (deptid != null && !deptid.equals(""))
			bean.setDeptId(Long.valueOf(deptid));
		List userList = UserService.getUserAllList(bean, page);
		// 区县
		Collection quIds = new ArrayList();
		// 街道办事
		Collection streetIds = new ArrayList();
		DynamicSelectDao dynamic = new DynamicSelectDao();
		if (!StringUtils.isBlank(quId)) {
			// quIds=dynamic.findRegionByList(quId);
			streetIds = dynamic.queryBasicInfoChiler(quId);
		}
		if (quIds.isEmpty()) {
			quIds = dynamic.getRegionByParentIdImp(Long.valueOf(2));
		}

		request.setAttribute("quanxianid", quanxianid);
		request.setAttribute("quanxian", quanxian);
		request.setAttribute("roleId", roleId);
		request.setAttribute("roleList", roleList);
		request.setAttribute("quIds", quIds);
		request.setAttribute("streetIds", streetIds);
		request.setAttribute("loginId", loginId);
		request.setAttribute("deptid", deptid);
		request.setAttribute("deptName", deptName);
		request.setAttribute("userList", userList);
		request.setAttribute("dataPage", page);
		request.setAttribute("name", name);
		return actionMapping.findForward("success");
	}

	/**
	 * 用户排序
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listUserforOrder(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Page page = PageFactory.getPage(request);
		page.setPageSize(100);
		String dept = request.getParameter("dept");
		String deptid = request.getParameter("deptid");
		UserQueryBean bean = new UserQueryBean();

		List userList = null;
		if (deptid != null && !deptid.equals("")) {
			bean.setDeptId(new Long(deptid));
			userList = UserService.getAjUserAllList(bean, page);
		}

		request.setAttribute("userList", userList);
		request.setAttribute("dataPage", page);
		request.setAttribute("dept", dept);
		request.setAttribute("deptid", deptid);
		request.setAttribute("type", request.getParameter("type"));
		return actionMapping.findForward("success");
	}
//
//	/**
//	 * 用户排序 上移功能
//	 * 
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward moveUp(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		String dept = request.getParameter("dept");
//		String deptid = request.getParameter("deptid");
//		String id = request.getParameter("id");
//		String orderByItem = request.getParameter("orderByItem");// 排序用的 序号
//		String type = request.getParameter("type");
//		// 在线用户信息
//		User user = UserSession.getUser(request);
//		// 取出用户编码
//		String userCode = user.getNum();
//
//		UserService serivce = new UserService();
//		if (orderByItem != null && !orderByItem.equals(""))
//			serivce.toMoveUp(id, orderByItem, deptid, userCode);
//
//		request.setAttribute("deptid", deptid);
//		request.setAttribute("dept", dept);
//		request.setAttribute("type", type);
//		return actionMapping.findForward("success");
//	}
//
//	/**
//	 * 用户排序 下移功能
//	 * 
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward moveDown(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		String dept = request.getParameter("dept");
//		String deptid = request.getParameter("deptid");
//		String id = request.getParameter("id");
//		String orderByItem = request.getParameter("orderByItem");// 排序用的 序号
//
//		// 在线用户信息
//		User user = UserSession.getUser(request);
//		// 取出用户编码
//		String userCode = user.getNum();
//
//		UserService serivce = new UserService();
//		serivce.toMoveDown(id, orderByItem, deptid, userCode);
//
//		request.setAttribute("deptid", deptid);
//		request.setAttribute("dept", dept);
//		request.setAttribute("type", request.getParameter("type"));
//		return actionMapping.findForward("success");
//	}

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
	public ActionForward updatePwd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService serivce = new UserService();
		User user = UserSession.getUser(request);
		String pwd = request.getParameter("password");
		UserDao dao = (UserDao) BeanFactoryUtil.getBeanFactoryUtil().getBean(
				"userDao", request);
		serivce.updateUserPwd(user, AESUtil.encrypt(pwd), dao);
		request.getSession().setAttribute("nochangepwd", null);
		return actionMapping.findForward("success");
	}

	private void processUserPriorityAndRole(HttpServletRequest request)
			throws TSDBException, NumberFormatException, SQLException {
		RoleService service = new RoleService();

		String fromOpener = request.getParameter("fromOpener");
		if ("true".equals(fromOpener)) {
			request.setAttribute("userPrios", request.getParameter("priority"));
			String systemRole = request.getParameter("systemRole");
			request.setAttribute("systemRole", systemRole);
			request.setAttribute("userRolesPriority", service
					.findRolesPriority(systemRole));
			return;
		}
		String[] ids = request.getParameterValues("ids");
		if (ids != null && ids.length != 0) {
			request.setAttribute("ids", StringUtils.join(ids, ','));
			return;
		}

		String id = request.getParameter("id");
		if (id != null && id.length() != 0) {
			String dId = new FormCrypto().decrypt(id, request.getSession());
			AjUser ajUser = UserService.getAjUserById(Long.valueOf(dId));
			if (ajUser != null) {
				request.setAttribute("ids", id);

				if (ajUser.getPriority() != null) {
					request.setAttribute("userPrios", ajUser.getPriority());
				}
				request.setAttribute("systemRole", ajUser.getSystemRole());
				request.setAttribute("userRolesPriority", service
						.findRolesPriority(ajUser.getSystemRole()));
			}
		}
	}

	public ActionForward showRolesFrame(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = PageUtil.getPageBean(request, "currentPage",
				"pageSize");
		request.setAttribute("page", pageBean);

		String systemRole = request.getParameter("systemRole");
//		String category = request.getParameter("category");
		boolean isSetCreatorId = Boolean.valueOf(
				(request.getParameter("isSetCreatorId"))).booleanValue();

		RoleService service = new RoleService();

		request.setAttribute("roles", service.findRolesOrderByIds(
				isSetCreatorId ? UserSession.getUser(request).getId() : null,
				systemRole, pageBean));

		return actionMapping.findForward("rolesFrame");
	}

	public ActionForward showChoosePriorityRole(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		processUserPriorityAndRole(request);

		request.setAttribute("prioTree", PriorityToHTML.generateByPriority(""));
		request.setAttribute("rootChildrenPrioritys", RoleService
				.getRootChildrenPrioritys());

		// request.setAttribute("roles", service.findRolesByCreatorId(null));
		request.setAttribute("isSetCreatorId", Boolean.FALSE);

		return actionMapping.findForward("success");
	}

	public ActionForward showSubChoosePriorityRole(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		processUserPriorityAndRole(request);

		Userext userExt = (Userext) DBUtility.load(Userext.class, UserSession
				.getUser(request).getId());
		request.setAttribute("prioTree", PriorityToHTML
				.generateByPriorityAndIds("", userExt.getPriority()));
		request.setAttribute("rootChildrenPrioritys", RoleService
				.getRootChildrenPrioritysIncludeIds(userExt.getPriority()));

		// request.setAttribute("roles",
		// service.findRolesByCreatorId(UserSession.getUser(request).getId()));
		request.setAttribute("isSetCreatorId", Boolean.TRUE);

		return actionMapping.findForward("success");
	}

	public ActionForward updateSystemRoleAndPriority(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("ids");
		try {
			Long[] userIds = new FormCrypto().decryptCsvToLong(ids, request
					.getSession());

			String systemRole = request.getParameter("systemRole");
			String priority = request.getParameter("priority");

			UserService userService = new UserService();
			boolean isAppend = "true".equals(request.getParameter("isAppend"));
			for (int i = 0; i < userIds.length; i++) {
				if (isAppend) {
					userService.mergeAndUpdateSystemRoleAndPriority(userIds[i],
							systemRole, priority);
				} else {
					userService.updateSystemRoleAndPriority(userIds[i],
							systemRole, priority);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Long[] processUserextSub(HttpServletRequest request)
			throws TSDBException, NumberFormatException, SQLException {
		String id = request.getParameter("id");
		Long[] officeIds = null;
		if (id != null && id.length() != 0) {
			String dId = new FormCrypto().decrypt(id, request.getSession());
			Userext userExt = (Userext) DBUtility.load(Userext.class, Long
					.valueOf(dId));
			if (userExt != null) {
				request.setAttribute("id", id);
				request.setAttribute("userextSubstr", userExt.getSubstr());
				request.setAttribute("userextPriority", userExt.getPriority());
				officeIds = com.topsuntech.gOS.identity.util.StringUtils
						.csvStrToLongs(userExt.getSubstr());
			}
		}
		return officeIds;
	}

	public ActionForward showChoosOfficePriority(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long[] officeIds = processUserextSub(request);

		OfficeFinder oFinder = (OfficeFinder) BeanFactoryUtil
				.getBeanFactoryUtil().getBean("officeFinder", request);
		AbsOfficeTreeViewCreator tvCreator = (AbsOfficeTreeViewCreator) BeanFactoryUtil
				.getBeanFactoryUtil().getBean("officeTreeViewCreator", request);
		TreeNode[] treeNodes;
		if (officeIds != null && officeIds.length != 0) {
			treeNodes = tvCreator.convertOfficesToTreeNodes(oFinder
					.getRootOfficesToIds(officeIds));
		} else {
			treeNodes = tvCreator.convertOfficesToTreeNodes(oFinder
					.getRootOffices());
		}
		request.setAttribute("treeData", JSONArray.fromObject(treeNodes)
				.toString());

		request.setAttribute("prioTree", PriorityToHTML.generateByPriority(""));

		return actionMapping.findForward("success");
	}

	public ActionForward showSubChoosOfficePriority(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long[] officeIds = processUserextSub(request);

		OfficeFinder oFinder = (OfficeFinder) BeanFactoryUtil
				.getBeanFactoryUtil().getBean("officeFinder", request);
		AbsOfficeTreeViewCreator tvCreator = (AbsOfficeTreeViewCreator) BeanFactoryUtil
				.getBeanFactoryUtil().getBean("officeTreeViewCreator", request);
		TreeNode[] treeNodes;
		if (officeIds != null && officeIds.length != 0) {
			treeNodes = tvCreator.convertOfficesToTreeNodes(oFinder
					.getUserManagedSubOfficesToIds(
							UserSession.getUser(request), officeIds));
		} else {
			treeNodes = tvCreator.convertOfficesToTreeNodes(oFinder
					.getUserManagedSubOffices(UserSession.getUser(request)));
		}
		request.setAttribute("treeData", JSONArray.fromObject(treeNodes)
				.toString());

		Userext userExt = (Userext) DBUtility.load(Userext.class, UserSession
				.getUser(request).getId());
		request.setAttribute("prioTree", PriorityToHTML
				.generateByPriorityAndIds("", userExt.getPriority()));

		return actionMapping.findForward("success");
	}

	public ActionForward updateUserextSubstrAndPriority(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		try {
			Long userextId = Long.valueOf(new FormCrypto().decrypt(id, request
					.getSession()));
			Userext userExt = (Userext) DBUtility
					.load(Userext.class, userextId);

			String userextSubstr = request.getParameter("userextSubstr");
			String userextPriority = request.getParameter("userextPriority");

			userExt.setSubstr(userextSubstr);
			userExt.setPriority(userextPriority);
			DBUtility.update(userExt);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 子系统用户管理
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward sublistAllUser(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = PageFactory.getPage(request);

		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String quId = request.getParameter("quId");
		String streetId = request.getParameter("streetId");
		String deptid = request.getParameter("deptid");
		String deptName = request.getParameter("dept");
		UserQueryBean bean = new UserQueryBean();
		bean.setName(name);
		bean.setQuId(quId);
		bean.setStreetId(streetId);
		bean.setLoginId(loginId);
		if (deptid != null && !deptid.equals(""))
			bean.setDeptId(Long.valueOf(deptid));
		List userList = UserService.getUserAllList(bean, page);
		// 区县
		Collection quIds = new ArrayList();
		// 街道办事
		Collection streetIds = new ArrayList();
		DynamicSelectDao dynamic = new DynamicSelectDao();
		if (!StringUtils.isBlank(quId)) {
			quIds = dynamic.findRegionByList(quId);
			streetIds = dynamic.queryChilerList(streetId);
		}
		if (quIds.isEmpty()) {
			quIds = dynamic.getRegionByParentIdImp(Long.valueOf(2));
		}

		request.setAttribute("quIds", quIds);
		request.setAttribute("streetIds", streetIds);
		request.setAttribute("loginId", loginId);
		request.setAttribute("deptid", deptid);
		request.setAttribute("deptName", deptName);
		request.setAttribute("userList", userList);
		request.setAttribute("dataPage", page);
		request.setAttribute("name", name);
		return actionMapping.findForward("success");
	}

	/**
	 * 显示用户权限
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showUserProAll(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		List list=new ArrayList();
		// 查出该用户下的权限
		List userproperty = new ArrayList();
		// 得到用户ID
		String usrid = request.getParameter("usrid");
		AjUser ajuser = new AjUser();
		if (usrid != null && !usrid.equals(""))
			ajuser = UserService.getAjUserById(new Long(usrid));
		String userProStr = ajuser.getPriority();
		String userRole = ajuser.getSystemRole();
		if (userProStr != null && !userProStr.equals("")) {
			String userProStrafter[] = userProStr.split(",");
			if (userRole != null && !userRole.equals("")) {
				String userRoleStrafter[] = userRole.split(",");
				for (int i = 0; i < userRoleStrafter.length; i++) {
					// 根据用户角色ID查这所包含的权限
					RoleService roleService = new RoleService();
					if (userRoleStrafter[i] != null
							&& !userRoleStrafter[i].equals("")) {
						AjRole role = roleService.queryAjRoleById(new Long(
								userRoleStrafter[i]));
						if (role != null) {
							if (role.getPriority() != null
									&& !role.getPriority().equals("")) {
								String userRolePro[] = role.getPriority()
										.split(",");
								for (int j = 0; j < userRolePro.length; j++) {
									if (userRolePro[j] != null
											&& !userRolePro[j].equals("")) {
										userproperty.add(userRolePro[j]);
									}
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < userProStrafter.length; i++) {
				if (userProStrafter[i] != null
						&& !userProStrafter[i].equals(""))
					userproperty.add(userProStrafter[i]);
			}

			List root = PriorityValidator.getAllPrivilege();
			Map rootChildrenPrioritys = new LinkedHashMap();
			Map prioritysAll = new LinkedHashMap();
			List mynewList=new ArrayList();
			for (int i = 0; i < root.size(); i++) {				
				Element el = (Element) root.get(i);
				rootChildrenPrioritys.put(el.getAttributeValue("id"), el);
				prioritysAll.put(el.getAttributeValue("id"), el.getAttributeValue("name"));				
			}
//			String parentName = "";
//			String rootName = "";
//			for (int k = 0; k < userproperty.size(); k++) {
//				String priority = (String) userproperty.get(k);
//				if (isExist(priority, rootChildrenPrioritys)) {
//					Element el1=(Element)rootChildrenPrioritys.get(userproperty.get(k));
//					
//					if(!el1.getParent().getParent().getParent().getAttributeValue("name").equals(rootName)){
//						list.add(el1.getParent().getParent().getParent().getAttributeValue("name"));
//						rootName = el1.getParent().getParent().getParent().getAttributeValue("name");
//					}
//					
//					if(!el1.getParent().getParent().getAttributeValue("name").equals(parentName)){
//						list.add(el1.getParent().getParent().getAttributeValue("name"));
//						parentName = el1.getParent().getParent().getAttributeValue("name");
//					}
//					list.add(prioritysAll.get(priority));
//					for(int z=0;z<list.size();z++){
//						 System.out.println(">>>>>>>>>%list%%%%%%%%%%%>>>>>>>>"+list.get(z));
//					}
//					
//				}
//
//			}
		}
		request.setAttribute("mylist", list);		
		
		
		//////////111111111
		List root = PriorityValidator.getAllPrivilege();
		Map rootChildrenPrioritys = new LinkedHashMap();
		Map prioritysAll = new LinkedHashMap();
		List mynewList=new ArrayList();
		for (int i = 0; i < root.size(); i++) {
			String parentName = "";
			String rootName = "";
			UserProList userProList=new UserProList();
			Element el = (Element) root.get(i);
			String pId = el.getAttributeValue("id");
			rootChildrenPrioritys.put(pId, el);
			prioritysAll.put(pId, el.getAttributeValue("name"));
			
			userProList.setStr1(el.getParentElement().getParentElement().getParentElement().getAttributeValue("name"));
			
			userProList.setStr2(el.getParentElement().getParentElement().getAttributeValue("name"));
				
			userProList.setStr3(el.getAttributeValue("name"));
			
			if (userproperty.indexOf(pId) != -1) {
				userProList.setStr4("1");
			} else {
				userProList.setStr4("0");
			}
			
			
			mynewList.add(userProList);
		}
		UserProList userProList=new UserProList();
		for(int a=0;a<mynewList.size();a++){
			 userProList=(UserProList)mynewList.get(a);			
		}
		request.setAttribute("mynewList", mynewList);
		request.setAttribute("userName", ajuser.getName());
		request.setAttribute("usrid", ajuser.getId());
		request.setAttribute("userWorkDeptid", ajuser.getWorkdept().getName());
		request.setAttribute("userDeptId", ajuser.getDeptid());
		return actionMapping.findForward("success");
	}
//dead code
//	private boolean isExist(String priority, Map rootChildrenPrioritys) {
//		return	rootChildrenPrioritys.containsKey(priority);
//		
//	}
	
	
	/**
	 * 导出用户权限
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward expUserPro(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		List list=new ArrayList();
		// 查出该用户下的权限
		List userproperty = new ArrayList();
		// 得到用户ID
		String usrid = request.getParameter("usrid");
		AjUser ajuser = new AjUser();
		if (usrid != null && !usrid.equals(""))
			ajuser = UserService.getAjUserById(new Long(usrid));
		String userProStr = ajuser.getPriority();
		String userRole = ajuser.getSystemRole();
		if (userProStr != null && !userProStr.equals("")) {
			String userProStrafter[] = userProStr.split(",");
			if (userRole != null && !userRole.equals("")) {
				String userRoleStrafter[] = userRole.split(",");
				for (int i = 0; i < userRoleStrafter.length; i++) {
					// 根据用户角色ID查这所包含的权限
					RoleService roleService = new RoleService();
					if (userRoleStrafter[i] != null
							&& !userRoleStrafter[i].equals("")) {
						AjRole role = roleService.queryAjRoleById(new Long(
								userRoleStrafter[i]));
						if (role != null) {
							if (role.getPriority() != null
									&& !role.getPriority().equals("")) {
								String userRolePro[] = role.getPriority()
										.split(",");
								for (int j = 0; j < userRolePro.length; j++) {
									if (userRolePro[j] != null
											&& !userRolePro[j].equals("")) {
										userproperty.add(userRolePro[j]);
									}
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < userProStrafter.length; i++) {
				if (userProStrafter[i] != null
						&& !userProStrafter[i].equals(""))
					userproperty.add(userProStrafter[i]);
			}

			List root = PriorityValidator.getAllPrivilege();
			Map rootChildrenPrioritys = new LinkedHashMap();
			Map prioritysAll = new LinkedHashMap();
			List mynewList=new ArrayList();
			for (int i = 0; i < root.size(); i++) {				
				Element el = (Element) root.get(i);
				rootChildrenPrioritys.put(el.getAttributeValue("id"), el);
				prioritysAll.put(el.getAttributeValue("id"), el.getAttributeValue("name"));				
			}

		}
		request.setAttribute("mylist", list);		

		List root = PriorityValidator.getAllPrivilege();
		Map rootChildrenPrioritys = new LinkedHashMap();
		Map prioritysAll = new LinkedHashMap();
		List mynewList=new ArrayList();
		for (int i = 0; i < root.size(); i++) {
			String parentName = "";
			String rootName = "";
			UserProList userProList=new UserProList();
			Element el = (Element) root.get(i);
			String pId = el.getAttributeValue("id");
			rootChildrenPrioritys.put(pId, el);
			prioritysAll.put(pId, el.getAttributeValue("name"));
			
			userProList.setStr1(el.getParentElement().getParentElement().getParentElement().getAttributeValue("name"));
			
			userProList.setStr2(el.getParentElement().getParentElement().getAttributeValue("name"));
				
			userProList.setStr3(el.getAttributeValue("name"));
			
			if (userproperty.indexOf(pId) != -1) {
				userProList.setStr4("1");
				userProList.setStr5("√");
			} else {
				userProList.setStr4("0");
				userProList.setStr5("");
			}
			//从页面中接取用户名 机构名 部门分存到实体中导出用
			
			mynewList.add(userProList);
		}
		UserProList userProList=new UserProList();
		for(int a=0;a<mynewList.size();a++){
			 userProList=(UserProList)mynewList.get(a);			
		}
		String userName=request.getParameter("userName");
		String workDeptName=request.getParameter("workDeptName");
		String deptName=request.getParameter("deptName");
		userProList.setUserName(userName);
		userProList.setWorkDeptName(workDeptName);
		userProList.setDeptName(deptName);
		String fileName=userName+".xls";
		excelBill(fileName, "用户权限列表", "中文字段名", "数据库字段名", mynewList, response,userName,workDeptName,deptName);
		return actionMapping.findForward("success");
	}
	/**
	 * 根据excel文件名，字段名，查询结果和排版大小进行excel输出
	 * @param deptName 
	 * @param workDeptName 
	 * @param userName 
	 * 
	 * @param filename
	 *            文件名 title 标题 characterName 字段中文名 characterId 数据库字段名 查询结果 list
	 * @note 
	 */
	public static void excelBill(String fileName, String title,
			String characterName, String characterId, List rslist,
			HttpServletResponse httpResponse, String userName, String workDeptName, String deptName) {
		try {
			OutputStream os = httpResponse.getOutputStream();
			httpResponse.setContentType("application/vnd.ms-excel; charset=GBK");
			httpResponse.setHeader("Content-Disposition", new String(("attachment; filename=" + fileName).getBytes("GBK"), "ISO-8859-1")); 
			// 开始写入excel
			// 加标题
			// 标题字体
			jxl.write.WritableFont wfc = new jxl.write.WritableFont(
					WritableFont.COURIER, 18, WritableFont.BOLD, true);
			jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(
					wfc);
			wcfFC.setAlignment(jxl.format.Alignment.CENTRE);
			wcfFC.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

			// 字段字体
			jxl.write.WritableFont wfc1 = new jxl.write.WritableFont(
					WritableFont.COURIER, 10, WritableFont.BOLD, true);
			jxl.write.WritableCellFormat wcfFC1 = new jxl.write.WritableCellFormat(
					wfc1);
			wcfFC1.setAlignment(jxl.format.Alignment.CENTRE);
			wcfFC1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

			// 结果字体
			jxl.write.WritableCellFormat wcfFC2 = new jxl.write.WritableCellFormat();
			wcfFC2.setAlignment(jxl.format.Alignment.CENTRE);
			wcfFC2.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

			WritableWorkbook wbook = Workbook.createWorkbook(os);
			// 写sheet名称
			WritableSheet wsheet = wbook.createSheet("sheet1", 0);
			Date aaa = new Date();
			SimpleDateFormat aSimpleDateFormat = new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			String today = aSimpleDateFormat.format(aaa);

			String[] splistCharacterName = characterName.split(",");
			String[] splistCharacterId = characterId.split(",");
			int characterSize = splistCharacterName.length;
			int resSize = rslist.size();
			int i;

//			for (i = 0; i < characterSize; i++) {
//				// 加入字段名
//				wsheet.addCell(new jxl.write.Label(i, 3, splistCharacterName,
//						wcfFC1));
//				System.out.println(splistCharacterName);
//
//			}
//			// 加入标题
			//wsheet.mergeCells(0, 0, 1 - 1, 0);
			wsheet.addCell(new Label(1, 0, title, wcfFC));
			wsheet.addCell(new Label(0, 1, "姓名"));
			wsheet.addCell(new Label(1, 1, userName));
			wsheet.addCell(new Label(2, 1, "机构名称"));
			wsheet.addCell(new Label(3, 1, workDeptName));
			wsheet.addCell(new Label(4, 1, "所在部门"));
			wsheet.addCell(new Label(5, 1, deptName));
			wsheet.addCell(new Label(0, 2, "系统名称"));
			wsheet.addCell(new Label(1, 2, "功能模块名称"));
			wsheet.addCell(new Label(2, 2, "权限"));
			wsheet.addCell(new Label(3, 2, "权限设置情况（以对勾勾选）"));
//			// 加入打印时间
//			wsheet.addCell(new Label(i - 2, 1, "打印日期:"));
//			wsheet.addCell(new Label(i - 1, 1, today));

			// 下面开始输出结果
			UserProList userProList=new UserProList();
			for (int j = 0; j < resSize; j++) {
				 userProList =(UserProList) rslist.get(j);
					wsheet.addCell(new Label(0, j+3, String.valueOf(userProList.getStr1())));
					wsheet.addCell(new Label(1, j+3, String.valueOf(userProList.getStr2())));
					wsheet.addCell(new Label(2, j+3 , String.valueOf(userProList.getStr3())));
					wsheet.addCell(new Label(3, j+3, String.valueOf(userProList.getStr5())));
			}
			// 写入流中
			wbook.write();
			wbook.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
//	/**
//	 * 改变用户排序
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward changeOrderItem(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		String[] userid = request.getParameterValues("userid");
//		String[] orderitem = request.getParameterValues("orderByItem");		
//		if(userid!=null){
//			if(userid.length!=0){
//				for(int i=0;i<userid.length;i++){
//					UserService.updateUserOrderItem(userid[i], orderitem[i]);
//				}
//			}
//		}
//		
//		
//		return listUserforOrder(actionMapping, actionForm, request, response);
//	}
	
	/**
	 * 修改用户密码 系统管理  用户管理 用
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePwdfor(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService serivce = new UserService();
		String userid=request.getParameter("id");
		String pwd = request.getParameter("password");
		UserDao dao = (UserDao) BeanFactoryUtil.getBeanFactoryUtil().getBean(
				"userDao", request);
		serivce.updateUserPwdfor(userid, AESUtil.encrypt(pwd));
		request.setAttribute("inputPath", request.getParameter("inputPath"));
		return actionMapping.findForward("success");
	}
	
//	public ActionForward updatePwdAll(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		UserService serivce = new UserService();
//		List userList=serivce.getUserListfor(null,null);
//		if(userList!=null&&userList.size()!=0){
//			for(int i=0;i<userList.size();i++){
//				AjUser user =(AjUser)userList.get(i);
//				serivce.updateUserPwdfor(String.valueOf(user.getId()), AESUtil.encrypt(user.getPassword()));
//			}			
//		}	
//	
//		return actionMapping.findForward("success");
//	}
	
	public ActionForward queryUserPwd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService serivce = new UserService();
		String loginid=request.getParameter("loginid");
		String name=request.getParameter("name");
		List list=serivce.getUserListfor(loginid,name);
		AjUser user=new AjUser();
		if(list!=null&&list.size()!=0){
			 user=(AjUser)list.get(0);			
		}
		
		request.setAttribute("password", AESUtil.decrypt(user.getPassword()));		
		return actionMapping.findForward("success");
	}
	
	/**
	 * 修改用户信息 系统管理  用户管理 用
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward reSaveUser(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService serivce = new UserService();
		String canumber=request.getParameter("canumber");
		String num = request.getParameter("num");
		AjUser user = (AjUser) serivce.getUserByNum(num);
		user.setCanumber(canumber);
		serivce.updateUserInfo(user);
		request.setAttribute("inputPath", request.getParameter("inputPath"));
		return actionMapping.findForward("success");
	}
//按系统全部选中 或者全部取消权限 已注释 李小红先不使 开始位置
//	/**
//	 *  查询权限配置文件 得到系统名称
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward showSys(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		String userid=request.getParameter("ids");
//		String useridafter=new FormCrypto().decrypt(userid, request.getSession());
//		
//		
//		DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();		 
//	    List mylist=new ArrayList();
//		try  {
//          DocumentBuilder dombuilder=domfac.newDocumentBuilder();
//          File f = new File(ConfigPath.getConfigPath("gUnit.xml"));
//          InputStream is=new FileInputStream(f);   	           
//          org.w3c.dom.Document doc=dombuilder.parse(is);
//          //先取根元素"gUnits"
//          org.w3c.dom.Element gUnits=doc.getDocumentElement();
//          //取"gTUnit"元素列表
//          NodeList gTUnits=gUnits.getChildNodes();
//        
//          if(gTUnits!=null) {
//                  //依次轮寻
//              for(int i=0;i<gTUnits.getLength();i++) {
//                  Node gTUnit=gTUnits.item(i);   
//                  if(gTUnit.getNodeType()==Node.ELEMENT_NODE) {
//                	  String gTUnitname=gTUnit.getAttributes().getNamedItem("name").getNodeValue();        	               	  
//                	
//                	  mylist.add(gTUnitname);
//                  }
//              }
//          }
//      } catch (ParserConfigurationException e)  {
//          e.printStackTrace();
//      } catch (FileNotFoundException e)  {
//          e.printStackTrace();
//      } catch (SAXException e)  {
//          e.printStackTrace();
//      } catch (IOException e)  {
//          e.printStackTrace();
//      }	 
//      String username="";
//      if(useridafter!=null&&!useridafter.equals("")){
//    	  AjUser user=UserService.getAjUserById(new Long(useridafter));
//    	  username=user.getName();
//      }
//      request.setAttribute("username", username); 
//        request.setAttribute("mylist", mylist);
//		request.setAttribute("userid", useridafter);
//		return actionMapping.findForward("success");
//	}
//
//	/**
//	 * 更新用户权限（全部授权或全部去掉）
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward updatePorperty(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		String userid = request.getParameter("id");
//		String sys = request.getParameter("sys");//系统名称	
//		String flag = request.getParameter("flag");//1全给  0还是全取消
//		//1去掉这个用户所有这个系统权限
//		List sysids=this.getUn(sys);
//		if(sysids!=null&&sysids.size()!=0){
//			for(int i=0;i<sysids.size();i++){
//				//去掉该用户得有这个权限
//				UserService.deUserPorperty(userid,String.valueOf(sysids.get(i)));			
//			}
//			if(flag!=null&&!flag.equals("")){
//				if(flag.equals("1")){//判断如果是全给
//					//再这个系统的权限都给这个用户追加上
//					for(int j=0;j<sysids.size();j++){
//					UserService.addUserPorperty(userid, String.valueOf(sysids.get(j)));
//					}
//				}
//			}
//			
//			
//		}
//		return actionMapping.findForward("success");
//	}
//	
//	/**
//	 * 根据系统名称得到该系统下的所有权限号
//	 * @param sysname
//	 * @return
//	 * @throws Exception
//	 */
//	public List  getUn(String sysname)throws Exception{
//		DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
//		  String nodeId="";
//		  List ids=new ArrayList();
//		try  {
//            DocumentBuilder dombuilder=domfac.newDocumentBuilder();
//            File f = new File(ConfigPath.getConfigPath("gUnit.xml"));
//            InputStream is=new FileInputStream(f);   	           
//            org.w3c.dom.Document doc=dombuilder.parse(is);
//            //先取根元素"gUnits"
//            org.w3c.dom.Element gUnits=doc.getDocumentElement();
//            //取"gTUnit"元素列表
//            NodeList gTUnits=gUnits.getChildNodes();
//          
//            if(gTUnits!=null) {
//                    //依次轮寻
//                for(int i=0;i<gTUnits.getLength();i++) {
//                    Node gTUnit=gTUnits.item(i);
//                    if(gTUnit.getNodeType()==Node.ELEMENT_NODE) {
//                     	//获取每个gTUnit节点的id
//                        String gEUnitId=gTUnit.getAttributes().getNamedItem("name").getNodeValue();
//                        //如果系统名称为 xxxx，继续轮寻下一级节点，并打印处节点id
//                        if(sysname.equals(gEUnitId))
//                        { 		                        
//	                        for(Node node=gTUnit.getFirstChild();node!=null;node=node.getNextSibling()) {
//	                            if(node.getNodeType()==Node.ELEMENT_NODE) {   
//	                            	 for(Node node1=node.getFirstChild();node1!=null;node1=node1.getNextSibling()) {
//	                            		 if(node1.getNodeType()==Node.ELEMENT_NODE) {   
//	     	                            	if(("privileges").equals(node1.getNodeName())){
//	     	                            		for(Node node2=node1.getFirstChild();node2!=null;node2=node2.getNextSibling()) {
//	     		    	                            if(node2.getNodeType()==Node.ELEMENT_NODE) {
//	     		    	                            	 nodeId=node2.getAttributes().getNamedItem("id").getNodeValue();
//	     		    	                            	 ids.add(nodeId);
//	     		    	                            	 System.out.println(">>>>>>>>>>>"+sysname+">>>>"+nodeId);
//	     		    	                            }
//	     		    	                        }
//	     	                            	}
//	     	                             }
//	                            	 }
//	                            }
//	                        }
//                        }
//                    }
//                }
//            }
//        } catch (ParserConfigurationException e)  {
//            e.printStackTrace();
//        } catch (FileNotFoundException e)  {
//            e.printStackTrace();
//        } catch (SAXException e)  {
//            e.printStackTrace();
//        } catch (IOException e)  {
//            e.printStackTrace();
//        }	
//		return ids;
//	}
	//按系统全部选中 或者全部取消权限 已注释 李小红先不使 结束位置
}
