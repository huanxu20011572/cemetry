package com.topsuntech.gUnit_xzqh.gEU_region.entity;

import java.util.Date;

/**
 * GosRegionAdjust entity.区划调整信息
 * 
 * @author MyEclipse Persistence Tools
 */

public class GosRegionAdjust implements java.io.Serializable {

	// Fields

	private Long id;
	/**调整类型 合并50161   拆分50162 */
	private Long adjustType;
	/**调整级别 区县50164  街道50165  社区50166*/
	private Long adjustLevel;
	private String adjustCountyIds;
	private String adjustCountyNames;
	private String adjustStreetIds;
	private String adjustStreetNames;
	private String adjustCommunityIds;
	private String adjustCommunityNames;
	private String newCountyIds;
	private String newCountyNames;
	private String newStreetIds;
	private String newStreetNames;
	private String newCommunityIds;
	private String newCommunityNames;
	private Date stopDate;
	/**是否停用    --1是  --0否*/
	private Long isStop;
	private Date createDate;
	private Long useFlag;
	private Long createUserId;

	// Constructors

	/** default constructor */
	public GosRegionAdjust() {
	}

	/** minimal constructor */
	public GosRegionAdjust(Long id) {
		this.id = id;
	}

	/** full constructor */
	public GosRegionAdjust(Long id, Long adjustType, Long adjustLevel,
			String adjustCountyIds, String adjustCountyNames,
			String adjustStreetIds, String adjustStreetNames,
			String adjustCommunityIds, String adjustCommunityNames,
			String newCountyIds, String newCountyNames, String newStreetIds,
			String newStreetNames, String newCommunityIds,
			String newCommunityNames, Date stopDate, Long isStop,
			Date createDate, Long useFlag, Long createUserId) {
		this.id = id;
		this.adjustType = adjustType;
		this.adjustLevel = adjustLevel;
		this.adjustCountyIds = adjustCountyIds;
		this.adjustCountyNames = adjustCountyNames;
		this.adjustStreetIds = adjustStreetIds;
		this.adjustStreetNames = adjustStreetNames;
		this.adjustCommunityIds = adjustCommunityIds;
		this.adjustCommunityNames = adjustCommunityNames;
		this.newCountyIds = newCountyIds;
		this.newCountyNames = newCountyNames;
		this.newStreetIds = newStreetIds;
		this.newStreetNames = newStreetNames;
		this.newCommunityIds = newCommunityIds;
		this.newCommunityNames = newCommunityNames;
		this.stopDate = stopDate;
		this.isStop = isStop;
		this.createDate = createDate;
		this.useFlag = useFlag;
		this.createUserId = createUserId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdjustType() {
		return this.adjustType;
	}

	public void setAdjustType(Long adjustType) {
		this.adjustType = adjustType;
	}

	public Long getAdjustLevel() {
		return this.adjustLevel;
	}

	public void setAdjustLevel(Long adjustLevel) {
		this.adjustLevel = adjustLevel;
	}

	public String getAdjustCountyIds() {
		return this.adjustCountyIds;
	}

	public void setAdjustCountyIds(String adjustCountyIds) {
		this.adjustCountyIds = adjustCountyIds;
	}

	public String getAdjustCountyNames() {
		return this.adjustCountyNames;
	}

	public void setAdjustCountyNames(String adjustCountyNames) {
		this.adjustCountyNames = adjustCountyNames;
	}

	public String getAdjustStreetIds() {
		return this.adjustStreetIds;
	}

	public void setAdjustStreetIds(String adjustStreetIds) {
		this.adjustStreetIds = adjustStreetIds;
	}

	public String getAdjustStreetNames() {
		return this.adjustStreetNames;
	}

	public void setAdjustStreetNames(String adjustStreetNames) {
		this.adjustStreetNames = adjustStreetNames;
	}

	public String getAdjustCommunityIds() {
		return this.adjustCommunityIds;
	}

	public void setAdjustCommunityIds(String adjustCommunityIds) {
		this.adjustCommunityIds = adjustCommunityIds;
	}

	public String getAdjustCommunityNames() {
		return this.adjustCommunityNames;
	}

	public void setAdjustCommunityNames(String adjustCommunityNames) {
		this.adjustCommunityNames = adjustCommunityNames;
	}

	public String getNewCountyIds() {
		return this.newCountyIds;
	}

	public void setNewCountyIds(String newCountyIds) {
		this.newCountyIds = newCountyIds;
	}

	public String getNewCountyNames() {
		return this.newCountyNames;
	}

	public void setNewCountyNames(String newCountyNames) {
		this.newCountyNames = newCountyNames;
	}

	public String getNewStreetIds() {
		return this.newStreetIds;
	}

	public void setNewStreetIds(String newStreetIds) {
		this.newStreetIds = newStreetIds;
	}

	public String getNewStreetNames() {
		return this.newStreetNames;
	}

	public void setNewStreetNames(String newStreetNames) {
		this.newStreetNames = newStreetNames;
	}

	public String getNewCommunityIds() {
		return this.newCommunityIds;
	}

	public void setNewCommunityIds(String newCommunityIds) {
		this.newCommunityIds = newCommunityIds;
	}

	public String getNewCommunityNames() {
		return this.newCommunityNames;
	}

	public void setNewCommunityNames(String newCommunityNames) {
		this.newCommunityNames = newCommunityNames;
	}

	public Date getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public Long getIsStop() {
		return this.isStop;
	}

	public void setIsStop(Long isStop) {
		this.isStop = isStop;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(Long useFlag) {
		this.useFlag = useFlag;
	}

	public Long getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

}