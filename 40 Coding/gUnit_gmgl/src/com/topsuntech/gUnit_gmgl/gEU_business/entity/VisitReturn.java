package com.topsuntech.gUnit_gmgl.gEU_business.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;

import java.util.Date;


/**
 * The persistent class for the VISIT_RETURN database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="VISIT_RETURN")

public class VisitReturn extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4274390654156295626L;
	private Long id;
	private Date beginCreateDate;
	private Date endCreateDate;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private String customerName;
	private Long customerNum;
	private String customerReq;
	private String customerSource;
	private String customerTel;
	private Long isReturn;
	private String remark;
	private Date returnDate;
	private String returnRemark;
	private Long returnUserId;

	public VisitReturn() {
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


	@Column(name="CUSTOMER_NAME")
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Column(name="CUSTOMER_NUM")
	public Long getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(Long customerNum) {
		this.customerNum = customerNum;
	}


	@Column(name="CUSTOMER_REQ")
	public String getCustomerReq() {
		return this.customerReq;
	}

	public void setCustomerReq(String customerReq) {
		this.customerReq = customerReq;
	}


	@Column(name="CUSTOMER_SOURCE")
	public String getCustomerSource() {
		return this.customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}


	@Column(name="CUSTOMER_TEL")
	public String getCustomerTel() {
		return this.customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}


	@Id
	@SequenceGenerator(name="VISIT_RETURN_ID_GENERATOR", allocationSize = 1,sequenceName="VISIT_RETURN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VISIT_RETURN_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="IS_RETURN")
	public Long getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(Long isReturn) {
		this.isReturn = isReturn;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="RETURN_DATE")
	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	@Column(name="RETURN_REMARK")
	public String getReturnRemark() {
		return this.returnRemark;
	}

	public void setReturnRemark(String returnRemark) {
		this.returnRemark = returnRemark;
	}


	@Column(name="RETURN_USER_ID")
	public Long getReturnUserId() {
		return this.returnUserId;
	}

	public void setReturnUserId(Long returnUserId) {
		this.returnUserId = returnUserId;
	}


	@Transient
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}


	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	@Transient
	public Date getEndCreateDate() {
		return endCreateDate;
	}


	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

}