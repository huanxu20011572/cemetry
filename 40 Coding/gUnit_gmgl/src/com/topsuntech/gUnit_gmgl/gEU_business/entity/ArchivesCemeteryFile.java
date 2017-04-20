package com.topsuntech.gUnit_gmgl.gEU_business.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.BaseBean;

import java.util.Date;


/**
 * The persistent class for the ARCHIVES_CEMETERY_FILE database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="ARCHIVES_CEMETERY_FILE")

public class ArchivesCemeteryFile extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6735148897969256938L;
	private Long id;
	private Date createDate;
	private Long createOrgId;
	private Long createUserId;
	private String fileName;
	private String filePath;
	private Long fileSize;
	private String fileType;
	private String remark;
	private ArchivesCemeteryRegistry archivesCemeteryRegistry;

	public ArchivesCemeteryFile() {
	}


	@Id
	@SequenceGenerator(name="ARCHIVES_CEMETERY_FILE_ID_GENERATOR",allocationSize = 1, sequenceName="ARCHIVES_CEMETERY_FILE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARCHIVES_CEMETERY_FILE_ID_GENERATOR")
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


	//bi-directional many-to-one association to ArchivesCemeteryRegistry
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FID")
	public ArchivesCemeteryRegistry getArchivesCemeteryRegistry() {
		return this.archivesCemeteryRegistry;
	}

	public void setArchivesCemeteryRegistry(ArchivesCemeteryRegistry archivesCemeteryRegistry) {
		this.archivesCemeteryRegistry = archivesCemeteryRegistry;
	}

}