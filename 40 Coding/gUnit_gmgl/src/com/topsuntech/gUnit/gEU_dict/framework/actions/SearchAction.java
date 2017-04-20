package com.topsuntech.gUnit.gEU_dict.framework.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryListService;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryService;
 
/**
 * 搜索以及列表Action
 *
 * @author shaojingze
 * @version 1.0
 */
public class SearchAction extends Action {

    public ActionForward execute(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");    
        Logger.debug("\n--- the action is " + action);
        if (action == null || action.length() == 0) {
            return actionMapping.findForward("error");
        }
        else if ("listNode".equals(action))
            return doListNode(actionMapping, actionForm, request, response);
        else if ("findNode".equals(action))
            return doFindNode(actionMapping, actionForm, request, response);
        else {
            return actionMapping.findForward("error");
        }
    }

    /**
     * 获取所有节点列表
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doListNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        Page page = PageFactory.getPage(request);
        DictionaryListService service = new DictionaryListService();      
        List list = service.findNode("", "0", page,request.getParameter("institutionId"));
        request.setAttribute("dataList", list);
        request.setAttribute("dataPage", page);       
        return actionMapping.findForward("success");
    }

    /**
     * 根据父节点获取所有节点列表
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doFindNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
    	
    	String sParentCode = request.getParameter("parentCode");  
    	//String sParentId   = request.getParameter("parentID");
    	String sInstitutionId = request.getParameter("institutionId");
    	
        if (sParentCode == null ){
        	//查询顶级节点
            return doListNode(actionMapping, actionForm, request, response);
        }
        
        DictionaryListService service = new DictionaryListService();
        Long parentID = service.getIdByCode(sParentCode);
       
       if(parentID != null){        	
        	if(sInstitutionId == null || sInstitutionId.length() <= 0 || sInstitutionId.equals("null")){
        		sInstitutionId = null;
        	}
        	

        	StringBuffer preffix =  new StringBuffer(sParentCode);        	
        	request.setAttribute("preffix",preffix.toString());
            List list = service.findNode("", parentID.toString() ,sInstitutionId);
            MetaData bean = new DictionaryService().getNode(parentID.longValue());
            request.setAttribute("institutionId",sInstitutionId);
            request.setAttribute("bean", bean);
            request.setAttribute("dataList", list);
        }
        
        return actionMapping.findForward("success");
    }
}
