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

import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.core.util.Base64;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.service.ArchivesCemeteryRegistryService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryLocationService;

/***
 * 业务归档
 * 
 * @author jerry
 * 
 */
public class ArchivesCemeteryRegistryController extends AbstractMultiController {
	private ArchivesCemeteryRegistryService archivesCemeteryRegistryService;
	private CemeteryLocationService cemeteryLocationService;

	public void setCemeteryLocationService(CemeteryLocationService cemeteryLocationService) {
		this.cemeteryLocationService = cemeteryLocationService;
	}

	public void setArchivesCemeteryRegistryService(ArchivesCemeteryRegistryService archivesCemeteryRegistryService) {
		this.archivesCemeteryRegistryService = archivesCemeteryRegistryService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub
		// try {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//
		// String buydate = request.getParameter("buydate");
		// String enddate = request.getParameter("enddate");
		// Date dt = sdf.parse("1900-01-01");
		// if (StringUtils.isNotEmpty(buydate)) {
		// dt = sdf.parse(buydate);
		// } else {
		// dt = sdf.parse("1900-01-01");
		// }
		// ((ArchivesCemeteryRegistry) command).setBuydate(dt);
		//
		// if (StringUtils.isNotEmpty(enddate)) {
		// dt = sdf.parse(enddate);
		// } else {
		// dt = sdf.parse("1900-01-01");
		// }
		// ((ArchivesCemeteryRegistry) command).setEnddate(dt);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, "buydate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		binder.registerCustomEditor(Date.class, "beginBuyDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		binder.registerCustomEditor(Date.class, "endBuyDate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		super.initBinder(request, binder);
	}

	/**
	 * 进入Edit页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistryEdit(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		// ArchivesCemeteryRegistry command = new ArchivesCemeteryRegistry();
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ArchivesCemeteryRegistry registry = archivesCemeteryRegistryService.getArchivesCemeteryRegistryById(id);
		ModelAndView mav = new ModelAndView();

		User user = UserSession.getUser(request);
		mav.addObject("entity", registry);
		mav.setViewName("support_service_edit.jsp");
		return mav;
	}

	/**
	 * 进入View页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistryView(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		// ArchivesCemeteryRegistry command = new ArchivesCemeteryRegistry();
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ArchivesCemeteryRegistry registry = archivesCemeteryRegistryService.getArchivesCemeteryRegistryById(id);
		ModelAndView mav = new ModelAndView();

		User user = UserSession.getUser(request);
		mav.addObject("entity", registry);
		mav.setViewName("support_service_view.jsp");
		return mav;
	}

	/**
	 * 保存--更新
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveArchivesCemeteryRegistryEdit(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		archivesCemeteryRegistryService.updateArchivesCemeteryRegistry(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList");
		return mav;
	}

	/**
	 * 姓名，性别; 证件类型：证件证号 移动电话
	 * 
	 * @param command
	 * @param registry
	 * @return
	 */

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistryPageList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArchivesCemeteryRegistry command = new ArchivesCemeteryRegistry();
		super.bindObject(request, command);
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<ArchivesCemeteryRegistry> list = archivesCemeteryRegistryService.getCemeteryRegistryList(page, command);
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", user);
		mav.addObject("list", list);
		mav.addObject("page", page);
		Long locationId = command.getCemeteryLocationId();
		if (locationId != null && locationId > 0)
			command.setCemeteryLocation(cemeteryLocationService.get(CemeteryLocation.class, locationId));
		mav.addObject("entity", command);
		mav.setViewName("support_service_list.jsp");
		return mav;
	}

	/**
	 * 归档以后返回当前页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView archives(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long[] ids = ServletRequestUtils.getLongParameters(request, "ids");
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		archivesCemeteryRegistryService.saveArchives(ids,isSupply);
		ModelAndView mav = new ModelAndView();
		// 要返回的Base64编码url
		String redirect_registry_url = ServletRequestUtils.getStringParameter(request, "redirect_registry_url");
		mav.setViewName("redirect:" + Base64.decode(redirect_registry_url));
		return mav;
	}
	
	
	/**
	 * 查找归档数据，选择列表页
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistrySelectList(HttpServletRequest request, HttpServletResponse response,ArchivesCemeteryRegistry command) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		Office office = UserSession.getUserDept(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		List<ArchivesCemeteryRegistry> list = null;
		String action_type = ServletRequestUtils.getStringParameter(request, "action_type");
		if("2".equals(action_type) || "3".equals(action_type) || "4".equals(action_type)){
			//2续租登记操作,3合葬登记操作,4迁出登记操作
			list = archivesCemeteryRegistryService.getArchivesCemeteryRegistryTypeList(page, command,office.getLevelid());
		}else if("certificate".equals(action_type)){
			//查询补证登记信息
			list = archivesCemeteryRegistryService.getArchivesCemeteryRegistryCertificateList(page, command,office.getLevelid());
		}else{
			list = archivesCemeteryRegistryService.getArchivesCemeteryRegistryList(page, command,office.getLevelid());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("archives_cemetery_registry_select_list.jsp");
		return mav;
	}
	
	/**
	 * 查找归档数据，选择列表页
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistryQueryList(HttpServletRequest request, HttpServletResponse response,ArchivesCemeteryRegistry command) throws Exception {
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		Office office =  UserSession.getUserDept(request);
		command.setCreateOrgId(user.getDeptid());
		command.setCreateUserId(user.getId());
		
		List<ArchivesCemeteryRegistry> list = archivesCemeteryRegistryService.getArchivesCemeteryRegistryList(page, command,office.getLevelid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("archives_cemetery_registry_query_list.jsp");
		return mav;
	}

	/**
	 * 获取最后一个业务办理内容
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getArchivesCemeteryRegistryConfirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cemeteryRegistryCode = ServletRequestUtils.getStringParameter(request, "cemeteryRegistryCode");
		
		User user = UserSession.getUser(request);
		ArchivesCemeteryRegistry registry = archivesCemeteryRegistryService.getArchivesCemeteryRegistryConfirm(cemeteryRegistryCode, user.getDeptid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("entity", registry);
		mav.setViewName("cemetery_registry_confirm.jsp");
		return mav;
	}
	
	/**
	 * 进入Edit页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editArchivesCemeteryRegistry(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ArchivesCemeteryRegistry registry = archivesCemeteryRegistryService.getArchivesCemeteryRegistryById(id);
		ModelAndView mav = new ModelAndView();

		User user = UserSession.getUser(request);
		mav.addObject("entity", registry);
		mav.setViewName("archives_cemetery_registry_edit.jsp");
		return mav;
	}
	/**
	 * 进入View页
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView showArchivesCemeteryRegistryView(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ArchivesCemeteryRegistry registry = archivesCemeteryRegistryService.getArchivesCemeteryRegistryById(id);
		ModelAndView mav = new ModelAndView();
		
		User user = UserSession.getUser(request);
		mav.addObject("entity", registry);
		mav.setViewName("archives_cemetery_registry_view.jsp");
		return mav;
	}
	/**
	 * 保存--更新
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveArchivesCemeteryRegistryEditInfo(HttpServletRequest request, HttpServletResponse response, ArchivesCemeteryRegistry command)
			throws Exception {
		User user = UserSession.getUser(request);
		ModelAndView mv = new ModelAndView();
		//保存档案登记
		if (command.getId() != null && command.getId().longValue() > 0) {
			archivesCemeteryRegistryService.updateArchivesCemeteryRegistryEditInfo(command);
		} /*else {
			command.setCreateUserId(user.getId());
			command.setCreateOrgId(user.getDeptid());
			command.setCreateDate(new Date());
			//this.cemeteryRegistryService.saveCemeteryRegistry(command);
		}*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryQueryList");
		return mav;
	}
	
	public ModelAndView getCemeteryChargeframe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ArchivesCemeteryRegistry cemeteryRegistry = archivesCemeteryRegistryService.load(ArchivesCemeteryRegistry.class, id);
		ModelAndView mv = new ModelAndView("archives_cemetery_charge_frame.jsp");
		mv.addObject("cemeteryRegistry", cemeteryRegistry);
		return mv;
	}
	public ModelAndView saveCemeteryChargeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType", 0);
		Long cemeteryRegistryId = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryId");
		long[] id = ServletRequestUtils.getLongParameters(request, "id");
		long[] isChargeType = ServletRequestUtils.getLongParameters(request, "isChargeType");
		long[] count = ServletRequestUtils.getLongParameters(request, "count");
		float[] receive = ServletRequestUtils.getFloatParameters(request, "receive");
		ModelAndView mav = new ModelAndView();

		//如果是补录时增加费用后跳转到method=editCemeteryRegistrySupply的位置
		/*Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			if (receive.length > 0) {
				archivesCemeteryRegistryService.addCemeteryChargeList(cemeteryRegistryId, id, isChargeType, count, receive,user);
			}
			mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{*/
			if (receive.length > 0) {
				archivesCemeteryRegistryService.addCemeteryChargeList(cemeteryRegistryId, (long) Constant.OUT_STOREHOUSE_SELL, id, isChargeType, count, receive,
						user);
			}
			mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		//}
		return mav;
	}
	
	/**
	 * add bai 2014-11-05 删除商品/费用信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryCharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType", 0);
		Long cemeteryRegistryId = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryId", 0);
		ModelAndView mav = new ModelAndView();
		//如果是补录时删除费用后跳转到method=editCemeteryRegistrySupply的位置
		/*Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			archivesCemeteryRegistryService.deleteCemeteryChargeSupply(id);
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{*/
			archivesCemeteryRegistryService.deleteCemeteryCharge(id);
			mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		//}
		return mav;
	}
	
	/**
	 * 执行文件上传，进入文件界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryFileEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("archives_cemetery_file_edit.jsp");
		ArchivesCemeteryFile cf = new ArchivesCemeteryFile();
		cf.setCreateDate(new Date());
		cf.setCreateUserId(UserSession.getUser(request).getId());
		mv.addObject("cemeteryFile", cf);
		return mv;
	}

	/**
	 * 增加文件
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long cemeteryRegistryId = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryId");
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType");
		String fileIds = ServletRequestUtils.getStringParameter(request, "fileId");
		String remark = ServletRequestUtils.getStringParameter(request, "remark");
		System.out.println(cemeteryRegistryId+","+fileIds+","+remark);
		archivesCemeteryRegistryService.saveCemeteryFileList(cemeteryRegistryId, fileIds, remark);
		ModelAndView mav = new ModelAndView();
		
		//如果是补录时增加的文件跳转到method=editCemeteryRegistrySupply的位置
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		/*if(isSupply.intValue() == 1){
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{*/
			mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		//}
		return mav;
	}

	/**
	 * 删除上传文件
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType");
		Long cemeteryRegistryId = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryId");
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		archivesCemeteryRegistryService.deleteCemeteryFileById(id);
		//如果是补录时删除的文件跳转到method=editCemeteryRegistrySupply的位置
		/*Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{*/
			//mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		//}
		mav.setViewName("redirect:archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		return mav;
	}

}
