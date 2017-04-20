/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_tree.service;

import java.util.ArrayList;
import java.util.List;

import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.en.region.Region;
import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
import com.topsuntech.gUnit.gEU_util.tools.Constants;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Ibm
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class RegionTreeService {
	private static DBWrapper db = DBRegistry.getDBWrapper("gos");

	/**
	 * 动态树：获取当前区域节点的下级区域节点
	 * 
	 * @param treeList
	 * @param regionId
	 *            区域ID
	 * @return
	 */
	public static List getRegionNodeForTree(List treeList, long regionId, long treeType, Long treeLev) {
		treeList = (treeList != null) ? treeList : new ArrayList();

		try {
			List list = Dicts.getRegionByParentIdImp(new Long(regionId), treeLev);

			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Region region = (Region) list.get(i);
					StringBuffer name = new StringBuffer();
					if (treeType == Constants.treeType.REGION_LIST_TREE) {
						name.append(region.getName()).append("&nbsp;&nbsp;").append("<a href=\" javascript: addChilds(").append(region.getId()).append(",'").append(region.getName()).append("',").append(region.getLevel()).append(")\" >增加下级</a>").append("&nbsp;&nbsp;").append(
								"<a href=\" javascript: updates(").append(region.getId()).append(",'").append(region.getName()).append("',").append(region.getLevel()).append(")\" >修改</a>").append("&nbsp;&nbsp;").append("<a href=\" javascript: stops(").append(region.getId()).append(",'").append(
								region.getName()).append("',").append(region.getLevel()).append(")\" >停用</a>").append("&nbsp;&nbsp;").append("<a href=\" javascript: deletes(").append(region.getId()).append(",'").append(region.getName()).append("',").append(region.getLevel()).append(")\" >删除</a>");
					} else if (treeType == Constants.treeType.REGION_SELECT_TREE) {
						name.append("<a href=\"javascript: doSelected(").append(region.getId()).append(",'").append(region.getName()).append("')\" >").append(region.getName()).append("</a>");
					}

					// System.out.println("\n --name : " + name.toString());
					String rootFlag = "Y";
					String chidlNodeValue = region.getId().toString() + "," + Constants.treeNodeType.REGION + "," + treeType;
					String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;

					treeList.add(new treeBean(region.getId().longValue(), name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
				}
			}
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		return treeList;
	}

}
