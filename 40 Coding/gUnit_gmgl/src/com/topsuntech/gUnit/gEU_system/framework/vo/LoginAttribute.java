package com.topsuntech.gUnit.gEU_system.framework.vo;

import com.topsuntech.gOS.user.en.user.User;

public class LoginAttribute {
    /*
     * ��¼�û����û���Ϣ
     */
    public User user;

    /*
     * ��¼�û���ϵͳ��ɫ
     */
    public long role;

    /*
     * ��¼�û���ƽ̨��ɫ
     */
    public long SystemRole;

    /*
     * ��¼�û�����������������ʶ
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
        buf.append("[ϵͳ��¼�û���Ϣ]").append("\n >user[�û���Ϣ]��" + user).append(
                "\n >role[ϵͳ��ɫ]:" + role).append(
                "\n >SystemRole[ƽ̨��ɫ]:" + SystemRole).append(
                "\n >approveUnitCode[��������������ʶ]:" + approveUnitCode).append("");

        return buf.toString();
    }
}
