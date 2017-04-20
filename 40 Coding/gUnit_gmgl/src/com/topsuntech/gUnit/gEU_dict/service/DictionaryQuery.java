package com.topsuntech.gUnit.gEU_dict.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.en.NodeVO;

/**
 * 机构查询
 * @author lixl To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Generation - Code and Comments
 */

public class DictionaryQuery {
	private static DBWrapper dbwrapper = DictDAOFactory.getInstance()
			.getDBWrapper();

	/**
	 * 根据大类编码查询数据列表
	 * @param type 父节点的ID
	 * @return
	 * @throws HibernateException
	 */
	public static List findDicnyByCode(String bigTypeCode, String institutionId)
			throws HibernateException {
		StringBuffer hsqlBuf = new StringBuffer(
				"select o.node_value,o.node_name");
		hsqlBuf.append(" from MetaData o,MetaData btc");
		hsqlBuf.append(" where btc.id = o.parentid");
		hsqlBuf.append(" and o.state = 2");
		if (institutionId != null) {
			hsqlBuf.append(" and o.institutionid = ");
			hsqlBuf.append(institutionId);
		}
		hsqlBuf.append(" and btc.node_value = '");
		hsqlBuf.append(bigTypeCode);
		hsqlBuf.append("'");
		hsqlBuf.append(" order by o.node_index,o.id");

		List list = dbwrapper.query(hsqlBuf.toString());
		List re = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object os[] = (Object[]) list.get(i);
			re.add(new NodeVO((String) os[0], (String) os[1]));
		}
		return re;
	}

	/**
	 * 根据大类的编码和小类的编码查询数据列表
	 * @param bigTypeCode 大类的编码
	 * @param smallTypeCode 小类的编码
	 * @return
	 * @throws HibernateException
	 */
	public static List findDicnyByCodeAndSubCode(String bigTypeCode,
			String smallTypeCode, String institutionId)
			throws HibernateException {
		/**
		 * sql: select o.* from sjzd_node o,sjzd_node py,sjzd_node sy where
		 * py.id = sy.parentid and sy.id = o.parentid and py.node_value = '102'
		 * and sy.node_value = '56776'
		 */
		StringBuffer hsqlBuf = new StringBuffer(
				"select o.node_value,o.node_name,syc.node_name,syc.node_index");
		hsqlBuf.append(" from MetaData o,MetaData btc,MetaData syc");
		hsqlBuf.append(" where btc.id = syc.parentid and syc.id = o.parentid");
		hsqlBuf.append(" and o.state = 2");
		if (institutionId != null) {
			hsqlBuf.append(" and o.institutionid = ");
			hsqlBuf.append(institutionId);
			hsqlBuf.append(" and syc.institutionid = ");
			hsqlBuf.append(institutionId);
		}
		hsqlBuf.append(" and btc.node_value = '");
		hsqlBuf.append(bigTypeCode);
		hsqlBuf.append("'");
		if (smallTypeCode != null) {
			hsqlBuf.append(" and syc.node_value = '");
			hsqlBuf.append(smallTypeCode);
			hsqlBuf.append("'");
		}
		hsqlBuf.append(" order by syc.node_index,o.node_index,o.id");

		System.out.println("hsql:" + hsqlBuf.toString());

		List list = dbwrapper.query(hsqlBuf.toString());
		List re = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object os[] = (Object[]) list.get(i);
			String displayName = (String) os[2] + " " + (String) os[1];
			re.add(new NodeVO((String) os[0], displayName));
		}
		return re;
	}

	/**
	 * 获取某个大类下的所有 如获取所有类型的车辆
	 * @param bigTypeCode 大类代码
	 * @param institutionId
	 * @return
	 * @throws HibernateException
	 */
	public static List findDicnyWithSubTypeByCode(String bigTypeCode,
			String institutionId) throws HibernateException {
		return findDicnyByCodeAndSubCode(bigTypeCode, null, institutionId);
	}

	/**
	 * 根据code获取名字
	 * @param code 代码
	 * @param institutionId 机构代码
	 * @return
	 * @throws HibernateException
	 */
	public static String findNameByCode(String code, String institutionId)
			throws HibernateException {
		StringBuffer hsqlBuf = new StringBuffer("select o.node_name");
		hsqlBuf.append(" from MetaData o");
		hsqlBuf.append(" where o.node_value = '");
		hsqlBuf.append(code);
		hsqlBuf.append("'");
		List list = dbwrapper.query(hsqlBuf.toString());
		if (list == null || list.size() == 0) {
			return null;
		}
		if (institutionId != null) {
			hsqlBuf.append(" and o.institutionid = ");
			hsqlBuf.append(institutionId);
		}
		return (String) list.get(0);
	}

	/**
	 * 根据code获取名字
	 * @param code 代码
	 * @param bigTypeCode 机构代码
	 * @return
	 * @throws HibernateException
	 */
	public static String findNameByType_Code(String code, String bigTypeCode)
			throws HibernateException {
		StringBuffer hsqlBuf = new StringBuffer("select o.node_name");
		hsqlBuf.append(" from MetaData o");
		hsqlBuf.append(" where o.node_value = '");
		hsqlBuf.append(code);
		hsqlBuf.append("'");

		if (bigTypeCode != null) {
			hsqlBuf.append(" and o.node_typename = '");
			hsqlBuf.append(bigTypeCode + "'");
		}

		List list = dbwrapper.query(hsqlBuf.toString());
		if (list == null || list.size() == 0) {
			return null;
		}
		return (String) list.get(0);
	}

	public static MetaData findNameByTypeCode(String code, String bigTypeCode)
			throws HibernateException {
		StringBuffer hsqlBuf = new StringBuffer("");
		hsqlBuf.append(" from MetaData o");
		hsqlBuf.append(" where o.node_value = '");
		hsqlBuf.append(code);
		hsqlBuf.append("'");

		if (bigTypeCode != null) {
			hsqlBuf.append(" and o.node_typename = '");
			hsqlBuf.append(bigTypeCode + "'");
		}
		List list = dbwrapper.query(hsqlBuf.toString());
		if (list == null || list.size() == 0) {
			return null;
		}
		return (MetaData) list.get(0);
	}

	/**
	 * 根据code获取名字
	 * @param code 代码
	 * @return
	 * @throws HibernateException
	 */
	public static String findNameByCode(String code) throws HibernateException {

		return findNameByCode(code, null);
	}

}
