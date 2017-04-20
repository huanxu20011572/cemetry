package com.topsuntech.gUnit_tjbz.gEU_system.service.vo;

/**
 * 权限操作表
 * 
 * @author cuixb
 * @create_date 20130819
 * 
 */
public class UserOpRoleQueryBean {

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
	private String create_date;
	private Long modify_user_id;
	private String modify_date;
	private Long use_flag;
	private Long userid;
	private Long is_modify_submit;

	public Long getIs_modify_submit() {
		return is_modify_submit;
	}

	public void setIs_modify_submit(Long is_modify_submit) {
		this.is_modify_submit = is_modify_submit;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUloginid() {
		return uloginid;
	}

	public void setUloginid(String uloginid) {
		this.uloginid = uloginid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSysflag() {
		return sysflag;
	}

	public void setSysflag(String sysflag) {
		this.sysflag = sysflag;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public Long getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(Long menu_type) {
		this.menu_type = menu_type;
	}

	public Long getIsadd() {
		return isadd;
	}

	public void setIsadd(Long isadd) {
		this.isadd = isadd;
	}

	public Long getIsedit() {
		return isedit;
	}

	public void setIsedit(Long isedit) {
		this.isedit = isedit;
	}

	public Long getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Long isdelete) {
		this.isdelete = isdelete;
	}

	public Long getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(Long create_user_id) {
		this.create_user_id = create_user_id;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public Long getModify_user_id() {
		return modify_user_id;
	}

	public void setModify_user_id(Long modify_user_id) {
		this.modify_user_id = modify_user_id;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public Long getUse_flag() {
		return use_flag;
	}

	public void setUse_flag(Long use_flag) {
		this.use_flag = use_flag;
	}

}
