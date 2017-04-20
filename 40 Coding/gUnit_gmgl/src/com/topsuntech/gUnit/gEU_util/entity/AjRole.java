package com.topsuntech.gUnit.gEU_util.entity;

import java.util.Date;

public class AjRole {
	private Long id;

	private String name;

	private Date createDate;

	private Long creatorId;

//	private String creatorName;

	private String description;

	private String priority;
	
//	private String category;

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
//
//	public String getCreatorName() {
//		return creatorName;
//	}
//
//	public void setCreatorName(String creatorName) {
//		this.creatorName = creatorName;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
