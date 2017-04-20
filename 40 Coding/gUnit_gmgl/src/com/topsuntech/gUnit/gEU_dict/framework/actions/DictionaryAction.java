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
 * 公共字典表Action
 * @author ZhangWei
 * modify by 李星亮
 * @version 1.0
 */
public class DictionaryAction extends Action {
    
    private static final String SJZD_MODULE_NAME = "数据字典/栏目管理";

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
     * 添加节点信息
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
            //操作成功
            if (result == ResultRef.OPER_SUCCESS) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_SUCCESS));
                LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.INSERT,
                        "新加数据字典条目,其类型为: "+bean.getNode_typename()+"-"+bean.getNode_name()+" 编码为："+bean.getNode_value());
                //因含有节点，添加失败
            }else if (result == ResultRef.OPER_HASRECORD) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_HASRECORD));
                //添加失败
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
     * 更新节点信息
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
        //设置更新后的数据
        bean.setNode_name(form.getNode_name());
        bean.setNode_value(form.getNode_value());
        
        try {
            int result = service.updateNode(bean);
            //操作成功
            if (result == ResultRef.OPER_SUCCESS) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_SUCCESS));
                LoggerFactory.insert("dictionary",SJZD_MODULE_NAME,request,OperateType.EDIT,
                        "更新数据字典条目,其类型为: "+bean.getNode_typename()+"-"+bean.getNode_name()+" 编码为："+bean.getNode_value());
                //因含有同名节点，更新失败
            }
            else if (result == ResultRef.OPER_HASRECORD) {
                request.setAttribute("result",
                                     String.valueOf(ResultRef.OPER_HASRECORD));
                //更新失败
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
     * 上移节点
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
				        "上移条目");
        return new SearchAction().doFindNode(actionMapping, actionForm,
                                             request, response);
    }

    /**
     * 下移节点
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
				"下移条目: ");
		
        return new SearchAction().doFindNode(actionMapping, actionForm,
                                             request, response);
    }

    /**
     * 获取节点List
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
     * 删除节点
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
				"改变条目状态: "+bean.getNode_typename()+"-"+bean.getNode_name()+" 编码为："+bean.getNode_value());
		sev.deleteMeteData(id);
		
		return new SearchAction().doFindNode(actionMapping, actionForm,
                request, response);
    }
    
    /**
     * 改变节点状态
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
				"改变条目状态: "+bean.getNode_typename()+"-"+bean.getNode_name()+" 编码为："+bean.getNode_value());
		return new SearchAction().doFindNode(actionMapping, actionForm,
                request, response);
    }
}



