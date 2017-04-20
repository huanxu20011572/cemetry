package com.topsuntech.gUnit_gmgl.gEU_cemetery.entity;

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
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;

/**
 * The persistent class for the CEMETERY_REGISTRY database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "CEMETERY_REGISTRY")
public class CemeteryRegistry extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3995748121716773379L;
	private Long id;
	private String agentName;
	//代理人凭证
	private String agentProve;
	private String agentReason;
	private String agentTel;
	// 业务分类
	private Long businessDataId = (long) -1;
	// 购墓时间
	private Date buydate;
	// 证件号码
	private String cardNum;
	// 证件类型
	private String cardType;
	// 墓穴价格
	private Float cemeteryPrice;
	// 业务编号
	private String cemeteryRegistryCode;
	// 登记类型（1租用，2续租，3合葬，4迁出，5退墓）
	private Integer cemeteryRegistryType;
	// 单位地址
	private String companyAddress;
	// 单位电话
	private String companyTel;
	// 单位邮编
	private String companyZip;
	// 创建时间
	private Date createDate;
	// 机构ID
	private Long createOrgId;
	// 创建用户ID
	private Long createUserId;
	// 欠款
	private Float debt;
	// 优惠费用 
	private Float discountPrice;
	// 电子邮件
	private String email;
	// 到期时间
	private Date enddate;
	// 实收费用
	private Float factPrice;
	// 家庭住址
	private String famliyAddress;
	// 固定电话
	private String famliyTel;
	// 家庭邮编
	private String famliyZip;
	// 是否本人（1是0否）
	private Long isOneself;
	// 手机
	private String mobilePhone;
	// 登记人
	private String name;
	// 民族
	private String nation;
	// 国籍
	private String nationality;
	// 退墓金额
	private Float backPrice;
	// 其他价格
	private Float otherPrice;
	// 每期（年）
	private Long periods;
	// 备注
	private String remark;
	// 性别
	private Long sex;
	// 碑后文字
	private String tombBack;
	// 碑前内容
	private String tombFront;
	// 碑文说明
	private String tombRemark;
	// 应收费用 
	private Float totalPrice;

	// 户口所在地省
	private String province;
	// 户口所在地县
	private String county;
	//是否补录
	private Long isSupply; 
	//退墓原因
	private String backReason;
	private List<CemeteryCharge> cemeteryCharges;
	private List<CemeteryFile> cemeteryFiles;
	private CemeteryLocation cemeteryLocation;
	private List<Departed> departeds = new ArrayList<Departed>();
	//墓位id
	private Long cemeteryLocationId;
	//逝者姓名
	private String departedName;

	public CemeteryRegistry() {
	}

	@Id
	@SequenceGenerator(name = "CEMETERY_REGISTRY_ID_GENERATOR",allocationSize = 1, sequenceName = "CEMETERY_REGISTRY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CEMETERY_REGISTRY_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "AGENT_NAME")
	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@Column(name = "AGENT_PROVE")
	public String getAgentProve() {
		return this.agentProve;
	}

	public void setAgentProve(String agentProve) {
		this.agentProve = agentProve;
	}

	@Column(name = "AGENT_REASON")
	public String getAgentReason() {
		return this.agentReason;
	}

	public void setAgentReason(String agentReason) {
		this.agentReason = agentReason;
	}

	@Column(name = "AGENT_TEL")
	public String getAgentTel() {
		return this.agentTel;
	}

	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
	}

	@Column(name = "BUSINESS_DATA_ID")
	public Long getBusinessDataId() {
		return this.businessDataId;
	}

	public void setBusinessDataId(Long businessDataId) {
		this.businessDataId = businessDataId;
	}

	@Temporal(TemporalType.DATE)
	public Date getBuydate() {
		return this.buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
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

	@Column(name = "CEMETERY_PRICE")
	public Float getCemeteryPrice() {
		return this.cemeteryPrice;
	}

	public void setCemeteryPrice(Float cemeteryPrice) {
		this.cemeteryPrice = cemeteryPrice;
	}

	@Column(name = "CEMETERY_REGISTRY_CODE")
	public String getCemeteryRegistryCode() {
		return this.cemeteryRegistryCode;
	}

	public void setCemeteryRegistryCode(String cemeteryRegistryCode) {
		this.cemeteryRegistryCode = cemeteryRegistryCode;
	}

	@Column(name = "CEMETERY_REGISTRY_TYPE")
	public Integer getCemeteryRegistryType() {
		return this.cemeteryRegistryType;
	}

	public void setCemeteryRegistryType(Integer cemeteryRegistryType) {
		this.cemeteryRegistryType = cemeteryRegistryType;
	}

	@Column(name = "COMPANY_ADDRESS")
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "COMPANY_TEL")
	public String getCompanyTel() {
		return this.companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	@Column(name = "COMPANY_ZIP")
	public String getCompanyZip() {
		return this.companyZip;
	}

	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
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

	public Float getDebt() {
		return this.debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	@Column(name = "DISCOUNT_PRICE")
	public Float getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "FACT_PRICE")
	public Float getFactPrice() {
		return this.factPrice;
	}

	public void setFactPrice(Float factPrice) {
		this.factPrice = factPrice;
	}

	@Column(name = "FAMLIY_ADDRESS")
	public String getFamliyAddress() {
		return this.famliyAddress;
	}

	public void setFamliyAddress(String famliyAddress) {
		this.famliyAddress = famliyAddress;
	}

	@Column(name = "FAMLIY_TEL")
	public String getFamliyTel() {
		return this.famliyTel;
	}

	public void setFamliyTel(String famliyTel) {
		this.famliyTel = famliyTel;
	}

	@Column(name = "FAMLIY_ZIP")
	public String getFamliyZip() {
		return this.famliyZip;
	}

	public void setFamliyZip(String famliyZip) {
		this.famliyZip = famliyZip;
	}

	@Column(name = "IS_ONESELF")
	public Long getIsOneself() {
		return this.isOneself;
	}

	public void setIsOneself(Long isOneself) {
		this.isOneself = isOneself;
	}

	@Column(name = "MOBILE_PHONE")
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	@Column(name = "BACK_PRICE")
	public Float getBackPrice() {
		return this.backPrice;
	}

	public void setBackPrice(Float backPrice) {
		this.backPrice = backPrice;
	}

	@Column(name = "OTHER_PRICE")
	public Float getOtherPrice() {
		return this.otherPrice;
	}

	public void setOtherPrice(Float otherPrice) {
		this.otherPrice = otherPrice;
	}

	@Column(name = "periods")
	public Long getPeriods() {
		return this.periods;
	}

	public void setPeriods(Long periods) {
		this.periods = periods;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSex() {
		return this.sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	@Column(name = "TOMB_BACK")
	public String getTombBack() {
		return this.tombBack;
	}

	public void setTombBack(String tombBack) {
		this.tombBack = tombBack;
	}

	@Column(name = "TOMB_FRONT")
	public String getTombFront() {
		return this.tombFront;
	}

	public void setTombFront(String tombFront) {
		this.tombFront = tombFront;
	}

	@Column(name = "TOMB_REMARK")
	public String getTombRemark() {
		return this.tombRemark;
	}

	public void setTombRemark(String tombRemark) {
		this.tombRemark = tombRemark;
	}

	@Column(name = "TOTAL_PRICE")
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	// bi-directional many-to-one association to CemeteryCharge
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cemeteryRegistry")
	public List<CemeteryCharge> getCemeteryCharges() {
		return this.cemeteryCharges;
	}

	public void setCemeteryCharges(List<CemeteryCharge> cemeteryCharges) {
		this.cemeteryCharges = cemeteryCharges;
	}

	// bi-directional many-to-one association to CemeteryFile
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cemeteryRegistry")
	public List<CemeteryFile> getCemeteryFiles() {
		return this.cemeteryFiles;
	}

	public void setCemeteryFiles(List<CemeteryFile> cemeteryFiles) {
		this.cemeteryFiles = cemeteryFiles;
	}

	// bi-directional many-to-one association to CemeteryLocation
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CEMETERY_LOCATION_ID")
	public CemeteryLocation getCemeteryLocation() {
		return this.cemeteryLocation;
	}

	public void setCemeteryLocation(CemeteryLocation cemeteryLocation) {
		this.cemeteryLocation = cemeteryLocation;
	}

	// bi-directional many-to-one association to Departed
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cemeteryRegistries")
	public List<Departed> getDeparteds() {
		return this.departeds;
	}

	public void setDeparteds(List<Departed> departeds) {
		this.departeds = departeds;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Transient
	public Long getCemeteryLocationId() {
		return cemeteryLocationId;
	}

	public void setCemeteryLocationId(Long cemeteryLocationId) {
		this.cemeteryLocationId = cemeteryLocationId;
	}

	@Transient
	public String getDepartedName() {
		return departedName;
	}

	public void setDepartedName(String departedName) {
		this.departedName = departedName;
	}

	@Column(name = "IS_SUPPLY")
	public Long getIsSupply() {
		return isSupply;
	}

	public void setIsSupply(Long isSupply) {
		this.isSupply = isSupply;
	}

	@Column(name = "BACK_REASON")
	public String getBackReason() {
		return backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

}