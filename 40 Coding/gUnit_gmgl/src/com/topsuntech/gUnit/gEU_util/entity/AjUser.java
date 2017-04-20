package com.topsuntech.gUnit.gEU_util.entity;

import java.io.Serializable;
import java.util.Date;

import com.topsuntech.gOS.user.en.user.User;

public class AjUser extends User implements Serializable {

	private String systemRole;
//	// 人员排序字段
//	private Integer orderByItem;
//	// 是否执法人员 1是 其它不是
//	private Integer sfzf;
//	private String zfNumber;// 执法编号
	private String zjHao;// 证件号

	public String getZjHao() {
		return zjHao;
	}

	public void setZjHao(String zjHao) {
		this.zjHao = zjHao;
	}

	public String getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}
//
//	public Integer getOrderByItem() {
//		return orderByItem;
//	}
//
//	public void setOrderByItem(Integer orderByItem) {
//		this.orderByItem = orderByItem;
//	}
//
//	public Integer getSfzf() {
//		return sfzf;
//	}
//
//	public void setSfzf(Integer sfzf) {
//		this.sfzf = sfzf;
//	}
//
//	public String getZfNumber() {
//		return zfNumber;
//	}
//
//	public void setZfNumber(String zfNumber) {
//		this.zfNumber = zfNumber;
//	}

}
