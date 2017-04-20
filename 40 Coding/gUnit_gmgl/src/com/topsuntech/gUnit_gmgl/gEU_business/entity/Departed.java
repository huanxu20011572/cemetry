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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

/**
 * The persistent class for the DEPARTED database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Departed extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5622365139828125502L;
	/**
	 * 
	 */
	private Long id;
	//年龄 
	private Long age;
	//出生日期 
	private Date birthDate;
    //	证件号码
	private String cardNum;
	// 证件类型
	private String cardType;
	//创建时间
	private Date createDate;
	//公墓id 
	private Long createOrgId;
	//创建人id 
	private Long createUserId;
	//辞世日期
	private Date deadDate;
	//实际安葬日期
	private Date factBuryDate;
	// 逝者姓名
	private String name;
	//民族
	private String nation;
	// 火化殡仪馆
	private String funeral;
	//国籍
	private String nationality;
	//籍贯
	private String nativeplace;
	//预约安葬日期 
	private Date orderBuryDate;
	//安放物 
	private String putGoods;
	//备注
	private String remark;
	//与承租人关系 
	private String rentrelation;
	//性别（1男，0女） 
	private Long sex;
	//施工人
	private String worker;
	private List<CemeteryRegistry> cemeteryRegistries = new ArrayList<CemeteryRegistry>();
	//业务办理id
	private Long regeditId;
	//身份证
	private String idCardNum;
	public Departed() {
	}

	@Id
	@SequenceGenerator(name = "DEPARTED_ID_GENERATOR",allocationSize = 1, sequenceName = "DEPARTED_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTED_ID_GENERATOR")
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

	// bi-directional many-to-one association to CemeteryRegistry
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY )
	@JoinTable(name="CEMETERY_REGISTRY_DEPARTED",joinColumns={@JoinColumn(name="DEPARTED_ID",referencedColumnName="ID")},inverseJoinColumns={@JoinColumn(name="CEMETERY_REGISTRY_ID",referencedColumnName="ID")})
	public List<CemeteryRegistry> getCemeteryRegistries() {
		return this.cemeteryRegistries;
	}

	public void setCemeteryRegistries(List<CemeteryRegistry> cemeteryRegistries) {
		this.cemeteryRegistries = cemeteryRegistries;
	}

	public String getFuneral() {
		return funeral;
	}

	public void setFuneral(String funeral) {
		this.funeral = funeral;
	}

	@Transient
	public Long getRegeditId() {
		return regeditId;
	}

	public void setRegeditId(Long regeditId) {
		this.regeditId = regeditId;
	}

	
	@Column(name = "ID_CARD_NUM")
	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

}