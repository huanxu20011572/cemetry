package com.topsuntech.gUnit_gmgl.gEU_cemetery.framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryZone;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryZoneService;

public class CemeteryZoneController extends AbstractMultiController {
	private CemeteryZoneService cemeteryZoneService;

	public void setCemeteryZoneService(CemeteryZoneService cemeteryZoneService) {
		this.cemeteryZoneService = cemeteryZoneService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}

	/**
	 * 加载根节点/展开树节点
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @throws Exception
	 */
	public ModelAndView getCemteryZoneTree(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		super.ajaxResult(response, cemeteryZoneService.getCemeteryZoneById(pid));
		return null;
	}

	/**
	 * 进入右侧IFfame页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemteryZoneTreeByPid(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		Long createOrgid = UserSession.getUser(request).getDeptid();
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		List<CemeteryZone> param = new ArrayList<CemeteryZone>();
		Office office = UserSession.getUserDept(request);
		param = cemeteryZoneService.getCemeteryZoneTreeNodeByPid(pid, createOrgid,office.getLevelid());
		super.ajaxResult(response, param);
		return null;
	}

	/**
	 * 进入右侧IFfame页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemteryZoneListByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_zone_list.jsp");
		Page page = PageConfig.getPage(request);
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		Long createOrgid = UserSession.getUser(request).getDeptid();
		List<CemeteryZone> list = cemeteryZoneService.getCemeteryZoneListByPID(page, pid, createOrgid);
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 进入新建页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryZoneCreate(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_zone_create.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "pid", 0);
		mv.addObject("zone", cemeteryZoneService.getCemeteryZoneById(id));
		mv.addObject("user", UserSession.getUser(request));
		return mv;
	}

	/**
	 * 进入编辑页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryZoneEditById(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_zone_edit.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		mv.addObject("zone", cemeteryZoneService.getCemeteryZoneById(id));
		return mv;
	}

	/**
	 * 进入查看页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryZoneViewById(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_zone_view.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		mv.addObject("zone", cemeteryZoneService.getCemeteryZoneById(id));
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryZoneById(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_zone_list.jsp");
		Page page = PageConfig.getPage(request);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		cemeteryZoneService.deleteCemeteryZoneById(id);
		Long createOrgid = UserSession.getUser(request).getDeptid();
		List<CemeteryZone> list = cemeteryZoneService.getCemeteryZoneListByPID(page, pid, createOrgid);
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 保存
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryZone(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		User user = UserSession.getUser(request);
		ModelAndView mv = new ModelAndView("cemetery_zone_list.jsp");
		Page page = PageConfig.getPage(request);
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		CemeteryZone para = new CemeteryZone();
		bindObject(request, para);
		// 用户ID
		para.setCreateUserId(user.getId());
		// 机构ID
		para.setCreateOrgId(user.getDeptid());
		// 创建
		para.setCreateDate(new Date());
		cemeteryZoneService.saveCemeteryZone(para, pid);
		List<CemeteryZone> list = cemeteryZoneService.getCemeteryZoneListByPID(page, pid, user.getDeptid());
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}

}
