package com.topsuntech.gUnit_gmgl.gEU_charge.entity;

import com.topsuntech.gUnit_gmgl.core.BaseBean;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CHARGE_TYPE database table.
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "CHARGE_TYPE")
public class ChargeType extends BaseBean {

    private static final long serialVersionUID = -3796083025397298097L;
    private Long id;
    private String chargeTypeDict;
    private String chargeTypeName;
    private Date createDate;
    private Long createOrgId;
    private Long createUserId;
    private Long isValidate;
    private String remark;
    private Long sort;
    private List<ChargeData> chargeData;

    public ChargeType() {
    }


    @Id
    @SequenceGenerator(name = "CHARGE_TYPE_ID_GENERATOR",allocationSize = 1, sequenceName = "CHARGE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHARGE_TYPE_ID_GENERATOR")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "CHARGE_TYPE_DICT")
    public String getChargeTypeDict() {
        return this.chargeTypeDict;
    }

    public void setChargeTypeDict(String chargeTypeDict) {
        this.chargeTypeDict = chargeTypeDict;
    }


    @Column(name = "CHARGE_TYPE_NAME")
    public String getChargeTypeName() {
        return this.chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName;
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


    @Column(name = "IS_VALIDATE")
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


    @Column(name = "\"SORT\"")
    public Long getSort() {
        return this.sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }


    //bi-directional many-to-one association to ChargeData
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "chargeType")
    public List<ChargeData> getChargeData() {
        return this.chargeData;
    }

    public void setChargeData(List<ChargeData> chargeData) {
        this.chargeData = chargeData;
    }

	/**
	 * 获取节点显示的内容
	 * @return
	 */
	@Transient
	public String getText(){
		return this.chargeTypeName;
	}
}