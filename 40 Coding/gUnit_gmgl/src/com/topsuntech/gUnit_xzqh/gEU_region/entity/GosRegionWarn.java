package com.topsuntech.gUnit_xzqh.gEU_region.entity;

import java.util.Date;

/**
 * GosRegionWarn entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GosRegionWarn implements java.io.Serializable {

	// Fields

	private Long id;
	private String warnName;
	private Date adjustDate;
	private Date effectDate;
	private String warnContent;
	private Long warnLevel;
	private Long warnRegion;
	private Date createDate;
	private Long useFlag;
	private Long createUserId;
	private Long gosRegionAdjustId;
	private Long adjustType;
	private Long adjustLevel;

	// Constructors

	/** default constructor */
	public GosRegionWarn() {
	}

	/** minimal constructor */
	public GosRegionWarn(Long id) {
		this.id = id;
	}

	/** full constructor */
	public GosRegionWarn(Long id, String warnName, Date adjustDate,
			Date effectDate, String warnContent, Long warnLevel,
			Long warnRegion, Date createDate, Long useFlag, Long createUserId) {
		this.id = id;
		this.warnName = warnName;
		this.adjustDate = adjustDate;
		this.effectDate = effectDate;
		this.warnContent = warnContent;
		this.warnLevel = warnLevel;
		this.warnRegion = warnRegion;
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

	public String getWarnName() {
		return this.warnName;
	}

	public void setWarnName(String warnName) {
		this.warnName = warnName;
	}

	public Date getAdjustDate() {
		return this.adjustDate;
	}

	public void setAdjustDate(Date adjustDate) {
		this.adjustDate = adjustDate;
	}

	public Date getEffectDate() {
		return this.effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getWarnContent() {
		return this.warnContent;
	}

	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}

	public Long getWarnLevel() {
		return this.warnLevel;
	}

	public void setWarnLevel(Long warnLevel) {
		this.warnLevel = warnLevel;
	}

	public Long getWarnRegion() {
		return this.warnRegion;
	}

	public void setWarnRegion(Long warnRegion) {
		this.warnRegion = warnRegion;
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

	public Long getGosRegionAdjustId() {
		return gosRegionAdjustId;
	}

	public void setGosRegionAdjustId(Long gosRegionAdjustId) {
		this.gosRegionAdjustId = gosRegionAdjustId;
	}

	public Long getAdjustType() {
		return adjustType;
	}

	public void setAdjustType(Long adjustType) {
		this.adjustType = adjustType;
	}

	public Long getAdjustLevel() {
		return adjustLevel;
	}

	public void setAdjustLevel(Long adjustLevel) {
		this.adjustLevel = adjustLevel;
	}
	
}