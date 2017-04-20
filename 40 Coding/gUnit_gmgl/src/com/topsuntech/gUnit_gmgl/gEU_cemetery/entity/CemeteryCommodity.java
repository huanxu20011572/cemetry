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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;


/**
 * The persistent class for the CEMETERY_COMMODITY database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_COMMODITY")

public class CemeteryCommodity extends BaseBean{

	/**
	 * 商品信息
	 */
	private static final long serialVersionUID = -4023185858675579260L;
	private Long id;
	private String commodityName;
	private String commodityType;
	//库存
	private Long count;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	//入库价格
	private Float inPrice;
	//出库价格
	private Float outPrice;
	//规格
	private String specifications;
	private List<CemeteryCharge> cemeteryCharges;

	public CemeteryCommodity() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_COMMODITY_ID_GENERATOR", allocationSize = 1,sequenceName="CEMETERY_COMMODITY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_COMMODITY_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="COMMODITY_NAME")
	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}


	@Column(name="COMMODITY_TYPE")
	public String getCommodityType() {
		return this.commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}


	@Column(name="\"COUNT\"")
	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
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


	@Column(name="IN_PRICE")
	public Float getInPrice() {
		return this.inPrice;
	}

	public void setInPrice(Float inPrice) {
		this.inPrice = inPrice;
	}


	@Column(name="OUT_PRICE")
	public Float getOutPrice() {
		return this.outPrice;
	}

	public void setOutPrice(Float outPrice) {
		this.outPrice = outPrice;
	}


	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}


	//bi-directional many-to-one association to CemeteryCharge
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryCommodity")
	public List<CemeteryCharge> getCemeteryCharges() {
		return this.cemeteryCharges;
	}

	public void setCemeteryCharges(List<CemeteryCharge> cemeteryCharges) {
		this.cemeteryCharges = cemeteryCharges;
	}


}