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
@SequenceGenerator(name = "apMultipickContentSeq", sequenceName = "AP_MULTIPICK_CONTENT_SEQ", allocationSize = 1)
@Table(name = "AP_MULTIPICK_CONTENT")
public class ApMultipickContent implements Serializable{
	private Long id;
	private Long baMultipickContent;
	private Long hisMultipickContent;
	private Long mainTableId;
	private String mainTableName;
	private Long hisMainTableId;
	private String partitionFlag;
	private String tagTableName;
	private Long chooseContent;
	private Long createUserId;
	private Date createDate;
	private Long useFlag;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apMultipickContentSeq")
	public Long getId(){
		return id;
	}
	
	/**
	* @param baMultipickContent
	*/
	public void setBaMultipickContent(Long baMultipickContent){
		this.baMultipickContent = baMultipickContent;
	}
	
	/**
	* @return the baMultipickContent
	*/
	@Column(name = "BA_MULTIPICK_CONTENT", length = 32)
	public Long getBaMultipickContent(){
		return baMultipickContent;
	}
	
	/**
	* @param hisMultipickContent
	*/
	public void setHisMultipickContent(Long hisMultipickContent){
		this.hisMultipickContent = hisMultipickContent;
	}
	
	/**
	* @return the hisMultipickContent
	*/
	@Column(name = "HIS_MULTIPICK_CONTENT", length = 32)
	public Long getHisMultipickContent(){
		return hisMultipickContent;
	}
	
	/**
	* @param mainTableId
	*/
	public void setMainTableId(Long mainTableId){
		this.mainTableId = mainTableId;
	}
	
	/**
	* @return the mainTableId
	*/
	@Column(name = "MAIN_TABLE_ID", length = 32)
	public Long getMainTableId(){
		return mainTableId;
	}
	
	/**
	* @param mainTableName
	*/
	public void setMainTableName(String mainTableName){
		this.mainTableName = mainTableName;
	}
	
	/**
	* @return the mainTableName
	*/
	@Column(name = "MAIN_TABLE_NAME", length = 50)
	public String getMainTableName(){
		return mainTableName;
	}
	
	/**
	* @param hisMainTableId
	*/
	public void setHisMainTableId(Long hisMainTableId){
		this.hisMainTableId = hisMainTableId;
	}
	
	/**
	* @return the hisMainTableId
	*/
	@Column(name = "HIS_MAIN_TABLE_ID", length = 32)
	public Long getHisMainTableId(){
		return hisMainTableId;
	}
	
	/**
	* @param partitionFlag
	*/
	public void setPartitionFlag(String partitionFlag){
		this.partitionFlag = partitionFlag;
	}
	
	/**
	* @return the partitionFlag
	*/
	@Column(name = "PARTITION_FLAG", length = 50)
	public String getPartitionFlag(){
		return partitionFlag;
	}
	
	/**
	* @param tagTableName
	*/
	public void setTagTableName(String tagTableName){
		this.tagTableName = tagTableName;
	}
	
	/**
	* @return the tagTableName
	*/
	@Column(name = "TAG_TABLE_NAME", length = 50)
	public String getTagTableName(){
		return tagTableName;
	}
	
	/**
	* @param chooseContent
	*/
	public void setChooseContent(Long chooseContent){
		this.chooseContent = chooseContent;
	}
	
	/**
	* @return the chooseContent
	*/
	@Column(name = "CHOOSE_CONTENT", length = 32)
	public Long getChooseContent(){
		return chooseContent;
	}
	
	/**
	* @param createUserId
	*/
	public void setCreateUserId(Long createUserId){
		this.createUserId = createUserId;
	}
	
	/**
	* @return the createUserId
	*/
	@Column(name = "CREATE_USER_ID", length = 32)
	public Long getCreateUserId(){
		return createUserId;
	}
	
	/**
	* @param createDate
	*/
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	* @return the createDate
	*/
	@Column(name = "CREATE_DATE", length = 0)
	public Date getCreateDate(){
		return createDate;
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
}