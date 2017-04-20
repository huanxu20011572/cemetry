package com.topsuntech.gUnit_gmgl.gEU_cemetery.framework;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryZone;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryLocationService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryZoneService;
import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

/**
 * 墓位管理
 * 
 * @author zzk
 * 
 */
public class CemeteryLocationController extends AbstractMultiController {
	
	//每页显示条数 
	private final int pagenum = 60;
	
	private CemeteryLocationService cemeteryLocationService;

	private CemeteryZoneService cemeteryZoneService;
	private DictService dictService;
	
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	public void setCemeteryZoneService(CemeteryZoneService cemeteryZoneService) {
		this.cemeteryZoneService = cemeteryZoneService;
	}

	public void setCemeteryLocationService(CemeteryLocationService cemeteryLocationService) {
		this.cemeteryLocationService = cemeteryLocationService;
	}

	/**
	 * 查找区排分类树
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryZoneTreeByPID(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		Long pid = ServletRequestUtils.getLongParameter(request, "id", 0);
		User user = UserSession.getUser(request);
		Office office = UserSession.getUserDept(request);
		List<CemeteryZone> list = cemeteryZoneService.getCemeteryZoneTreeNodeByPid(pid, user.getDeptid(),office.getLevelid());
		ajaxResult(response, list);
		return null;
	}

	/**
	 * 查找区排树根节点
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryZoneTree(HttpServletRequest request, HttpServletResponse response, CemeteryZone command) throws Exception {
		ajaxResult(response, cemeteryZoneService.getCemeteryZoneById(Long.valueOf(0)));
		return null;
	}

	/**
	 * 查找墓位列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryLocationListByPID(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command)
			throws Exception {
		Page page = PageConfig.getPage(request);
		page.setPagenum(pagenum);
		Long cemeteryZoneId = ServletRequestUtils.getLongParameter(request, "pid", 0);// 区排ID
		command.setCemeteryZoneId(cemeteryZoneId);// 设置区排ID
		command.setCreateOrgId(UserSession.getUser(request).getDeptid());
		Office office = UserSession.getUserDept(request);
		List<CemeteryLocation> list = cemeteryLocationService.getCemeteryLocationList(page, command,office.getLevelid());

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("cemetery_location_list.jsp");
		return mav;
	}

	/**
	 * 快速查找墓位列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryLocationFastListByPID(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command)
			throws Exception {
		ModelAndView mav =getCemeteryLocationListByPID(request, response, command);
		mav.setViewName("cemetery_location_fast_list.jsp");
		return mav;
	}


	/**
	 * 选择墓位信息列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getCemeteryLocationSelectListByPID(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command)
			throws Exception {
		ModelAndView mav =getCemeteryLocationListByPID(request, response, command);
		mav.setViewName("cemetery_location_select_list.jsp");
		return mav;
	}

	/**
	 * 编辑墓位
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editCemeteryLocation(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command) throws Exception {
		ModelAndView mav = new ModelAndView();
		if (command.getId() != null && command.getId().longValue() > 0) {
			// 编辑墓位
			CemeteryLocation cemeteryLocation = cemeteryLocationService.get(CemeteryLocation.class, command.getId());
 
			mav.addObject("cemeteryLocation", cemeteryLocation);
		} else {
			// 添加墓位时，设置墓位编号
			command.setCemeteryLocationCode(cemeteryLocationService.getCemeteryLocationSerial());
			command.setCreateDate(new Date());
			command.setCreateOrgId(UserSession.getUser(request).getDeptid());
			command.setCreateUserId(UserSession.getUser(request).getId());
			mav.addObject("cemeteryLocation", command);

		}
		List<BusinessData> businessDataList = cemeteryLocationService.getBusinessDataList();
		mav.addObject("businessDataList", businessDataList);
		mav.setViewName("cemetery_location_edit.jsp");
		return mav;
	}

	/**
	 * 在编辑墓位功能时，根据义务分类id获取墓型列表
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryTypeListByBusinessDataId(HttpServletRequest request, HttpServletResponse response, BusinessData command)
			throws Exception {
		Long businessDataId = ServletRequestUtils.getLongParameter(request, "businessDataId", 0);
		User user =  UserSession.getUser(request);
		List<CemeteryType> list = cemeteryLocationService.getCemeteryTypeJSonByBusinessDataId(businessDataId,user);
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(CemeteryType.class, "id", "cemeteryTypeName");
		ajaxResult(response, list, filter);
		return null;
	}

	/**
	 * 在编辑墓位功能时，获取单个墓型json格式
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getCemeteryTypeById(HttpServletRequest request, HttpServletResponse response, CemeteryType command) throws Exception {
		Long cemeteryTypeId = ServletRequestUtils.getLongParameter(request, "cemeteryTypeId", 0);
		CemeteryType type = cemeteryLocationService.get(CemeteryType.class, cemeteryTypeId);
		List<Dict> dicts=dictService.getDictByCode(type.getCemeteryProperty());
		if(dicts!=null&&dicts.size()>0){
			type.setCemeteryProperty(dicts.get(0).getDictName());
		}
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(CemeteryType.class, "id", "cemeteryTypeCode", "cemeteryTypeName",
				"businessData", "cemeteryProperty", "specification", "area", "cave", "boxsize", "totalPrice", "stoneprovider", "remark",
				"groundPrice", "managePrice", "constructionPrice","cemeteryFile");
		ajaxResult(response, type, filter);
		return null;
	}

	/**
	 * 查找墓位列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveCemeteryLocation(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command) throws Exception {
		Long cemeteryZoneId = ServletRequestUtils.getLongParameter(request, "pid", 0);// 区排ID
		User user = UserSession.getUser(request);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		command.setCemeteryZoneId(cemeteryZoneId);// 传递区排ID
		cemeteryLocationService.saveCemeteryLocation(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryLocationController.fj?method=getCemeteryLocationListByPID&pid=" + cemeteryZoneId);
		return mav;
	}

	/**
	 * 查找墓位列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteCemeteryLocation(HttpServletRequest request, HttpServletResponse response, CemeteryLocation command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		cemeteryLocationService.deleteCemeteryLocation(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:cemeteryLocationController.fj?method=getCemeteryLocationListByPID&pid=" + pid);
		return mav;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}
}
