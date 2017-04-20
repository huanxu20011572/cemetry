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
@SequenceGenerator(name = "jzDictionarySeq", sequenceName = "JZ_DICTIONARY_SEQ", allocationSize = 1)
@Table(name = "JZ_DICTIONARY")
public class Dictionary implements Serializable{
	private Long id;
	private Long parentid;
	private Long deptid;
	private String userid;
	private String name;
	private Long lev;
	private String val;
	private Long ind;
	private Long useFlag;
	private String typename;
	private Long type;
	private String propertiyValue;
	private String useBound;
	private String oldDictionaryId;
	private Date createDate;
	private Long createUserId;
	private Long systemType;
	private Long convertId;
	private Long dictionaryType;
	private Long correspondingId;
	private Long jbshType;
	private Long lcwbType;
	private Long sbjType;
	private Long bjsjType;
	private Long lowType;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jzDictionarySeq")
	public Long getId(){
		return id;
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
	@Column(name = "PARENTID", length = 12)
	public Long getParentid(){
		return parentid;
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
	@Column(name = "DEPTID", length = 12)
	public Long getDeptid(){
		return deptid;
	}
	
	/**
	* @param userid
	*/
	public void setUserid(String userid){
		this.userid = userid;
	}
	
	/**
	* @return the userid
	*/
	@Column(name = "USERID", length = 128)
	public String getUserid(){
		return userid;
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
	@Column(name = "NAME", length = 512)
	public String getName(){
		return name;
	}
	
	/**
	* @param lev
	*/
	public void setLev(Long lev){
		this.lev = lev;
	}
	
	/**
	* @return the lev
	*/
	@Column(name = "LEV", length = 8)
	public Long getLev(){
		return lev;
	}
	
	/**
	* @param val
	*/
	public void setVal(String val){
		this.val = val;
	}
	
	/**
	* @return the val
	*/
	@Column(name = "VAL", length = 512)
	public String getVal(){
		return val;
	}
	
	/**
	* @param ind
	*/
	public void setInd(Long ind){
		this.ind = ind;
	}
	
	/**
	* @return the ind
	*/
	@Column(name = "IND", length = 8)
	public Long getInd(){
		return ind;
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
	* @param typename
	*/
	public void setTypename(String typename){
		this.typename = typename;
	}
	
	/**
	* @return the typename
	*/
	@Column(name = "TYPENAME", length = 32)
	public String getTypename(){
		return typename;
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
	@Column(name = "TYPE", length = 1)
	public Long getType(){
		return type;
	}
	
	/**
	* @param propertiyValue
	*/
	public void setPropertiyValue(String propertiyValue){
		this.propertiyValue = propertiyValue;
	}
	
	/**
	* @return the propertiyValue
	*/
	@Column(name = "PROPERTIY_VALUE", length = 500)
	public String getPropertiyValue(){
		return propertiyValue;
	}
	
	/**
	* @param useBound
	*/
	public void setUseBound(String useBound){
		this.useBound = useBound;
	}
	
	/**
	* @return the useBound
	*/
	@Column(name = "USE_BOUND", length = 20)
	public String getUseBound(){
		return useBound;
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
	* @param systemType
	*/
	public void setSystemType(Long systemType){
		this.systemType = systemType;
	}
	
	/**
	* @return the systemType
	*/
	@Column(name = "SYSTEM_TYPE", length = 1)
	public Long getSystemType(){
		return systemType;
	}
	
	/**
	* @param convertId
	*/
	public void setConvertId(Long convertId){
		this.convertId = convertId;
	}
	
	/**
	* @return the convertId
	*/
	@Column(name = "CONVERT_ID", length = 12)
	public Long getConvertId(){
		return convertId;
	}
	
	/**
	* @param dictionaryType
	*/
	public void setDictionaryType(Long dictionaryType){
		this.dictionaryType = dictionaryType;
	}
	
	/**
	* @return the dictionaryType
	*/
	@Column(name = "DICTIONARY_TYPE", length = 1)
	public Long getDictionaryType(){
		return dictionaryType;
	}
	
	/**
	* @param correspondingId
	*/
	public void setCorrespondingId(Long correspondingId){
		this.correspondingId = correspondingId;
	}
	
	/**
	* @return the correspondingId
	*/
	@Column(name = "CORRESPONDING_ID", length = 32)
	public Long getCorrespondingId(){
		return correspondingId;
	}
	
	/**
	* @param jbshType
	*/
	public void setJbshType(Long jbshType){
		this.jbshType = jbshType;
	}
	
	/**
	* @return the jbshType
	*/
	@Column(name = "JBSH_TYPE", length = 1)
	public Long getJbshType(){
		return jbshType;
	}
	
	/**
	* @param lcwbType
	*/
	public void setLcwbType(Long lcwbType){
		this.lcwbType = lcwbType;
	}
	
	/**
	* @return the lcwbType
	*/
	@Column(name = "LCWB_TYPE", length = 1)
	public Long getLcwbType(){
		return lcwbType;
	}
	
	/**
	* @param sbjType
	*/
	public void setSbjType(Long sbjType){
		this.sbjType = sbjType;
	}
	
	/**
	* @return the sbjType
	*/
	@Column(name = "SBJ_TYPE", length = 1)
	public Long getSbjType(){
		return sbjType;
	}
	
	/**
	* @param bjsjType
	*/
	public void setBjsjType(Long bjsjType){
		this.bjsjType = bjsjType;
	}
	
	/**
	* @return the bjsjType
	*/
	@Column(name = "BJSJ_TYPE", length = 1)
	public Long getBjsjType(){
		return bjsjType;
	}
	
	/**
	* @param lowType
	*/
	public void setLowType(Long lowType){
		this.lowType = lowType;
	}
	
	/**
	* @return the lowType
	*/
	@Column(name = "LOW_TYPE", length = 1)
	public Long getLowType(){
		return lowType;
	}
}