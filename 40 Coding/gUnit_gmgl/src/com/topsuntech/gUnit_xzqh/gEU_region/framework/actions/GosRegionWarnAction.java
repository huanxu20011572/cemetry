package com.topsuntech.gUnit_xzqh.gEU_region.framework.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit.gEU_util.framework.actions.BaseAction;
import com.topsuntech.gUnit.gEU_util.tools.Constants;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionWarn;
import com.topsuntech.gUnit_xzqh.gEU_region.framework.actionForms.GosRegionWarnForm;
import com.topsuntech.gUnit_xzqh.gEU_region.service.GosRegionWarnService;
import com.topsuntech.gUnit_xzqh.gEU_region.service.impl.GosRegionWarnServiceImpl;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionWarnQueryBean;



public class GosRegionWarnAction extends BaseAction {

	/**
	* description:GosRegionWarn[list]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GosRegionWarnForm gosRegionWarnForm = (GosRegionWarnForm)form;
		GosRegionWarnQueryBean gosRegionWarnQueryBean = new GosRegionWarnQueryBean();
		BeanUtils.copyProperties(gosRegionWarnQueryBean, gosRegionWarnForm);
		gosRegionWarnQueryBean.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.byteValue()));

		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		Page page = PageFactory.getPage(request);
		List list = gosRegionWarnService.queryGosRegionWarn(gosRegionWarnQueryBean, page);
		request.setAttribute("list", list);
		if(list != null && !list.isEmpty())
			request.setAttribute("total", new Long(list.size()));
		request.setAttribute("page", page);
		request.setAttribute("queryBean", gosRegionWarnQueryBean);

		return mapping.findForward("success");
	};

	/**
	* description:GosRegionWarn[detail]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward detail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = getLongReturnNull(request, "id");
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(id);
		request.setAttribute("gosRegionWarn",gosRegionWarn);

		return mapping.findForward("success");
	};


	/**
	* description:GosRegionWarn[edit]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = getLongReturnNull(request, "id");
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(id);
		request.setAttribute("gosRegionWarn",gosRegionWarn);

		return mapping.findForward("success");
	};


	/**
	* description:GosRegionWarn[update]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = getLongReturnNull(request, "id");
		GosRegionWarnForm gosRegionWarnForm = (GosRegionWarnForm)form;
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(id);
		BeanUtils.copyProperties(gosRegionWarn, gosRegionWarnForm);
		gosRegionWarn.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.longValue()));
		gosRegionWarnService.updateGosRegionWarn(gosRegionWarn);

		String close = request.getParameter("close");
		if(close != null && !"".equals(close.trim()))
			return mapping.findForward("success");
		else{
			response.sendRedirect("listGosRegionWarn.do?method=list");
			return null;
		}
	};


	/**
	* description:GosRegionWarn[delete]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = getLongReturnNull(request, "id");
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(id);
		gosRegionWarnService.deleteGosRegionWarn(gosRegionWarn);
		response.sendRedirect("listGosRegionWarn.do?method=list");
		return null;
	};


	/**
	* description:GosRegionWarn[deleteSel]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward deleteSel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		String id = getString(request, "id");
		if(id == null || "".equals(id.trim())){
			response.sendRedirect("listGosRegionWarn.do?method=list");
			return null;
		}
		if(id.indexOf(",") != -1){
			String[] ids = id.split(",");
			for(int i = 0; i < ids.length; i++){
				GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(new Long(ids[i]));
				gosRegionWarnService.deleteGosRegionWarn(gosRegionWarn);
			}
		}else{
			GosRegionWarn gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(new Long(id));
			gosRegionWarnService.deleteGosRegionWarn(gosRegionWarn);
		}
		response.sendRedirect("listGosRegionWarn.do?method=list");
		return null;
	};


	/**
	* description:GosRegionWarn[prepAdd]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward prepAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("success");
	};


	/**
	* description:GosRegionWarn[list]
	*
	* @param mapping
	* @param form
	* @param request
	* @param response
	*
	* @author Auto-Build
	*
	*/
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GosRegionWarnForm gosRegionWarnForm = (GosRegionWarnForm)form;
		GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();
		GosRegionWarn gosRegionWarn = new GosRegionWarn();
		BeanUtils.copyProperties(gosRegionWarn, gosRegionWarnForm);
		gosRegionWarn.setCreateDate(new Date());
		User user = getUser(request);
		gosRegionWarn.setCreateUserId(user.getId());
		gosRegionWarn.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.longValue()));
		gosRegionWarnService.addGosRegionWarn(gosRegionWarn);

		String close = request.getParameter("close");
		if(close != null && !"".equals(close.trim()))
			return mapping.findForward("success");
		else{
			response.sendRedirect("listGosRegionWarn.do?method=list");
			return null;
		}
	};
}
