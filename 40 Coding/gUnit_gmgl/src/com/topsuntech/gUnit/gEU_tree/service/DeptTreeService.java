 /*
  * Created on 2008-1-28
  *
  * TODO To change the template for this generated file go to
  * Window - Preferences - Java - Code Style - Code Templates
  */
 package com.topsuntech.gUnit.gEU_tree.service;
 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;
 
 import com.topsuntech.gOS.query.DBRegistry;
 import com.topsuntech.gOS.query.DBWrapper;
 import com.topsuntech.gOS.query.TSDBException;
 import com.topsuntech.gOS.user.en.region.Region;
 import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
 import com.topsuntech.gUnit.gEU_util.tools.Constants;
 import com.topsuntech.gUnit.gEU_util.tools.Dicts;
 import com.topsuntech.gUnit.gEU_util.tools.Tools;
 
 /**
  * @author Ibm
  * 
  *         TODO To change the template for this generated type comment go to
  *         Window - Preferences - Java - Code Style - Code Templates
  */
 public class DeptTreeService {
 	private static DBWrapper db = DBRegistry.getDBWrapper("gos");
 
 	/**
 	 * 动态树：获取当前区域节点的下级区域节点
 	 * 
 	 * @param treeList
 	 * @param regionId
 	 *            区域ID
 	 * @return
 	 */
 	public static List getRegionNodeForDeptTree(List treeList, long regionId, long treeType, Long treeLev) {
 		treeList = (treeList != null) ? treeList : new ArrayList();
 
 		try {
 
 			List list = Dicts.getRegionByParentIdImp(new Long(regionId), treeLev);
 
 			if (list != null && list.size() > 0) {
 				for (int i = 0; i < list.size(); i++) {
 					Region region = (Region) list.get(i);
 
 					StringBuffer name = new StringBuffer();
 					if (treeType == Constants.treeType.DEPT_LIST_TREE) {
 						name.append(region.getName()).append("[区域]")
 						  .append("&nbsp;&nbsp;")
 						  .append("<a href=\" javascript: addChildDept(").append(region.getId())
 						  .append(")\" >增加下级机构</a>");
 					} else if (treeType == Constants.treeType.DEPT_SELECT_TREE) {
 						name.append(region.getName()).append("[区域]");
 					}
 
 					String rootFlag = "Y";
 					String chidlNodeValue = region.getId().toString() + "," + Constants.treeNodeType.REGION_DN_DEPT + "," + treeType;
 					String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;
 
 					treeList.add(new treeBean(region.getId().longValue(), name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
 				}
 			}
 		} catch (TSDBException e) {
 			e.printStackTrace();
 		}
 		return treeList;
 	}
 
 	/**
 	 * 动态树：获取当前区域节点下的机构节点值
 	 * 
 	 * @param treeList
 	 *            treeList
 	 * @param regionId
 	 *            区域Id
 	 * @param treeType
 	 *            树类型
 	 * @param showCheck
 	 *            显示checkbox
 	 * @param archiveRegionId
 	 *            本级区域ID
 	 * @return
 	 */
 	public static List getDeptNodeForTree(List treeList, String regionIdStr, long treeType, String showCheckBox, long archiveRegionId, String rootFlag) {
 
 		ResultSet rs = null;
 
 		treeList = (treeList != null) ? treeList : new ArrayList();
 		regionIdStr = Tools.afterString(regionIdStr, ",");
 		String checkName = "chg" + archiveRegionId;
 
 		try {
 			StringBuffer querySql = new StringBuffer();
 			querySql.append("select * from gos_dept dt where dt.regionid in (").append(regionIdStr).append(")");
 			querySql.append(" and dt.use_flag=1 ");
 			  querySql.append(" and dt.approve_unit_code is not null");
 			querySql.append(" order by dt.orderby_item asc ");
 
 			System.out.println("\n ---querySql : " + querySql.toString());
 
 			rs = db.executeQuery(querySql.toString());
 			while (rs.next()) {
 				StringBuffer name = new StringBuffer();
 
 				name.append("<a href='#' onClick=\"javascript:doSelected(").append(rs.getLong("id")).append(",'").append(rs.getString("name")).append("')\">").append(rs.getString("name")).append("</a>");
 
 				String chidlNodeValue = rs.getLong("id") + "," + Constants.treeNodeType.DEPT + "," + treeType;
 				String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;
 
 				  System.out.println("\n ----name.toString() : " +
 				  name.toString());
 				treeList.add(new treeBean(rs.getLong("id"), name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
 			}
 		} catch (Exception e) {
 			;
 		} finally {
 			if (rs != null)
 				try {
 					rs.close();
 				} catch (SQLException e1) {
 					e1.printStackTrace();
 				}
 		}
 
 		  System.out.println("\n ----treeList : " + treeList);
 
 		return treeList;
 
 	}
 
 	/**
 	 * 动态树：获取当前区域节点下的机构节点值
 	 * 
 	 * @param treeList
 	 *            treeList
 	 * @param regionId
 	 *            区域Id
 	 * @param treeType
 	 *            树类型
 	 * @param showCheck
 	 *            显示checkbox
 	 * @param archiveRegionId
 	 *            本级区域ID
 	 * @return
 	 */
 	public static List getDeptChildByDeptTree(List treeList, long rootId, long treeType, String showCheckBox, String rootFlag, long rootType) {
 
 		ResultSet rs = null;
 
 		treeList = (treeList != null) ? treeList : new ArrayList();
 		String checkName = "chg" + rootId;
 
 		try {
 			StringBuffer querySql = new StringBuffer();
 			querySql.append(" select * from gos_dept t where t.use_flag=1 ");
 			if (rootType == Constants.treeNodeType.DEPT) {
 				querySql.append(" and t.parent_id=").append(rootId);
 			} else {
 				querySql.append(" and t.regionid=").append(rootId);
 				querySql.append(" and t.levelid in(3,4)");
 				long regionLevId = Dicts.judgeRegionLevel(new Long(rootId));
 				if (regionLevId == 3) {
 					querySql.append(" and t.tree_node =0");
 					  querySql.append(" and t.approve_unit_code is not null ");
 				}
 				if (regionLevId == 2) {
 					querySql.append(" and t.tree_node =2");
 					  querySql.append(" and t.approve_unit_code is not null ");
 				}
 			}
 
 			querySql.append(" order by t.orderby_item asc ");
 
 			  System.out.println("\n ---querySql : " + querySql.toString());
 
 			rs = db.executeQuery(querySql.toString());
 			while (rs.next()) {
 				long deptId = rs.getLong("id");
 				String deptName = rs.getString("name");
 				long deptLevId = rs.getLong("levelid");
 
 				StringBuffer name = new StringBuffer();
 				if (treeType == Constants.treeType.DEPT_LIST_TREE) {
 					name.append(deptName).append("&nbsp;&nbsp;").append("<a href=\" javascript: updateDept(").append(deptId).append(")\" >修改</a>").append("&nbsp;&nbsp;").append("<a href=\" javascript: stopDept(").append(deptId).append(")\" >停用</a>").append("&nbsp;&nbsp;").append(
 							"<a href=\" javascript: deleteDept(").append(deptId).append(")\" >删除</a>")
 					  .append("&nbsp;&nbsp;")
 					  .append("<a href=\" javascript: addChildDept(").append(deptId)
 					  .append(")\" >增加下级</a>");
 				} else if (treeType == Constants.treeType.DEPT_SELECT_TREE) {
 					name.append("<a href=\"javascript: doSelected(").append(deptId).append(",'").append(deptName).append("')\" >").append(deptName).append("</a>");
 				}
 
 				String chidlNodeValue = "";
 				long ctLev = -1;
 
 				if (rootType == Constants.treeNodeType.DEPT)
 					ctLev = Dicts.judgeRoleById(deptId);
 
 				if (ctLev != 3) {
 					chidlNodeValue = deptId + "," + Constants.treeNodeType.DEPT + "," + treeType;
 				} else {
 					chidlNodeValue = deptId + "," + Constants.treeNodeType.DEPT_DN_REGION + "," + treeType;
 				}
 				String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;
 
 				treeList.add(new treeBean(deptId, name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
 			}
 		} catch (Exception e) {
 			;
 		} finally {
 			if (rs != null)
 				try {
 					rs.close();
 				} catch (SQLException e1) {
 					e1.printStackTrace();
 				}
 		}
 
 		  System.out.println("\n ----treeList : " + treeList);
 
 		return treeList;
 
 	}
 
 }
