package com.topsuntech.gUnit_gmgl.gEU_business.framework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.VisitReturn;
import com.topsuntech.gUnit_gmgl.gEU_business.service.FirstPageService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

/**
 * 首页
 * @author zhangzhenkun
 *
 */
public class FirstPageController extends AbstractMultiController {
	private FirstPageService firstPageService;

	public void setFirstPageService(FirstPageService firstPageService) {
		this.firstPageService = firstPageService;
	}

	public ModelAndView getFirstList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		Long loginOrgId = user.getDeptid();
		//下面代码查询待回访提醒
		VisitReturn visitReturn = new VisitReturn();
		visitReturn.setCreateOrgId(loginOrgId);
		visitReturn.setIsReturn(new Long("0"));//0表示未回访
		//查询“待回访提醒”信息
		List<VisitReturn> visitReturnList = firstPageService.getVisitReturnList(page, visitReturn);
		
		//下面代码查询待安放提醒
		CemeteryRegistry waitingPlaceEntity = new CemeteryRegistry();
		waitingPlaceEntity.setCemeteryRegistryType(Constant.CEMETERY_STATUS_RETAIN);//  待安放的查询条件
		waitingPlaceEntity.setCreateOrgId(loginOrgId);
		//查询“待安放提醒”信息
		List<CemeteryRegistry> waitingPlaceList = firstPageService.getWaitingPlaceList(page, waitingPlaceEntity);
		
		//下面代码查询待归档提醒
		CemeteryRegistry waitingArchivesEntity = new CemeteryRegistry();
		waitingArchivesEntity.setCemeteryRegistryType(Constant.CEMETERY_STATUS_LOCK);//  待归档的查询条件
		waitingArchivesEntity.setCreateOrgId(loginOrgId);
		//查询“待归档提醒”信息
		List<CemeteryRegistry> waitingArchivesList = firstPageService.getWaitingArchivesList(page, waitingArchivesEntity);
		
		//下面代码查询待续租提醒，即查询最近30天到期的信息
		ArchivesCemeteryRegistry waitingReletEntity = new ArchivesCemeteryRegistry();
		waitingReletEntity.setCreateOrgId(loginOrgId);
		//查询“待续租提醒”信息
		List<ArchivesCemeteryRegistry> waitingReletList = firstPageService.getWaitingReletList(page, waitingReletEntity);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("visitReturnList", visitReturnList);
		mav.addObject("waitingPlaceList", waitingPlaceList);
		mav.addObject("waitingArchivesList", waitingArchivesList);
		mav.addObject("waitingReletList", waitingReletList);
		mav.addObject("visitReturnListSize", visitReturnList.size());
		mav.addObject("waitingPlaceListSize", waitingPlaceList.size());
		mav.addObject("waitingArchivesListSize", waitingArchivesList.size());
		mav.addObject("waitingReletListSize", waitingReletList.size());
		mav.addObject("page", page);
		mav.setViewName("first_page_list.jsp");
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
