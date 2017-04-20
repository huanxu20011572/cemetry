package com.topsuntech.gUnit_gmgl.gEU_cemetery.framework;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryChargeService;

public class CemeteryChargeController extends AbstractMultiController{
	
	private CemeteryChargeService cemeteryChargeService;

	public void setCemeteryChargeService(CemeteryChargeService cemeteryChargeService) {
		this.cemeteryChargeService = cemeteryChargeService;
	}
	
	/**
	 * 查找商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryChargeList(HttpServletRequest request, HttpServletResponse response,CemeteryCharge command) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<CemeteryCharge> list = cemeteryChargeService.getCemeteryChargeList(page, command);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("user", user);
		
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("cemetery_charge_list.jsp");
		return mav;
	}
//
//
	/**
	 * 显示新增或编辑商品页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editCemeteryCharge(HttpServletRequest request, HttpServletResponse response,CemeteryCharge command) throws Exception {
		User user = UserSession.getUser(request);
		ModelAndView mav = new ModelAndView();
		CemeteryCharge cemeteryCharge = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			cemeteryCharge = cemeteryChargeService.get(CemeteryCharge.class, command.getId());
			mav.addObject("cemeteryCharge", cemeteryCharge);
		}
		if (cemeteryCharge==null) {
			cemeteryCharge = new CemeteryCharge();
			cemeteryCharge.setCreateUserId(user.getId());
			cemeteryCharge.setCreateDate(new Date());
			mav.addObject("cemeteryCharge", cemeteryCharge);
		}
		mav.setViewName("cemetery_charge_edit.jsp");
		return mav;
	}
	
	/**
	 * 显示查看商品页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showCemeteryCharge(HttpServletRequest request, HttpServletResponse response,CemeteryCharge command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			CemeteryCharge cemeteryCharge = cemeteryChargeService.get(CemeteryCharge.class, command.getId());
			mav.addObject("cemeteryCharge", cemeteryCharge);
		}
		mav.setViewName("cemetery_charge_show.jsp");
		return mav;
	}

	/**
	 * add bai 2014-11-05 批量添加商品/费用信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryChargeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		Long outStorehouseType = ServletRequestUtils.getLongParameter(request, "outStorehouseType");
		long[] id = ServletRequestUtils.getLongParameters(request, "id");
		long[] isChargeType = ServletRequestUtils.getLongParameters(request, "isChargeType");
		long[] count = ServletRequestUtils.getLongParameters(request, "count");
		float[] receive = ServletRequestUtils.getFloatParameters(request, "receive");
		if (receive.length > 0) {
			cemeteryChargeService.addCemeteryChargeList(null, outStorehouseType, id, isChargeType, count, receive,
					user);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryChargeController.fj?method=getCemeteryChargeList");
		return mav;
	}

	/**
	 * 删除商品的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryCharge(HttpServletRequest request, HttpServletResponse response,CemeteryCharge command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		cemeteryChargeService.deleteCemeteryCharge(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryChargeController.fj?method=getCemeteryChargeList");
		return mav;
	}
	
	/**
	 * 删除商品的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryChargeSupply(HttpServletRequest request, HttpServletResponse response,CemeteryCharge command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		cemeteryChargeService.deleteCemeteryChargeSupply(id);;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryChargeController.fj?method=getCemeteryChargeList");
		return mav;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command,
			ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}

}
