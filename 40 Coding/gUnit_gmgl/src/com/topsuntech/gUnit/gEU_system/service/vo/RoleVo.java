package com.topsuntech.gUnit.gEU_system.service.vo;

import java.util.Date;

public class RoleVo {
    private Long id;
    
    private String name;
    
    private String priority;
    
    private Date createDate;
    
    private String description;
    
    private Long deptId;

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the deptId
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("\n RoleVo[")
            .append("\n id=").append(this.id)
            .append("\n nam=").append(this.name)
            .append("\n priority=").append(this.priority);
        
        return buf.toString();
    }
    
    
    
}
