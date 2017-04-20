package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "gosUserextSeq", sequenceName = "GOS_USEREXT_SEQ", allocationSize = 1)
@Table(name = "GOS_USEREXT")
public class Userext implements Serializable{
	private Long id;
	private Long issuperman;
	private Long issubman;
	private Long isdeptman;
	private Long islogman;
	private Long subcreatorid;
	private Long logcreatorid;
	private Long deptcreatorid;
	private String substr;
	private String deptstr;
	private String logstr;
	private String priority;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gosUserextSeq")
	public Long getId(){
		return id;
	}
	
	/**
	* @param issuperman
	*/
	public void setIssuperman(Long issuperman){
		this.issuperman = issuperman;
	}
	
	/**
	* @return the issuperman
	*/
	@Column(name = "ISSUPERMAN", length = 1)
	public Long getIssuperman(){
		return issuperman;
	}
	
	/**
	* @param issubman
	*/
	public void setIssubman(Long issubman){
		this.issubman = issubman;
	}
	
	/**
	* @return the issubman
	*/
	@Column(name = "ISSUBMAN", length = 1)
	public Long getIssubman(){
		return issubman;
	}
	
	/**
	* @param isdeptman
	*/
	public void setIsdeptman(Long isdeptman){
		this.isdeptman = isdeptman;
	}
	
	/**
	* @return the isdeptman
	*/
	@Column(name = "ISDEPTMAN", length = 1)
	public Long getIsdeptman(){
		return isdeptman;
	}
	
	/**
	* @param islogman
	*/
	public void setIslogman(Long islogman){
		this.islogman = islogman;
	}
	
	/**
	* @return the islogman
	*/
	@Column(name = "ISLOGMAN", length = 1)
	public Long getIslogman(){
		return islogman;
	}
	
	/**
	* @param subcreatorid
	*/
	public void setSubcreatorid(Long subcreatorid){
		this.subcreatorid = subcreatorid;
	}
	
	/**
	* @return the subcreatorid
	*/
	@Column(name = "SUBCREATORID", length = 25)
	public Long getSubcreatorid(){
		return subcreatorid;
	}
	
	/**
	* @param logcreatorid
	*/
	public void setLogcreatorid(Long logcreatorid){
		this.logcreatorid = logcreatorid;
	}
	
	/**
	* @return the logcreatorid
	*/
	@Column(name = "LOGCREATORID", length = 25)
	public Long getLogcreatorid(){
		return logcreatorid;
	}
	
	/**
	* @param deptcreatorid
	*/
	public void setDeptcreatorid(Long deptcreatorid){
		this.deptcreatorid = deptcreatorid;
	}
	
	/**
	* @return the deptcreatorid
	*/
	@Column(name = "DEPTCREATORID", length = 25)
	public Long getDeptcreatorid(){
		return deptcreatorid;
	}
	
	/**
	* @param substr
	*/
	public void setSubstr(String substr){
		this.substr = substr;
	}
	
	/**
	* @return the substr
	*/
	@Column(name = "SUBSTR", length = 4000)
	public String getSubstr(){
		return substr;
	}
	
	/**
	* @param deptstr
	*/
	public void setDeptstr(String deptstr){
		this.deptstr = deptstr;
	}
	
	/**
	* @return the deptstr
	*/
	@Column(name = "DEPTSTR", length = 1000)
	public String getDeptstr(){
		return deptstr;
	}
	
	/**
	* @param logstr
	*/
	public void setLogstr(String logstr){
		this.logstr = logstr;
	}
	
	/**
	* @return the logstr
	*/
	@Column(name = "LOGSTR", length = 1000)
	public String getLogstr(){
		return logstr;
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
}