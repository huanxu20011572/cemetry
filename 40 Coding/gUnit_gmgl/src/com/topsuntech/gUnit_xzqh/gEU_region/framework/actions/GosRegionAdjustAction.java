package com.topsuntech.gUnit_xzqh.gEU_region.framework.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_util.tools.Constants;
import com.topsuntech.gUnit.gEU_util.tools.Tools;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionAdjust;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionWarn;
import com.topsuntech.gUnit_xzqh.gEU_region.framework.actionForms.GosRegionAdjustForm;
import com.topsuntech.gUnit_xzqh.gEU_region.service.GosRegionAdjustService;
import com.topsuntech.gUnit_xzqh.gEU_region.service.GosRegionWarnService;
import com.topsuntech.gUnit_xzqh.gEU_region.service.impl.GosRegionAdjustServiceImpl;
import com.topsuntech.gUnit_xzqh.gEU_region.service.impl.GosRegionWarnServiceImpl;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionAdjustQueryBean;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionWarnQueryBean;



public class GosRegionAdjustAction extends DispatchAction {
	private GosRegionAdjustService gosRegionAdjustService =  new GosRegionAdjustServiceImpl();
	private GosRegionWarnService gosRegionWarnService =  new GosRegionWarnServiceImpl();

	/**
	* description:GosRegionAdjust[list]
	* warn��ѯ 
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @author zp
	*/
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GosRegionAdjustForm gosRegionAdjustForm = (GosRegionAdjustForm)form;
		GosRegionAdjustQueryBean gosRegionAdjustQueryBean = new GosRegionAdjustQueryBean();		
		GosRegionWarnQueryBean gosRegionWarnQueryBean = new GosRegionWarnQueryBean();
		if(gosRegionAdjustForm != null){
			BeanUtils.copyProperties(gosRegionAdjustQueryBean, gosRegionAdjustForm);
			BeanUtils.copyProperties(gosRegionWarnQueryBean, gosRegionAdjustForm);
		}
		Page page = PageFactory.getPage(request);
		gosRegionWarnQueryBean.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.byteValue()));
		
		//��������	ADJUST_LEVEL 		����ʱ�䣺		��Чʱ�䣺
		String adjustType = request.getParameter("adjustType");//�������ͺϲ�50161   ���50162
		gosRegionWarnQueryBean.setAdjustType(Long.valueOf(adjustType));
		
		List warnList = gosRegionWarnService.queryGosRegionWarn(gosRegionWarnQueryBean, page);
		request.setAttribute("list", warnList);
		if(warnList != null && !warnList.isEmpty())
			request.setAttribute("total", new Long(warnList.size()));
		request.setAttribute("page", page);
		request.setAttribute("queryBean", gosRegionWarnQueryBean);
		
		if(Long.valueOf(adjustType) == 50161){
			//�������ͺϲ�50161   ���50162
			return mapping.findForward("mergerSuccess");
		}
			return mapping.findForward("devideSuccess");
		
		
	};

	/**
	* description:GosRegionAdjust[detail]
	* �鿴����
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @author zp
	*/
	public ActionForward detail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String warnId = request.getParameter("id");
		GosRegionWarn gosRegionWarn = new GosRegionWarn();
		GosRegionAdjust gosRegionAdjust = new GosRegionAdjust();
		if(warnId != null){
			gosRegionWarn = gosRegionWarnService.getGosRegionWarnById(Long.valueOf(warnId));
		}
		gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(gosRegionWarn.getGosRegionAdjustId());
		request.setAttribute("gosRegionAdjust",gosRegionAdjust);
		request.setAttribute("gosRegionWarn",gosRegionWarn);

		return mapping.findForward("detailSuccess");
	};


	/**
	* description:GosRegionAdjust[edit]
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
		String id = request.getParameter("id");
		GosRegionAdjustService gosRegionAdjustService =  new GosRegionAdjustServiceImpl();
		GosRegionAdjust gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(Long.valueOf(id));
		request.setAttribute("gosRegionAdjust",gosRegionAdjust);

		return mapping.findForward("success");
	};


	/**
	* description:GosRegionAdjust[update]
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
		String id = request.getParameter("id");
		GosRegionAdjustForm gosRegionAdjustForm = (GosRegionAdjustForm)form;
		GosRegionAdjustService gosRegionAdjustService =  new GosRegionAdjustServiceImpl();
		GosRegionAdjust gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(Long.valueOf(id));
		BeanUtils.copyProperties(gosRegionAdjust, gosRegionAdjustForm);
		gosRegionAdjust.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.longValue()));
		gosRegionAdjustService.updateGosRegionAdjust(gosRegionAdjust);

		String close = request.getParameter("close");
		if(close != null && !"".equals(close.trim()))
			return mapping.findForward("success");
		else{
			response.sendRedirect("listGosRegionAdjust.do?method=list");
			return null;
		}
	};


	/**
	* description:GosRegionAdjust[delete]
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
		String id = request.getParameter("id");
		GosRegionAdjustService gosRegionAdjustService =  new GosRegionAdjustServiceImpl();
		GosRegionAdjust gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(Long.valueOf(id));
		gosRegionAdjustService.deleteGosRegionAdjust(gosRegionAdjust);
		response.sendRedirect("listGosRegionAdjust.do?method=list");
		return null;
	};


	/**
	* description:GosRegionAdjust[deleteSel]
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
		GosRegionAdjustService gosRegionAdjustService =  new GosRegionAdjustServiceImpl();
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.sendRedirect("listGosRegionAdjust.do?method=list");
			return null;
		}
		if(id.indexOf(",") != -1){
			String[] ids = id.split(",");
			for(int i = 0; i < ids.length; i++){
				GosRegionAdjust gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(new Long(ids[i]));
				gosRegionAdjustService.deleteGosRegionAdjust(gosRegionAdjust);
			}
		}else{
			GosRegionAdjust gosRegionAdjust = gosRegionAdjustService.getGosRegionAdjustById(new Long(id));
			gosRegionAdjustService.deleteGosRegionAdjust(gosRegionAdjust);
		}
		response.sendRedirect("listGosRegionAdjust.do?method=list");
		return null;
	};


	/**
	* description:GosRegionAdjust[prepAdd]
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
	* description:GosRegionAdjust[list]
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @author zp
	*/
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GosRegionAdjustForm gosRegionAdjustForm = (GosRegionAdjustForm)form;
		User user = UserSession.getUser(request);
		GosRegionAdjust gosRegionAdjust = new GosRegionAdjust();		
		GosRegionWarn gosRegionWarn = new GosRegionWarn();
		if(gosRegionAdjustForm != null){
			BeanUtils.copyProperties(gosRegionAdjust, gosRegionAdjustForm);
			BeanUtils.copyProperties(gosRegionWarn, gosRegionAdjustForm);
		}

		//**ҳ���ʱ���ȡ**//
		//ԭ����ͣ��ʱ��
		String stopDates = gosRegionAdjustForm.getStopDates();
		Date stopDate = new Date();
		Date date = new Date();//ϵͳ��ǰ����
		if(stopDates != null){
			stopDate = Tools.getDateByStr(stopDates, "yyyy-MM-dd");
		}
		//��Чʱ��
		Date effectDate = stopDate;//Ԥ����Ϣ����Чʱ��������������Ϣ���ԭ����ͣ��ʱ��һ��
		

		
		//����������Ϣ��
		gosRegionAdjust.setStopDate(stopDate);
		gosRegionAdjust.setIsStop(new Long(Constants.NO));
		gosRegionAdjust.setCreateDate(date);		
		gosRegionAdjust.setCreateUserId(user.getId());
		gosRegionAdjust.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.longValue()));
		
		//����Ԥ����Ϣ��
		gosRegionWarn.setAdjustDate(date);//����ʱ��������������Ϣ���ԭ��������ʱ��һ��
		gosRegionWarn.setEffectDate(effectDate);
		gosRegionWarn.setCreateDate(new Date());
		gosRegionWarn.setCreateUserId(user.getId());
		gosRegionWarn.setUseFlag(new Long(Constants.USE_FLAG.USE_FLAG_ON.longValue()));
		
		if(gosRegionAdjustForm.getAdjustType() != null){
			request.setAttribute("adjustType", gosRegionAdjustForm.getAdjustType());
		}
		
		try {
			gosRegionAdjustService.addGosRegionAdjust(gosRegionAdjust);
			gosRegionWarn.setGosRegionAdjustId(gosRegionAdjust.getId());
			gosRegionWarnService.addGosRegionWarn(gosRegionWarn);
			return  mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  mapping.findForward("error");
	};
}
