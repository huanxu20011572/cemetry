/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.service.vo;

/**
 * @author Ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RegionInfoVo {
    private Long id;
    
    private String name;
    
    private Long levelid;
    
    private String createdateStr;
    
    private Long creatorid;
    
    private Long parentId;
    
    private Long disporder;
    
    private String standard_no;
    
  
    
    /**
     * @return Returns the createdateStr.
     */
    public String getCreatedateStr() {
        return createdateStr;
    }
    /**
     * @param createdateStr The createdateStr to set.
     */
    public void setCreatedateStr(String createdateStr) {
        this.createdateStr = createdateStr;
    }
    /**
     * @return Returns the creatorid.
     */
    public Long getCreatorid() {
        return creatorid;
    }
    /**
     * @param creatorid The creatorid to set.
     */
    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
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
     * @return Returns the levelid.
     */
    public Long getLevelid() {
        return levelid;
    }
    /**
     * @param levelid The levelid to set.
     */
    public void setLevelid(Long levelid) {
        this.levelid = levelid;
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
     * @return Returns the standard_no.
     */
    public String getStandard_no() {
        return standard_no;
    }
    /**
     * @param standard_no The standard_no to set.
     */
    public void setStandard_no(String standard_no) {
        this.standard_no = standard_no;
    }
}
