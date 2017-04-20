package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "gosUserSeq", sequenceName = "GOS_USER_SEQ", allocationSize = 1)
@Table(name = "GOS_USER")
public class User implements Serializable{
	private Long id;
	private String loginid;
	private String password;
	private String name;
	private String gender;
	private Long deptid;
//	private String userCode;
	private String jiguan;
	private Date birthday;
	private String birthlocation;
	private String nation;
	private String xueli;
	private String xuewei;
	private String zhuanye;
	private String yuanxiao;
	private String zhengzhimianmao;
	private Date rudangshijian;
	private Date workyear;
	private String callname;
	private String positionid;
	private String identitynum;
	private String worknum;
	private String address;
	private String homephone;
	private String officephone;
	private String mobile;
	private String publicmoneynum;
	private String oldsupportnum;
	private String housepaynum;
	private String securitynum;
	private Date createdate;
	private Long creatorid;
	private String priority;
	private String memo;
	private Long deleted;
	private Date biyetime;
	private Date xzyear;
	private String retire;
	private Long registstatus;
	private String deletereason;
	private Long workdeptid;
	private Long type;
	private String canumber;
	private String emailid;
	private String systemRole;
//	private Long orderbyItem;
//	private Long sfzf;
//	private Long zfNumber;
	
	/**
	* @param id
	*/
	public void setId(Long id){
		this.id = id;
	}
	
	/**
	* @return the id
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gosUserSeq")
	public Long getId(){
		return id;
	}
	
	/**
	* @param loginid
	*/
	public void setLoginid(String loginid){
		this.loginid = loginid;
	}
	
	/**
	* @return the loginid
	*/
	@Column(name = "LOGINID", length = 100)
	public String getLoginid(){
		return loginid;
	}
	
	/**
	* @param password
	*/
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	* @return the password
	*/
	@Column(name = "PASSWORD", length = 200)
	public String getPassword(){
		return password;
	}
	
	/**
	* @param name
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* @return the name
	*/
	@Column(name = "NAME", length = 20)
	public String getName(){
		return name;
	}
	
	/**
	* @param gender
	*/
	public void setGender(String gender){
		this.gender = gender;
	}
	
	/**
	* @return the gender
	*/
	@Column(name = "GENDER", length = 10)
	public String getGender(){
		return gender;
	}
	
	/**
	* @param deptid
	*/
	public void setDeptid(Long deptid){
		this.deptid = deptid;
	}
	
	/**
	* @return the deptid
	*/
	@Column(name = "DEPTID", length = 25)
	public Long getDeptid(){
		return deptid;
	}
//	
//	/**
//	* @param userCode
//	*/
//	public void setUserCode(String userCode){
//		this.userCode = userCode;
//	}
//	
//	/**
//	* @return the userCode
//	*/
//	@Column(name = "USER_CODE", length = 50)
//	public String getUserCode(){
//		return userCode;
//	}
	
	/**
	* @param jiguan
	*/
	public void setJiguan(String jiguan){
		this.jiguan = jiguan;
	}
	
	/**
	* @return the jiguan
	*/
	@Column(name = "JIGUAN", length = 50)
	public String getJiguan(){
		return jiguan;
	}
	
	/**
	* @param birthday
	*/
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	/**
	* @return the birthday
	*/
	@Column(name = "BIRTHDAY", length = 0)
	public Date getBirthday(){
		return birthday;
	}
	
	/**
	* @param birthlocation
	*/
	public void setBirthlocation(String birthlocation){
		this.birthlocation = birthlocation;
	}
	
	/**
	* @return the birthlocation
	*/
	@Column(name = "BIRTHLOCATION", length = 200)
	public String getBirthlocation(){
		return birthlocation;
	}
	
	/**
	* @param nation
	*/
	public void setNation(String nation){
		this.nation = nation;
	}
	
	/**
	* @return the nation
	*/
	@Column(name = "NATION", length = 20)
	public String getNation(){
		return nation;
	}
	
	/**
	* @param xueli
	*/
	public void setXueli(String xueli){
		this.xueli = xueli;
	}
	
	/**
	* @return the xueli
	*/
	@Column(name = "XUELI", length = 50)
	public String getXueli(){
		return xueli;
	}
	
	/**
	* @param xuewei
	*/
	public void setXuewei(String xuewei){
		this.xuewei = xuewei;
	}
	
	/**
	* @return the xuewei
	*/
	@Column(name = "XUEWEI", length = 50)
	public String getXuewei(){
		return xuewei;
	}
	
	/**
	* @param zhuanye
	*/
	public void setZhuanye(String zhuanye){
		this.zhuanye = zhuanye;
	}
	
	/**
	* @return the zhuanye
	*/
	@Column(name = "ZHUANYE", length = 200)
	public String getZhuanye(){
		return zhuanye;
	}
	
	/**
	* @param yuanxiao
	*/
	public void setYuanxiao(String yuanxiao){
		this.yuanxiao = yuanxiao;
	}
	
	/**
	* @return the yuanxiao
	*/
	@Column(name = "YUANXIAO", length = 200)
	public String getYuanxiao(){
		return yuanxiao;
	}
	
	/**
	* @param zhengzhimianmao
	*/
	public void setZhengzhimianmao(String zhengzhimianmao){
		this.zhengzhimianmao = zhengzhimianmao;
	}
	
	/**
	* @return the zhengzhimianmao
	*/
	@Column(name = "ZHENGZHIMIANMAO", length = 20)
	public String getZhengzhimianmao(){
		return zhengzhimianmao;
	}
	
	/**
	* @param rudangshijian
	*/
	public void setRudangshijian(Date rudangshijian){
		this.rudangshijian = rudangshijian;
	}
	
	/**
	* @return the rudangshijian
	*/
	@Column(name = "RUDANGSHIJIAN", length = 0)
	public Date getRudangshijian(){
		return rudangshijian;
	}
	
	/**
	* @param workyear
	*/
	public void setWorkyear(Date workyear){
		this.workyear = workyear;
	}
	
	/**
	* @return the workyear
	*/
	@Column(name = "WORKYEAR", length = 0)
	public Date getWorkyear(){
		return workyear;
	}
	
	/**
	* @param callname
	*/
	public void setCallname(String callname){
		this.callname = callname;
	}
	
	/**
	* @return the callname
	*/
	@Column(name = "CALLNAME", length = 100)
	public String getCallname(){
		return callname;
	}
	
	/**
	* @param positionid
	*/
	public void setPositionid(String positionid){
		this.positionid = positionid;
	}
	
	/**
	* @return the positionid
	*/
	@Column(name = "POSITIONID", length = 100)
	public String getPositionid(){
		return positionid;
	}
	
	/**
	* @param identitynum
	*/
	public void setIdentitynum(String identitynum){
		this.identitynum = identitynum;
	}
	
	/**
	* @return the identitynum
	*/
	@Column(name = "IDENTITYNUM", length = 100)
	public String getIdentitynum(){
		return identitynum;
	}
	
	/**
	* @param worknum
	*/
	public void setWorknum(String worknum){
		this.worknum = worknum;
	}
	
	/**
	* @return the worknum
	*/
	@Column(name = "WORKNUM", length = 100)
	public String getWorknum(){
		return worknum;
	}
	
	/**
	* @param address
	*/
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	* @return the address
	*/
	@Column(name = "ADDRESS", length = 100)
	public String getAddress(){
		return address;
	}
	
	/**
	* @param homephone
	*/
	public void setHomephone(String homephone){
		this.homephone = homephone;
	}
	
	/**
	* @return the homephone
	*/
	@Column(name = "HOMEPHONE", length = 100)
	public String getHomephone(){
		return homephone;
	}
	
	/**
	* @param officephone
	*/
	public void setOfficephone(String officephone){
		this.officephone = officephone;
	}
	
	/**
	* @return the officephone
	*/
	@Column(name = "OFFICEPHONE", length = 100)
	public String getOfficephone(){
		return officephone;
	}
	
	/**
	* @param mobile
	*/
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	/**
	* @return the mobile
	*/
	@Column(name = "MOBILE", length = 100)
	public String getMobile(){
		return mobile;
	}
	
	/**
	* @param publicmoneynum
	*/
	public void setPublicmoneynum(String publicmoneynum){
		this.publicmoneynum = publicmoneynum;
	}
	
	/**
	* @return the publicmoneynum
	*/
	@Column(name = "PUBLICMONEYNUM", length = 100)
	public String getPublicmoneynum(){
		return publicmoneynum;
	}
	
	/**
	* @param oldsupportnum
	*/
	public void setOldsupportnum(String oldsupportnum){
		this.oldsupportnum = oldsupportnum;
	}
	
	/**
	* @return the oldsupportnum
	*/
	@Column(name = "OLDSUPPORTNUM", length = 100)
	public String getOldsupportnum(){
		return oldsupportnum;
	}
	
	/**
	* @param housepaynum
	*/
	public void setHousepaynum(String housepaynum){
		this.housepaynum = housepaynum;
	}
	
	/**
	* @return the housepaynum
	*/
	@Column(name = "HOUSEPAYNUM", length = 100)
	public String getHousepaynum(){
		return housepaynum;
	}
	
	/**
	* @param securitynum
	*/
	public void setSecuritynum(String securitynum){
		this.securitynum = securitynum;
	}
	
	/**
	* @return the securitynum
	*/
	@Column(name = "SECURITYNUM", length = 100)
	public String getSecuritynum(){
		return securitynum;
	}
	
	/**
	* @param createdate
	*/
	public void setCreatedate(Date createdate){
		this.createdate = createdate;
	}
	
	/**
	* @return the createdate
	*/
	@Column(name = "CREATEDATE", length = 0)
	public Date getCreatedate(){
		return createdate;
	}
	
	/**
	* @param creatorid
	*/
	public void setCreatorid(Long creatorid){
		this.creatorid = creatorid;
	}
	
	/**
	* @return the creatorid
	*/
	@Column(name = "CREATORID", length = 25)
	public Long getCreatorid(){
		return creatorid;
	}
	
	/**
	* @param priority
	*/
	public void setPriority(String priority){
		this.priority = priority;
	}
	
	/**
	* @return the priority
	*/
	@Column(name = "PRIORITY", length = 4000)
	public String getPriority(){
		return priority;
	}
	
	/**
	* @param memo
	*/
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	/**
	* @return the memo
	*/
	@Column(name = "MEMO", length = 500)
	public String getMemo(){
		return memo;
	}
	
	/**
	* @param deleted
	*/
	public void setDeleted(Long deleted){
		this.deleted = deleted;
	}
	
	/**
	* @return the deleted
	*/
	@Column(name = "DELETED", length = 1)
	public Long getDeleted(){
		return deleted;
	}
	
	/**
	* @param biyetime
	*/
	public void setBiyetime(Date biyetime){
		this.biyetime = biyetime;
	}
	
	/**
	* @return the biyetime
	*/
	@Column(name = "BIYETIME", length = 0)
	public Date getBiyetime(){
		return biyetime;
	}
	
	/**
	* @param xzyear
	*/
	public void setXzyear(Date xzyear){
		this.xzyear = xzyear;
	}
	
	/**
	* @return the xzyear
	*/
	@Column(name = "XZYEAR", length = 0)
	public Date getXzyear(){
		return xzyear;
	}
	
	/**
	* @param retire
	*/
	public void setRetire(String retire){
		this.retire = retire;
	}
	
	/**
	* @return the retire
	*/
	@Column(name = "RETIRE", length = 10)
	public String getRetire(){
		return retire;
	}
	
	/**
	* @param registstatus
	*/
	public void setRegiststatus(Long registstatus){
		this.registstatus = registstatus;
	}
	
	/**
	* @return the registstatus
	*/
	@Column(name = "REGISTSTATUS", length = 2)
	public Long getRegiststatus(){
		return registstatus;
	}
	
	/**
	* @param deletereason
	*/
	public void setDeletereason(String deletereason){
		this.deletereason = deletereason;
	}
	
	/**
	* @return the deletereason
	*/
	@Column(name = "DELETEREASON", length = 100)
	public String getDeletereason(){
		return deletereason;
	}
	
	/**
	* @param workdeptid
	*/
	public void setWorkdeptid(Long workdeptid){
		this.workdeptid = workdeptid;
	}
	
	/**
	* @return the workdeptid
	*/
	@Column(name = "WORKDEPTID", length = 25)
	public Long getWorkdeptid(){
		return workdeptid;
	}
	
	/**
	* @param type
	*/
	public void setType(Long type){
		this.type = type;
	}
	
	/**
	* @return the type
	*/
	@Column(name = "TYPE", length = 2)
	public Long getType(){
		return type;
	}
	
	/**
	* @param canumber
	*/
	public void setCanumber(String canumber){
		this.canumber = canumber;
	}
	
	/**
	* @return the canumber
	*/
	@Column(name = "CANUMBER", length = 100)
	public String getCanumber(){
		return canumber;
	}
	
	/**
	* @param emailid
	*/
	public void setEmailid(String emailid){
		this.emailid = emailid;
	}
	
	/**
	* @return the emailid
	*/
	@Column(name = "EMAILID", length = 50)
	public String getEmailid(){
		return emailid;
	}
	
	/**
	* @param systemRole
	*/
	public void setSystemRole(String systemRole){
		this.systemRole = systemRole;
	}
	
	/**
	* @return the systemRole
	*/
	@Column(name = "SYSTEM_ROLE", length = 4000)
	public String getSystemRole(){
		return systemRole;
	}
//	
//	/**
//	* @param orderbyItem
//	*/
//	public void setOrderbyItem(Long orderbyItem){
//		this.orderbyItem = orderbyItem;
//	}
//	
//	/**
//	* @return the orderbyItem
//	*/
//	@Column(name = "ORDERBY_ITEM", length = 10)
//	public Long getOrderbyItem(){
//		return orderbyItem;
//	}
//	
//	/**
//	* @param sfzf
//	*/
//	public void setSfzf(Long sfzf){
//		this.sfzf = sfzf;
//	}
//	
//	/**
//	* @return the sfzf
//	*/
//	@Column(name = "SFZF", length = 10)
//	public Long getSfzf(){
//		return sfzf;
//	}
//	
//	/**
//	* @param zfNumber
//	*/
//	public void setZfNumber(Long zfNumber){
//		this.zfNumber = zfNumber;
//	}
//	
//	/**
//	* @return the zfNumber
//	*/
//	@Column(name = "ZF_NUMBER", length = 32)
//	public Long getZfNumber(){
//		return zfNumber;
//	}
}