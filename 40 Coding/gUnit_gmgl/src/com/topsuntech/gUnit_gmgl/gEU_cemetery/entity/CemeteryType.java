package com.topsuntech.gUnit_gmgl.gEU_cemetery.entity;


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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;


/**
 * 墓型
 * The persistent class for the CEMETERY_TYPE database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_TYPE")

public class CemeteryType extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1151637597357518611L;
	private Long id;
	//面积
	private Float area;
	//护合尺寸
	private String boxsize;
	//穴别
	private Integer cave;
	//墓型编码
	private String cemeteryTypeCode;
	//墓型名称
	private String cemeteryTypeName;
	// 工程费
	private Float constructionPrice;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Long flatcost;
	// 土地租赁费
	private Float groundPrice;
	// 管理费
	private Float managePrice;
	private Float otherPrice;
	private String remark;
	private String specification;
	private String stoneprovider;
	private Float totalPrice;
	private Long cemeteryFileId;
//	private List<CemeteryChargeData> cemeteryChargeData;
	private CemeteryFile cemeteryFile;
	private List<CemeteryLocation> cemeteryLocations;
	private BusinessData businessData;
	private Long businessDataId;
	private String cemeteryProperty;

	public CemeteryType() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_TYPE_ID_GENERATOR",allocationSize = 1, sequenceName="CEMETERY_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_TYPE_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Float getArea() {
		return this.area;
	}

	public void setArea(Float area) {
		this.area = area;
	}


	public String getBoxsize() {
		return this.boxsize;
	}

	public void setBoxsize(String boxsize) {
		this.boxsize = boxsize;
	}


	public Integer getCave() {
		return this.cave;
	}

	public void setCave(Integer cave) {
		this.cave = cave;
	}


	@Column(name="CEMETERY_TYPE_CODE")
	public String getCemeteryTypeCode() {
		return this.cemeteryTypeCode;
	}

	public void setCemeteryTypeCode(String cemeteryTypeCode) {
		this.cemeteryTypeCode = cemeteryTypeCode;
	}


	@Column(name="CEMETERY_TYPE_NAME")
	public String getCemeteryTypeName() {
		return this.cemeteryTypeName;
	}

	public void setCemeteryTypeName(String cemeteryTypeName) {
		this.cemeteryTypeName = cemeteryTypeName;
	}


	@Column(name="CONSTRUCTION_PRICE")
	public Float getConstructionPrice() {
		return this.constructionPrice;
	}

	public void setConstructionPrice(Float constructionPrice) {
		this.constructionPrice = constructionPrice;
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


	public Long getFlatcost() {
		return this.flatcost;
	}

	public void setFlatcost(Long flatcost) {
		this.flatcost = flatcost;
	}


	@Column(name="GROUND_PRICE")
	public Float getGroundPrice() {
		return this.groundPrice;
	}

	public void setGroundPrice(Float groundPrice) {
		this.groundPrice = groundPrice;
	}


	@Column(name="MANAGE_PRICE")
	public Float getManagePrice() {
		return this.managePrice;
	}

	public void setManagePrice(Float managePrice) {
		this.managePrice = managePrice;
	}


	@Column(name="OTHER_PRICE")
	public Float getOtherPrice() {
		return this.otherPrice;
	}

	public void setOtherPrice(Float otherPrice) {
		this.otherPrice = otherPrice;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public String getStoneprovider() {
		return this.stoneprovider;
	}

	public void setStoneprovider(String stoneprovider) {
		this.stoneprovider = stoneprovider;
	}


	@Column(name="TOTAL_PRICE")
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

//
//	//bi-directional many-to-one association to CemeteryChargeData
//	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryType")
//	public List<CemeteryChargeData> getCemeteryChargeData() {
//		return this.cemeteryChargeData;
//	}
//
//	public void setCemeteryChargeData(List<CemeteryChargeData> cemeteryChargeData) {
//		this.cemeteryChargeData = cemeteryChargeData;
//	}
//
	//bi-directional many-to-one association to CemeteryFile
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="IMG")
	public CemeteryFile getCemeteryFile() {
		return this.cemeteryFile;
	}

	public void setCemeteryFile(CemeteryFile cemeteryFile) {
		this.cemeteryFile = cemeteryFile;
	}

	//bi-directional many-to-one association to CemeteryLocation
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryType")
	public List<CemeteryLocation> getCemeteryLocations() {
		return this.cemeteryLocations;
	}

	public void setCemeteryLocations(List<CemeteryLocation> cemeteryLocations) {
		this.cemeteryLocations = cemeteryLocations;
	}

	//bi-directional many-to-one association to BusinessData
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BUSINESS_DATA_ID")
	public BusinessData getBusinessData() {
		return this.businessData;
	}

	public void setBusinessData(BusinessData businessData) {
		this.businessData = businessData;
	}
	
	@Column(name="CEMETERY_PROPERTY")
	public String getCemeteryProperty() {
		return cemeteryProperty;
	}


	public void setCemeteryProperty(String cemeteryProperty) {
		this.cemeteryProperty = cemeteryProperty;
	}

	@Transient
	public Long getBusinessDataId() {
		return businessDataId;
	}


	public void setBusinessDataId(Long businessDataId) {
		this.businessDataId = businessDataId;
	}


	@Transient
	public Long getCemeteryFileId() {
		return cemeteryFileId;
	}


	public void setCemeteryFileId(Long cemeteryFileId) {
		this.cemeteryFileId = cemeteryFileId;
	}


}