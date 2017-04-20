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
		// added by pengzuocong 2012-5-18 �ǿ��ж�
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
	 * ������������ '����'��Ӧ�Ļ�����Ϣ
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
		Long regionId = form.getRegionId();// �õ�����ID

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
//		dept.setDwdm(regionCode);// ��λ������������
		// ���ű���=�������+��λ����+��Ա��λ���Ʊ���+����
//		String deptCode = standardNo + form.getDwlx() + form.getCybm();
//		String finalDeptCode = "";
//		if (form.getJgmx().intValue() == 1) {// ����
//			// ��Ŀǰ�ı����һ�£����ɿ��Һš����ɹ���+1
//			int deptSize = deptService.getDeptCodeSize(deptCode);// ��ǰ��
//			int finalSize = 1000 + deptSize + 1;// ��ǰ��+1����һ��
//			String finalSizeCode = String.valueOf(finalSize);
//			// ��ʱ�����ɵĺ���1xxx ����Ҫ��1ȥ��������XXX
//			finalDeptCode = finalSizeCode.substring(1, 4);
//			deptCode = deptCode + finalDeptCode;
//		} else {// ���¼�������
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
	 * ������������ '��ʾ��Ҫ�޸�'�Ļ�����Ϣ
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
		// �����һ��parentIdΪ0����������û��Ϊ0�����ݣ�����id��ȡ���ݻ��׳��쳣
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
	 * ������������ '�޸�'��Ӧ�Ļ�����Ϣ
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
	 * ������������ 'ͣ��'��'ɾ��'��Ӧ�Ļ�����Ϣ
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
	 * ��������
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
//	 * �������� ���ƹ���
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
//		String orderByItem = request.getParameter("orderByItem");// �����õ� ���
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
//	 * �������� ���ƹ���
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
//		String orderByItem = request.getParameter("orderByItem");// �����õ� ���
//
//		DeptService service = new DeptService();
//		service.toMoveDown(id, orderByItem, deptid);
//
//		request.setAttribute("deptid", deptid);
//		request.setAttribute("dept", dept);
//		return actionMapping.findForward("success");
//	}

}
