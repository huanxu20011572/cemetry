package com.topsuntech.gUnit_gmgl.gEU_business.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;

/**
 * The persistent class for the BUSINESS_DATA database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "BUSINESS_DATA")
public class BusinessData extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3827179808223852767L;
	private Long id;
	private String businessName;
	private String businessType;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Long isValidate;
	private String remark;
	private Long sort;
	private List<CemeteryType> cemeteryTypes;

	public BusinessData() {
	}

	@Id
	@SequenceGenerator(name = "BUSINESS_DATA_ID_GENERATOR", allocationSize = 1,sequenceName = "BUSINESS_DATA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUSINESS_DATA_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BUSINESS_NAME")
	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "BUSINESS_TYPE")
	public String getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_ORG_ID")
	public Long getCreateOrgId() {
		return this.createOrgId;
	}

	public void setCreateOrgId(Long createOrgId) {
		this.createOrgId = createOrgId;
	}

	@Column(name = "CREATE_USER_ID")
	public Long getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "IS_VALIDATE")
	public Long getIsValidate() {
		return this.isValidate;
	}

	public void setIsValidate(Long isValidate) {
		this.isValidate = isValidate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "\"SORT\"")
	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	// bi-directional many-to-one association to CemeteryType
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy = "businessData")
	public List<CemeteryType> getCemeteryTypes() {
		return this.cemeteryTypes;
	}

	public void setCemeteryTypes(List<CemeteryType> cemeteryTypes) {
		this.cemeteryTypes = cemeteryTypes;
	}


}