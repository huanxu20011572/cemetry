package com.topsuntech.gUnit_gmgl.gEU_business.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.util.Base64;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;
import com.topsuntech.gUnit_gmgl.gEU_business.service.DepartedService;

/**
 * 逝者信息
 * 
 * @author jerry
 * 
 */
public class DepartedController extends AbstractMultiController {
	private DepartedService departedService;

	public void setDepartedService(DepartedService departedService) {
		this.departedService = departedService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}


	/**
	 * 进入设置逝者信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editDeparted(HttpServletRequest request, HttpServletResponse response,Departed command) throws Exception {
		ModelAndView mv = new ModelAndView("departed_edit.jsp");
		User user = UserSession.getUser(request);
		if(command.getId() != null && command.getId().longValue() > 0){
			command = departedService.load(Departed.class, command.getId());
		}else{
			command.setCreateDate(new Date());
			command.setCreateOrgId(user.getDeptid());
			command.setCreateUserId(user.getId());
		}
		mv.addObject("entity", command);
		return mv;
	}


	/**
	 * 保存登记信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveDeparted(HttpServletRequest request, HttpServletResponse response,Departed command) throws Exception {
		User user = UserSession.getUser(request);
		if(command.getId() == null || command.getId().longValue() <= 0){
			command.setCreateDate(new Date());
			command.setCreateUserId(user.getId());
			command.setCreateOrgId(user.getDeptid());
		}
		departedService.saveOrUpdate(command);
		String redirect_url = ServletRequestUtils.getStringParameter(request, "redirect_url");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:"+Base64.decode(redirect_url));
		mav.addObject("entity",command);
		return mav;
	}

	/**
	 * 查看逝者
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getDepartedViewById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("departed_view.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Departed departed = this.departedService.load(Departed.class, id);
		mv.addObject("entity", departed);
		return mv;
	}

	/**
	 * modify bai 2014-11-02
	 * 删除逝者
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteDepartedById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		String redirect_url = ServletRequestUtils.getStringParameter(request, "redirect_url");
		this.departedService.deleteDeparted(id);
		mav.setViewName("redirect:"+Base64.decode(redirect_url));
		return mav;
	}
	
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
	    binder.registerCustomEditor(Date.class, "deadDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
	    binder.registerCustomEditor(Date.class, "orderBuryDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
	    binder.registerCustomEditor(Date.class, "factBuryDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		super.initBinder(request, binder);
	}

}
