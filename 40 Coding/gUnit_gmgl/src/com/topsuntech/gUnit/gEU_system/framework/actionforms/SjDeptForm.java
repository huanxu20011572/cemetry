/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.framework.actionforms;

import org.apache.struts.action.ActionForm;

/**
 * @author lixirong
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SjDeptForm extends ActionForm{
    private Long id;
    
    private String name;
    //行政级别        1 市局单位，2区县，3，街乡 4，社区 农村
    private Long levelId;
        
    private Long creatOrid;
    
    private Long parentId;
    
    private Long disporder;
    
    private Long regionId;
    
    private String approveUnitCode;
    
    private Long useFlag; 
    
    private Long lowFlag;
    
    private Long treeNode;

    //单位类型       1 安监局、2 煤监局 3 其它安委会成员单位
    private Long dwlx;
    //成员单位名称编码
    private String cybm;
   //单位行政区划代码
    private String dwdm;
    //本级/内设机构 1 本级 2 内设机构
    private Long jgmx;  
    
   private Integer orderByItem; 
    
    private Boolean isRegion;
    
	public Long getDwlx() {
		return dwlx;
	}
	public void setDwlx(Long dwlx) {
		this.dwlx = dwlx;
	}
	public String getCybm() {
		return cybm;
	}
	public void setCybm(String cybm) {
		this.cybm = cybm;
	}
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	
	public Long getJgmx() {
		return jgmx;
	}
	public void setJgmx(Long jgmx) {
		this.jgmx = jgmx;
	}
	/**
     * @return the treeNode
     */
    public Long getTreeNode() {
        return treeNode;
    }
    /**
     * @param treeNode the treeNode to set
     */
    public void setTreeNode(Long treeNode) {
        this.treeNode = treeNode;
    }
    /**
     * @return Returns the lowFlag.
     */
    public Long getLowFlag() {
        return lowFlag;
    }
    /**
     * @param lowFlag The lowFlag to set.
     */
    public void setLowFlag(Long lowFlag) {
        this.lowFlag = lowFlag;
    }
    /**
     * @return Returns the approveUnitCode.
     */
    public String getApproveUnitCode() {
        return approveUnitCode;
    }
    /**
     * @param approveUnitCode The approveUnitCode to set.
     */
    public void setApproveUnitCode(String approveUnitCode) {
        this.approveUnitCode = approveUnitCode;
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
     * @return Returns the regionId.
     */
    public Long getRegionId() {
        return regionId;
    }
    /**
     * @param regionId The regionId to set.
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
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
	public Boolean getIsRegion() {
		return isRegion;
	}
	public void setIsRegion(Boolean isRegion) {
		this.isRegion = isRegion;
	}
	public Integer getOrderByItem() {
		return orderByItem;
	}
	public void setOrderByItem(Integer orderByItem) {
		this.orderByItem = orderByItem;
	}
}
