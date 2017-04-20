package com.topsuntech.gUnit_gmgl.gEU_charge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;
//import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryChargeData;


/**
 * The persistent class for the CHARGE_DATA database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CHARGE_DATA")

public class ChargeData extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4574185374562906138L;
	private Long id;
	//价格
	private Float chargeDataPrice;
	private String chargeDataName;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Long isValidate;
	private String remark;
	private Long sort;
//	private List<CemeteryChargeData> cemeteryChargeData;
	private ChargeType chargeType;

	public ChargeData() {
	}


	@Id
	@SequenceGenerator(name="CHARGE_DATA_ID_GENERATOR",allocationSize = 1, sequenceName="CHARGE_DATA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHARGE_DATA_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="CHARGE_DATA_PRICE")
	public Float getChargeDataPrice() {
		return this.chargeDataPrice;
	}

	public void setChargeDataPrice(Float chargeDataPrice) {
		this.chargeDataPrice = chargeDataPrice;
	}


	@Column(name="CHARGE_DATA_NAME")
	public String getChargeDataName() {
		return this.chargeDataName;
	}

	public void setChargeDataName(String chargeDataName) {
		this.chargeDataName = chargeDataName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="CREATE_ORG_ID")
	public Long getCreateOrgId() {
		return this.createOrgId;
	}

	public void setCreateOrgId(Long createOrgId) {
		this.createOrgId = createOrgId;
	}


	@Column(name="CREATE_USER_ID")
	public Long getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}


	@Column(name="IS_VALIDATE")
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


	@Column(name="\"SORT\"")
	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
//
//
//	//bi-directional many-to-one association to CemeteryChargeData
//	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="chargeData")
//	public List<CemeteryChargeData> getCemeteryChargeData() {
//		return this.cemeteryChargeData;
//	}
//
//	public void setCemeteryChargeData(List<CemeteryChargeData> cemeteryChargeData) {
//		this.cemeteryChargeData = cemeteryChargeData;
//	}

	//bi-directional many-to-one association to ChargeType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CHARGE_TYPE_ID")
	public ChargeType getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

}