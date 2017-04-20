package com.topsuntech.gUnit_gmgl.gEU_cemetery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;


/**
 * The persistent class for the CEMETERY_CHARGE database table.
 * 费用信息
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_CHARGE")

public class CemeteryCharge extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5160877219750577516L;
	private Long id;
	private Long count;
	//优惠价格
	private Float discount;
	//单价
	private Float price;
	//应收款
	private Float receivable;
	//本次收款
	private Float receive;

	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	//是否是费用，1是(费用)，0否（商品） 
	private Long isChargeType;
	//出库类型1,售卖2，赠送，3损耗 
	private Long outStorehouseType;
	private String productName;
	private String productType;
	private CemeteryRegistry cemeteryRegistry;
	//公墓商品
	private CemeteryCommodity cemeteryCommodity;

	public CemeteryCharge() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_CHARGE_ID_GENERATOR",allocationSize = 1, sequenceName="CEMETERY_CHARGE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_CHARGE_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}


	@Column(name="IS_CHARGE_TYPE")
	public Long getIsChargeType() {
		return this.isChargeType;
	}

	public void setIsChargeType(Long isChargeType) {
		this.isChargeType = isChargeType;
	}


	@Column(name="OUT_STOREHOUSE_TYPE")
	public Long getOutStorehouseType() {
		return this.outStorehouseType;
	}

	public void setOutStorehouseType(Long outStorehouseType) {
		this.outStorehouseType = outStorehouseType;
	}


	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}


	@Column(name="PRODUCT_NAME")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Column(name="PRODUCT_TYPE")
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	public Float getReceivable() {
		return this.receivable;
	}

	public void setReceivable(Float receivable) {
		this.receivable = receivable;
	}


	public Float getReceive() {
		return this.receive;
	}

	public void setReceive(Float receive) {
		this.receive = receive;
	}


	//bi-directional many-to-one association to CemeteryRegistry
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CEMETERY_REGISTRY_ID")
	public CemeteryRegistry getCemeteryRegistry() {
		return this.cemeteryRegistry;
	}

	public void setCemeteryRegistry(CemeteryRegistry cemeteryRegistry) {
		this.cemeteryRegistry = cemeteryRegistry;
	}


	//bi-directional many-to-one association to CemeteryCommodity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CEMETERY_COMMODITY_ID")
	public CemeteryCommodity getCemeteryCommodity() {
		return this.cemeteryCommodity;
	}

	public void setCemeteryCommodity(CemeteryCommodity cemeteryCommodity) {
		this.cemeteryCommodity = cemeteryCommodity;
	}

}