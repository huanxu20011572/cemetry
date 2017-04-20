/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.framework.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.user.en.region.Region;
import com.topsuntech.gUnit.gEU_dict.service.DynamicSelectDao;
import com.topsuntech.gUnit.gEU_system.framework.actionforms.SjRegionForm;
import com.topsuntech.gUnit.gEU_system.service.RegionService;
import com.topsuntech.gUnit.gEU_system.service.UserService;
import com.topsuntech.gUnit.gEU_system.service.vo.UserQueryBean;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;


/**
 * @author ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SjRegionAction extends DispatchAction {
    
    /**
     * “区域维护”：'新增'相应的区域数据
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward add(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SjRegionForm form = (SjRegionForm)actionForm;
        
        SjRegion region = new SjRegion();        
        PropertyUtils.copyProperties(region, form);
        region.setUseFlag(new Long(1));
        region.setCreateDate(new Date());
        RegionService service=new RegionService();
//        int orderItem=service.getMaxOrderItem();
//        region.setOrderByItem(orderItem);   
        RegionService.insertRegion(region);   
        
        request.setAttribute("action", "add");
        
		return actionMapping.findForward("success");
	}
    
    /**
     * “区域维护”：'显示将要修改'的区域数据
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward toUpdate(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       String regionId = request.getParameter("regionId");
       
        SjRegion region = new SjRegion();   
        region = RegionService.getRegion(Long.valueOf(regionId));
        
        com.topsuntech.gUnit.gEU_util.entity.Region parentRegion = Dicts.getRegionById(region.getParentId());
                
        request.setAttribute("parentName", parentRegion.getName());
        request.setAttribute("region", region);

		return actionMapping.findForward("success");
	}
   
    /**
     * “区域维护”：'修改'相应的区域数据
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SjRegionForm form = (SjRegionForm)actionForm;
        
        SjRegion region = new SjRegion();        
        PropertyUtils.copyProperties(region, form);
        
        RegionService.updateRegion(region);
        
        request.setAttribute("action", "update");

		return actionMapping.findForward("success");
	}
    
    /**
     * “区域维护”：'停用'、'删除'相应的区域数据
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward delete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SjRegionForm form = (SjRegionForm)actionForm;
        
        String regionId = request.getParameter("regionId");
        
        SjRegion region = RegionService.getRegion(Long.valueOf(regionId));
        region.setUseFlag(form.getUseFlag());
        RegionService.updateRegion(region);
        
        request.setAttribute("action", "delete");
        
		return actionMapping.findForward("success");
	}   
    
    /**
     * 区域排序
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward regionList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
    	SjRegion region = new SjRegion();		
		Page page = PageFactory.getPage(request);	
		page.setPageSize(100);
		// 区县
		Collection county = new ArrayList();
		// 街道办事
		Collection street = new ArrayList();
		DynamicSelectDao dynamic = new DynamicSelectDao();
		String countyParam = request.getParameter("county");
		String streetParam = request.getParameter("street");
		if (StringUtils.isNotBlank(countyParam)) {
			county = dynamic.findRegionByList(countyParam);			
		} else {
			county = dynamic.getRegionByParentIdImp(Long.valueOf(2));			
		}
		if (StringUtils.isNotBlank(streetParam)) {
			street = dynamic.queryChilerList(streetParam);
		}
		if(StringUtils.isNotBlank(countyParam) && StringUtils.isBlank(streetParam)){
			street =dynamic.queryBasicInfoChiler(countyParam);
		}			
		List dataList =null;
		if(countyParam!=null&&!countyParam.equals("")){
			dataList = RegionService.queryRegionByUpCode(countyParam,page);
		}
		
		request.setAttribute("dataList", dataList);
		request.setAttribute("countys", county);
		request.setAttribute("streets", street);
		request.setAttribute("page", page);
		return actionMapping.findForward("success");
	}
//    
//    /**
//     * 区域排序 上移功能
//     * @param actionMapping
//     * @param actionForm
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    public ActionForward moveUp(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response)throws Exception{
//    	
//    	String county=request.getParameter("county");//接区县
//    	String id=request.getParameter("id");
//    	String orderByItem=request.getParameter("orderByItem");//排序用的 序号
//    	
//    	RegionService serivce=new RegionService();
//    	serivce.toMoveUp(id,orderByItem,county);
//    	
//    	request.setAttribute("county", county);
//    	return actionMapping.findForward("success");
//    }
//    
//    /**
//     * 区域排序 下移功能
//     * @param actionMapping
//     * @param actionForm
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    public ActionForward moveDown(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response)throws Exception{
//    	
//    	String county=request.getParameter("county");//接区县
//    	String id=request.getParameter("id");
//    	String orderByItem=request.getParameter("orderByItem");//排序用的 序号
//    	
//    	RegionService serivce=new RegionService();
//    	serivce.toMoveDown(id,orderByItem,county);
//    	
//    	request.setAttribute("county", county);
//    	return actionMapping.findForward("success");
//    }
//      
}
