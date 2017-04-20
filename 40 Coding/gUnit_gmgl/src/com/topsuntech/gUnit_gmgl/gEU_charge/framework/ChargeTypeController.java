package com.topsuntech.gUnit_gmgl.gEU_charge.framework;

import java.text.SimpleDateFormat;
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
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;
import com.topsuntech.gUnit_gmgl.gEU_charge.service.ChargeTypeService;

/**
 * <p>
 * 费用分类Controller类
 * </p>
 * 
 * @author jiao
 * @date 2014-08-20
 * 
 */
public class ChargeTypeController extends AbstractMultiController {
	private ChargeTypeService chargeTypeService;

	public void setChargeTypeService(ChargeTypeService _chargeTypeService) {
		this.chargeTypeService = _chargeTypeService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command,
			ServletRequestDataBinder binder) {
	}

	/**
	 * 根据条件｛费用分类、大分类｝查询所属的费用类型列表；查询条件动态组合。
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getChargeTypeList(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		Page page = PageConfig.getPage(request);
		command.setCreateOrgId(UserSession.getUser(request).getDeptid());
		List<ChargeType> list = chargeTypeService.getChargeTypeList(page,
				command);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("charge_type_list.jsp");
		mav.addObject("chargetype", command);
		return mav;
	}

	/**
	 * 编辑费用类别： 如果参数id不为空，查询对应的费用类别信息返回（对应为编辑操作）； 如果参数id为空，只跳转到编辑界面（对应为新建操作）。
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editChargeType(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		ModelAndView mav = new ModelAndView("charge_type_edit.jsp");
		if (command.getId() != null && command.getId().longValue() > 0) {
			ChargeType chargeType = chargeTypeService.get(ChargeType.class,
					command.getId());
			mav.addObject("chargeType", chargeType);
		}
		return mav;
	}

	public ModelAndView getCreateChargeType(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		ModelAndView mav = new ModelAndView("charge_type_create.jsp");
		ChargeType chargeType = new ChargeType();
		User user = UserSession.getUser(request);
		chargeType.setCreateUserId(user.getId());
		chargeType.setCreateDate(new Date());
		mav.addObject("chargeType", chargeType);
		mav.addObject("user", user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		mav.addObject("currentTime", sdf.format(new Date()));
		return mav;
	}

	/**
	 * 查看功能
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getChargeTypeView(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		ModelAndView mav = new ModelAndView("charge_type_view.jsp");
		if (command.getId() != null && command.getId().longValue() > 0) {
			ChargeType chargeType = chargeTypeService.get(ChargeType.class,
					command.getId());
			mav.addObject("chargeType", chargeType);
		}
		return mav;
	}

	/**
	 * 保存新建或编辑够的费用类型信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveChargeType(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		User user = UserSession.getUser(request);
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		ChargeType type = null;  
		if (id == 0) {
			type=new ChargeType();
			type.setCreateUserId(user.getId());
			type.setCreateDate(new Date(System.currentTimeMillis()));
			type.setCreateOrgId(user.getDeptid());
		}else{
			type=chargeTypeService.get(ChargeType.class, command.getId());
		}
		type.setChargeTypeName(command.getChargeTypeName());
		type.setChargeTypeDict(command.getChargeTypeDict());
		type.setIsValidate(command.getIsValidate());
		type.setRemark(command.getRemark());
		type.setSort(command.getSort());
		chargeTypeService.saveOrUpdateChargeType(type);
		ModelAndView mav = new ModelAndView("charge_type_list.jsp");
		Page page = PageConfig.getPage(request);
		command = new ChargeType();
		command.setCreateOrgId(user.getDeptid());
		List<ChargeType> list = chargeTypeService.getChargeTypeList(page,
				command);

		mav.addObject("list", list);
		mav.addObject("page", page);

		return mav;
	}

	/**
	 * 通过id删除对应的费用类别信息
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteChargeType(HttpServletRequest request,
			HttpServletResponse response, ChargeType command) throws Exception {
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		chargeTypeService.deleteChargeType(id);
		Page page = PageConfig.getPage(request);
		command.setCreateOrgId(UserSession.getUser(request).getDeptid());
		List<ChargeType> list = chargeTypeService.getChargeTypeList(page,
				command);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("charge_type_list.jsp");
		mav.addObject("chargetype", command);
		return mav;
	}

}
