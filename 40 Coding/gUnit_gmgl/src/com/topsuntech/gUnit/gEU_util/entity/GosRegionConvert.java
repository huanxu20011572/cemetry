package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOS_REGION_CONVERT")
public class GosRegionConvert implements Serializable {
	private Long id;
	private Long regionId;
	private String name;
	private Long parentId;
	private String parentName;
	private Date createDate;
	private Long useFlag;
	private Long ruleId;

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * @param regionId
	 */
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return the regionId
	 */
	@Column(name = "REGION_ID", length = 25)
	public Long getRegionId() {
		return regionId;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", length = 100)
	public String getName() {
		return name;
	}

	/**
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the parentId
	 */
	@Column(name = "PARENT_ID", length = 25)
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentName
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the parentName
	 */
	@Column(name = "PARENT_NAME", length = 100)
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createDate
	 */
	@Column(name = "CREATE_DATE", length = 0)
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param useFlag
	 */
	public void setUseFlag(Long useFlag) {
		this.useFlag = useFlag;
	}

	/**
	 * @return the useFlag
	 */
	@Column(name = "USE_FLAG", length = 1)
	public Long getUseFlag() {
		return useFlag;
	}

	/**
	 * @param ruleId
	 */
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	/**
	 * @return the ruleId
	 */
	@Column(name = "RULE_ID", length = 4)
	public Long getRuleId() {
		return ruleId;
	}
}