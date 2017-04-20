package com.topsuntech.gUnit_gmgl.gEU_business.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;

/**
 * The persistent class for the CEMETERY_SERVICES database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "CEMETERY_SERVICES")
public class CemeteryService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6444696991737095360L;
	private Long id;
	// 服务开始时间
	private Date begindate;
	// 服务内容
	private String contents;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	// 服务结束时间
	private Date enddate;
	// 服务事项
	private String item;
	// 服务费用
	private Float price;
	// 备注
	private String remark;
	private ArchivesCemeteryRegistry archivesCemeteryRegistry;

	public CemeteryService() {
	}

	@Temporal(TemporalType.DATE)
	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	@Column(name = "\"CONTENTS\"")
	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	@Temporal(TemporalType.DATE)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	@Column(name = "ITEM")
	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	@Column(name = "PRICE")
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	// bi-directional many-to-one association to ArchivesCemeteryRegistry
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARCHIVES_CEMETERY_REGISTRY_ID")
	public ArchivesCemeteryRegistry getArchivesCemeteryRegistry() {
		return this.archivesCemeteryRegistry;
	}

	public void setArchivesCemeteryRegistry(ArchivesCemeteryRegistry archivesCemeteryRegistry) {
		this.archivesCemeteryRegistry = archivesCemeteryRegistry;
	}

	@Id
	@SequenceGenerator(name = "CEMETERY_SERVICES_ID_GENERATOR", allocationSize = 1, sequenceName = "CEMETERY_SERVICES_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CEMETERY_SERVICES_ID_GENERATOR")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}