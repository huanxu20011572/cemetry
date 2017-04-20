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
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.CemeteryService;
import com.topsuntech.gUnit_gmgl.gEU_business.service.CemeteryServiceService;

/**
 * 服务事项
 * 
 * @author jerry
 * 
 */
public class CemeteryServiceController extends AbstractMultiController {
	private CemeteryServiceService cemeteryServiceService;

	public void setCemeteryServiceService(CemeteryServiceService cemeteryServiceService) {
		this.cemeteryServiceService = cemeteryServiceService;
	}

	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, "begindate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		super.initBinder(request, binder);
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}

	/**
	 * 分页查询服务事项
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryServicePageList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_service_list.jsp");
		ArchivesCemeteryRegistry command = new ArchivesCemeteryRegistry();
		super.bindObject(request, command);
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		List<CemeteryService> list = cemeteryServiceService.getCemeteryServicePageList(page, command);
		mv.addObject("list", list);
		mv.addObject("entity", command);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 编辑
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryServiceView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_service_show.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		CemeteryService en = cemeteryServiceService.load(CemeteryService.class, id);
		mv.addObject("entity", en);
		return mv;
	}

	/**
	 * 查看
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryServiceEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_service_edit.jsp");
		User user=UserSession.getUser(request);
	
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Long registryId = ServletRequestUtils.getLongParameter(request, "registryId", 0);
		if (0 != id) {
			CemeteryService en = cemeteryServiceService.load(CemeteryService.class, id);
			if (null != en)
				mv.addObject("entity", en);
		}
		if (0 != registryId) {
			mv.addObject("registryId", registryId);
			CemeteryService command=new CemeteryService();
			command.setCreateDate(new Date());
			command.setCreateOrgId(user.getDeptid());
			command.setCreateUserId(user.getId());
			mv.addObject("entity", command);
		}
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		cemeteryServiceService.deleteCemeteryService(id);
		mv.setViewName("redirect:cemeteryServiceController.fj?method=getCemeteryServicePageList");
		return mv;
	}

	/**
	 * 保存
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryService(HttpServletRequest request, HttpServletResponse response, CemeteryService command) throws Exception {
		ModelAndView mv = new ModelAndView();
		Long registryId = ServletRequestUtils.getLongParameter(request, "registryId", 0);
		User user=UserSession.getUser(request);
		command.setCreateDate(new Date());
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		cemeteryServiceService.saveCemeteryService(command, registryId);
		mv.setViewName("redirect:cemeteryServiceController.fj?method=getCemeteryServicePageList");
		return mv;
	}
}
