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

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gUnit.gEU_dict.utils.WebUtility;
import com.topsuntech.gUnit.gEU_system.framework.actionforms.SjDeptForm;
import com.topsuntech.gUnit.gEU_system.service.DeptService;
import com.topsuntech.gUnit.gEU_system.service.RegionService;
import com.topsuntech.gUnit.gEU_system.service.UserService;
import com.topsuntech.gUnit.gEU_util.entity.AjDept;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;

/**
 * @author Ibm
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class SjDeptAction extends DispatchAction {

	public ActionForward toAdd(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String inputPath = request.getParameter("inputPath");

		String deptId = request.getParameter("deptId");
		AjDept parentDept = DeptService.getDept(Long.valueOf(deptId));
		request.setAttribute("parentDept", parentDept);

		String regionId = request.getParameter("regionId");
		// added by pengzuocong 2012-5-18 非空判断
		if (regionId != null && !"".equals(regionId.trim())) {
			SjRegion region = RegionService.getRegion(Long.valueOf(regionId));
			request.setAttribute("region", region);
		}else{
			//updated by lihaitao 2012-7-2
			AjDept ajDept = DeptService.getDept(new Long(deptId));
			SjRegion region = RegionService.getRegion(Long.valueOf(ajDept.getRegionid()));
			request.setAttribute("region", region);
		}

		WebUtility.saveDictionarysToReq("F04", request);
		request.setAttribute("inputPath", inputPath);
		return actionMapping.findForward("success");
	}

	/**
	 * “机构管理”： '新增'相应的机构信息
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		SjDeptForm form = (SjDeptForm) actionForm;
		Long regionId = form.getRegionId();// 得到机构ID

		UserService service = new UserService();
//		DeptService deptService = new DeptService();
//		SjRegion region = service.getRegionCode(regionId);
//		String standardNo = region.getStandardNo();
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// System.out.println(">>>>>>regionCode>>>>>>>>regionCode>>>>>>>>>>>>>>>>>regionCode="+regionCode);
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		AjDept dept = new AjDept();
		PropertyUtils.copyProperties(dept, form);
		dept.setRoleLev(dept.getLevelId());
		dept.setCreateDate(new Date());
//		dept.setDwdm(regionCode);// 单位行政区划代码
		// 部门编码=区域编码+单位性质+成员单位名称编码+科室
//		String deptCode = standardNo + form.getDwlx() + form.getCybm();
//		String finalDeptCode = "";
//		if (form.getJgmx().intValue() == 1) {// 本级
//			// 按目前的编码查一下，生成科室号。生成规则+1
//			int deptSize = deptService.getDeptCodeSize(deptCode);// 当前号
//			int finalSize = 1000 + deptSize + 1;// 当前号+1是下一个
//			String finalSizeCode = String.valueOf(finalSize);
//			// 这时候生成的号是1xxx 我需要把1去掉。留下XXX
//			finalDeptCode = finalSizeCode.substring(1, 4);
//			deptCode = deptCode + finalDeptCode;
//		} else {// 有下级机构的
//			deptCode = deptCode + "100";
//		}
//		dept.setApproveUnitCode(deptCode);
		if (form.getParentId() == null) {
			dept.setParentId(new Long("0"));
		}
//		DeptService deptservice = new DeptService();
//		int orderItem = deptservice.getMaxOrderItem();
//		dept.setOrderByItem(orderItem);
		DeptService.insertDept(dept);
		request.setAttribute("action", "add");

		request.setAttribute("id", dept.getId().toString());
		return actionMapping.findForward("success");
	}

	/**
	 * “机构管理”： '显示将要修改'的机构信息
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward toUpdate(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String deptId = request.getParameter("deptId");

		AjDept dept = DeptService.getDept(Long.valueOf(deptId));
		if (dept != null)
			request.setAttribute("dept", dept);
		WebUtility.saveDictionarysToReq("F04", request);

		// modified by pengzuocong 2012-5-18
		// 天津市一级parentId为0，机构表中没有为0的数据，根据id读取数据会抛出异常
		AjDept parentDept = null;
		if (dept != null && dept.getParentId().longValue() != 0)
			parentDept = DeptService.getDept(dept.getParentId());
		if (parentDept != null)
			request.setAttribute("parentName", parentDept.getName());

		SjRegion region = RegionService.getRegion(dept.getRegionId());
		if (region != null)
			request.setAttribute("regionName", region.getName());

		return actionMapping.findForward("success");
	}

	/**
	 * “机构管理”： '修改'相应的机构信息
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		SjDeptForm form = (SjDeptForm) actionForm;

		AjDept dept = new AjDept();
		PropertyUtils.copyProperties(dept, form);
		dept.setRoleLev(dept.getLevelId());
		dept.setCreateDate(new Date());
		DeptService.updateDept(dept);

		request.setAttribute("action", "update");

		request.setAttribute("id", dept.getId().toString());
		return actionMapping.findForward("success");
	}

	/**
	 * “机构管理”： '停用'、'删除'相应的机构信息
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		SjDeptForm form = (SjDeptForm) actionForm;

		String deptId = request.getParameter("deptId");
		AjDept dept = DeptService.getDept(Long.valueOf(deptId));
		dept.setUseFlag(form.getUseFlag());
		DeptService.updateDept(dept);

		request.setAttribute("action", "delete");
		request.setAttribute("id", dept.getParentId().toString());
		return actionMapping.findForward("success");
	}

	/**
	 * 部门排序
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deptList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String dept = request.getParameter("dept");
		String deptid = request.getParameter("deptId");
		Page page = PageFactory.getPage(request);
		page.setPageSize(100);
		DeptService service = new DeptService();
		List dataList = null;
		if (deptid != null && !deptid.equals(""))
			dataList = service.queryDeptByUpCode(deptid, page);

		request.setAttribute("dataList", dataList);
		request.setAttribute("dept", dept);
		request.setAttribute("deptid", deptid);
		request.setAttribute("page", page);
		return actionMapping.findForward("success");
	}
//
//	/**
//	 * 部门排序 上移功能
//	 * 
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward moveUp(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		String dept = request.getParameter("dept");
//		String deptid = request.getParameter("deptId");
//		String id = request.getParameter("id");
//		String orderByItem = request.getParameter("orderByItem");// 排序用的 序号
//
//		DeptService service = new DeptService();
//		service.toMoveUp(id, orderByItem, deptid);
//
//		request.setAttribute("deptid", deptid);
//		request.setAttribute("dept", dept);
//		return actionMapping.findForward("success");
//	}
//
//	/**
//	 * 部门排序 下移功能
//	 * 
//	 * @param actionMapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward moveDown(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		String dept = request.getParameter("dept");
//		String deptid = request.getParameter("deptId");
//		String id = request.getParameter("id");
//		String orderByItem = request.getParameter("orderByItem");// 排序用的 序号
//
//		DeptService service = new DeptService();
//		service.toMoveDown(id, orderByItem, deptid);
//
//		request.setAttribute("deptid", deptid);
//		request.setAttribute("dept", dept);
//		return actionMapping.findForward("success");
//	}

}
