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
public class MatterBean implements Serializable {
    
	public MatterBean(long id, String numValue,String unitId) { 
		this.id = id; 
		this.numValue = numValue;
		this.unitId  = unitId;	
	} 
	
	static final long serialVersionUID=100000;
	
	private long id;
	private String numValue;
	private String unitId;
	
	
	
	
	
    /**
     * @return Returns the id.
     */
    public long getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return Returns the numValue.
     */
    public String getNumValue() {
        return numValue;
    }
    /**
     * @param numValue The numValue to set.
     */
    public void setNumValue(String numValue) {
        this.numValue = numValue;
    }
    /**
     * @return Returns the unitId.
     */
    public String getUnitId() {
        return unitId;
    }
    /**
     * @param unitId The unitId to set.
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    
    public String toString(){
        return Long.toString(this.id);
    }
    
    
}
