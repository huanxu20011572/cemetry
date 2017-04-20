package com.topsuntech.gUnit_gmgl.gEU_business.framework;

import java.text.SimpleDateFormat;
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
import com.topsuntech.gUnit_gmgl.gEU_business.service.BusinessDataService;

/**
 * 机构业务明细
 * @author zhangzhenkun
 *
 */
public class BusinessDataController extends AbstractMultiController {
	private BusinessDataService businessDataService;

	public void setBusinessDataService(BusinessDataService businessDataService) {
		this.businessDataService = businessDataService;
	}

	/**
	 * 查找机构业务分类列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getBusinessDataList(HttpServletRequest request, HttpServletResponse response,BusinessData command) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<BusinessData> list = businessDataService.getBusinessDataList(page, command);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("business_data_list.jsp");
		return mav;
	}
	
	/**
	 * 显示新增或编辑分类管理页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editBusinessData(HttpServletRequest request, HttpServletResponse response,BusinessData command) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		BusinessData businessData = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			businessData = businessDataService.get(BusinessData.class, command.getId());
			mav.addObject("businessData", businessData);
		}
		if (businessData==null) {
			businessData = new BusinessData();
			businessData.setCreateUserId(user.getId());
			businessData.setCreateDate(new Date());
			mav.addObject("businessData", businessData);
			
			mav.addObject("user", user);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			mav.addObject("currentTime", sdf.format(new Date()));
		}
		mav.setViewName("business_data_edit.jsp");
		return mav;
	}
	
	/**
	 * 保存分类的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveBusinessData(HttpServletRequest request, HttpServletResponse response,BusinessData command) throws Exception {
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		
		businessDataService.saveBusinessData(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:businessDataController.fj?method=getBusinessDataList");
		return mav;
	}
	
	/**
	 * 显示查看分类页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showBusinessData(HttpServletRequest request, HttpServletResponse response,BusinessData command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			BusinessData businessData = businessDataService.get(BusinessData.class, command.getId());
			mav.addObject("businessData", businessData);
		}
		mav.setViewName("business_data_show.jsp");
		return mav;
	}
	
	/**
	 * 删除分类的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteBusinessData(HttpServletRequest request, HttpServletResponse response,BusinessData command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		businessDataService.deleteBusinessData(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:businessDataController.fj?method=getBusinessDataList");
		return mav;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}
}
