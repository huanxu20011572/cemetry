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
@SequenceGenerator(name = "gosRegionSeq", sequenceName = "GOS_REGION_SEQ", allocationSize = 1)
@Table(name = "GOS_REGION")
public class Region implements Serializable{
	private Long id;
	private String name;
	private Long levelid;
	private String description;
	private Date createdate;
	private Long creatorid;
	private Long parentid;
	private String num;
	private String shortname;
	private String disporder;
	private String standardNo;
	private Long useFlag;
	private String oldDictionaryId;
	private String convertId;
	private Long peopleNum;
//	private String regionCode;
//	private Long orderbyItem;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gosRegionSeq")
	public Long getId(){
		return id;
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
	@Column(name = "NAME", length = 100)
	public String getName(){
		return name;
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
	* @param description
	*/
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	* @return the description
	*/
	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription(){
		return description;
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
	* @param parentid
	*/
	public void setParentid(Long parentid){
		this.parentid = parentid;
	}
	
	/**
	* @return the parentid
	*/
	@Column(name = "PARENTID", length = 25)
	public Long getParentid(){
		return parentid;
	}
	
	/**
	* @param num
	*/
	public void setNum(String num){
		this.num = num;
	}
	
	/**
	* @return the num
	*/
	@Column(name = "NUM", length = 100)
	public String getNum(){
		return num;
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
	@Column(name = "SHORTNAME", length = 50)
	public String getShortname(){
		return shortname;
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
	@Column(name = "DISPORDER", length = 2)
	public String getDisporder(){
		return disporder;
	}
	
	/**
	* @param standardNo
	*/
	public void setStandardNo(String standardNo){
		this.standardNo = standardNo;
	}
	
	/**
	* @return the standardNo
	*/
	@Column(name = "STANDARD_NO", length = 20)
	public String getStandardNo(){
		return standardNo;
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
	* @param oldDictionaryId
	*/
	public void setOldDictionaryId(String oldDictionaryId){
		this.oldDictionaryId = oldDictionaryId;
	}
	
	/**
	* @return the oldDictionaryId
	*/
	@Column(name = "OLD_DICTIONARY_ID", length = 30)
	public String getOldDictionaryId(){
		return oldDictionaryId;
	}
	
	/**
	* @param convertId
	*/
	public void setConvertId(String convertId){
		this.convertId = convertId;
	}
	
	/**
	* @return the convertId
	*/
	@Column(name = "CONVERT_ID", length = 30)
	public String getConvertId(){
		return convertId;
	}
	
	/**
	* @param peopleNum
	*/
	public void setPeopleNum(Long peopleNum){
		this.peopleNum = peopleNum;
	}
	
	/**
	* @return the peopleNum
	*/
	@Column(name = "PEOPLE_NUM", length = 10)
	public Long getPeopleNum(){
		return peopleNum;
	}
//	
//	/**
//	* @param regionCode
//	*/
//	public void setRegionCode(String regionCode){
//		this.regionCode = regionCode;
//	}
//	
//	/**
//	* @return the regionCode
//	*/
//	@Column(name = "REGION_CODE", length = 20)
//	public String getRegionCode(){
//		return regionCode;
//	}
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
}