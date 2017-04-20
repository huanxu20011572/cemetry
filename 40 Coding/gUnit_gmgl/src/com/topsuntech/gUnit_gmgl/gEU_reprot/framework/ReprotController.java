package com.topsuntech.gUnit_gmgl.gEU_reprot.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;

/***
 * 统计报表
 * 
 * @author baiweiming
 * 
 */
public class ReprotController extends AbstractMultiController {

	/**
	 * 墓区信息一览表
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView orgLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("org_location.jsp");
		return mav;
	}

	/**
	 * 墓区信息一览表
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView subOrgLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		mav.setViewName("sub_org_location.jsp?org_id="+user.getDeptid()+"&org_name="+user.getDeptname());
		return mav;
	}

	/**
	 * 墓区信息一览表(公墓)
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView typeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		mav.setViewName("type_detail.jsp?createOrgId="+user.getDeptid()+"&org_name="+user.getDeptname());
		return mav;
	}

	/**
	 * 墓区信息一览表(公墓)
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView subCaveUserCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		mav.setViewName("sub_cave_user_case.jsp?org_id="+user.getDeptid()+"&org_name="+user.getDeptname());
		return mav;
	}

	/**
	 * 墓区信息一览表(市级)
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView caveUserCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		mav.setViewName("cave_user_case.jsp");
		return mav;
	}
	
	/**
	 * 公墓同期业务对比表(公墓级)
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView subPeriodBusiness(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		mav.addObject("user", user);
		mav.setViewName("sub_period_business.jsp");
		return mav;
	}
	
	/**
	 * 打印业务单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView businessDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		User user = UserSession.getUser(request);
		mav.addObject("user", user);
		mav.setViewName("business_detail.jsp?id="+id+"&org_name="+user.getDeptname());
		return mav;
	}

	/**
	 * 打印安葬证
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView burialDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		User user = UserSession.getUser(request);
		mav.addObject("user", user);
		mav.setViewName("burial_detail.jsp?id="+id+"&org_name="+user.getDeptname());
		return mav;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}

}
