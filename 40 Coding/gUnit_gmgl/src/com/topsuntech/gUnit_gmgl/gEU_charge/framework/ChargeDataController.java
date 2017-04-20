package com.topsuntech.gUnit_gmgl.gEU_charge.framework;

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
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;
import com.topsuntech.gUnit_gmgl.gEU_charge.service.ChargeDataService;

public class ChargeDataController extends AbstractMultiController {
	private ChargeDataService chargeDataService;

	public void setChargeDataService(ChargeDataService chargeDataService) {
		this.chargeDataService = chargeDataService;
	}

	/**
	 * 存储明细
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView saveChargeData(HttpServletRequest request, HttpServletResponse response, ChargeData command) throws Exception {
		User user = UserSession.getUser(request);
		Long chargeTypeID = ServletRequestUtils.getLongParameter(request, "ctid", 0);
		command.setCreateUserId(user.getId());
		command.setCreateOrgId(user.getDeptid());
		chargeDataService.saveChargeData(command, chargeTypeID);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:chargeDataController.fj?method=getChargeDataList&ctid="+chargeTypeID);
		return mav;
	}

	/**
	 * 新增或编辑操作
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getChargeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long chargeDateID = ServletRequestUtils.getLongParameter(request, "id", 0);
		ChargeData chargeData = new ChargeData();
		if (chargeDateID.longValue() > 0) {
			// id不为空，为编辑操作
			chargeData = chargeDataService.load(ChargeData.class, chargeDateID);
		} else {
			User user = UserSession.getUser(request);
			chargeData.setCreateUserId(user.getId());
			chargeData.setCreateDate(new Date());
		}
		mav.addObject("chargeData", chargeData);
		mav.setViewName("charge_data_edit.jsp");
		return mav;
	}

	/**
	 * 获取费用json
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getChargeDataJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long chargeDateID = ServletRequestUtils.getLongParameter(request, "id", 0);
		ChargeData chargeData = chargeDataService.load(ChargeData.class, chargeDateID);
		ajaxResult(response, chargeData);
		return null;
	}

	/**
	 * 获取费用类型数据明细列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getChargeDataList(HttpServletRequest request, HttpServletResponse response,ChargeData command) throws Exception {
		Page page = PageConfig.getPage(request);
		Long chargeTypeID = ServletRequestUtils.getLongParameter(request, "ctid", 0);
		command.setCreateOrgId(UserSession.getUser(request).getDeptid());
		List<ChargeData> list = chargeDataService.getChargeDataList(page, command, chargeTypeID);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		
		String checked = ServletRequestUtils.getStringParameter(request, "checked", "");
		if(StringUtils.isNotEmpty("checked") && "checked".equals(checked)){
			mav.setViewName("charge_data_checked_list.jsp");
		}else{
			mav.setViewName("charge_data_list.jsp");
		}
		return mav;
	}

	/**
	 * <p>
	 * 获取费用类型树列表
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getChargeTypeTree(HttpServletRequest request, HttpServletResponse response, ChargeData command) throws Exception {
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		List<ChargeType> list = chargeDataService.getChargeTypeTree(pid, UserSession.getUser(request).getDeptid());
		ajaxResult(response, list);
		return null;
	}

	/**
	 * <p>
	 * 删除费用分类的控制方法
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView deleteChargeData(HttpServletRequest request, HttpServletResponse response, ChargeData command) throws Exception {
		Long chargeTypeID = ServletRequestUtils.getLongParameter(request, "ctid", 0);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		chargeDataService.deleteChargeData(id);
		ModelAndView mav = new ModelAndView();
		// 删除完了再刷新查询一下。
		mav.setViewName("redirect:chargeDataController.fj?method=getChargeDataList&ctid="+chargeTypeID);
		return mav;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
	}
}
