package com.topsuntech.gUnit_gmgl.gEU_business.entity;

import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * The persistent class for the ARCHIVES_DEPARTED database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ARCHIVES_DEPARTED")
public class ArchivesDeparted extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5184651854879223025L;
	private Long id;
	private Long age;
	private Date birthDate;
	private String cardNum;
	private String cardType;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private Date deadDate;
	private Date factBuryDate;
	private String name;
	private String nation;
	private String nationality;
	private String nativeplace;
	private Date orderBuryDate;
	private String putGoods;
	private String remark;
	private String rentrelation;
	private Long sex;
	private String worker;
	private List<ArchivesCemeteryRegistry> archivesCemeteryRegistries = new ArrayList<ArchivesCemeteryRegistry>();
	// 承租人电话
	private String mobilePhone;
	// 承租人姓名
	private String registryName;
	// 业务编号
	private String cemeteryRegistryCode;
	private Date buydate;
	private Date enddate;
	private String idCardNum;
	//档案业务办理id
	private Long regeditId;
	private String funeral;

	public ArchivesDeparted() {
	}

	@Id
	@SequenceGenerator(name = "ARCHIVES_DEPARTED_ID_GENERATOR", allocationSize = 1,sequenceName = "ARCHIVES_DEPARTED_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARCHIVES_DEPARTED_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "CARD_NUM")
	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Column(name = "CARD_TYPE")
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
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
	@Column(name = "DEAD_DATE")
	public Date getDeadDate() {
		return this.deadDate;
	}

	public void setDeadDate(Date deadDate) {
		this.deadDate = deadDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FACT_BURY_DATE")
	public Date getFactBuryDate() {
		return this.factBuryDate;
	}

	public void setFactBuryDate(Date factBuryDate) {
		this.factBuryDate = factBuryDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativeplace() {
		return this.nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_BURY_DATE")
	public Date getOrderBuryDate() {
		return this.orderBuryDate;
	}

	public void setOrderBuryDate(Date orderBuryDate) {
		this.orderBuryDate = orderBuryDate;
	}

	@Column(name = "PUT_GOODS")
	public String getPutGoods() {
		return this.putGoods;
	}

	public void setPutGoods(String putGoods) {
		this.putGoods = putGoods;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRentrelation() {
		return this.rentrelation;
	}

	public void setRentrelation(String rentrelation) {
		this.rentrelation = rentrelation;
	}

	public Long getSex() {
		return this.sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public String getWorker() {
		return this.worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	// bi-directional many-to-one association to ArchivesCemeteryRegistry
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY )
	@JoinTable(name="ARC_CEMETERY_REGISTRY_DEPARTED",joinColumns={@JoinColumn(name="ARCHIVES_DEPARTED_ID",referencedColumnName="ID")},inverseJoinColumns={@JoinColumn(name="ARCHIVES_CEMETERY_REGISTRY_ID",referencedColumnName="ID")})
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistries() {
		return this.archivesCemeteryRegistries;
	}

	public void setArchivesCemeteryRegistries(List<ArchivesCemeteryRegistry> archivesCemeteryRegistries) {
		this.archivesCemeteryRegistries = archivesCemeteryRegistries;
	}

	@Transient
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Transient
	public String getRegistryName() {
		return registryName;
	}

	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}

	@Transient
	public String getCemeteryRegistryCode() {
		return cemeteryRegistryCode;
	}

	public void setCemeteryRegistryCode(String cemeteryRegistryCode) {
		this.cemeteryRegistryCode = cemeteryRegistryCode;
	}

	@Transient
	public Date getBuydate() {
		return buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	@Transient
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	@Column(name = "ID_CARD_NUM")
	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	@Transient
	public Long getRegeditId() {
		return regeditId;
	}

	public void setRegeditId(Long regeditId) {
		this.regeditId = regeditId;
	}

	public String getFuneral() {
		return funeral;
	}

	public void setFuneral(String funeral) {
		this.funeral = funeral;
	}

}