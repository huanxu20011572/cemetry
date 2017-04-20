package com.topsuntech.gUnit.gEU_system.framework.actionforms;

import org.apache.struts.action.ActionForm;

public class SjUserForm extends ActionForm {
    
    private Long id;

    private String name;

    private String loginId;
    
    private Long deptId;
    
    private Long workDeptId;
    
    private String deleteReason;
    
    private String systemRole;
    
    private String priority;
    
    private String emailid;
    
    private String quId;
    
    private String streetId;
    
    
   
    private String loginid;
    private String password;
    private String gender;
 
    private long workdeptid;
    private long parentid;
    private String num;
    private String jiguan;
  
    private String birthday;
    private String birthlocation;
    private String xueli;
    private String xuewei;
    private String yuanxiao;
    private String zhuanye;
    private String zhengzhimianmao;
    private String oldpwd;
    private String newpwd;
    private String nation;
    private String learndegree;
    private String workyear;
    private String callname;
    private String positionid;
    private String identitynum;
    private String worknum;
    private String address;
    private String homephone;
    private String rudangshijian;
    private String officephone;
    private String mobile;
    private String publicmoneynum;
    private String oldsupportnum;
    private String housepaynum;
    private String securitynum;
    private long creatorid;
    private String prioritys;
    private String memo;
    private String dept;
    private String creatorname;
    private Integer type;   
    private String canumber;
    private boolean cansms;



	/**
     * @return the emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * @param emailid the emailid to set
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getWorkdeptid() {
		return workdeptid;
	}

	public void setWorkdeptid(long workdeptid) {
		this.workdeptid = workdeptid;
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

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthlocation() {
		return birthlocation;
	}

	public void setBirthlocation(String birthlocation) {
		this.birthlocation = birthlocation;
	}

	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getXuewei() {
		return xuewei;
	}

	public void setXuewei(String xuewei) {
		this.xuewei = xuewei;
	}

	public String getYuanxiao() {
		return yuanxiao;
	}

	public void setYuanxiao(String yuanxiao) {
		this.yuanxiao = yuanxiao;
	}

	public String getZhuanye() {
		return zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	public String getZhengzhimianmao() {
		return zhengzhimianmao;
	}

	public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLearndegree() {
		return learndegree;
	}

	public void setLearndegree(String learndegree) {
		this.learndegree = learndegree;
	}

	public String getWorkyear() {
		return workyear;
	}

	public void setWorkyear(String workyear) {
		this.workyear = workyear;
	}

	public String getCallname() {
		return callname;
	}

	public void setCallname(String callname) {
		this.callname = callname;
	}

	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public String getIdentitynum() {
		return identitynum;
	}

	public void setIdentitynum(String identitynum) {
		this.identitynum = identitynum;
	}

	public String getWorknum() {
		return worknum;
	}

	public void setWorknum(String worknum) {
		this.worknum = worknum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getRudangshijian() {
		return rudangshijian;
	}

	public void setRudangshijian(String rudangshijian) {
		this.rudangshijian = rudangshijian;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPublicmoneynum() {
		return publicmoneynum;
	}

	public void setPublicmoneynum(String publicmoneynum) {
		this.publicmoneynum = publicmoneynum;
	}

	public String getOldsupportnum() {
		return oldsupportnum;
	}

	public void setOldsupportnum(String oldsupportnum) {
		this.oldsupportnum = oldsupportnum;
	}

	public String getHousepaynum() {
		return housepaynum;
	}

	public void setHousepaynum(String housepaynum) {
		this.housepaynum = housepaynum;
	}

	public String getSecuritynum() {
		return securitynum;
	}

	public void setSecuritynum(String securitynum) {
		this.securitynum = securitynum;
	}

	public long getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(long creatorid) {
		this.creatorid = creatorid;
	}

	public String getPrioritys() {
		return prioritys;
	}

	public void setPrioritys(String prioritys) {
		this.prioritys = prioritys;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCanumber() {
		return canumber;
	}

	public void setCanumber(String canumber) {
		this.canumber = canumber;
	}

	public boolean isCansms() {
		return cansms;
	}

	public void setCansms(boolean cansms) {
		this.cansms = cansms;
	}
    
    
    

}
