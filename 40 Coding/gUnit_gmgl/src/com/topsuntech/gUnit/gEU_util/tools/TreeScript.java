/*
 * Created on 2007-11-7
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_util.forms.TreeBean;

/**
 * ����һ��Dtree script
 * 
 * @author zhangyong
 * 
 */
public class TreeScript {

	// ���з�
	private static final String endOfLine = System
			.getProperty("line.separator");

	private Map scriptContainer = new HashMap();

	/**
	 * ����dTree�ű�
	 * 
	 * @param treeValue
	 * @param treeTitle
	 * @return
	 */
	public String generateTree(
	        String path, 
	        long root, 
	        List treeValue, 
	        String treeTitle,
			List finalTree,
			long treeType, 
			long chargeAll , 
			long showType,
			long role,
			String sysTemFlag,
            Long userId) {

		StringBuffer script = new StringBuffer();
		script.append("<div class='dtree'>").append(endOfLine);
		script.append("<p>").append(endOfLine);
		if(showType == 1){
			script.append("<a href='javascript:chooseValue();'>").append("���ѡ��")
				.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);					
		}
		if(showType == 1 && role == 3){
		    ;
		}else{
			script.append("<a href='javascript:tree.openAll();'>").append("ȫ��չ��")
				.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);
			script.append("<a href='javascript:tree.closeAll();'>").append("ȫ���ر�")
					.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);
		    
		}
		script.append("<a href='javascript:window.close();'>").append("�رմ���")
				.append("</a>").append(endOfLine);
		script.append("</p>").append(endOfLine);
		script.append("<script type='text/javascript'>").append(endOfLine);
		script.append("var tree = new dTree('tree',").append(path).append(");").append(endOfLine);
		script.append("tree.add(").append(root).append(",-1,'");
		
		if(showType == 1 && role == 3)
		    script.append("<input type=checkbox name=allbox onclick=checkAll(this,chk1) >");
		
		script.append(treeTitle);		
		script.append("');").append(endOfLine);
		script.append(recursionTree(treeValue, finalTree, chargeAll));
		script.append("document.write(tree);").append(endOfLine);
		script.append("</script>").append(endOfLine);
		script.append("</div>").append(endOfLine);
		return script.toString();
	}

	/**
	 * ����dTree�ű�
	 * 
	 * @param node
	 * @return
	 * @throws Exception
	 */
//	public String generateTree(
//	        String path, 
//	        long resourceDeptId, 
//	        long node, 
//	        String title ,
//	        long treeType,
//	        long chargeAll, 
//	        long projectStatus, 
//	        long projectType ,
//	        long showType,
//	        String callObjName,
//	        String sysTemFlag,
//            Long userId,
//            String salvageTypeId,
//            String sendMoney,
//            String sendType, 
//            String selectObjIdValue) throws Exception {
//	    
//		try {
//		    //����ί���            
//		    long role = Dicts.judgeRoleById(node);		    		    
//		    if(callObjName != null 
//		            && callObjName.trim().equals("1") && treeType == 2 && role == 2)
//		        node = Constants.NODE_GUIDANCE.ID;
//		                
// 			List listTree = Dicts.getCurrentNodeDownTree(resourceDeptId, 
// 			        node,treeType, 
// 			        projectStatus,
// 			        projectType,
// 			        showType, 
// 			        callObjName,
// 			        sysTemFlag,
// 			        userId,
//                   salvageTypeId,
//                   sendMoney,
//                   sendType,
//                   selectObjIdValue
//                   );
// 			
// 			Object rootTreeObj = listTree.get(0);
// 			node = Long.parseLong(rootTreeObj.toString());
// 			
// 			Object treeObject = listTree.get(1);
// 			List tree = (ArrayList)treeObject; 
// 			
//			List finalTree = new ArrayList(tree);
//			return generateTree(
//			        path, 
//			        node, 
//			        tree, 
//			        title, 
//			        finalTree,
//			        treeType,
//			        chargeAll, 
//			        showType,
//			        role,
//			        sysTemFlag,
//                    userId
//			        );
//		} catch (SQLException e) {
//			Logger.error("ץȡ�����ֵ䣨����ʧ��.", e);
//			throw new Exception("ץȡ�����ֵ䣨����ʧ��.", e);
//		}
//	}

	/**
	 * �ݹ�
	 * 
	 * @param treeValue
	 * @param node
	 * @return
	 */
	protected String recursionTree(List treeValue, List finalTree, long chargeType) {
		StringBuffer script = new StringBuffer();
				
		for (int i = 0; i < treeValue.size(); i++) {
			TreeBean root = (TreeBean) treeValue.get(i);

			if (hasChildNode(root, finalTree)) {
			    if(chargeType == 0)
			        script.append(generateParentScriptLine(root));
			    else if(chargeType == 1){
			        script.append(generateChildScriptLine(root));
			    }
			    
				List childNode = getChildNode(root, treeValue);
				// �ݹ��ӽڵ�
				script.append(recursionTree(childNode, finalTree, chargeType));
			} else {
				//����������ӽڵ㣬�Ͳ�������
				if (!scriptContainer.containsKey(String.valueOf(root.getKey()))) {
					scriptContainer.put(String.valueOf(root.getKey()), root);
					script.append(generateChildScriptLine(root));
				}
			}
		}

		return script.toString();
	}

	/**
	 * ����һ��dTree Script
	 * 
	 * @param root
	 * @return
	 */
	protected String generateChildScriptLine(TreeBean root) {
		StringBuffer script = new StringBuffer();

		script.append("tree.add(").append(root.getKey()).append(",").append(
				root.getParentid()).append(",");
		script.append("'").append(root.getValue()).append("',").append(
				"\"javascript:toValue('");
		script.append(root.getKey()).append("','").append(root.getValue())
				.append("','").append(root.getNum()).append("')\");").append(endOfLine);

		return script.toString();
	}

	protected String generateParentScriptLine(TreeBean root) {
		StringBuffer script = new StringBuffer();

		script.append("tree.add(").append(root.getKey()).append(",").append(
				root.getParentid()).append(",");

//		script.append("'").append(root.getValue()).append("',").append(
//		        root.getNum()).append(");").append(endOfLine);
		
		script.append("'").append(root.getValue()).append("',").append(
			"\"javascript:toValue('");
		script.append(root.getKey()).append("','").append(root.getValue())
				.append("','").append(root.getNum()).append("')\");").append(endOfLine);
		
		return script.toString();
	}

	/**
	 * �õ��ӽڵ�
	 * 
	 * @param treeRoot
	 * @param tree
	 * @return
	 */
	protected List getChildNode(TreeBean treeRoot, List tree) {
		List childNode = new ArrayList();

		for (int i = 0; i < tree.size(); i++) {
			TreeBean child = (TreeBean) tree.get(i);
			if (child.getParentid() == treeRoot.getKey()) {
				childNode.add(child);
			}
		}
		return childNode;
	}

	/**
	 * �õ��ӽڵ�
	 * 
	 * @param root
	 * @param tree
	 * @return
	 */
	protected List getChildNode(long root, List tree) {
		List childNode = new ArrayList();

		for (int i = 0; i < tree.size(); i++) {
			TreeBean child = (TreeBean) tree.get(i);
			if (child.getParentid() == root) {
				childNode.add(child);
			}
		}
		return childNode;
	}

	/**
	 * �жϵ�ǰ�ڵ��Ƿ����ӽڵ�
	 * 
	 * @param treeRoot
	 * @param tree
	 * @return
	 */
	protected boolean hasChildNode(TreeBean treeRoot, List tree) {
		for (int i = 0; i < tree.size(); i++) {
			TreeBean child = (TreeBean) tree.get(i);
			if (child.getParentid() == treeRoot.getKey()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		TreeScript treeScript = new TreeScript();
//		try {
//			System.out.println(treeScript.generateTree(
//					"hdsj", 0 ,Constants.RESOURCE_TYPE.ROOT_ID, "��Դ����", 1, 0,1, -1, 0, null,"jbsh", null, null,null,null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
