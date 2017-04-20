/*
 * Created on 2008-1-1
 * @author lixirong
 * 描述：动态树vo
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_tree.service.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class treeBean implements Serializable{
    public treeBean(long key, String value) { 
		this.key = key; 
		this.value = value;
	} 
	
	public treeBean(long key, String value, long lockStatus) { 
		this.key = key; 
		this.value = value;
		this.lockStatus = lockStatus;
	} 
	
	public treeBean(long key, String value, List childs) { 
		this.key = key; 
		this.value = value;
		this.childs = childs;
	} 	
	
	
	public treeBean(long key, String value, Object obj, long flag) { 
		this.key = key; 
		this.value = value;
		this.obj = obj;
		this.flag = flag;
	} 	
	

	public treeBean(long key, String value, int parentId,Object obj) { 
		this.key = key; 
		this.value = value;
		this.parentId = parentId;
		this.obj = obj;		
	} 	
	
	

	public treeBean(
	        long key, 
	        String value, 
	        String rootFlag ,
	        String chidlNodeValue, 
	        String nodeImage, 
	        String nodeUrl
	        ) { 
		this.key = key; 
		this.value = value;
		this.rootFlag = rootFlag;
		this.chidlNodeValue = chidlNodeValue;
		this.nodeImage = nodeImage;	
		this.nodeUrl  = nodeUrl;
	} 		
	
	static final long serialVersionUID=11;
	
	private long key; 	
	
	private String value; 
	
	private long lockStatus;
	
	private List childs = new ArrayList();
	
	private Object obj;
	
	private long flag ;
	
	private long parentId;
	
	private String isFolder;
	//是否树节点
	private String rootFlag; 
	//树节点
	private String chidlNodeValue;
	//节点图片
	private String nodeImage;
	//节点Url
	private String nodeUrl; 
	
	
	
	
	
	
    /**
     * @return Returns the isFolder.
     */
    public String getIsFolder() {
        return isFolder;
    }
    /**
     * @param isFolder The isFolder to set.
     */
    public void setIsFolder(String isFolder) {
        this.isFolder = isFolder;
    }
    /**
   
    /**
     * @return Returns the nodeUrl.
     */
    public String getNodeUrl() {
        return nodeUrl;
    }
    /**
     * @param nodeUrl The nodeUrl to set.
     */
    public void setNodeUrl(String nodeUrl) {
        this.nodeUrl = nodeUrl;
    }
    /**
     * @return Returns the nodeImage.
     */
    public String getNodeImage() {
        return nodeImage;
    }
    /**
     * @param nodeImage The nodeImage to set.
     */
    public void setNodeImage(String nodeImage) {
        this.nodeImage = nodeImage;
    }
    /**
     * @return Returns the rootFlag.
     */
    public String getRootFlag() {
        return rootFlag;
    }
    /**
     * @param rootFlag The rootFlag to set.
     */
    public void setRootFlag(String rootFlag) {
        this.rootFlag = rootFlag;
    }
    /**
     * @return Returns the isFolder.
     */
    public String isFolder() {
        return isFolder;
    }
    /**
     * @param isFolder The isFolder to set.
     */
    public void setFolder(String isFolder) {
        this.isFolder = isFolder;
    }
    /**
     * @return Returns the parentId.
     */
    public long getParentId() {
        return parentId;
    }
    /**
     * @param parentId The parentId to set.
     */
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    public long getFlag() {
        return flag;
    }
    public void setFlag(long flag) {
        this.flag = flag;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
	public long getKey() { 
		return this.key; 
	} 	
	public void setKey(long key) { 
		this.key = key; 
	} 
	public String getValue() { 
		return this.value; 
	} 	
	public void setValue(String value) { 
		this.value = value; 
	}
    public long getLockStatus() {
        return lockStatus;
    }
    public void setLockStatus(long lockStatus) {
        this.lockStatus = lockStatus;
    }
    public List getChilds() {
        return childs;
    }
    public void setChilds(List childs) {
        this.childs = childs;
    }
	
    public String toString() { 
        StringBuffer str = new StringBuffer();
        str.append("\n key = " ).append(this.key);
        str.append("\n value = " ).append(this.value);  
        str.append("\n rootFlag = " ).append(this.rootFlag);      
        str.append("\n chidlNodeValue = " ).append(this.chidlNodeValue);
        str.append("\n nodeImage = " ).append(this.nodeImage);
        str.append("\n nodeUrl = " ).append(this.nodeUrl);
        
        
        
        
		return str.toString();
	} 
	
    /**
     * @return Returns the chidlNodeValue.
     */
    public String getChidlNodeValue() {
        return chidlNodeValue;
    }
    /**
     * @param chidlNodeValue The chidlNodeValue to set.
     */
    public void setChidlNodeValue(String chidlNodeValue) {
        this.chidlNodeValue = chidlNodeValue;
    }
}
