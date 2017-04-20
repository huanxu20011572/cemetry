/*
 * Created on 2006-1-14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.forms;

import java.io.Serializable;

/**
 * @author Lixirong
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeBean implements Serializable {
    
	public TreeBean(long key, String value,long parentid ,String num) { 
		this.key = key; 
		this.value = value;
		this.parentid = parentid;
		this.num  = num;
	} 
	
	static final long serialVersionUID=10000;
	
	private long key; 
	private String value;
	private long parentid;
	private String num;
	
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
    public long getParentid() {
        return parentid;
    }
    public void setParentid(long parentid) {
        this.parentid = parentid;
    }
    
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
	public String toString() { 
        StringBuffer str = new StringBuffer();
        str.append("\n key = " ).append(this.key);
        str.append("\n value = " ).append(this.value);
        str.append("\n parentid = " ).append(this.parentid);
        str.append("\n num = " ).append(this.num);
        
		return str.toString();
	} 
	
}
