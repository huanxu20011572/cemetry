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
public class DictBean implements Serializable {
    private String value;
    private String key; 
    private Long  correspondenValue;
    
	public DictBean(String key, String value, Long correspondenValue) { 
		this.key = key; 
		this.value = value;
		this.correspondenValue = correspondenValue;
	}
	
	public DictBean(String key, String value) { 
		this.key = key; 
		this.value = value;
	}
	
	public String getKey() { 
		return this.key; 
	} 
	
	public void setKey(String key) { 
		this.key = key; 
	}
	
	public String getValue() { 
		return this.value; 
	} 
	
	public void setValue(String value) { 
		this.value = value; 
	}
	
	public String toString() { 
		return (this.value);
	}	
	
	public Long getCorrespondenValue() {
		return correspondenValue;
	}
	public void setCorrespondenValue(Long correspondenValue) {
		this.correspondenValue = correspondenValue;
	}
}
