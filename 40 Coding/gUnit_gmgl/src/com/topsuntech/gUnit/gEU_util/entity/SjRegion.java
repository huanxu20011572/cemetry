/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SjRegion  implements Serializable{
	
    private Long id;
    
    private String name;
    
    private Long levelId;
    
    private Date createDate;
    
    private Long creatOrid;
    
    private Long parentId;
    
    private Long disporder;
    
    private String standardNo;
    
    private Long useFlag; 
   
//    private String regionCode;
    
//    private Integer orderByItem; 
    
    private String  shortName;
    
    
    
    public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
//	public String getRegionCode() {
//		return regionCode;
//	}
//	public void setRegionCode(String regionCode) {
//		this.regionCode = regionCode;
//	}
	/**
     * @return Returns the useFlag.
     */
    public Long getUseFlag() {
        return useFlag;
    }
    /**
     * @param useFlag The useFlag to set.
     */
    public void setUseFlag(Long useFlag) {
        this.useFlag = useFlag;
    }
    /**
     * @return Returns the createDate.
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * @param date The createDate to set.
     */
    public void setCreateDate(Date date) {
        this.createDate = date;
    }
    /**
     * @return Returns the creatOrid.
     */
    public Long getCreatOrid() {
        return creatOrid;
    }
    /**
     * @param creatOrid The creatOrid to set.
     */
    public void setCreatOrid(Long creatOrid) {
        this.creatOrid = creatOrid;
    }
    /**
     * @return Returns the disporder.
     */
    public Long getDisporder() {
        return disporder;
    }
    /**
     * @param disporder The disporder to set.
     */
    public void setDisporder(Long disporder) {
        this.disporder = disporder;
    }
    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return Returns the levelId.
     */
    public Long getLevelId() {
        return levelId;
    }
    /**
     * @param levelId The levelId to set.
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
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
    /**
     * @return Returns the standardNo.
     */
    public String getStandardNo() {
        return standardNo;
    }
    /**
     * @param standardNo The standardNo to set.
     */
    public void setStandardNo(String standardNo) {
        this.standardNo = standardNo;
    }
//	public Integer getOrderByItem() {
//		return orderByItem;
//	}
//	public void setOrderByItem(Integer orderByItem) {
//		this.orderByItem = orderByItem;
//	}
	
}
