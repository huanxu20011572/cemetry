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

import com.topsuntech.gUnit_gmgl.core.tree.TreeNode;


/**
 * The persistent class for the CEMETERY_ZONE database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_ZONE")

public class CemeteryZone extends TreeNode<CemeteryZone>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8087609145993230959L;
	private Long id;
	private String cemeteryZoneName;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Long isValidate;
	private String remark;
	private Long sort;
	private List<CemeteryLocation> cemeteryLocations;

	public CemeteryZone() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_ZONE_ID_GENERATOR", allocationSize = 1,sequenceName="CEMETERY_ZONE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_ZONE_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="CEMETERY_ZONE_NAME")
	public String getCemeteryZoneName() {
		return this.cemeteryZoneName;
	}

	public void setCemeteryZoneName(String cemeteryZoneName) {
		this.cemeteryZoneName = cemeteryZoneName;
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


	//bi-directional many-to-one association to CemeteryLocation
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="cemeteryZone")
	public List<CemeteryLocation> getCemeteryLocations() {
		return this.cemeteryLocations;
	}

	public void setCemeteryLocations(List<CemeteryLocation> cemeteryLocations) {
		this.cemeteryLocations = cemeteryLocations;
	}

	@Override
	@OrderBy(value = "sort")
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="parent")
	public List<CemeteryZone> getChildren() {
		return this.children;
	}


	@Override
	public void setChildren(List<CemeteryZone> children) {
		this.children = children;
	}


	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PID")
	public CemeteryZone getParent() {
		return this.parent;
	}


	@Override
	public void setParent(CemeteryZone parent) {
		this.parent = parent;
	}


	@Override
	@Transient
	public String getState() {
		if(!isLeaf()){
			return "closed";
		}
		return null;
	}


	@Override
	@Transient
	public String getText() {
		return this.cemeteryZoneName;
	}
}