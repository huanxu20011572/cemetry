//package com.topsuntech.gUnit.gEU_tree.service;
//
///**
// * ��̬����pubTree
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
//     * ��̬���������û���ɫ��
//     * @param treeList
//     * @param rootId
//     * @return
//     * @throws SQLException
//     */
//    public  List createUserRoleTree(List treeList, long rootId) throws SQLException;
//    
//    
//    /**
//     * ��̬��������������
//     * 
//     * @param treeList
//     * @param regionId  ����ID
//     *            
//     * @return
//     */
//    public List createRegionTree(List treeList, long regionId);
//    
//    
//    /**
//     *  ��̬��: ���ɱ��������ڵ�
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
//     * ��̬������ӿ�ѡ���box
//     * @param bExistChild 
//     * @param strValue  �����ַ���
//     * @return
//     */
//    public  String addChooseBox(boolean bExistChild, String strValue ,boolean disabled,boolean checked );
//    
//    
//    
//    /**
//     * ��̬�������ɻ����ڵ���
//     * @param treeList
//     * @param rootId           ���ڵ�
//     * @param showType         0,����ʾ��1����ʾ'checkbox'����;
//     * @param treeType         ������
//     * @param projectStatus    -1����ʾ������Ŀ��1��ֻ��ʾ��Ч��Ŀ[ֻ����Ŀ��Դ����Ч] 
//     * @param sysTemFlag       ϵͳ��ʶ
//     * @param regionId         ����ID
//     * @param deptLev          ��������
//     * @param bcurr            
//     * @param platFormRole     ƽ̨��ɫ
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
//     * ��̬���������ֵ���
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
 * ��̬����pubTree
 */

import java.sql.SQLException;
import java.util.List;

public interface StaticTreeService {

	/**
	 * ��̬���������û���ɫ��
	 * 
	 * @param treeList
	 * @param rootId
	 * @return
	 * @throws SQLException
	 */
	public List createUserRoleTree(List treeList, long rootId) throws SQLException;

	/**
	 * ��̬��������������
	 * 
	 * @param treeList
	 * @param regionId
	 *            ����ID
	 * 
	 * @return
	 */
	public List createRegionTree(List treeList, long regionId);

	/**
	 * ��̬��: ���ɱ��������ڵ�
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
	 * ��̬������ӿ�ѡ���box
	 * 
	 * @param bExistChild
	 * @param strValue
	 *            �����ַ���
	 * @return
	 */
	public String addChooseBox(boolean bExistChild, String strValue, boolean disabled, boolean checked);

	/**
	 * ��̬�������ɻ����ڵ���
	 * 
	 * @param treeList
	 * @param rootId
	 *            ���ڵ�
	 * @param showType
	 *            0,����ʾ��1����ʾ'checkbox'����;
	 * @param treeType
	 *            ������
	 * @param projectStatus
	 *            -1����ʾ������Ŀ��1��ֻ��ʾ��Ч��Ŀ[ֻ����Ŀ��Դ����Ч]
	 * @param sysTemFlag
	 *            ϵͳ��ʶ
	 * @param regionId
	 *            ����ID
	 * @param deptLev
	 *            ��������
	 * @param bcurr
	 * @param platFormRole
	 *            ƽ̨��ɫ
	 * @return
	 */
	public List addSjDeptNodeTree(List treeList, Long rootId, long showType, long treeType, long projectStatus, String sysTemFlag, Long regionId, long deptLev, boolean bcurr, long userPlateFormRole);

	/**
	 * ��̬���������ֵ���
	 * 
	 * @param rootId
	 * @param treeType
	 * @param showType
	 * @param selectObjIdValue
	 * @return
	 */
	public List createDictTree(long rootId, long treeType, long showType, String selectObjIdValue);

}
