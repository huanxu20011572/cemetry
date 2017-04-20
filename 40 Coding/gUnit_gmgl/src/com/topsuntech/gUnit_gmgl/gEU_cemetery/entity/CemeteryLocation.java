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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;


/**
 * The persistent class for the CEMETERY_LOCATION database table.
 * 
 */
@Entity
@Table(name="CEMETERY_LOCATION")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)

public class CemeteryLocation extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3325558034603155257L;
	private Long id;
	private String cemeteryLocationCode;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Long status;
	private CemeteryType cemeteryType;
	private CemeteryZone cemeteryZone;
	private List<ArchivesCemeteryRegistry> archivesCemeteryRegistries ;
	private List<CemeteryRegistry> cemeteryRegistries;
	private Long amount;//增加墓位个数
	private Long cemeteryTypeId;
	private Long cemeteryZoneId;
	private Long cemeteryRegistryId;
	
	public CemeteryLocation() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_LOCATION_ID_GENERATOR",allocationSize = 1, sequenceName="CEMETERY_LOCATION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_LOCATION_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="CEMETERY_LOCATION_CODE")
	public String getCemeteryLocationCode() {
		return this.cemeteryLocationCode;
	}

	public void setCemeteryLocationCode(String cemeteryLocationCode) {
		this.cemeteryLocationCode = cemeteryLocationCode;
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


	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	//bi-directional many-to-one association to CemeteryType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CEMETERY_TYPE_ID")
	public CemeteryType getCemeteryType() {
		return this.cemeteryType;
	}

	public void setCemeteryType(CemeteryType cemeteryType) {
		this.cemeteryType = cemeteryType;
	}


	//bi-directional many-to-one association to CemeteryZone
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CEMETERY_ZONE_ID")
	public CemeteryZone getCemeteryZone() {
		return this.cemeteryZone;
	}

	public void setCemeteryZone(CemeteryZone cemeteryZone) {
		this.cemeteryZone = cemeteryZone;
	}

	//bi-directional many-to-one association to CemeteryRegistry
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryLocation")
	@OrderBy(value = "id DESC")
	public List<CemeteryRegistry> getCemeteryRegistries() {
		return this.cemeteryRegistries;
	}

	public void setCemeteryRegistries(List<CemeteryRegistry> cemeteryRegistries) {
		this.cemeteryRegistries = cemeteryRegistries;
	}

	@Transient
	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Transient
	public Long getCemeteryTypeId() {
		return cemeteryTypeId;
	}


	public void setCemeteryTypeId(Long cemeteryTypeId) {
		this.cemeteryTypeId = cemeteryTypeId;
	}

	@Transient
	public Long getCemeteryZoneId() {
		return cemeteryZoneId;
	}


	public void setCemeteryZoneId(Long cemeteryZoneId) {
		this.cemeteryZoneId = cemeteryZoneId;
	}

	@Transient
	public Long getCemeteryRegistryId() {
		return cemeteryRegistryId;
	}


	public void setCemeteryRegistryId(Long cemeteryRegistryId) {
		this.cemeteryRegistryId = cemeteryRegistryId;
	}

	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryLocation")
	@OrderBy(value = "id DESC")
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistries() {
		return archivesCemeteryRegistries;
	}


	public void setArchivesCemeteryRegistries(List<ArchivesCemeteryRegistry> archivesCemeteryRegistries) {
		this.archivesCemeteryRegistries = archivesCemeteryRegistries;
	}
}