//package com.topsuntech.gUnit.gEU_tree.service;
//
///**
// * 静态树：pubTree
// */
//
//import java.sql.SQLException;
//import java.util.List;
//
//
//public interface  StaticTreeService {
//    
//
//    
//
//    
//    
//    /**
//     * 静态树：生成用户角色树
//     * @param treeList
//     * @param rootId
//     * @return
//     * @throws SQLException
//     */
//    public  List createUserRoleTree(List treeList, long rootId) throws SQLException;
//    
//    
//    /**
//     * 静态树：生成区域树
//     * 
//     * @param treeList
//     * @param regionId  区域ID
//     *            
//     * @return
//     */
//    public List createRegionTree(List treeList, long regionId);
//    
//    
//    /**
//     *  静态树: 生成本级机构节点
//     * @param treeList
//     * @param rootId
//     * @param showType
//     * @param treeType
//     * @param tree
//     * @param type
//     * @return
//     */
//    public  List createSameDeptNodeTree(List treeList, long rootId,
//            long showType, long treeType, List tree, long type);
//    
//    
//    
//    /**
//     * 静态树：添加可选择的box
//     * @param bExistChild 
//     * @param strValue  返回字符串
//     * @return
//     */
//    public  String addChooseBox(boolean bExistChild, String strValue ,boolean disabled,boolean checked );
//    
//    
//    
//    /**
//     * 静态树：生成机构节点树
//     * @param treeList
//     * @param rootId           树节点
//     * @param showType         0,不显示；1，显示'checkbox'对象;
//     * @param treeType         树类型
//     * @param projectStatus    -1，显示所有项目；1，只显示有效项目[只对项目资源树有效] 
//     * @param sysTemFlag       系统标识
//     * @param regionId         区域ID
//     * @param deptLev          机构级别
//     * @param bcurr            
//     * @param platFormRole     平台角色
//     * @return
//     */
//    public List addSjDeptNodeTree(
//            List treeList, 
//            Long rootId, 
//            long showType, 
//            long treeType, 
//            long projectStatus, 
//            String sysTemFlag, 
//            Long regionId, 
//            long deptLev, 
//            boolean bcurr, 
//            long userPlateFormRole); 
//
//    /**
//     * 静态树：建立字典树
//     * @param rootId
//     * @param treeType
//     * @param showType
//     * @param selectObjIdValue
//     * @return
//     */
////    public List createDictTree(long rootId,long treeType,long showType, String selectObjIdValue);
//
//   
//}
package com.topsuntech.gUnit.gEU_tree.service;

/**
 * 静态树：pubTree
 */

import java.sql.SQLException;
import java.util.List;

public interface StaticTreeService {

	/**
	 * 静态树：生成用户角色树
	 * 
	 * @param treeList
	 * @param rootId
	 * @return
	 * @throws SQLException
	 */
	public List createUserRoleTree(List treeList, long rootId) throws SQLException;

	/**
	 * 静态树：生成区域树
	 * 
	 * @param treeList
	 * @param regionId
	 *            区域ID
	 * 
	 * @return
	 */
	public List createRegionTree(List treeList, long regionId);

	/**
	 * 静态树: 生成本级机构节点
	 * 
	 * @param treeList
	 * @param rootId
	 * @param showType
	 * @param treeType
	 * @param tree
	 * @param type
	 * @return
	 */
	public List createSameDeptNodeTree(List treeList, long rootId, long showType, long treeType, List tree, long type);

	/**
	 * 静态树：添加可选择的box
	 * 
	 * @param bExistChild
	 * @param strValue
	 *            返回字符串
	 * @return
	 */
	public String addChooseBox(boolean bExistChild, String strValue, boolean disabled, boolean checked);

	/**
	 * 静态树：生成机构节点树
	 * 
	 * @param treeList
	 * @param rootId
	 *            树节点
	 * @param showType
	 *            0,不显示；1，显示'checkbox'对象;
	 * @param treeType
	 *            树类型
	 * @param projectStatus
	 *            -1，显示所有项目；1，只显示有效项目[只对项目资源树有效]
	 * @param sysTemFlag
	 *            系统标识
	 * @param regionId
	 *            区域ID
	 * @param deptLev
	 *            机构级别
	 * @param bcurr
	 * @param platFormRole
	 *            平台角色
	 * @return
	 */
	public List addSjDeptNodeTree(List treeList, Long rootId, long showType, long treeType, long projectStatus, String sysTemFlag, Long regionId, long deptLev, boolean bcurr, long userPlateFormRole);

	/**
	 * 静态树：建立字典树
	 * 
	 * @param rootId
	 * @param treeType
	 * @param showType
	 * @param selectObjIdValue
	 * @return
	 */
	public List createDictTree(long rootId, long treeType, long showType, String selectObjIdValue);

}
