/*
 * Created on 2008-1-27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_tree.service;

import java.util.ArrayList;
import java.util.List;

import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

/**
 * @author lixirong
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class ArchivesTreeService {
	private static DBWrapper db = DBRegistry.getDBWrapper("gos");

	/**
	 * 动态树：
	 * 
	 * @param treeList
	 *            treeList
	 * @param regionId
	 *            区域Id
	 * @param treeType
	 *            树类型
	 * @param showCheck
	 *            显示checkbox
	 * @return
	 */
	public static List buildBJDeptNodeForTree(List treeList, long rootId, long treeType) {
		treeList = (treeList != null) ? treeList : new ArrayList();

		String deptName = "";
		String checkName = "";
		if (treeType == Constants.treeType.REGION_DEPT_NORMAL_WORK_BJ) {
			deptName = "本级机构";
			checkName = "ckg" + rootId;
		} else if (treeType == Constants.treeType.REGION_DEPT_NORMAL_WORK_XJ) {
			deptName = "下级机构";
			checkName = "ckg" + rootId + "000";
		}

		StringBuffer name = new StringBuffer();
		name.append("<input type='checkbox' name='").append(checkName).append("'").append(" value=',").append(rootId).append(",|,").append(deptName).append(",'").append(" onclick='javascript: getSelectedBJ(this)' ").append(">").append(deptName);

		String rootFlag = "Y";
		String chidlNodeValue = rootId + "," + Constants.treeNodeType.DEPT + "," + treeType;
		String image = Constants.treeAttribute.IMAGE;

		treeList.add(new treeBean(rootId, name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));

		return treeList;
	}

}
