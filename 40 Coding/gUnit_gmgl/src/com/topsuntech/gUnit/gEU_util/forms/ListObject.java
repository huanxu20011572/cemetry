/*
 * Created on 2006-1-13
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
public class ListObject implements Serializable { 
    
	public ListObject(long key, double total, Object o) { 
		this.key = key; 
		this.total = total;
		this.o = o;
	} 
	
	static final long serialVersionUID=11;
	
	private long key; 
	
	private double total;
	
	private Object o;
	

    public long getKey() {
        return key;
    }
    public void setKey(long key) {
        this.key = key;
    }
    public Object getO() {
        return o;
    }
    public void setO(Object o) {
        this.o = o;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
	public String toString() { 
		return (this.o.toString());
	} 
	
}
