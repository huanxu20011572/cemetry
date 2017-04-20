package com.topsuntech.gUnit.gEU_system.framework.vo;

import com.topsuntech.gOS.user.en.user.User;

public class LoginAttribute {
    /*
     * 登录用户：用户信息
     */
    public User user;

    /*
     * 登录用户：系统角色
     */
    public long role;

    /*
     * 登录用户：平台角色
     */
    public long SystemRole;

    /*
     * 登录用户：所属机构审批标识
     */
    public String approveUnitCode;

    /**
     * @return the approveUnitCode
     */
    public String getApproveUnitCode() {
        return approveUnitCode;
    }

    /**
     * @param approveUnitCode
     *            the approveUnitCode to set
     */
    public void setApproveUnitCode(String approveUnitCode) {
        this.approveUnitCode = approveUnitCode;
    }

    /**
     * @return the role
     */
    public long getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(long role) {
        this.role = role;
    }

    /**
     * @return the systemRole
     */
    public long getSystemRole() {
        return SystemRole;
    }

    /**
     * @param systemRole
     *            the systemRole to set
     */
    public void setSystemRole(long systemRole) {
        SystemRole = systemRole;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("[系统登录用户信息]").append("\n >user[用户信息]：" + user).append(
                "\n >role[系统角色]:" + role).append(
                "\n >SystemRole[平台角色]:" + SystemRole).append(
                "\n >approveUnitCode[所属机构审批标识]:" + approveUnitCode).append("");

        return buf.toString();
    }
}
