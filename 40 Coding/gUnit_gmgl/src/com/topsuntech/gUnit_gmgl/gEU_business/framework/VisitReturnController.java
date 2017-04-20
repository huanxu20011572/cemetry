package com.topsuntech.gUnit_gmgl.gEU_business.framework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.VisitReturn;
import com.topsuntech.gUnit_gmgl.gEU_business.service.VisitReturnService;

/**
 * 来访登记
 * @author zhangzhenkun
 *
 */
public class VisitReturnController extends AbstractMultiController {
	private VisitReturnService visitReturnService;

	public void setVisitReturnService(VisitReturnService visitReturnService) {
		this.visitReturnService = visitReturnService;
	}

	/**
	 * 查找来访信息列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getVisitReturnList(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<VisitReturn> list = visitReturnService.getVisitReturnList(page, command);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("visit_return_list.jsp");
		return mav;
	}
	
	/**
	 * 显示新增或编辑来访信息页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editVisitReturn(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		VisitReturn visitReturn = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			visitReturn = visitReturnService.get(VisitReturn.class, command.getId());
			mav.addObject("visitReturn", visitReturn);
		}
		if (visitReturn==null) {
			visitReturn = new VisitReturn();
			visitReturn.setCreateUserId(user.getId());
			visitReturn.setCreateDate(new Date());
			mav.addObject("visitReturn", visitReturn);
			
			mav.addObject("user", user);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			mav.addObject("currentTime", sdf.format(new Date()));
		}
		mav.setViewName("visit_return_edit.jsp");
		return mav;
	}
	
	/**
	 * 保存来访登记的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveVisitReturn(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		
		visitReturnService.saveVisitReturn(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:visitReturnController.fj?method=getVisitReturnList");
		return mav;
	}
	
	/**
	 * 显示回访来访信息页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView backVisitReturn(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		VisitReturn visitReturn = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			visitReturn = visitReturnService.get(VisitReturn.class, command.getId());
			if (visitReturn!=null && visitReturn.getReturnDate()==null) {
				visitReturn.setReturnDate(new Date());
			}
			if (visitReturn!=null && visitReturn.getReturnUserId()==null) {
				visitReturn.setReturnUserId(user.getId());
			}
			mav.addObject("visitReturn", visitReturn);
		}
		
		mav.setViewName("visit_return_back.jsp");
		return mav;
	}
	
	/**
	 * 保存回访情况的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveVisitReturnBack(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		User user = UserSession.getUser(request);
		command.setReturnUserId(user.getId());
		
		visitReturnService.saveVisitReturnBack(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:visitReturnController.fj?method=getVisitReturnList");
		return mav;
	}
	
	/**
	 * 显示查看来访信息页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showVisitReturn(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			VisitReturn visitReturn = visitReturnService.get(VisitReturn.class, command.getId());
			mav.addObject("visitReturn", visitReturn);
		}
		mav.setViewName("visit_return_show.jsp");
		return mav;
	}
	
	/**
	 * 删除来访信息的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteVisitReturn(HttpServletRequest request, HttpServletResponse response,VisitReturn command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		visitReturnService.deleteVisitReturn(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:visitReturnController.fj?method=getVisitReturnList");
		return mav;
	}
	
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, "beginCreateDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
	    binder.registerCustomEditor(Date.class, "endCreateDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		super.initBinder(request, binder);
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}
}
