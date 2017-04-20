/*
 * Created on 2006-1-13
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Lixirong
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ListBean implements Serializable { 
    
	public ListBean(int key, String value) { 
		this.key = key; 
		this.value = value;
	} 
	
	public ListBean(int key, String value, long lockStatus) { 
		this.key = key; 
		this.value = value;
		this.lockStatus = lockStatus;
	} 
	
	public ListBean(int key, String value, List childs) { 
		this.key = key; 
		this.value = value;
		this.childs = childs;
	} 	
	
	
	public ListBean(int key, String value, Object obj, long flag) { 
		this.key = key; 
		this.value = value;
		this.obj = obj;
		this.flag = flag;
	} 	
	

	public ListBean(int key, String value, int parentId,Object obj) { 
		this.key = key; 
		this.value = value;
		this.parentId = parentId;
		this.obj = obj;		
	} 	
	
	static final long serialVersionUID=11;
	
	private int key; 	
	
	private String value; 
	
	private long lockStatus;
	
	private List childs = new ArrayList();
	
	private Object obj;
	
	private long flag ;
	
	private long parentId;
	
	
	
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
	public int getKey() { 
		return this.key; 
	} 	
	public void setKey(int key) { 
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
               
		return (this.value );
	} 
	
}
