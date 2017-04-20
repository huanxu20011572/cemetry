/*
 * Created on 2007-1-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class UserInfo implements Serializable{
    /**
     * identifier field
     */
	private Long id;
    /**
     * 注册id
     */
	private String loginId;
    /**
     * 用户密码
     */
	private String password;
    /**
     * 用户名字
     */
	private String name;
    /**
     * 用户性别
     */
	private String gender;
    /**
     * 用户部门id
     */
	private Long deptId;
    /**
     * 
     */
	private String num;
    /**
     * 用户籍贯
     */
	private String jiguan;
    /**
     * 用户的出生年月
     */
	private Date birthDay;
    /**
     * 用户的出生地
     */
	private String birthLocation;
    /**
     * 用户所属的民族
     */
	private String nation;
    /**
     * 用户的学历
     */
	private String xueli;
    /**
     * 用户的学位
     */
	private String xuewei;
    /**
     * 用户所学的专业
     */
	private String zhuanye;
    /**
     * 用户毕业院校
     */
	private String yuanxiao;
    /**
     * 用户政治面貌
     */
	private String zhengZhiMianMao;
    /**
     * 用户入党时间
     */
	private Date ruDangShiJian;
    /**
     * 用户参加工作的时间
     */
	private Date workYear;
    /**
     * 
     */
	private String callName;
    /**
     * 用户职位id
     */
	private String positionId;
    /**
     * 用户的身份证号码 
     */
	private String identityNum;
    /**
     * 
     */
	private String workNum;
    /**
     * 家庭住址 
     */
	private String address;
    /**
     * 家庭电话 
     */
	private String homePhone;
    /**
     * 办公室电话 
     */
	private String officePhone;
    /**
     * 移动电话  
     */
	private String mobile;
    /**
     * 公积金号 
     */
	private String publicMoneyNum;
    /**
     * 养老金
     */
	private String oldSupportNum;
    /**
     * 住房补贴 
     */
	private String housePayNum;
    /**
     * 医疗保险 
     */
	private String securityNum;
    /**
     * 创建时间 
     */
	private Date createDate;
    /**
     * 
     */
	private Long creatorId;
    /**
     * 优先级 
     */
	private String priority;

	private String memo;

	private Long deleted;

	private Date biyeTime;

	private Date xzyear;

	private String retire;

	private Long registStatus;

	private String deleteReason;

	private Long workDeptId;

	private Long type;

	private String emailId;

	private Long cansms;

	private String canumber;

	private Long sedDeptId;
	
	private Long roleId;
	

	
    public Long getRole() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return Returns the birthDay.
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay
	 *            The birthDay to set.
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return Returns the birthLocation.
	 */
	public String getBirthLocation() {
		return birthLocation;
	}

	/**
	 * @param birthLocation
	 *            The birthLocation to set.
	 */
	public void setBirthLocation(String birthLocation) {
		this.birthLocation = birthLocation;
	}

	/**
	 * @return Returns the biyeTime.
	 */
	public Date getBiyeTime() {
		return biyeTime;
	}

	/**
	 * @param biyeTime
	 *            The biyeTime to set.
	 */
	public void setBiyeTime(Date biyeTime) {
		this.biyeTime = biyeTime;
	}

	/**
	 * @return Returns the callName.
	 */
	public String getCallName() {
		return callName;
	}

	/**
	 * @param callName
	 *            The callName to set.
	 */
	public void setCallName(String callName) {
		this.callName = callName;
	}

	/**
	 * @return Returns the cansms.
	 */
	public Long getCansms() {
		return cansms;
	}

	/**
	 * @param cansms
	 *            The cansms to set.
	 */
	public void setCansms(Long cansms) {
		this.cansms = cansms;
	}

	/**
	 * @return Returns the canumber.
	 */
	public String getCanumber() {
		return canumber;
	}

	/**
	 * @param canumber
	 *            The canumber to set.
	 */
	public void setCanumber(String canumber) {
		this.canumber = canumber;
	}

	/**
	 * @return Returns the createDate.
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            The createDate to set.
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return Returns the creatorId.
	 */
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId
	 *            The creatorId to set.
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * @return Returns the deleted.
	 */
	public Long getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            The deleted to set.
	 */
	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return Returns the deleteReason.
	 */
	public String getDeleteReason() {
		return deleteReason;
	}

	/**
	 * @param deleteReason
	 *            The deleteReason to set.
	 */
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	/**
	 * @return Returns the deptId.
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 *            The deptId to set.
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return Returns the emailId.
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            The emailId to set.
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return Returns the gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return Returns the homePhone.
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            The homePhone to set.
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return Returns the housePayNum.
	 */
	public String getHousePayNum() {
		return housePayNum;
	}

	/**
	 * @param housePayNum
	 *            The housePayNum to set.
	 */
	public void setHousePayNum(String housePayNum) {
		this.housePayNum = housePayNum;
	}

	/**
	 * @return Returns the identityNum.
	 */
	public String getIdentityNum() {
		return identityNum;
	}

	/**
	 * @param identityNum
	 *            The identityNum to set.
	 */
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	/**
	 * @return Returns the jiguan.
	 */
	public String getJiguan() {
		return jiguan;
	}

	/**
	 * @param jiguan
	 *            The jiguan to set.
	 */
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	/**
	 * @return Returns the loginId.
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            The loginId to set.
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return Returns the memo.
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return Returns the mobile.
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            The mobile to set.
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the nation.
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation
	 *            The nation to set.
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return Returns the num.
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num
	 *            The num to set.
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return Returns the officePhone.
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @param officePhone
	 *            The officePhone to set.
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * @return Returns the oldSupportNum.
	 */
	public String getOldSupportNum() {
		return oldSupportNum;
	}

	/**
	 * @param oldSupportNum
	 *            The oldSupportNum to set.
	 */
	public void setOldSupportNum(String oldSupportNum) {
		this.oldSupportNum = oldSupportNum;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the positionId.
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId
	 *            The positionId to set.
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return Returns the priority.
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            The priority to set.
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return Returns the publicMoneyNum.
	 */
	public String getPublicMoneyNum() {
		return publicMoneyNum;
	}

	/**
	 * @param publicMoneyNum
	 *            The publicMoneyNum to set.
	 */
	public void setPublicMoneyNum(String publicMoneyNum) {
		this.publicMoneyNum = publicMoneyNum;
	}

	/**
	 * @return Returns the registStatus.
	 */
	public Long getRegistStatus() {
		return registStatus;
	}

	/**
	 * @param registStatus
	 *            The registStatus to set.
	 */
	public void setRegistStatus(Long registStatus) {
		this.registStatus = registStatus;
	}

	/**
	 * @return Returns the retire.
	 */
	public String getRetire() {
		return retire;
	}

	/**
	 * @param retire
	 *            The retire to set.
	 */
	public void setRetire(String retire) {
		this.retire = retire;
	}

	/**
	 * @return Returns the ruDangShiJian.
	 */
	public Date getRuDangShiJian() {
		return ruDangShiJian;
	}

	/**
	 * @param ruDangShiJian
	 *            The ruDangShiJian to set.
	 */
	public void setRuDangShiJian(Date ruDangShiJian) {
		this.ruDangShiJian = ruDangShiJian;
	}

	/**
	 * @return Returns the securityNum.
	 */
	public String getSecurityNum() {
		return securityNum;
	}

	/**
	 * @param securityNum
	 *            The securityNum to set.
	 */
	public void setSecurityNum(String securityNum) {
		this.securityNum = securityNum;
	}

	/**
	 * @return Returns the sedDeptId.
	 */
	public Long getSedDeptId() {
		return sedDeptId;
	}

	/**
	 * @param sedDeptId
	 *            The sedDeptId to set.
	 */
	public void setSedDeptId(Long sedDeptId) {
		this.sedDeptId = sedDeptId;
	}

	/**
	 * @return Returns the type.
	 */
	public Long getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set.
	 */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	 * @return Returns the workDeptId.
	 */
	public Long getWorkDeptId() {
		return workDeptId;
	}

	/**
	 * @param workDeptId
	 *            The workDeptId to set.
	 */
	public void setWorkDeptId(Long workDeptId) {
		this.workDeptId = workDeptId;
	}

	/**
	 * @return Returns the workNum.
	 */
	public String getWorkNum() {
		return workNum;
	}

	/**
	 * @param workNum
	 *            The workNum to set.
	 */
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	/**
	 * @return Returns the workYear.
	 */
	public Date getWorkYear() {
		return workYear;
	}

	/**
	 * @param workYear
	 *            The workYear to set.
	 */
	public void setWorkYear(Date workYear) {
		this.workYear = workYear;
	}

	/**
	 * @return Returns the xueli.
	 */
	public String getXueli() {
		return xueli;
	}

	/**
	 * @param xueli
	 *            The xueli to set.
	 */
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	/**
	 * @return Returns the xuewei.
	 */
	public String getXuewei() {
		return xuewei;
	}

	/**
	 * @param xuewei
	 *            The xuewei to set.
	 */
	public void setXuewei(String xuewei) {
		this.xuewei = xuewei;
	}

	/**
	 * @return Returns the xzyear.
	 */
	public Date getXzyear() {
		return xzyear;
	}

	/**
	 * @param xzyear
	 *            The xzyear to set.
	 */
	public void setXzyear(Date xzyear) {
		this.xzyear = xzyear;
	}

	/**
	 * @return Returns the yuanxiao.
	 */
	public String getYuanxiao() {
		return yuanxiao;
	}

	/**
	 * @param yuanxiao
	 *            The yuanxiao to set.
	 */
	public void setYuanxiao(String yuanxiao) {
		this.yuanxiao = yuanxiao;
	}

	/**
	 * @return Returns the zhengZhiMianMao.
	 */
	public String getZhengZhiMianMao() {
		return zhengZhiMianMao;
	}

	/**
	 * @param zhengZhiMianMao
	 *            The zhengZhiMianMao to set.
	 */
	public void setZhengZhiMianMao(String zhengZhiMianMao) {
		this.zhengZhiMianMao = zhengZhiMianMao;
	}

	/**
	 * @return Returns the zhuanye.
	 */
	public String getZhuanye() {
		return zhuanye;
	}

	/**
	 * @param zhuanye
	 *            The zhuanye to set.
	 */
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		StringBuffer toStr = new StringBuffer();
		toStr.append("[UserInfo] = [\n");
		toStr.append("    id = " + this.id + ";\n");
		toStr.append("    loginId = " + this.loginId + ";\n");
		toStr.append("    password = " + this.password + ";\n");
		toStr.append("    name = " + this.name + ";\n");
		toStr.append("    gender = " + this.gender + ";\n");
		toStr.append("    deptId = " + this.deptId + ";\n");
		toStr.append("    num = " + this.num + ";\n");
		toStr.append("    jiguan = " + this.jiguan + ";\n");
		toStr.append("    birthDay = " + this.birthDay + ";\n");
		toStr.append("    birthLocation = " + this.birthLocation + ";\n");
		toStr.append("    nation = " + this.nation + ";\n");
		toStr.append("    xueli = " + this.xueli + ";\n");
		toStr.append("    xuewei = " + this.xuewei + ";\n");
		toStr.append("    zhuanye = " + this.zhuanye + ";\n");
		toStr.append("    yuanxiao = " + this.yuanxiao + ";\n");
		toStr.append("    zhengZhiMianMao = " + this.zhengZhiMianMao + ";\n");
		toStr.append("    ruDangShiJian = " + this.ruDangShiJian + ";\n");
		toStr.append("    workYear = " + this.workYear + ";\n");
		toStr.append("    callName = " + this.callName + ";\n");
		toStr.append("    positionId = " + this.positionId + ";\n");
		toStr.append("    identityNum = " + this.identityNum + ";\n");
		toStr.append("    workNum = " + this.workNum + ";\n");
		toStr.append("    address = " + this.address + ";\n");
		toStr.append("    homePhone = " + this.homePhone + ";\n");
		toStr.append("    officePhone = " + this.officePhone + ";\n");
		toStr.append("    mobile = " + this.mobile + ";\n");
		toStr.append("    publicMoneyNum = " + this.publicMoneyNum + ";\n");
		toStr.append("    oldSupportNum = " + this.oldSupportNum + ";\n");
		toStr.append("    housePayNum = " + this.housePayNum + ";\n");
		toStr.append("    securityNum = " + this.securityNum + ";\n");
		toStr.append("    createDate = " + this.createDate + ";\n");
		toStr.append("    creatorId = " + this.creatorId + ";\n");
		toStr.append("    priority = " + this.priority + ";\n");
		toStr.append("    memo = " + this.memo + ";\n");
		toStr.append("    deleted = " + this.deleted + ";\n");
		toStr.append("    biyeTime = " + this.biyeTime + ";\n");
		toStr.append("    xzyear = " + this.xzyear + ";\n");
		toStr.append("    retire = " + this.retire + ";\n");
		toStr.append("    registStatus = " + this.registStatus + ";\n");
		toStr.append("    deleteReason = " + this.deleteReason + ";\n");
		toStr.append("    workDeptId = " + this.workDeptId + ";\n");
		toStr.append("    type = " + this.type + ";\n");
		toStr.append("    emailId = " + this.emailId + ";\n");
		toStr.append("    cansms = " + this.cansms + ";\n");
		toStr.append("    canumber = " + this.canumber + ";\n");
		toStr.append("    sedDeptId = " + this.sedDeptId + ";\n");
		toStr.append("    roleId = " + this.roleId + ";\n");		
		toStr.append("    ];\n");
		return toStr.toString();
	}

    public Long getRoleId() {
        return roleId;
    }
}