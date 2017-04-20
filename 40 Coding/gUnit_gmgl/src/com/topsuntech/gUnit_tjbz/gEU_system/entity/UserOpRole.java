package com.topsuntech.gUnit_tjbz.gEU_system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 权限操作表(殡葬)
 * 
 * @author cuixb
 * @create_date 20130819
 * 
 */
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "userOpRoleSeq", sequenceName = "USER_OP_ROLE_SEQ", allocationSize = 1)
@Table(name = "USER_OP_ROLE")
public class UserOpRole implements Serializable {

	private Long id;
	private String uname;
	private String uloginid;
	private String position;
	private String sysflag;
	private String sys_name;
	private Long menu_type;
	private Long isadd;
	private Long isedit;
	private Long isdelete;
	private Long create_user_id;
	private Date create_date;
	private Long modify_user_id;
	private Date modify_date;
	private Long use_flag;
	private Long userid;
	private Long is_modify_submit;
	private Long is_delete_submit;
	

	

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userOpRoleSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	@Column(name = "UNAME", length = 50)
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "ULOGINID", length = 50)
	public String getUloginid() {
		return uloginid;
	}

	public void setUloginid(String uloginid) {
		this.uloginid = uloginid;
	}

	@Column(name = "POSITION", length = 50)
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "SYSFLAG", length = 50)
	public String getSysflag() {
		return sysflag;
	}

	public void setSysflag(String sysflag) {
		this.sysflag = sysflag;
	}

	@Column(name = "SYS_NAME", length = 50)
	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	@Column(name = "MENU_TYPE", length = 32)
	public Long getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(Long menu_type) {
		this.menu_type = menu_type;
	}

	@Column(name = "ISADD", length = 32)
	public Long getIsadd() {
		return isadd;
	}

	public void setIsadd(Long isadd) {
		this.isadd = isadd;
	}

	@Column(name = "ISEDIT", length = 32)
	public Long getIsedit() {
		return isedit;
	}

	public void setIsedit(Long isedit) {
		this.isedit = isedit;
	}
	
	@Column(name = "ISDELETE", length = 32)
	public Long getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Long isdelete) {
		this.isdelete = isdelete;
	}

	@Column(name = "CREATE_USER_ID", length = 32)
	public Long getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(Long create_user_id) {
		this.create_user_id = create_user_id;
	}

	@Column(name = "CREATE_DATE", length = 0)
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Column(name = "MODIFY_USER_ID", length = 32)
	public Long getModify_user_id() {
		return modify_user_id;
	}

	public void setModify_user_id(Long modify_user_id) {
		this.modify_user_id = modify_user_id;
	}

	@Column(name = "MODIFY_DATE", length = 0)
	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	@Column(name = "USE_FLAG", length = 32)
	public Long getUse_flag() {
		return use_flag;
	}

	public void setUse_flag(Long use_flag) {
		this.use_flag = use_flag;
	}

	@Column(name = "USERID", length = 32)
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	@Column(name = "IS_DELETE_SUBMIT", length = 32)
	public Long getIs_delete_submit() {
		return is_delete_submit;
	}

	public void setIs_delete_submit(Long is_delete_submit) {
		this.is_delete_submit = is_delete_submit;
	}

	@Column(name = "IS_MODIFY_SUBMIT", length = 32)
	public Long getIs_modify_submit() {
		return is_modify_submit;
	}

	public void setIs_modify_submit(Long is_modify_submit) {
		this.is_modify_submit = is_modify_submit;
	}
	
}
