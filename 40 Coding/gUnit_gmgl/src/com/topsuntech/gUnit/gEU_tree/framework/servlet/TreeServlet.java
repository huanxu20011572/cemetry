/**
 * @author lixirong
 * 描述：动态树，基本ajax
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_tree.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONTokener;

import com.topsuntech.gUnit.gEU_tree.service.DeptTreeService;
import com.topsuntech.gUnit.gEU_tree.service.JZDictionaryService;
import com.topsuntech.gUnit.gEU_tree.service.RegionTreeService;
import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
import com.topsuntech.gUnit.gEU_util.methods.PBMethod;
import com.topsuntech.gUnit.gEU_util.tools.Constants;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

public class TreeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String data = request.getParameter("data");
		if (action.equalsIgnoreCase("getChildren")) {
			JSONTokener jsonTokener = new JSONTokener(data);
			JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
			JSONObject parentNodeObject = (JSONObject) jsonObject.get("node");

			response.setContentType("text/json; charset=GBK");
			PrintWriter out = response.getWriter();
			out.write(getChildren(parentNodeObject, request));
		} else {
		}
	}

	private String getChildren(JSONObject parentNodeObject, HttpServletRequest request) {
		JSONArray result = new JSONArray();
		String objectIdStr = parentNodeObject.getString("objectId"); //id 唯一

		String userIdStr = parentNodeObject.getString("userId"); //id 唯一

		String[] objectIds = PBMethod.stringToKenizer(objectIdStr, ",");

		long rootId = -1;
		long treeNodeType = -1;
		long treeType = -1;
		Long treeLev = new Long(3);
		List treeList = null;
		if (objectIds != null) {
			rootId = Long.parseLong(objectIds[0].trim());
			treeNodeType = Long.parseLong(objectIds[1].trim());
			treeType = Long.parseLong(objectIds[2].trim());

			 //树类型判断
			if (treeType == Constants.treeType.REGION_LIST_TREE || treeType == Constants.treeType.REGION_SELECT_TREE) {

				treeList = RegionTreeService.getRegionNodeForTree(treeList, rootId, treeType, null);
			} else if (treeType == Constants.treeType.DEPT_LIST_TREE || treeType == Constants.treeType.DEPT_SELECT_TREE) {

				treeLev = new Long(4);
				if (treeNodeType == Constants.treeNodeType.DEPT) {
					treeList = DeptTreeService.getDeptChildByDeptTree(treeList, rootId, treeType, Constants.NO, Constants.treeAttribute.root_YES, treeNodeType);
				} else if (treeNodeType == Constants.treeNodeType.DEPT_DN_REGION) {
					long currentRegionId = 2;
					treeList = DeptTreeService.getRegionNodeForDeptTree(treeList, currentRegionId, treeType, treeLev);
				} else if (treeNodeType == Constants.treeNodeType.REGION_DN_DEPT || treeNodeType == Constants.treeNodeType.REGION) {
					treeList = DeptTreeService.getDeptChildByDeptTree(treeList, rootId, treeType, Constants.NO, Constants.treeAttribute.root_YES, treeNodeType);
					treeList = DeptTreeService.getRegionNodeForDeptTree(treeList, rootId, treeType, treeLev);
				}
			} else if (treeType == Constants.treeType.REGION_DEPT) {
				if (treeNodeType == Constants.treeNodeType.REGION) {
					treeList = DeptTreeService.getDeptNodeForTree(treeList, Long.toString(rootId), treeType, Constants.NO, rootId, Constants.treeAttribute.root_YES);
					treeList = Dicts.getRegionNodeForTree(treeList, rootId, treeType, treeLev);
				}
			} else if (treeType == Constants.treeType.SJ_STATUS_CANUM_SELECT_TREE) {

				JZDictionaryService service = new JZDictionaryService();
				treeList = service.getDictNodeForTree(treeList, rootId, treeType, Constants.YES, Constants.treeAttribute.root_YES);

			}

		}

		result = buildChildren(treeList);

		return result.toString();

	}

	private JSONArray buildChildren(List treeList) {
		JSONArray result = new JSONArray();

		if (treeList != null) {
			Iterator it = treeList.iterator();
			while (it.hasNext()) {
				treeBean bean = (treeBean) it.next();
				try {
					JSONObject jsonGnmkObject = new JSONObject();

					String rootFlag = bean.getRootFlag();
					boolean isFolder = rootFlag.equalsIgnoreCase("Y") ? true : false;

					jsonGnmkObject.put("title", bean.getValue());
					jsonGnmkObject.put("isFolder", isFolder);
					jsonGnmkObject.put("widgetId", bean.getKey());
					jsonGnmkObject.put("objectId", bean.getChidlNodeValue());
					jsonGnmkObject.put("childIconSrc", "images/" + bean.getNodeImage());
					jsonGnmkObject.put("url", bean.getNodeUrl());

					result.put(jsonGnmkObject);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
