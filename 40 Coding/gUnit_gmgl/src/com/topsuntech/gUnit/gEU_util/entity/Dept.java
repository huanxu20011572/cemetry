package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOS_DEPT")
public class Dept implements Serializable{
	private Long id;
//	private String deptCode;
	private String name;
	private String cat;
	private Long levelid;
	private Date createdate;
	private Long creatorid;
	private String description;
	private Long bzsm;
	private Long syrs;
	private Long faren;
	private String bzxs;
	private Long ldzzs;
	private Long ldfzs;
	private String jfxs;
	private String shortname;
	private String frzhengshu;
	private String officephone;
	private String officecode;
	private String officeaddr;
	private String officeduty;
	private Long regionid;
	private String disporder;
	private String officetime;
	private String traffictype;
	private String officemail;
	private Long parentId;
	private Long roleLev;
	private Long useFlag;
	private String contactPerson;
	private String email;
	private String header;
	private Long treeNode;
//	private Long dwlx;
//	private String cybm;
//	private String dwdm;
//	private Long jgmx;
	private String jgHyfl;
	private String jgHyflxl;
//	private Long orderbyItem;
//	private Long isRegion;
	private Long sfqy;
	private Long tsjbIssendinfo;
	private Long tsjbSendtel;
	
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
	public Long getId(){
		return id;
	}
//	
//	/**
//	* @param deptCode
//	*/
//	public void setDeptCode(String deptCode){
//		this.deptCode = deptCode;
//	}
//	
//	/**
//	* @return the deptCode
//	*/
//	@Column(name = "DEPT_CODE", length = 50)
//	public String getDeptCode(){
//		return deptCode;
//	}
	
	/**
	* @param name
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* @return the name
	*/
	@Column(name = "NAME", length = 100)
	public String getName(){
		return name;
	}
	
	/**
	* @param cat
	*/
	public void setCat(String cat){
		this.cat = cat;
	}
	
	/**
	* @return the cat
	*/
	@Column(name = "CAT", length = 50)
	public String getCat(){
		return cat;
	}
	
	/**
	* @param levelid
	*/
	public void setLevelid(Long levelid){
		this.levelid = levelid;
	}
	
	/**
	* @return the levelid
	*/
	@Column(name = "LEVELID", length = 25)
	public Long getLevelid(){
		return levelid;
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
	* @param description
	*/
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	* @return the description
	*/
	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription(){
		return description;
	}
	
	/**
	* @param bzsm
	*/
	public void setBzsm(Long bzsm){
		this.bzsm = bzsm;
	}
	
	/**
	* @return the bzsm
	*/
	@Column(name = "BZSM", length = 10)
	public Long getBzsm(){
		return bzsm;
	}
	
	/**
	* @param syrs
	*/
	public void setSyrs(Long syrs){
		this.syrs = syrs;
	}
	
	/**
	* @return the syrs
	*/
	@Column(name = "SYRS", length = 10)
	public Long getSyrs(){
		return syrs;
	}
	
	/**
	* @param faren
	*/
	public void setFaren(Long faren){
		this.faren = faren;
	}
	
	/**
	* @return the faren
	*/
	@Column(name = "FAREN", length = 25)
	public Long getFaren(){
		return faren;
	}
	
	/**
	* @param bzxs
	*/
	public void setBzxs(String bzxs){
		this.bzxs = bzxs;
	}
	
	/**
	* @return the bzxs
	*/
	@Column(name = "BZXS", length = 50)
	public String getBzxs(){
		return bzxs;
	}
	
	/**
	* @param ldzzs
	*/
	public void setLdzzs(Long ldzzs){
		this.ldzzs = ldzzs;
	}
	
	/**
	* @return the ldzzs
	*/
	@Column(name = "LDZZS", length = 5)
	public Long getLdzzs(){
		return ldzzs;
	}
	
	/**
	* @param ldfzs
	*/
	public void setLdfzs(Long ldfzs){
		this.ldfzs = ldfzs;
	}
	
	/**
	* @return the ldfzs
	*/
	@Column(name = "LDFZS", length = 5)
	public Long getLdfzs(){
		return ldfzs;
	}
	
	/**
	* @param jfxs
	*/
	public void setJfxs(String jfxs){
		this.jfxs = jfxs;
	}
	
	/**
	* @return the jfxs
	*/
	@Column(name = "JFXS", length = 50)
	public String getJfxs(){
		return jfxs;
	}
	
	/**
	* @param shortname
	*/
	public void setShortname(String shortname){
		this.shortname = shortname;
	}
	
	/**
	* @return the shortname
	*/
	@Column(name = "SHORTNAME", length = 10)
	public String getShortname(){
		return shortname;
	}
	
	/**
	* @param frzhengshu
	*/
	public void setFrzhengshu(String frzhengshu){
		this.frzhengshu = frzhengshu;
	}
	
	/**
	* @return the frzhengshu
	*/
	@Column(name = "FRZHENGSHU", length = 100)
	public String getFrzhengshu(){
		return frzhengshu;
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
	@Column(name = "OFFICEPHONE", length = 50)
	public String getOfficephone(){
		return officephone;
	}
	
	/**
	* @param officecode
	*/
	public void setOfficecode(String officecode){
		this.officecode = officecode;
	}
	
	/**
	* @return the officecode
	*/
	@Column(name = "OFFICECODE", length = 50)
	public String getOfficecode(){
		return officecode;
	}
	
	/**
	* @param officeaddr
	*/
	public void setOfficeaddr(String officeaddr){
		this.officeaddr = officeaddr;
	}
	
	/**
	* @return the officeaddr
	*/
	@Column(name = "OFFICEADDR", length = 160)
	public String getOfficeaddr(){
		return officeaddr;
	}
	
	/**
	* @param officeduty
	*/
	public void setOfficeduty(String officeduty){
		this.officeduty = officeduty;
	}
	
	/**
	* @return the officeduty
	*/
	@Column(name = "OFFICEDUTY", length = 50)
	public String getOfficeduty(){
		return officeduty;
	}
	
	/**
	* @param regionid
	*/
	public void setRegionid(Long regionid){
		this.regionid = regionid;
	}
	
	/**
	* @return the regionid
	*/
	@Column(name = "REGIONID", length = 25)
	public Long getRegionid(){
		return regionid;
	}
	
	/**
	* @param disporder
	*/
	public void setDisporder(String disporder){
		this.disporder = disporder;
	}
	
	/**
	* @return the disporder
	*/
	@Column(name = "DISPORDER", length = 4)
	public String getDisporder(){
		return disporder;
	}
	
	/**
	* @param officetime
	*/
	public void setOfficetime(String officetime){
		this.officetime = officetime;
	}
	
	/**
	* @return the officetime
	*/
	@Column(name = "OFFICETIME", length = 100)
	public String getOfficetime(){
		return officetime;
	}
	
	/**
	* @param traffictype
	*/
	public void setTraffictype(String traffictype){
		this.traffictype = traffictype;
	}
	
	/**
	* @return the traffictype
	*/
	@Column(name = "TRAFFICTYPE", length = 50)
	public String getTraffictype(){
		return traffictype;
	}
	
	/**
	* @param officemail
	*/
	public void setOfficemail(String officemail){
		this.officemail = officemail;
	}
	
	/**
	* @return the officemail
	*/
	@Column(name = "OFFICEMAIL", length = 100)
	public String getOfficemail(){
		return officemail;
	}
	
	/**
	* @param parentId
	*/
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	
	/**
	* @return the parentId
	*/
	@Column(name = "PARENT_ID", length = 32)
	public Long getParentId(){
		return parentId;
	}
	
	/**
	* @param roleLev
	*/
	public void setRoleLev(Long roleLev){
		this.roleLev = roleLev;
	}
	
	/**
	* @return the roleLev
	*/
	@Column(name = "ROLE_LEV", length = 32)
	public Long getRoleLev(){
		return roleLev;
	}
	
	/**
	* @param useFlag
	*/
	public void setUseFlag(Long useFlag){
		this.useFlag = useFlag;
	}
	
	/**
	* @return the useFlag
	*/
	@Column(name = "USE_FLAG", length = 1)
	public Long getUseFlag(){
		return useFlag;
	}
	
	/**
	* @param contactPerson
	*/
	public void setContactPerson(String contactPerson){
		this.contactPerson = contactPerson;
	}
	
	/**
	* @return the contactPerson
	*/
	@Column(name = "CONTACT_PERSON", length = 40)
	public String getContactPerson(){
		return contactPerson;
	}
	
	/**
	* @param email
	*/
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	* @return the email
	*/
	@Column(name = "EMAIL", length = 40)
	public String getEmail(){
		return email;
	}
	
	/**
	* @param header
	*/
	public void setHeader(String header){
		this.header = header;
	}
	
	/**
	* @return the header
	*/
	@Column(name = "HEADER", length = 40)
	public String getHeader(){
		return header;
	}
	
	/**
	* @param treeNode
	*/
	public void setTreeNode(Long treeNode){
		this.treeNode = treeNode;
	}
	
	/**
	* @return the treeNode
	*/
	@Column(name = "TREE_NODE", length = 2)
	public Long getTreeNode(){
		return treeNode;
	}
	
//	/**
//	* @param dwlx
//	*/
//	public void setDwlx(Long dwlx){
//		this.dwlx = dwlx;
//	}
//	
//	/**
//	* @return the dwlx
//	*/
//	@Column(name = "DWLX", length = 32)
//	public Long getDwlx(){
//		return dwlx;
//	}
//	
//	/**
//	* @param cybm
//	*/
//	public void setCybm(String cybm){
//		this.cybm = cybm;
//	}
//	
//	/**
//	* @return the cybm
//	*/
//	@Column(name = "CYBM", length = 40)
//	public String getCybm(){
//		return cybm;
//	}
//	
//	/**
//	* @param dwdm
//	*/
//	public void setDwdm(String dwdm){
//		this.dwdm = dwdm;
//	}
//	
//	/**
//	* @return the dwdm
//	*/
//	@Column(name = "DWDM", length = 40)
//	public String getDwdm(){
//		return dwdm;
//	}
//	
//	/**
//	* @param jgmx
//	*/
//	public void setJgmx(Long jgmx){
//		this.jgmx = jgmx;
//	}
//	
//	/**
//	* @return the jgmx
//	*/
//	@Column(name = "JGMX", length = 32)
//	public Long getJgmx(){
//		return jgmx;
//	}
	
	/**
	* @param jgHyfl
	*/
	public void setJgHyfl(String jgHyfl){
		this.jgHyfl = jgHyfl;
	}
	
	/**
	* @return the jgHyfl
	*/
	@Column(name = "JG_HYFL", length = 64)
	public String getJgHyfl(){
		return jgHyfl;
	}
	
	/**
	* @param jgHyflxl
	*/
	public void setJgHyflxl(String jgHyflxl){
		this.jgHyflxl = jgHyflxl;
	}
	
	/**
	* @return the jgHyflxl
	*/
	@Column(name = "JG_HYFLXL", length = 64)
	public String getJgHyflxl(){
		return jgHyflxl;
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
//	* @param isRegion
//	*/
//	public void setIsRegion(Long isRegion){
//		this.isRegion = isRegion;
//	}
//	
//	/**
//	* @return the isRegion
//	*/
//	@Column(name = "IS_REGION", length = 1)
//	public Long getIsRegion(){
//		return isRegion;
//	}
	
	/**
	* @param sfqy
	*/
	public void setSfqy(Long sfqy){
		this.sfqy = sfqy;
	}
	
	/**
	* @return the sfqy
	*/
	@Column(name = "SFQY", length = 1)
	public Long getSfqy(){
		return sfqy;
	}
	
	/**
	* @param tsjbIssendinfo
	*/
	public void setTsjbIssendinfo(Long tsjbIssendinfo){
		this.tsjbIssendinfo = tsjbIssendinfo;
	}
	
	/**
	* @return the tsjbIssendinfo
	*/
	@Column(name = "TSJB_ISSENDINFO", length = 2)
	public Long getTsjbIssendinfo(){
		return tsjbIssendinfo;
	}
	
	/**
	* @param tsjbSendtel
	*/
	public void setTsjbSendtel(Long tsjbSendtel){
		this.tsjbSendtel = tsjbSendtel;
	}
	
	/**
	* @return the tsjbSendtel
	*/
	@Column(name = "TSJB_SENDTEL", length = 15)
	public Long getTsjbSendtel(){
		return tsjbSendtel;
	}
}