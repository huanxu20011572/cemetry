package com.topsuntech.gUnit_gmgl.gEU_business.entity;

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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;


/**
 * The persistent class for the CEMETERY_CERTIFICATE database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_CERTIFICATE")
public class CemeteryCertificate extends BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7517009312349990244L;
	private Long id;
	private Float charge;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private String reason;
	private String remark;
	private ArchivesCemeteryRegistry archivesCemeteryRegistry;
	private Long archivesCemeteryRegistryId;

	public CemeteryCertificate() {
	}


	public Float getCharge() {
		return this.charge;
	}

	public void setCharge(Float charge) {
		this.charge = charge;
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


	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	//bi-directional many-to-one association to ArchivesCemeteryRegistry
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ARCHIVES_CEMETERY_REGISTRY_ID")
	public ArchivesCemeteryRegistry getArchivesCemeteryRegistry() {
		return this.archivesCemeteryRegistry;
	}

	public void setArchivesCemeteryRegistry(ArchivesCemeteryRegistry archivesCemeteryRegistry) {
		this.archivesCemeteryRegistry = archivesCemeteryRegistry;
	}

	@Id
	@SequenceGenerator(name="CEMETERY_CERTIFICATE_ID_GENERATOR",allocationSize = 1, sequenceName="CEMETERY_CERTIFICATE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_CERTIFICATE_ID_GENERATOR")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public Long getArchivesCemeteryRegistryId() {
		return archivesCemeteryRegistryId;
	}


	public void setArchivesCemeteryRegistryId(Long archivesCemeteryRegistryId) {
		this.archivesCemeteryRegistryId = archivesCemeteryRegistryId;
	}

}