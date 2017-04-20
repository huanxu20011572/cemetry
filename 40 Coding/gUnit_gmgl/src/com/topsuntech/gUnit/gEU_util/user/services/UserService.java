/*
 * Created on 2006-5-15
 *
 */
package com.topsuntech.gUnit.gEU_util.user.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBUtility;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_util.user.entity.UserInfo;

/**
 * @author ZhangXuan
 * 
 * TopsunTech 2006-5-15
 */
public class UserService {
	private static DBWrapper dao = DBRegistry.getDefaultDBWrapper();

	private static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}

		return instance;
	}

	/**
	 * ��֤�û������Ƿ���ȷ
	 * 
	 * @author zcpeng 2008-10-30
	 * @param userId
	 * @param password
	 * @return
	 * @throws TSDBException
	 */
	public boolean checkUserPwd(Long userId, String password)
			throws TSDBException {
		User user = (User) DBUtility.load(User.class, userId);
		if (user.getPassword().equals(password))
			return true;
		return false;
	}

	/**
	 * �����û�CAΨһ�������û�����
	 * 
	 * @param caNumber
	 * @return
	 * @throws TSDBException
	 */
	public User getUserByCANumber(String caNumber) throws TSDBException {
		String query = "from com.topsuntech.gOS.user.en.user.User u where u.canumber='" + caNumber + "'";
		List list = DBUtility.query(query);
		if (list.size() == 0) {
			throw new IllegalStateException("û������û�����֤�鲻ƥ�䣡");
		} else {
			User user = (User) list.get(0);
			if (user.getRegiststatus() != 2) {
				throw new IllegalStateException("�Բ�������δ����ˣ�");
			} else {
				return user;
			}
		}
	}

	/**
	 * ���ݻ��������û�������
	 * 
	 * @param num
	 * @return
	 * @throws TSDBException
	 */
	public Office getOfficeByNum(String num) throws TSDBException {
		String query = "select o from Office o where o.num = '" + num + "'";
		List list = DBUtility.query(query);
		Office office = null;
		if (list.size() == 0) {
			throw new IllegalStateException("û������û�����֤�鲻ƥ�䣡");
		} else {
			office = (Office) list.get(0);
		}

		return office;
	}

	public boolean login(HttpServletRequest request, String caNumber) {
		boolean result = false;
		try {
			User user = getUserByCANumber(caNumber);
			Office office = user.getWorkdept();
			if (office != null) {
				user.setDeptname(office.getName());
				UserSession.setOffice(request, office);
			}
			UserSession.setUser(request, user);
			result = true;
		} catch (Exception e) {
			Logger.error("query user error", e);
			return false;
		}

		return result;
	}

	/**
	 * ���½�ɫ����Ӧ���û���ɫ����
	 * 
	 * @param roleId
	 *            '��ɫId'
	 * @throws SQLException
	 */
	public void updateRoles(long roleId) throws SQLException {
		StringBuffer querySql = new StringBuffer();
		StringBuffer updateSql = new StringBuffer();
		ResultSet roleRs = null;
		String priorty = "";

		querySql.append("select r.priority from gos_role r where r.id=")
				.append(roleId);
		roleRs = DBUtility.executeQuery(querySql.toString());
		try {
			if (roleRs != null && roleRs.next()) {
				priorty = roleRs.getString(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (roleRs != null)
				roleRs.close();
		}

		updateSql.append("update gos_user u set u.priority='").append(priorty)
				.append("'").append(" where u.role_id=").append(roleId);
		DBUtility.executeUpdate(updateSql.toString());

	}

	/**
	 * �����û��Ľ�ɫ
	 * 
	 * @param id
	 *            '�û�ID'
	 * @param rightRoleId
	 *            'Ȩ�޽�ɫID'
	 * @throws SQLException
	 */
	public static boolean updateUserInfoByRightRole(long id, long rightRoleId)
			throws SQLException {
		StringBuffer querySql = new StringBuffer();
		boolean bu = false;
		ResultSet roleRs = null;
		String priorty = "";

		try {
			querySql.append("select r.priority from gos_role r where r.id=")
					.append(rightRoleId);
			roleRs = DBUtility.executeQuery(querySql.toString());
			if (roleRs != null && roleRs.next()) {
				priorty = roleRs.getString(1);
			}

			UserInfo userInfo = (UserInfo) dao.load(UserInfo.class, id);

			if (userInfo != null) {
				userInfo.setRoleId(new Long(rightRoleId));
				userInfo.setPriority(priorty);
				dao.update(userInfo);
				bu = true;
			}

		} catch (TSDBException e) {
			e.printStackTrace();
		} finally {
			if (roleRs != null)
				roleRs.close();
		}

		return bu;
	}

	/**
	 * �����û�����
	 */
	public static void updateUser(Long id, String password)
			throws TSDBException {
		User user = (User) dao.load(User.class, id.longValue());
		if (user != null) {
			user.setPassword(password);
			dao.update(user);
		}
	}

	/**
	 * �����û�������
	 * 
	 * @param id
	 * @param password
	 */
	public static void updateUserInfo(long id, String password) {
		try {
			UserInfo userInfo = (UserInfo) dao.load(UserInfo.class, id);
			if (userInfo != null) {
				userInfo.setPassword(password);
				dao.update(userInfo);
			}
		} catch (TSDBException e) {
			e.printStackTrace();
		}
	}
}
