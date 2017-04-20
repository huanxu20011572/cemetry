package com.topsuntech.gUnit_gmgl.gEU_business.framework;

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
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.CemeteryCertificate;
import com.topsuntech.gUnit_gmgl.gEU_business.service.CemeteryCertificateService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;

public class CemeteryCertificateController extends AbstractMultiController{
	
	private CemeteryCertificateService cemeteryCertificateService;

	public void setCemeteryCertificateService(CemeteryCertificateService cemeteryCertificateService) {
		this.cemeteryCertificateService = cemeteryCertificateService;
	}
	
	/**
	 * 查找补证列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryCertificatePageList(HttpServletRequest request, HttpServletResponse response,CemeteryCertificate command) throws Exception {
		Page page = PageConfig.getPage(request);
		ArchivesCemeteryRegistry archivesCemeteryRegistry = new ArchivesCemeteryRegistry();
		String cemeteryRegistryCode = ServletRequestUtils.getStringParameter(request, "cemeteryRegistryCode");
		archivesCemeteryRegistry.setCemeteryRegistryCode(cemeteryRegistryCode);
		String cemeteryLocationId = ServletRequestUtils.getStringParameter(request, "cemeteryLocationId");
		cemeteryLocationId = cemeteryLocationId==null || "".equals(cemeteryLocationId) ? "0" : cemeteryLocationId;
		CemeteryLocation cemeteryLocation = new CemeteryLocation();
		cemeteryLocation.setId(new Long(cemeteryLocationId));
		archivesCemeteryRegistry.setCemeteryLocation(cemeteryLocation);
		String name = ServletRequestUtils.getStringParameter(request, "name");
		archivesCemeteryRegistry.setName(name);
		String mobilePhone = ServletRequestUtils.getStringParameter(request, "mobilePhone");
		archivesCemeteryRegistry.setMobilePhone(mobilePhone);
		command.setArchivesCemeteryRegistry(archivesCemeteryRegistry);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<CemeteryCertificate> list = cemeteryCertificateService.getCemeteryCertificateList(page, command);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("cemetery_certificate_list.jsp");
		return mav;
	}
	/**
	 * 显示新增或编辑补证页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editCemeteryCertificate(HttpServletRequest request, HttpServletResponse response,CemeteryCertificate command) throws Exception {
		
		String archivesCemeteryRegistryId = ServletRequestUtils.getStringParameter(request, "archivesCemeteryRegistryId");
		archivesCemeteryRegistryId = archivesCemeteryRegistryId==null || "".equals(archivesCemeteryRegistryId)?"0":archivesCemeteryRegistryId;
		
		ModelAndView mav = new ModelAndView();
		User user = UserSession.getUser(request);
		CemeteryCertificate cemeteryCertificate = null;
		if(command.getId() != null  && command.getId().longValue() > 0){
			cemeteryCertificate = cemeteryCertificateService.get(CemeteryCertificate.class, command.getId());
			mav.addObject("cemeteryCertificate", cemeteryCertificate);
		}
		if (cemeteryCertificate==null) {
			cemeteryCertificate = new CemeteryCertificate();
			cemeteryCertificate.setCreateUserId(user.getId());
			cemeteryCertificate.setCreateDate(new Date());
			cemeteryCertificate.setArchivesCemeteryRegistryId(new Long(archivesCemeteryRegistryId));
			mav.addObject("cemeteryCertificate", cemeteryCertificate);
		}
		List<BusinessData> businessDataList = cemeteryCertificateService.getBusinessDataList();
		mav.addObject("businessDataList", businessDataList);
		mav.setViewName("cemetery_certificate_edit.jsp");
		return mav;
	}
	
	/**
	 * 显示查看补证页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView showCemeteryCertificate(HttpServletRequest request, HttpServletResponse response,CemeteryCertificate command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(command.getId() != null  && command.getId().longValue() > 0){
			CemeteryCertificate cemeteryCertificate = cemeteryCertificateService.get(CemeteryCertificate.class, command.getId());
			mav.addObject("cemeteryCertificate", cemeteryCertificate);
		}
		mav.setViewName("cemetery_certificate_show.jsp");
		return mav;
	}
//
	/**
	 * 保存补证的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryCertificate(HttpServletRequest request, HttpServletResponse response,CemeteryCertificate command) throws Exception {
		
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		
		cemeteryCertificateService.saveCemeteryCertificate(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryCertificateController.fj?method=getCemeteryCertificatePageList");
		return mav;
	}

	/**
	 * 删除补证的方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryCertificate(HttpServletRequest request, HttpServletResponse response,CemeteryCertificate command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id",0);
		cemeteryCertificateService.deleteCemeteryCertificate(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryCertificateController.fj?method=getCemeteryCertificatePageList");
		return mav;
	}
	
	@Override
	protected void preBind(HttpServletRequest request, Object command,
			ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		
	}

}
