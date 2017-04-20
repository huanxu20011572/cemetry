/*
 * Created on 2007-11-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.vo;

import com.topsuntech.gOS.user.en.office.Office;

/**
 * @author Ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OfficeVO extends Office{
  private Long parentId ;
  private long treeNode;
  
  
  
  
/**
 * @return Returns the treeNode.
 */
public long getTreeNode() {
    return treeNode;
}
/**
 * @param treeNode The treeNode to set.
 */
public void setTreeNode(long treeNode) {
    this.treeNode = treeNode;
}
/**
 * @return Returns the parentId.
 */
public Long getParentId() {
    return parentId;
}
/**
 * @param parentId The parentId to set.
 */
public void setParentId(Long parentId) {
    this.parentId = parentId;
}

}
