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
@SequenceGenerator(name = "gosRoleSeq", sequenceName = "GOS_ROLE_SEQ", allocationSize = 1)
@Table(name = "GOS_ROLE")
public class Role implements Serializable{
	private Long id;
	private String name;
	private Date createdate;
	private Long creatorid;
	private String description;
	private String priority;
	private Long deptId;
	private Long oldRoleId;
	private String creatorName;
	private String category;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gosRoleSeq")
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
	@Column(name = "NAME", length = 120)
	public String getName(){
		return name;
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
	* @param priority
	*/
	public void setPriority(String priority){
		this.priority = priority;
	}
	
	/**
	* @return the priority
	*/
	@Column(name = "PRIORITY", length = 2000)
	public String getPriority(){
		return priority;
	}
	
	/**
	* @param deptId
	*/
	public void setDeptId(Long deptId){
		this.deptId = deptId;
	}
	
	/**
	* @return the deptId
	*/
	@Column(name = "DEPT_ID", length = 25)
	public Long getDeptId(){
		return deptId;
	}
	
	/**
	* @param oldRoleId
	*/
	public void setOldRoleId(Long oldRoleId){
		this.oldRoleId = oldRoleId;
	}
	
	/**
	* @return the oldRoleId
	*/
	@Column(name = "OLD_ROLE_ID", length = 10)
	public Long getOldRoleId(){
		return oldRoleId;
	}
	
	/**
	* @param creatorName
	*/
	public void setCreatorName(String creatorName){
		this.creatorName = creatorName;
	}
	
	/**
	* @return the creatorName
	*/
	@Column(name = "CREATOR_NAME", length = 50)
	public String getCreatorName(){
		return creatorName;
	}
	
	/**
	* @param category
	*/
	public void setCategory(String category){
		this.category = category;
	}
	
	/**
	* @return the category
	*/
	@Column(name = "CATEGORY", length = 100)
	public String getCategory(){
		return category;
	}
}