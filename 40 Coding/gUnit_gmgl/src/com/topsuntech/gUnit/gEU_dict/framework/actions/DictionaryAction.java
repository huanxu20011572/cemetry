package com.topsuntech.gUnit.gEU_dict.framework.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.topsuntech.gOS.applog.utility.OperateType;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.framework.actionforms.DictionaryForm;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryListService;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryService;
import com.topsuntech.gUnit.gEU_dict.utils.LoggerFactory;
import com.topsuntech.gUnit.gEU_dict.utils.ResultRef;

/**
 * �����ֵ��Action
 * @author ZhangWei
 * modify by ������
 * @version 1.0
 */
public class DictionaryAction extends Action {
    
    private static final String SJZD_MODULE_NAME = "�����ֵ�/��Ŀ����";

    public ActionForward execute(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action == null || action.length() == 0) {
            return actionMapping.findForward("error");
        }
        if ("addNode".equals(action))
            return doAddNode(actionMapping, actionForm, request, response);
        else if ("modifyNode".equals(action))
            return doModifyNode(actionMapping, actionForm, request, response);
        else if ("moveUpNode".equals(action))
            return doMoveUpNode(actionMapping, actionForm, request, response);
        else if ("moveDownNode".equals(action))
            return doMoveDownNode(actionMapping, actionForm, request, response);
        else if ("getNodeList".equals(action))
            return doGetNodeList(actionMapping, actionForm, request, response);
        else if ("deleteNode".equals(action))
        	return deleteNode(actionMapping, actionForm, request, response);
        else if ("changeState".equals(action))
        	return changeNodeState(actionMapping, actionForm, request, response);
        else
            return actionMapping.findForward("error");

    }

    /**
     * ��ӽڵ���Ϣ
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doAddNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
    	
    	DictionaryForm form = (DictionaryForm) actionForm;
    	MetaData bean = form.populate();
    	//Long institutionId = WebHelper.getInstitutionId(request,FuneralDAOFactory.SCHEMA_NAME_BJBZ);
    	//bean.setInstitutionid(institutionId);
    	bean.setState(new Integer(1));
    	DictionaryService service = new DictionaryService();
        try {
            int result = service.addNode(bean);
            //�����ɹ�
            if (result == ResultRef.OPER_SUCCESS) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_SUCCESS));
                LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.INSERT,
                        "�¼������ֵ���Ŀ,������Ϊ: "+bean.getNode_typename()+"-"+bean.getNode_name()+" ����Ϊ��"+bean.getNode_value());
                //���нڵ㣬���ʧ��
            }else if (result == ResultRef.OPER_HASRECORD) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_HASRECORD));
                //���ʧ��
            }else {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_FAILD));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new SearchAction().doFindNode(actionMapping, actionForm, request,
                                             response);
    }

    /**
     * ���½ڵ���Ϣ
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doModifyNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
    	DictionaryForm form = (DictionaryForm) actionForm;
        if (form.getNode_name() == null)
            return actionMapping.findForward("error");

        long id = form.getId().longValue();
        DictionaryService service = new DictionaryService();
        MetaData bean = service.getNode(id);
        //���ø��º������
        bean.setNode_name(form.getNode_name());
        bean.setNode_value(form.getNode_value());
        
        try {
            int result = service.updateNode(bean);
            //�����ɹ�
            if (result == ResultRef.OPER_SUCCESS) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_SUCCESS));
                LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.EDIT,
                        "���������ֵ���Ŀ,������Ϊ: "+bean.getNode_typename()+"-"+bean.getNode_name()+" ����Ϊ��"+bean.getNode_value());
                //����ͬ���ڵ㣬����ʧ��
            }
            else if (result == ResultRef.OPER_HASRECORD) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_HASRECORD));
                //����ʧ��
            }
            else {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_FAILD));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new SearchAction().doFindNode(actionMapping, actionForm, request,
                                             response);
    }

    /**
     * ���ƽڵ�
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doMoveUpNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        if (request.getParameter("parentID") == null)
            return new SearchAction().doListNode(actionMapping, actionForm,
                                                 request, response);

        String parentID = (String) request.getParameter("parentID");
        String node_index = (String) request.getParameter("index");
        DictionaryService service = new DictionaryService();
        service.moveUpNode(Long.parseLong(parentID), Long.parseLong(node_index));
        LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.EDIT,
				        "������Ŀ");
        return new SearchAction().doFindNode(actionMapping, actionForm,
                                             request, response);
    }

    /**
     * ���ƽڵ�
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    protected ActionForward doMoveDownNode(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        if (request.getParameter("parentID") == null)
            return new SearchAction().doListNode(actionMapping, actionForm,
                                                 request, response);

        String parentID = (String) request.getParameter("parentID");
        String node_index = (String) request.getParameter("index");
        DictionaryService service = new DictionaryService();
        service.moveDownNode(Long.parseLong(parentID),
                             Long.parseLong(node_index));
        
        LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.DELETE,
				"������Ŀ: ");
		
        return new SearchAction().doFindNode(actionMapping, actionForm,
                                             request, response);
    }

    /**
     * ��ȡ�ڵ�List
     * @param actionMapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     */
    protected ActionForward doGetNodeList(
        ActionMapping actionMapping,
        ActionForm actionForm,
        HttpServletRequest request,
        HttpServletResponse response) {
        if (request.getParameter("nodeID") == null) {
            request.setAttribute("result",
                                 String.valueOf(ResultRef.OPER_FAILD));
            return actionMapping.findForward("error");
        }

        String nodeID = (String) request.getParameter("nodeID");
        DictionaryService service = new DictionaryService();
        List list = service.getNodeListByID(Long.parseLong(nodeID));
        request.setAttribute("nodeList", list);
        request.setAttribute("result",
                             String.valueOf(ResultRef.OPER_SUCCESS));
        return actionMapping.findForward("success");
    }
    
    /**
     * ɾ���ڵ�
     */
    protected ActionForward deleteNode(
            ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	String id = request.getParameter("id");
		DictionaryListService sev = new DictionaryListService();
		DictionaryService ds = new DictionaryService();
		MetaData bean = ds.getNode(Long.parseLong(id));
		LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.DELETE,
				"�ı���Ŀ״̬: "+bean.getNode_typename()+"-"+bean.getNode_name()+" ����Ϊ��"+bean.getNode_value());
		sev.deleteMeteData(id);
		
		return new SearchAction().doFindNode(actionMapping, actionForm,
                request, response);
    }
    
    /**
     * �ı�ڵ�״̬
     */
    protected ActionForward changeNodeState(
            ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	String id = request.getParameter("id");
    	String oldstate = request.getParameter("oldstate");
    	String newstate = request.getParameter("newstate");
		DictionaryListService sev = new DictionaryListService();
		sev.changeState(id,oldstate,newstate);
		
		DictionaryService ds = new DictionaryService();
		MetaData bean = ds.getNode(Long.parseLong(id));
		LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.EDIT,
				"�ı���Ŀ״̬: "+bean.getNode_typename()+"-"+bean.getNode_name()+" ����Ϊ��"+bean.getNode_value());
		return new SearchAction().doFindNode(actionMapping, actionForm,
                request, response);
    }
}



