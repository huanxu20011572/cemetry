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
 * 生成一个Dtree script
 * 
 * @author zhangyong
 * 
 */
public class TreeScript {

	// 换行符
	private static final String endOfLine = System
			.getProperty("line.separator");

	private Map scriptContainer = new HashMap();

	/**
	 * 生成dTree脚本
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
			script.append("<a href='javascript:chooseValue();'>").append("添加选择")
				.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);					
		}
		if(showType == 1 && role == 3){
		    ;
		}else{
			script.append("<a href='javascript:tree.openAll();'>").append("全部展开")
				.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);
			script.append("<a href='javascript:tree.closeAll();'>").append("全部关闭")
					.append("</a>").append(endOfLine);
			script.append(" | ").append(endOfLine);
		    
		}
		script.append("<a href='javascript:window.close();'>").append("关闭窗口")
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
	 * 生成dTree脚本
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
//		    //用于委办局            
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
//			Logger.error("抓取数据字典（树）失败.", e);
//			throw new Exception("抓取数据字典（树）失败.", e);
//		}
//	}

	/**
	 * 递归
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
				// 递归子节点
				script.append(recursionTree(childNode, finalTree, chargeType));
			} else {
				//如果已生成子节点，就不再生成
				if (!scriptContainer.containsKey(String.valueOf(root.getKey()))) {
					scriptContainer.put(String.valueOf(root.getKey()), root);
					script.append(generateChildScriptLine(root));
				}
			}
		}

		return script.toString();
	}

	/**
	 * 生成一条dTree Script
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
	 * 得到子节点
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
	 * 得到子节点
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
	 * 判断当前节点是否有子节点
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
//					"hdsj", 0 ,Constants.RESOURCE_TYPE.ROOT_ID, "资源分类", 1, 0,1, -1, 0, null,"jbsh", null, null,null,null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
