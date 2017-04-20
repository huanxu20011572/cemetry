/*
 * Created on 2007-1-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.user.framework.actionforms;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UserForm extends ActionForm{
	
	private String password;
	
	private String newPassword;
	
	private String newPassword1;

	/**
	 * @return Returns the newPassword.
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword The newPassword to set.
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return Returns the newPassword1.
	 */
	public String getNewPassword1() {
		return newPassword1;
	}
	/**
	 * @param newPassword1 The newPassword1 to set.
	 */
	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
