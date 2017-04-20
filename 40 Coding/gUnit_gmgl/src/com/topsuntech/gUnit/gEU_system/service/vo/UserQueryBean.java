package com.topsuntech.gUnit.gEU_system.service.vo;

public class UserQueryBean {
   
    private Long id;
    
    private String name;
    
    private String loginId;
    
    private Long deptId;
    
    private Long workDeptId;
    
    private String deleteReason;
    
    private String systemRole;
    
    private String priority;
    
    private String quId;
    
    private String streetId;
    
    private String regoin;
    
    private String roleId;
    
    private String quanxianid;
    
    private Long traingId;
    
 // 是否执法人员 1是 其它不是
	private Integer sfzf;
    
	public Integer getSfzf() {
		return sfzf;
	}

	public void setSfzf(Integer sfzf) {
		this.sfzf = sfzf;
	}

	public String getQuanxianid() {
		return quanxianid;
	}

	public void setQuanxianid(String quanxianid) {
		this.quanxianid = quanxianid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRegoin() {
		return regoin;
	}

	public void setRegoin(String regoin) {
		this.regoin = regoin;
	}

	public String getQuId() {
		return quId;
	}

	public void setQuId(String quId) {
		this.quId = quId;
	}

	public String getStreetId() {
		return streetId;
	}

	public void setStreetId(String streetId) {
		this.streetId = streetId;
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

    /**
     * @return the systemRole
     */
    public String getSystemRole() {
        return systemRole;
    }

    /**
     * @param systemRole the systemRole to set
     */
    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }

    /**
     * @return the deleteReason
     */
    public String getDeleteReason() {
        return deleteReason;
    }

    /**
     * @param deleteReason the deleteReason to set
     */
    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
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
     * @return the workDeptId
     */
    public Long getWorkDeptId() {
        return workDeptId;
    }

    /**
     * @param workDeptId the workDeptId to set
     */
    public void setWorkDeptId(Long workDeptId) {
        this.workDeptId = workDeptId;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
     
    
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("\n UerQueryBean [")
           .append("\n loginId= " ).append(loginId)
           .append("\n name=").append(name);
        
        return buf.toString();
    }

	public Long getTraingId() {
		return traingId;
	}

	public void setTraingId(Long traingId) {
		this.traingId = traingId;
	}
    
}
