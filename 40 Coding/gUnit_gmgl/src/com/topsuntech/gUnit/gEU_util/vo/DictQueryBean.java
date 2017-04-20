package com.topsuntech.gUnit.gEU_util.vo;

public class DictQueryBean {
	
	private Long parentId;
	
	private Byte useFlag;
	
	private String sysFlag;

	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Byte getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(Byte useFlag) {
		this.useFlag = useFlag;
	}

}
