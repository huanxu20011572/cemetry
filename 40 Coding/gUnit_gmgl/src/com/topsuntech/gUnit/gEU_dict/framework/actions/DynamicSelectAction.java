package com.topsuntech.gUnit.gEU_dict.framework.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gPortal.page.PageFactory;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryService;
import com.topsuntech.gUnit.gEU_dict.service.DynamicSelectDao;


/**
 * 联动下接列表框
 * 
 * @author liushuhua
 * 
 */
public class DynamicSelectAction extends DispatchAction {
	/**
	 * 加载一个列表
	 * 
	 * @throws Exception
	 */
	public ActionForward findNodes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynamicSelectDao dao = new DynamicSelectDao();
		List list = new ArrayList();
		list = dao.getRegionByParentIdImp(Long.valueOf(2));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray jsonArray = JSONArray.fromObject(list);
		response.setContentType("text/json;charset=GBK");
		response.getWriter().write(jsonArray.toString());

		return null;
	}

	/**
	 * 加载一个列表
	 * 
	 * @throws Exception
	 */
	public ActionForward findChilderNodes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynamicSelectDao dao = new DynamicSelectDao();
		String parentCode = request.getParameter("parentCode");
		List list = new ArrayList();
		list = dao.queryBasicInfo(parentCode);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray jsonArray = JSONArray.fromObject(list);
		// JSON jsonwrite = JSONSerializer.toJSON(list);
		response.setContentType("text/json;charset=GBK");
		response.getWriter().write(jsonArray.toString());
		// (jsonArray.write(response.getWriter()));
		// System.out.println(jsonArray.toString());
		return null;
	}
	
	

	/**
	 * 行业分类小类
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findChilderList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DictionaryService service = new DictionaryService();
		String parentNodeTypeName = request.getParameter("parentNodeTypeName");
		String childerNodeTypeName = request
				.getParameter("childerNodeTypeName");

		String parentid = request.getParameter("parentid");

		if (StringUtils.isBlank(parentNodeTypeName)
				&&StringUtils.isBlank(childerNodeTypeName))
			return null;
		List list = new ArrayList();
		// 两种查询子节点的方式 一种根据 子节点的typename 一种根据子节点的parentid
		if (parentid != null && !parentid.equalsIgnoreCase("")) {
			list = service.findChilderByParentIdAndNodeValue(
					parentNodeTypeName, parentid);
		} else {
			
			if(parentNodeTypeName!=null&&parentNodeTypeName.equals("F14")){
				list = service.findChilderByNodeValueHangye(parentNodeTypeName,
						childerNodeTypeName);
			}else{
				list = service.findChilderByNodeValue(parentNodeTypeName,
						childerNodeTypeName);
			}
			
		}

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray jsonArray = JSONArray.fromObject(list);

		response.setContentType("text/json;charset=GBK");
		response.getWriter().write(jsonArray.toString());

		return null;
	}
	
	/**
	 * 职安行业三类
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findChilderListByZN(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DictionaryService service = new DictionaryService();
		
		String nodeValue = request
				.getParameter("nodeValue");
		
		String type = request.getParameter("type");
		
		if (StringUtils.isBlank(nodeValue))
			return null;
		
		List list = new ArrayList();
		// 两种查询子节点的方式 一种根据 子节点的typename 一种根据子节点的parentid
		if(type != null && type.length() > 0){
			list = service.findNodeValueByZN(nodeValue,
					"F14");
		}else{
			list = service.findNodeValueByZN(nodeValue,
					nodeValue);
		}

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray jsonArray = JSONArray.fromObject(list);

		response.setContentType("text/json;charset=GBK");
		response.getWriter().write(jsonArray.toString());

		return null;
	}

//	/**
//	 * 取出所有父节点
//	 */
//	public ActionForward parentNodeList(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		DictionaryService service = new DictionaryService();
//		List dynaTrees = new ArrayList();
//		List list = new ArrayList();
//		list = service.parentNodeList();
//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			MetaData element = (MetaData) iter.next();
//			DynaTree dynaTree = new DynaTree();
//			dynaTree.setKey(element.getId().toString());
//			dynaTree.setTitle(element.getNode_name());
//			dynaTree.setLazy(true);
//			dynaTrees.add(dynaTree);
//		}
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//		JSONArray jsonArray = JSONArray.fromObject(dynaTrees);
//		// JSON jsonwrite = JSONSerializer.toJSON(list);
//		response.setContentType("text/json;charset=GBK");
//		response.getWriter().write(jsonArray.toString());
//		// (jsonArray.write(response.getWriter()));
//
//		return null;
//	}


}
