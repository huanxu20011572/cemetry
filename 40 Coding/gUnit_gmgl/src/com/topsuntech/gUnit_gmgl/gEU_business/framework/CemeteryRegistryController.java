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

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.service.ArchivesCemeteryRegistryService;
import com.topsuntech.gUnit_gmgl.gEU_business.service.CemeteryRegistryService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryChargeService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryFileService;

/**
 * 登记业务
 */
public class CemeteryRegistryController extends AbstractMultiController {
	private CemeteryRegistryService cemeteryRegistryService;
	private CemeteryFileService cemeteryFileService;
	private CemeteryChargeService cemeteryChargeService;
	private ArchivesCemeteryRegistryService archivesCemeteryRegistryService;
	
	public void setCemeteryFileService(CemeteryFileService cemeteryFileService) {
		this.cemeteryFileService = cemeteryFileService;
	}

	public void setCemeteryRegistryService(CemeteryRegistryService cemeteryRegistryService) {
		this.cemeteryRegistryService = cemeteryRegistryService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
	}

	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, "buydate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(new SimpleDateFormat(DateUtils.yyyy_MM_dd), true));
		super.initBinder(request, binder);
	}

	/**
	 * modify baiweiming 2014-10-29 查询租用等列表
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryRegistryPageList(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command)
			throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_registry_list.jsp");
		User user = UserSession.getUser(request);
		Page page = PageConfig.getPage(request);
		command.setIsSupply(Long.valueOf(Constant.NO));
		command.setCreateOrgId(user.getDeptid());
		List<CemeteryRegistry> list = this.cemeteryRegistryService.getCemeteryRegistryPageList(page, command);
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * add baiweiming 2014-11-20 查询补录列表
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryRegistryPageSupplyList(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command)
			throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_registry_supply_list.jsp");
		Page page = PageConfig.getPage(request);
		User user = UserSession.getUser(request);
		command.setIsSupply(Long.valueOf(Constant.YES));
		command.setCreateOrgId(user.getDeptid());
		List<CemeteryRegistry> list = this.cemeteryRegistryService.getCemeteryRegistryPageList(page, command);
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}


	/**
	 * modify baiweiming 2014-11-17 进入业务办理，生产业务编号
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editCemeteryRegistry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = UserSession.getUser(request);
		Integer cemeteryRegistryType = ServletRequestUtils.getIntParameter(request, "cemeteryRegistryType",0);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		CemeteryRegistry entity = new CemeteryRegistry();
		
		
		if (id == 0) {
			//新增
			entity.setCreateUserId(user.getId());
			entity.setCreateOrgId(user.getDeptid());
			entity.setCreateDate(new Date());
			entity.setCemeteryRegistryType(cemeteryRegistryType.intValue());
			
			if(entity.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_RENT){
				//租用登记
				entity.setCemeteryRegistryCode(cemeteryRegistryService.getCemeteryRegistrySerial(user.getDeptid()));
			}else{
				//办理续租、合葬、迁出时确认的业务id
				Long archivesRegistryId = ServletRequestUtils.getLongParameter(request, "archivesRegistryId",0);
				//确认办理业务，复制归档数据到业务数据
				entity = cemeteryRegistryService.saveCemeteryRegistryConfirm(entity, archivesRegistryId);
				//查询相关业务归档数据
				List<ArchivesCemeteryRegistry> archivesCemeteryRegistries = archivesCemeteryRegistryService.getArchivesCemeteryRegistryList(entity.getCemeteryRegistryCode(), user.getDeptid());
				mv.addObject("archivesCemeteryRegistries",archivesCemeteryRegistries);
				
			}
		}else {
			//编辑
			entity = this.cemeteryRegistryService.load(CemeteryRegistry.class, id);
			//查询相关业务归档数据
			List<ArchivesCemeteryRegistry> archivesCemeteryRegistries = archivesCemeteryRegistryService.getArchivesCemeteryRegistryList(entity.getCemeteryRegistryCode(), user.getDeptid());
			mv.addObject("archivesCemeteryRegistries",archivesCemeteryRegistries);
		}
		if(cemeteryRegistryType.intValue() == Constant.REGEDIT_TYPE_RENT){
			//租用登记
			mv.setViewName("cemetery_rent_edit.jsp");
		}else if(cemeteryRegistryType.intValue() == Constant.REGEDIT_TYPE_RELET){
			//续租登记
			mv.setViewName("cemetery_relet_edit.jsp");
		}else if(cemeteryRegistryType.intValue() == Constant.REGEDIT_TYPE_MULTI){
			//合葬登记
			mv.setViewName("cemetery_multi_edit.jsp");
		}else if(cemeteryRegistryType.intValue() == Constant.REGEDIT_TYPE_REMOVAL){
			//迁出登记
			mv.setViewName("cemetery_removal_edit.jsp");
		}
		mv.addObject("entity", entity);
		return mv;
	}


	/**
	 * modify baiweiming 2014-11-17 进入业务办理，生产业务编号
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editCemeteryRegistrySupply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = UserSession.getUser(request);
		Integer cemeteryRegistryType = ServletRequestUtils.getIntParameter(request, "cemeteryRegistryType",0);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		CemeteryRegistry entity = new CemeteryRegistry();
		
		
		if (id == 0) {
			//新增
			entity.setCreateUserId(user.getId());
			entity.setCreateOrgId(user.getDeptid());
			entity.setCreateDate(new Date());
			entity.setCemeteryRegistryType(cemeteryRegistryType.intValue());
			
			if(entity.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_RENT){
				//租用登记
				entity.setCemeteryRegistryCode(cemeteryRegistryService.getCemeteryRegistrySerial(user.getDeptid()));
			}
		}else{
			//编辑
			entity = this.cemeteryRegistryService.load(CemeteryRegistry.class, id);
		}
		if(cemeteryRegistryType.intValue() == Constant.REGEDIT_TYPE_RENT){
			//租用登记
			mv.setViewName("cemetery_rent_supply_edit.jsp");
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * add baiweiming 2014-10-31 在义务办理功能时，获取单个墓型json格式
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryTypeById(HttpServletRequest request, HttpServletResponse response, CemeteryType command) throws Exception {
		Long cemeteryTypeId = ServletRequestUtils.getLongParameter(request, "cemeteryTypeId", 0);
		CemeteryType type = cemeteryRegistryService.get(CemeteryType.class, cemeteryTypeId);
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(CemeteryType.class, "id", "cemeteryTypeCode", "cemeteryTypeName",
				"businessData", "cemeteryProperty", "specification", "area", "cave", "boxsize", "totalPrice", "stoneprovider", "remark",
				"groundPrice", "managePrice", "constructionPrice", "cemeteryFile");
		ajaxResult(response, type, filter);
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryRegistry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType", 0);
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		this.cemeteryRegistryService.deleteCemeteryRegistry(id,cemeteryRegistryType);
		mav.setViewName("redirect:cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType="+cemeteryRegistryType);
		return mav;
	}


	/**
	 * 删除补录信息
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryRegistrySupply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType", 0);
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		this.cemeteryRegistryService.deleteCemeteryRegistrySupply(id);
		mav.setViewName("redirect:cemeteryRegistryController.fj?method=getCemeteryRegistryPageSupplyList&cemeteryRegistryType="+cemeteryRegistryType);
		return mav;
	}

	/**
	 * add bai 2014-11-20 保存业务办理补录信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryRegistrySupply(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) throws Exception {
		User user = UserSession.getUser(request);
		ModelAndView mv = new ModelAndView();
		//保存租用登记
		if (command.getId() != null && command.getId().longValue() > 0) {
			this.cemeteryRegistryService.updateCemeteryRegistry(command);
		} else {
			command.setCreateUserId(user.getId());
			command.setCreateOrgId(user.getDeptid());
			command.setCreateDate(new Date());
			this.cemeteryRegistryService.saveCemeteryRegistrySupply(command);
		}
		mv.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+command.getCemeteryRegistryType()+"&id=" + command.getId());
		return mv;
	}

	/**
	 * add bai 2014-11-20 保存业务办理信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryRegistry(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) throws Exception {
		User user = UserSession.getUser(request);
		ModelAndView mv = new ModelAndView();
		//保存租用登记
		if (command.getId() != null && command.getId().longValue() > 0) {
			this.cemeteryRegistryService.updateCemeteryRegistry(command);
		} else {
			command.setCreateUserId(user.getId());
			command.setCreateOrgId(user.getDeptid());
			command.setCreateDate(new Date());
			this.cemeteryRegistryService.saveCemeteryRegistry(command);
		}
		mv.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+command.getCemeteryRegistryType()+"&id=" + command.getId());
		return mv;
	}

	/**
	 * add bai 2014-11-05 批量添加商品/费用信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
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
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			if (receive.length > 0) {
				cemeteryChargeService.addCemeteryChargeList(cemeteryRegistryId, id, isChargeType, count, receive,user);
			}
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{
			if (receive.length > 0) {
				cemeteryChargeService.addCemeteryChargeList(cemeteryRegistryId, (long) Constant.OUT_STOREHOUSE_SELL, id, isChargeType, count, receive,
						user);
			}
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}
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
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			cemeteryChargeService.deleteCemeteryChargeSupply(id);
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{
			cemeteryChargeService.deleteCemeteryCharge(id);
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}
		return mav;
	}

	/**
	 * add baiweiming 2014-11-06 完成业务登记
	 */
	public ModelAndView endCemeteryRegistry(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) {
		ModelAndView mav = new ModelAndView();
		Long cemeteryRegistryType = ServletRequestUtils.getLongParameter(request, "cemeteryRegistryType", 0);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		cemeteryRegistryService.updateCemeteryLocationStatus(id, Constant.CEMETERY_STATUS_LOCK);
		mav.setViewName("redirect:cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType="+cemeteryRegistryType);
		return mav;
	}

	/**
	 * 查看登记业务
	 */
	public ModelAndView getCemeteryRegistryViewById(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) {
		ModelAndView mv = new ModelAndView("cemetery_rent_view.jsp");
		CemeteryRegistry cemeteryRegistry = null;
		cemeteryRegistry = cemeteryRegistryService.get(CemeteryRegistry.class, command.getId());
		mv.addObject("entity", cemeteryRegistry);
		return mv;
	}

	/**
	 * 进入费用处理界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryChargeframe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		CemeteryRegistry cemeteryRegistry = cemeteryRegistryService.load(CemeteryRegistry.class, id);
		ModelAndView mv = new ModelAndView("cemetery_charge_frame.jsp");
		mv.addObject("cemeteryRegistry", cemeteryRegistry);
		return mv;
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
		ModelAndView mv = new ModelAndView("cemetery_file_edit.jsp");
		CemeteryFile cf = new CemeteryFile();
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
		cemeteryFileService.saveCemeteryFileList(cemeteryRegistryId, fileIds, remark);
		ModelAndView mav = new ModelAndView();
		
		//如果是补录时增加的文件跳转到method=editCemeteryRegistrySupply的位置
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}
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
		cemeteryFileService.deleteCemeteryFileById(id);
		//如果是补录时删除的文件跳转到method=editCemeteryRegistrySupply的位置
		Long isSupply = ServletRequestUtils.getLongParameter(request, "isSupply",0);
		if(isSupply.intValue() == 1){
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}else{
			mav.setViewName("redirect:cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + cemeteryRegistryId);
		}
		return mav;
	}

	/**
	 * 进入退墓
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryRegistryBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("cemetery_rent_back.jsp");
		CemeteryRegistry registry = new CemeteryRegistry();
		Long id = ServletRequestUtils.getLongParameter(request, "id");
		registry.setId(id);
		registry.setCreateDate(new Date());
		registry.setCreateUserId(UserSession.getUser(request).getDeptid());
		mv.addObject("registry",registry );
		return mv;
	}

	/**
	 * 进入退墓
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView backCemeteryRegistry(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) throws Exception {
		ModelAndView mv = new ModelAndView();
		command.setCreateUserId(UserSession.getUser(request).getDeptid());
		cemeteryRegistryService.updateBackCemeteryRegistry(command);
		mv.setViewName("redirect:cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=1");
		return mv;
	}
	/**
	 * 查看退墓
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView viewBackCemeteryRegistry(HttpServletRequest request, HttpServletResponse response, CemeteryRegistry command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		CemeteryRegistry cemeteryRegistry = cemeteryRegistryService.load(CemeteryRegistry.class, id);
		ModelAndView mv = new ModelAndView("cemetery_rent_back_view.jsp");
		mv.addObject("registry",cemeteryRegistry );
		return mv;
	}

	public void setCemeteryChargeService(CemeteryChargeService cemeteryChargeService) {
		this.cemeteryChargeService = cemeteryChargeService;
	}

	public void setArchivesCemeteryRegistryService(ArchivesCemeteryRegistryService archivesCemeteryRegistryService) {
		this.archivesCemeteryRegistryService = archivesCemeteryRegistryService;
	}
}
