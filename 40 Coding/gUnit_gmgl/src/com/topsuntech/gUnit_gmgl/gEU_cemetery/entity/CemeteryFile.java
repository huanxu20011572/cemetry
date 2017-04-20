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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;


/**
 * The persistent class for the CEMETERY_FILE database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="CEMETERY_FILE")

public class CemeteryFile extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4728201848992783909L;
	private Long id;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	////文件上传前名称
	private String fileName;
	//文件上传后名称
	private String filePath;
	private Long fileSize;
	private String fileType;
	private String remark;
	private CemeteryRegistry cemeteryRegistry;
//	private CemeteryType cemeteryType;

	public CemeteryFile() {
	}


	@Id
	@SequenceGenerator(name="CEMETERY_FILE_ID_GENERATOR", allocationSize = 1,sequenceName="CEMETERY_FILE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CEMETERY_FILE_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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


	@Column(name="FILE_NAME")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Column(name="FILE_PATH")
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Column(name="FILE_SIZE")
	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}


	@Column(name="FILE_TYPE")
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	//bi-directional many-to-one association to CemeteryRegistry
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FID")
	public CemeteryRegistry getCemeteryRegistry() {
		return this.cemeteryRegistry;
	}

	public void setCemeteryRegistry(CemeteryRegistry cemeteryRegistry) {
		this.cemeteryRegistry = cemeteryRegistry;
	}


//	@OneToOne(mappedBy="cemeteryFile")
//	public CemeteryType getCemeteryType() {
//		return cemeteryType;
//	}
//
//
//	public void setCemeteryType(CemeteryType cemeteryType) {
//		this.cemeteryType = cemeteryType;
//	}


}