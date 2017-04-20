package com.topsuntech.gUnit_gmgl.gEU_cemetery.framework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCommodity;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryCommodityService;

public class CemeteryCommodityController extends AbstractMultiController{
	
	private CemeteryCommodityService cemeteryCommodityService;

	public void setCemeteryCommodityService(CemeteryCommodityService cemeteryCommodityService) {
		this.cemeteryCommodityService = cemeteryCommodityService;
	}
	
	/**
	 * 查找商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryCommodityList(HttpServletRequest request, HttpServletResponse response,CemeteryCommodity command) throws Exception {
		Page page = PageConfig.getPage(request);
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<CemeteryCommodity> list = cemeteryCommodityService.getCemeteryCommodityList(page, command);
		
		mav.addObject("user", user);
		
		mav.addObject("list", list);
		mav.addObject("page", page);
		
		String checked = ServletRequestUtils.getStringParameter(request, "checked", "");
		if(StringUtils.isNotEmpty("checked") && "checked".equals(checked)){
			mav.setViewName("cemetery_commondity_checked_list.jsp");
		}else{
			mav.setViewName("cemetery_commondity_list.jsp");
		}
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
	public ModelAndView editCemeteryCommodity(HttpServletRequest request, HttpServletResponse response,CemeteryCommodity command) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		CemeteryCommodity cemeteryCommodity = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			cemeteryCommodity = cemeteryCommodityService.get(CemeteryCommodity.class, command.getId());
			mav.addObject("cemeteryCommodity", cemeteryCommodity);
		}
		if (cemeteryCommodity == null) {
			cemeteryCommodity = new CemeteryCommodity();
			cemeteryCommodity.setCreateDate(new Date());
			cemeteryCommodity.setCreateUserId(user.getId());
			mav.addObject("cemeteryCommodity", cemeteryCommodity);
			
			mav.addObject("user", user);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			mav.addObject("currentTime", sdf.format(new Date()));
		}
		mav.setViewName("cemetery_commondity_edit.jsp");
		return mav;
	}
	
	/**
	 * 显示查看商品页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showCemeteryCommodity(HttpServletRequest request, HttpServletResponse response,CemeteryCommodity command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			CemeteryCommodity cemeteryCommodity = cemeteryCommodityService.get(CemeteryCommodity.class, command.getId());
			mav.addObject("cemeteryCommodity", cemeteryCommodity);
		}
		mav.setViewName("cemetery_commondity_show.jsp");
		return mav;
	}
	
	/**
	 * 获取商品json
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryCommodityJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		CemeteryCommodity cemeteryCommodity = cemeteryCommodityService.get(CemeteryCommodity.class, id);
		ajaxResult(response, cemeteryCommodity);
		return null;
	}

//
	/**
	 * 保存商品的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryCommodity(HttpServletRequest request, HttpServletResponse response,CemeteryCommodity command) throws Exception {
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateDate(new Date());
		command.setCreateOrgId(user.getDeptid());
		cemeteryCommodityService.saveCemeteryCommodity(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryCommodityController.fj?method=getCemeteryCommodityList");
		return mav;
	}

	/**
	 * 删除商品的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryCommodity(HttpServletRequest request, HttpServletResponse response,CemeteryCommodity command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		cemeteryCommodityService.deleteCemeteryCommodity(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryCommodityController.fj?method=getCemeteryCommodityList");
		return mav;
	}
	
	@Override
	protected void preBind(HttpServletRequest request, Object command,
			ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}

}
