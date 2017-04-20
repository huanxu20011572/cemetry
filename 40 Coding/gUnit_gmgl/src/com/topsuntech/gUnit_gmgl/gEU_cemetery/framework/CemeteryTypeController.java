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
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryTypeService;

public class CemeteryTypeController extends AbstractMultiController{
	
	private CemeteryTypeService cemeteryTypeService;

	public void setCemeteryTypeService(CemeteryTypeService cemeteryTypeService) {
		this.cemeteryTypeService = cemeteryTypeService;
	}
	
	/**
	 * 查找墓型列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryTypeList(HttpServletRequest request, HttpServletResponse response,CemeteryType command) throws Exception {
		Page page = PageConfig.getPage(request);
		String businessName = ServletRequestUtils.getStringParameter(request, "businessName");
		BusinessData businessData = new BusinessData();
		businessData.setBusinessName(businessName);
		command.setBusinessData(businessData);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<CemeteryType> list = cemeteryTypeService.getCemeteryTypeList(page, command);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		List<BusinessData> businessDataList = cemeteryTypeService.getBusinessDataList();
		mav.addObject("businessDataList", businessDataList);
		mav.setViewName("cemetery_type_list.jsp");
		return mav;
	}
//
//
	/**
	 * 显示新增或编辑墓型页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editCemeteryType(HttpServletRequest request, HttpServletResponse response,CemeteryType command) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		CemeteryType cemeteryType = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			cemeteryType = cemeteryTypeService.get(CemeteryType.class, command.getId());
			mav.addObject("cemeteryType", cemeteryType);
		}
		if (cemeteryType==null) {
			cemeteryType = new CemeteryType();
			cemeteryType.setCreateUserId(user.getId());
			cemeteryType.setCreateDate(new Date());
			mav.addObject("cemeteryType", cemeteryType);
		}
		List<BusinessData> businessDataList = cemeteryTypeService.getBusinessDataList();
		mav.addObject("businessDataList", businessDataList);
		mav.setViewName("cemetery_type_edit.jsp");
		return mav;
	}
	
	/**
	 * 显示查看墓型页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showCemeteryType(HttpServletRequest request, HttpServletResponse response,CemeteryType command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			CemeteryType cemeteryType = cemeteryTypeService.get(CemeteryType.class, command.getId());
			mav.addObject("cemeteryType", cemeteryType);
		}
		mav.setViewName("cemetery_type_show.jsp");
		return mav;
	}
//
	/**
	 * 保存墓型的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryType(HttpServletRequest request, HttpServletResponse response,CemeteryType command) throws Exception {
		
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		
		cemeteryTypeService.saveCemeteryType(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryTypeController.fj?method=getCemeteryTypeList");
		return mav;
	}

	/**
	 * 删除墓型的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryType(HttpServletRequest request, HttpServletResponse response,CemeteryType command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		cemeteryTypeService.deleteCemeteryType(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryTypeController.fj?method=getCemeteryTypeList");
		return mav;
	}
	
	@Override
	protected void preBind(HttpServletRequest request, Object command,
			ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}

}
