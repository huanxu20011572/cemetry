/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.RowSet;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.type.Type;

import org.jdom.Document;
import org.jdom.Element;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.gUnit.database.GUnitDBUtility;
import com.topsuntech.gOS.gUnit.database.XMLGUnitFunc;
import com.topsuntech.gOS.identity.util.PageBean;
import com.topsuntech.gOS.identity.util.StringUtils;
import com.topsuntech.gOS.priority.PriorityValidator;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.utility.CSVUtility;
import com.topsuntech.gUnit.gEU_system.service.vo.RoleVo;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.entity.AjRole;
import com.topsuntech.gUnit.gEU_util.methods.PBMethod;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

/**
 * @author ibm
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class RoleService extends SJBaseDAO {
	protected DBWrapper db = getDBWrapper();
	private static DBWrapper dao = DBRegistry.getDefaultDBWrapper();

	/**
	 * 获取所有的角色信息列表
	 * 
	 * @return
	 */
	public List getRole(String roleStr) {
		List roleRole = new ArrayList();
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;

		sql.append(" select * from gos_role r  ");
		if (roleStr != null && roleStr.trim().length() > 0)
			sql.append(" where r.id in (").append(roleStr).append(")");
		sql.append(" order by r.id asc");

		try {
			rs = getDBWrapper().executeQuery(sql.toString());
			while (rs.next()) {
				RoleVo role = new RoleVo();
				role.setId(new Long(rs.getLong("id")));
				role.setName(rs.getString("name"));
				role.setPriority(rs.getString("priority"));
				role.setDescription(rs.getString("description"));
				roleRole.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return roleRole;
	}

	/**
	 * 获取权限信息
	 * 
	 * @param priorityIdStr
	 *            权限ID串
	 * @return
	 */
	public List gettPriorityListByIdStr(String priorityIdStr) {
		List priorityList = null;

		if (priorityIdStr != null && priorityIdStr.trim().length() > 0) {
			long[] priorityIds = PBMethod.getArrayId(priorityIdStr, ",");
			priorityList = GUnitDBUtility.getPriorityByIds(priorityIds);

		}

		return priorityList;
	}

	/**
	 *用户管理：更新用户的'系统角色'、'用户权限'信息
	 * 
	 * @param userId
	 * @param systemRole
	 * @param priority
	 */
	public void updateUserSystemRole(Long userId, String systemRole, String priorityIdStr) {
		StringBuffer sql = new StringBuffer();

		sql.append(" update gos_user u set ").append(" u.priority='").append(priorityIdStr).append("'").append(" ,u.system_role='").append(systemRole).append("'").append(" where u.id=").append(userId);

		try {
			getDBWrapper().executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取平台中的系统用户的角色
	 * 
	 * @param userId
	 *            用户ID
	 * @return 1,市级管理人员[平台];2,市级管理人员[平台];3,市级管理人员[平台];4,一般工作人员;
	 */
	public long getSystemRoleByUserId(Long userId) {
		long platFormRole = -1;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		String systemRole = "";
		long deptLev = -1;

		sql.append("select u.system_role,t.role_lev from gos_user u,gos_dept t ").append(" where u.deptid=t.id").append(" and u.id=").append(userId);

		try {
			rs = getDBWrapper().executeQuery(sql.toString());
			if (rs != null && rs.next()) {
				systemRole = rs.getString("system_role");
				deptLev = rs.getLong("role_lev");

				if (systemRole != null && systemRole.trim().length() > 0) {
					List roleList = getRole(systemRole);
					if (roleList != null) {
						for (int i = 0; i < roleList.size(); i++) {
							RoleVo role = (RoleVo) roleList.get(i);
							if (role.getName().trim().equals(Constants.platFormRole.CITY_MANAGER_USER_NAME) && deptLev == Constants.platFormRole.CITY_MANAGER_USER) {
								platFormRole = Constants.platFormRole.CITY_MANAGER_USER;
							} else if (role.getName().trim().equals(Constants.platFormRole.COUNTRY_MANAGER_USER_NAME) && deptLev == Constants.platFormRole.COUNTRY_MANAGER_USER) {
								platFormRole = Constants.platFormRole.COUNTRY_MANAGER_USER;
							} else if (role.getName().trim().equals(Constants.platFormRole.COUNTRY_LEAD_USER_NAME) && deptLev == Constants.platFormRole.COUNTRY_MANAGER_USER) {
								platFormRole = Constants.platFormRole.COUNTRY_LEAD_USER;
							} else if (role.getName().trim().equals(Constants.platFormRole.STREET_MANAGER_USER_NAME) && deptLev == Constants.platFormRole.STREET_MANAGER_USER) {
								platFormRole = Constants.platFormRole.STREET_MANAGER_USER;
							}
						}
					}
				} else {
					platFormRole = Constants.platFormRole.GENERAL_USER;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return platFormRole;

	}

	/**
	 * “角色管理”： 自动更新角色对应的用户权限
	 * 
	 * @param roleId
	 *            '角色ID'
	 */
	public void updateUserPriByRoleId(long roleId) {
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" select u.* from gos_user u ").append(" where u.deletereason is null ").append("  and u.system_role like '%").append(roleId).append("%'");

		try {
			rs = getDBWrapper().executeQuery(sql.toString());
			if (rs != null) {
				while (rs.next()) {
					long userId = rs.getLong("id");
					String systemRole = rs.getString("system_role");
					String priorityIdStr = "";
					// 转化成角色数组
					List roleList = getRole(systemRole);
					for (int i = 0; i < roleList.size(); i++) {
						RoleVo role = (RoleVo) roleList.get(i);
						if (priorityIdStr.trim().length() == 0) {
							priorityIdStr = role.getPriority();
						} else {
							priorityIdStr = PBMethod.mergerStr(priorityIdStr, ",", role.getPriority(), ",");
						}
					}
					// 更新用户权限
					updateUserSystemRole(new Long(userId), systemRole, priorityIdStr);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] str) {
		RoleService service = new RoleService();
		long role = service.getSystemRoleByUserId(new Long(30603));
		// System.out.println("\n ---role : " + role);
	}

	/**
	 * 得到角色列表
	 * 
	 * @deprecated
	 * @return where 1=1 and r.name like '%%'
	 * @throws SQLException
	 */
	public List _getRoleList(String rolename, String roleman, Page page) throws SQLException {
		List list = new ArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from gos_role r  where 1=1 ");
		if (rolename != null && !rolename.equals("")) {
			sql.append(" and r.name like '%").append(rolename).append("%'");
		}

		if (roleman != null && !roleman.equals("")) {
			sql.append(" and r.description like '%").append(roleman).append("%'");
		}
		RowSet rs = PBMethod.queryForOracle(sql.toString(), page, this.getDBWrapper());
		list = PBMethod.rs2MapListAndClose(rs);
		return list;
	}

	private boolean buildLikeHql(StringBuffer[] sqlBufs, String pName, String value, List objList, List typeList) {
		boolean r = buildHql(sqlBufs, pName, "like", value, Hibernate.STRING, objList, typeList);
		if (r && objList != null) {
			objList.set(objList.size() - 1, "%" + value + "%");
		}
		return r;
	}

	private boolean buildHql(StringBuffer[] sqlBufs, String pName, String method, Object value, Type type, List objList, List typeList) {
		if (value != null) {
			if (value instanceof String && ((String) value).length() == 0) {
				return false;
			}

			for (int i = 0; i < sqlBufs.length; i++) {
				sqlBufs[i].append("and ").append(pName).append(" ").append(method).append(" ? ");
			}
			if (objList != null) {
				objList.add(value);
			}
			if (typeList != null) {
				typeList.add(type);
			}
			return true;
		}
		return false;
	}

	private List countAndQuery(String queryHql, String countHql, List objs, List types, Page page) throws TSDBException {
		int count = db.count(countHql, (Type[]) types.toArray(new Type[] {}), objs.toArray());
		page.setTotalCount(count);
		return count == 0 ? Collections.EMPTY_LIST : db.query(queryHql, objs.toArray(), (Type[]) types.toArray(new Type[0]), page.getPageSize(), page.getCurrentPage() - 1);
	}

	private List countAndQueryByNSql(String queryNSql, String countSql, String[] returnAliases, Class[] returnClasses, List objs, PageBean pageBean) throws SQLException {
		ResultSet rs = db.executePreparedQuery(countSql, objs.toArray());
		long count = rs.next() ? rs.getLong(1) : 0;

		pageBean.setRowNum(count);

		if (count == 0) {
			return Collections.EMPTY_LIST;
		}

		Session session = null;
		try {
			session = db.openSession();

			Query query = session.createSQLQuery(queryNSql, returnAliases, returnClasses);

			for (int i = 0; i < objs.size(); i++) {
				query.setParameter(i, objs.get(i));
			}

			query.setMaxResults(pageBean.getPageSize());
			query.setFirstResult((pageBean.getCurrentPage() - 1) * pageBean.getPageSize());

			return query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
				}
			}
		}
	}

	public List getRoleList(String roleName, String desc, Long creatorId, Page page) throws TSDBException {
		StringBuffer qSql = new StringBuffer();
		qSql.append("from AjRole r where 1=1 ");

		StringBuffer cSql = new StringBuffer();
		cSql.append("select count(*) from AjRole r where 1=1 ");

		List objList = new ArrayList();
		List typeList = new ArrayList();

		buildLikeHql(new StringBuffer[] { qSql, cSql }, "r.name", roleName, objList, typeList);
		buildLikeHql(new StringBuffer[] { qSql, cSql }, "r.description", desc, objList, typeList);
//		buildHql(new StringBuffer[] { qSql, cSql }, "r.category", "=", category, Hibernate.STRING, objList, typeList);
		buildHql(new StringBuffer[] { qSql, cSql }, "r.creatorId", "=", creatorId, Hibernate.LONG, objList, typeList);

		qSql.append("order by r.creatorId,  r.id");
		return countAndQuery(qSql.toString(), cSql.toString(), objList, typeList, page);
	}

	public static Map getRootChildrenPrioritys() {
		Document doc = PriorityValidator.getDoc();
		Element root = doc.getRootElement();
		List children = root.getChildren();

		Map rootChildrenPrioritys = new LinkedHashMap();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			rootChildrenPrioritys.put(element.getAttributeValue("id"), element.getAttributeValue("name"));
		}
		return rootChildrenPrioritys;
	}

	public static Map getRootChildrenPrioritysIncludeIds(String priorityIds) {
		long[] pIds = CSVUtility.strToLongArray(priorityIds);

		Document doc = PriorityValidator.getDoc();
		Element root = doc.getRootElement();
		List children = root.getChildren();

		Map rootChildrenPrioritys = new LinkedHashMap();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			if (XMLGUnitFunc.hasPrivilegeAmong(element, pIds)) {
				rootChildrenPrioritys.put(element.getAttributeValue("id"), element.getAttributeValue("name"));
			}
		}
		return rootChildrenPrioritys;
	}

	public void saveOrUpdateAjRole(AjRole role) throws TSDBException {
		db.insertOrUpdate(role);
	}

	public void deleteAjRoleById(Long id) throws TSDBException {
		db.deleteById(AjRole.class, id);
	}

	public AjRole getAjRoleById(Long id) throws TSDBException {
		return (AjRole) db.load(AjRole.class, id.longValue());
	}

	public List findRolesByCreatorId(Long creatorId) throws TSDBException {
		StringBuffer qSql = new StringBuffer();
		qSql.append("from AjRole r where 1=1 ");

		List objList = new ArrayList();
		List typeList = new ArrayList();

		buildHql(new StringBuffer[] { qSql }, "r.creatorId", "=", creatorId, Hibernate.LONG, objList, typeList);
		qSql.append("order by  r.creatorId, r.id");
		return db.query(qSql.toString(), objList.toArray(), (Type[]) typeList.toArray(new Type[0]));
	}

	public List findRolesOrderByIds(Long creatorId,  String roleIdsStr, PageBean pageBean) throws SQLException {
		StringBuffer qnSql = new StringBuffer();
		qnSql.append("select {r.*} from gos_role r where 1=1 ");

		StringBuffer cSql = new StringBuffer();
		cSql.append("select count(*) from gos_role r where 1=1 ");

		List objList = new ArrayList();

		buildHql(new StringBuffer[] { qnSql, cSql }, "r.CREATORID", "=", creatorId, null, objList, null);
//		buildHql(new StringBuffer[] { qnSql, cSql }, "r.CATEGORY", "=", category, null, objList, null);

		qnSql.append("order by ");
		Long[] roleIds = StringUtils.csvStrToLongs(roleIdsStr);
		if (roleIds.length > 0) {
			qnSql.append("case when id in (");
			for (int i = 0; i < roleIds.length; i++) {
				if (i != 0) {
					qnSql.append(",");
				}
				qnSql.append(roleIds[i]);
			}
			qnSql.append(") then id else null end, ");
		}
		qnSql.append("r.CREATORID,  r.ID");

		return countAndQueryByNSql(qnSql.toString(), cSql.toString(), new String[] { "r" }, new Class[] { AjRole.class }, objList, pageBean);
	}

	public String findRolesPriority(String roleIdsStr) throws TSDBException {
		StringBuffer qSql = new StringBuffer();
		qSql.append("from AjRole r where r.id in (");

		Long[] roleIds = StringUtils.csvStrToLongs(roleIdsStr);
		if (roleIds.length == 0) {
			return null;
		}

		Type[] types = new Type[roleIds.length];
		for (int i = 0; i < types.length; i++) {
			types[i] = Hibernate.LONG;
			if (i != 0) {
				qSql.append(",");
			}
			qSql.append("?");
		}
		qSql.append(")");

		List l = db.query(qSql.toString(), roleIds, types);

		String rolesPriority = ",";
		String rPriority = null;
		for (int i = 0; i < l.size(); i++) {
			rPriority = ((AjRole) l.get(i)).getPriority();
			if (rPriority != null && rPriority.length() != 0) {
				rolesPriority += rPriority.substring(1, rPriority.length());
			}
		}

		return ",".equals(rolesPriority) ? null : rolesPriority;
	}

	/**
	 * 根据ID得到用户角色
	 * 
	 * @param id
	 * @return
	 * @throws TSDBException
	 * @throws SQLException
	 */
	public AjRole queryAjRoleById(Long id) throws TSDBException, SQLException {

		List list = null;
		AjRole ajRole = new AjRole();
		StringBuffer sql = new StringBuffer();
		if (id != null) {
			sql.append("  from AjRole r where   1=1 ");
			sql.append(" and r.id=").append(id);

		}
		if (sql != null && !sql.equals("")) {
			list = dao.query(sql.toString());
			if (list != null && list.size() > 0)
				ajRole = (AjRole) list.get(0);
		}

		return ajRole;
	}
}
