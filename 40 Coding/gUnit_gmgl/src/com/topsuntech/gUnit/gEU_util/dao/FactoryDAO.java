package com.topsuntech.gUnit.gEU_util.dao;

/**
 * create_user : lxr
 * create_date : 2009701
 * desc :西城区社区平台[底层支持数据访问工厂基础DAO]，程序中的DAO不能直接继承它；
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;
import oracle.sql.TIMESTAMP;

import org.apache.commons.beanutils.BeanUtils;

import sun.jdbc.rowset.CachedRowSet;

import com.runqian.base4.util.Logger;
import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;

public class FactoryDAO {

	/**
	 * use_flag:是（开）
	 */
	public static final Byte USE_FLAG_ON = Byte.valueOf("1");

	/**
	 * use_flag:否（关）
	 */
	public static final Byte USE_FLAG_OFF = Byte.valueOf("0");

	public DBWrapper dbWrapper;

	public DBWrapper getDBWrapper() {
		return dbWrapper;
	}

	// 以下为通用方法
	/**
	 * add Entity(insert)
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void addEntity(Serializable object) throws TSDBException {
		dbWrapper.insert(object);
	}

	/**
	 * add Entity(insert or update)
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void addOrUpdateEntity(Serializable object) throws TSDBException {
		dbWrapper.insertOrUpdate(object);
	}

	/**
	 * getEntity -----举例：(XzxkUser) db.getEntity(XzxkUser.class, new
	 * Long(userid));
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 * @return Object
	 */
	public Object getEntity(Class clazz, Serializable id) throws TSDBException {
		return dbWrapper.load(clazz, ((Long) id).longValue());
	}

	/**
	 * updateEntity -----举例：db.updateEntity(XzxkUser);
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void updateEntity(Serializable object) throws TSDBException {
		dbWrapper.update(object);
	}

	/**
	 * updateEntity -----举例：db.updateEntity(XzxkUser);
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void updateEntity(Object[] objects) throws TSDBException {
		dbWrapper.update(objects);
	}

	/**
	 * removeEntity
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 */
	public void removeEntity(Class clazz, Serializable id) throws TSDBException {
		dbWrapper.removeById(clazz, ((Long) id).intValue());
	}

	/**
	 * removeEntity
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 */
	public void deleteEntity(Serializable object) throws TSDBException {
		dbWrapper.delete(object);
	}

	/**
	 * queryList
	 * 
	 * @param sql
	 *            Serializable
	 * @throws TSDBException
	 * @return List
	 */
	public List queryList(String sql) throws TSDBException {
		List list = null;
		try {
			list = dbWrapper.query(sql);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception ", ex);
			throw new TSDBException(" DBWrapper query error !", ex);
		}

		return list;
	}

	/**
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void addEntity(Serializable[] object) throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.insertOrUpdate(object);
	}

	/**
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void addOrUpdateEntity(Serializable[] object) throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.insertOrUpdate(object);
	}

	/**
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void updateEntity(Serializable[] object) throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.update(object);

	}

	/**
	 * 
	 * @param sql
	 *            Serializable
	 * @param pageSize
	 *            Serializable
	 * @param pageNumber
	 *            Serializable
	 * @throws TSDBException
	 * @return List
	 */
	public List queryList(String sql, int pageSize, int pageNumber) throws TSDBException {

		List list = null;
		try {
			list = dbWrapper.query(sql, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception " + ex.getMessage());
			throw new TSDBException(" DBWrapper query error !" + ex);
		}

		return list;
	}

	/**
	 * queryList
	 * 
	 * @param sql
	 *            Serializable
	 * @param objs
	 *            Serializable[]
	 * @param types
	 *            Serializable[]
	 * @param pageSize
	 *            Serializable
	 * @param pageNumber
	 *            Serializable
	 * @return List
	 */
	public List queryList(String sql, Object[] objs, Type[] types, int pageSize, int pageNumber) throws TSDBException {

		List list = new ArrayList();
		try {
			list = dbWrapper.query(sql, objs, types, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception " + ex.getMessage());
			throw new TSDBException(" DBWrapper query error !" + ex);
		}

		return list;
	}

	/**
	 * queryListSize
	 * 
	 * @param sql
	 *            Serializable
	 * @param objs
	 *            Serializable[]
	 * @param types
	 *            Serializable[]
	 * @return int
	 */
	public int queryListSize(String sql, Object[] objs, Type[] types) throws TSDBException {
		int count = dbWrapper.count(sql, types, objs);
		return count;
	}

	/**
	 * queryListSize
	 * 
	 * @param sql
	 *            Serializable
	 * @param objs
	 *            Serializable[]
	 * @param types
	 *            Serializable[]
	 * @return int
	 */
	public int queryListSize(String sql) throws TSDBException {
		int count = dbWrapper.count(sql);
		return count;
	}

	public List query(String queryHql, String countHql, Object[] params, Type[] types, Page page) throws TSDBException {
		int count = 0;
		if (page.getTotalCount() < 0) {
			count = queryListSize(countHql, params, types);
			page.setTotalCount(count);
		} else {
			count = page.getTotalCount();
		}

		if (count == 0) {
			return new ArrayList();
		}

		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return dbWrapper.query(queryHql, params, types, pageSize, (pageNumber - 1));
	}

	public List query(String queryHql, String countHql, Page page) throws TSDBException {
		int count = 0;
		if (page.getTotalCount() < 0) {
			count = queryListSize(countHql);
			page.setTotalCount(count);
		} else {
			count = page.getTotalCount();
		}

		if (count == 0) {
			return new ArrayList();
		}
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return dbWrapper.query(queryHql, pageSize, (pageNumber - 1));
	}

	/**
	 * 获取当前 'sql'的分页结果集
	 * 
	 * @param page
	 * @param db
	 * @param sSql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public static ResultSet getPageResult(Page page, DBWrapper db, String sSql, String countSql) throws HibernateException, SQLException {

		ResultSet rs = null;
		int count = 0;

		try {
			rs = db.executeQuery(countSql);
			if (rs != null) {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			count = 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
				;
			}

		}

		page.setTotalCount(count);

		CachedRowSet cachedrowset = null;
		ResultSet rs1 = null;

		try {
			// int pageSize = page.getPageSize();
			// int pageNumber = page.getCurrentPage();
			// if (page.getPageCount() <= page.getCurrentPage()) {
			// pageNumber = page.getPageCount();
			// }

			int end = page.getCurrentPage() * page.getPageSize();
			int start = end - page.getPageSize();

			// String sql ="select * from (" +sSql + " ) tt where rownum<="
			// +end;

			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" SELECT tt.* FROM ( ");
			sbSql.append(" SELECT ROWNUM AS ORDERID, t.* FROM ( ");
			sbSql.append(sSql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(start);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			Logger.info("########### sql:" + sbSql.toString());

			rs1 = db.executeQuery(sbSql.toString());
			//          
			// if(start >0)
			// rs1.absolute(start);
			//          
			cachedrowset = new CachedRowSet();
			cachedrowset.populate(rs1);

		} catch (Exception e) {
			cachedrowset = null;
		} finally {
			if (rs1 != null)
				rs1.close();
		}

		return cachedrowset;
	}

	/**
	 * 获取当前 'sql'的结果集
	 * 
	 * @param db
	 * @param sSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public static ResultSet getResult(DBWrapper db, String sSql) throws HibernateException, SQLException {
		return db.executeQuery(sSql.toString());
	}

	public abstract class SessionDao {

		public abstract Object crud(Session sn) throws HibernateException;

		public Object commit() throws TSDBException {
			Session sn = null;
			Transaction tx = null;
			Object aObj = null;
			TSDBException tsdbe = null;
			try {
				sn = getDBWrapper().openSession();
				tx = sn.beginTransaction();
				aObj = crud(sn);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					try {
						tx.rollback();
					} catch (HibernateException e1) {
						Logger.warn("rollback", e);
					}
				}
				tsdbe = new TSDBException(e);
			} finally {
				if (sn != null)
					try {
						sn.close();
					} catch (HibernateException e1) {
						Logger.warn("close session", e1);
					}
			}

			if (tsdbe != null)
				throw tsdbe;
			return aObj;
		}
	}

	private boolean hasUseFlag(Object obj) {
		try {
			BeanUtils.getProperty(obj, "useFlag");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			return false;
		}
		return true;
	}

	/**
	 * 得到指定ID的对象
	 * 
	 * @param clazz
	 * @param id
	 * @param userFlag
	 * @return
	 * @throws TSDBException
	 */
	public Object get(Class clazz, Long id, Byte userFlag) throws TSDBException {
		try {
			if (id != null)
				return checkObject(dbWrapper.load(clazz, id.longValue()), userFlag);
			else
				return null;
		} catch (TSDBException e) {
			return null;
		}
	}

	private Serializable setUseFlag(Serializable object, Byte useFlag) {
		if (object != null) {
			try {
				BeanUtils.setProperty(object, "useFlag", useFlag);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return object;
		}
		return object;
	}

	/**
	 * hibernate 分页
	 * 
	 * @param page
	 * @param sSql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 */
	public List getPageList(Page page, String sSql, String countSql) throws HibernateException {

		List ptList = null;
		if (page != null) {
			ptList = query(sSql, countSql, page);
		} else {
			ptList = dbWrapper.query(sSql);
		}

		return ptList;

	}

	/**
	 * sql 分页
	 * 
	 * @param page
	 * @param sSql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public ResultSet getPageResult(Page page, String sSql, String countSql) {

		ResultSet rs = null;
		try {
			if (page != null) {
				rs = getPageResult(page, dbWrapper, sSql, countSql);
			} else {
				rs = dbWrapper.executeQuery(sSql);
			}
		} catch (Exception e) {

		}
		return rs;

	}

	/**
	 * sql 执行'删除操作'
	 * 
	 * @param sSql
	 * @return
	 * @throws Exception
	 */
	public int deleteForSQL(String sSql) throws Exception {
		int b = dbWrapper.executeUpdate(sSql);
		return b;
	}

	/**
	 * 判断当前数据的使用标志是否与传入的相同
	 * 
	 * @param object
	 * @param userFlag
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Object checkObject(Object object, Byte useFlag) {
		if (useFlag == null)
			return object;
		if (object != null) {
			if (hasUseFlag(object)) {
				try {
					String flag = BeanUtils.getProperty(object, "useFlag");
					if (flag != null) {
						if (useFlag.equals(new Byte(flag)))
							return object;
						else
							return null;
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			} else
				return object;
		}
		return null;
	}

	/**
	 * 
	 * <p>
	 * 功能描述：[方法功能描述]
	 * </p>
	 * 
	 * @param firsType
	 * @param obj
	 * @return
	 * @author:xufeng
	 * @update:[日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private String getColumnValue(String firsType, Object obj) {

		String value = "";
		String daDate = "";
		StringBuffer buffer = new StringBuffer(700000);
		if (firsType.equals("TIMESTAMP")) {
			TIMESTAMP tt = (TIMESTAMP) obj;
			try {
				Timestamp ts = tt.timestampValue();
				Date date = new Date(ts.getTime());
				daDate = this.dateToString(date);
				value = daDate;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (firsType.equals("CLOB")) {
			try {
				java.sql.Clob clob = (java.sql.Clob) obj;

				Reader reader = clob.getCharacterStream();
				char[] b = new char[4096];
				int i = 0;
				while ((i = reader.read(b)) != -1) {
					buffer.append(b, 0, i);
				}
				value = buffer.toString();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (firsType.equals("BLOB")) {
			InputStream input = null;
			try {
				java.sql.Blob clob = (java.sql.Blob) obj;
				input = clob.getBinaryStream();
				int i = 0;
				byte[] b = new byte[4096];
				while (input.read(b) != -1) {
					buffer.append(b);
				}
				value = buffer.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			value = String.valueOf(obj);
		}

		return value;

	}

	public String getChangeColumn(String columnName) {
		String newStr = "";
		char separator = "_".charAt(0);
		/**
		 * 记录分隔符的位置
		 */
		int position = 0;
		for (int i = 0; i < columnName.length(); i++) {
			Character cc = new Character(columnName.charAt(i));
			if (!cc.equals(new Character(separator))) {
				if (i < columnName.length()) {
					if (i == position + 1 && position != 0)
						newStr += String.valueOf(cc).toUpperCase();// 将分隔符后一位大写
					else
						newStr += String.valueOf(cc);
				}
			} else {
				position = i;
			}
		}

		return newStr;
	}

	public static String dateToString(Date s) {
		String pattrrn = "yyyy-MM-dd";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattrrn);
			return sdf.format(s);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * <p>
	 * 功能描述：[查询结果生成hashMap]
	 * </p>
	 * 
	 * @param rs
	 * @return
	 * @throws Exception
	 * @author:new
	 * @update:[日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public List getListHashMap(ResultSet rs) throws Exception {

		StringBuffer buff = new StringBuffer();
		List list = new ArrayList();
		try {
			while (rs.next()) {
				ResultSetMetaData pmd = rs.getMetaData();

				String columnName = "";
				String values = "";
				HashMap map = new HashMap();
				for (int i = 1; i <= pmd.getColumnCount(); i++) {
					columnName = pmd.getColumnName(i);

					values = this.getColumnValue(pmd.getColumnTypeName(i), rs.getObject(i));
					map.put(this.getChangeColumn(columnName.toLowerCase()), values);
					columnName = "";
					values = "";

				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("sql结果出现错误！");
		} finally {
			rs.close();
		}

		return list;
	}

	/**
	 * <p>
	 * 功能描述：[单条查询结果生成hashMap]
	 * </p>
	 * 
	 * @param rs
	 * @return
	 * @throws Exception
	 * @author:new
	 * @update:[日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public HashMap getSingleHashMap(ResultSet rs) throws Exception {
		StringBuffer buff = new StringBuffer();
		List list = new ArrayList();
		HashMap map = new HashMap();
		try {

			ResultSetMetaData pmd = rs.getMetaData();
			rs.last();
			int row = rs.getRow();
			String columnName = "";
			String values = "";

			if (row == 1) {
				for (int i = 1; i <= pmd.getColumnCount(); i++) {
					columnName = pmd.getColumnName(i);
					values = this.getColumnValue(pmd.getColumnTypeName(i), rs.getObject(i));

					map.put(columnName.toLowerCase(), values);
					columnName = "";
					values = "";

				}

			}

		} catch (SQLException e) {
			throw new Exception("sql结果出现错误！");
		} finally {
			rs.close();
		}

		return map;
	}

	/**
	 * 获取当前 'sql'的分页结果集
	 * 
	 * @param page
	 * @param db
	 * @param sSql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public static ResultSet getPageResult(Page page, Connection con, String sSql, String countSql) throws HibernateException, SQLException {
		Statement st = null;
		ResultSet rs = null;
		int count = 0;

		try {
			st = con.createStatement();
			Logger.info("############### countSql:" + countSql);
			rs = st.executeQuery(countSql);
			if (rs != null) {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			count = 0;
		} finally {
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
				;
			}

		}

		page.setTotalCount(count);

		CachedRowSet cachedrowset = null;
		Statement st1 = null;
		ResultSet rs1 = null;

		try {
			int end = page.getCurrentPage() * page.getPageSize();
			int start = end - page.getPageSize();

			Logger.info("####### currentPage:" + page.getCurrentPage());
			Logger.info("####### pageSize:" + page.getPageSize());
			Logger.info("####### start:" + start);
			Logger.info("####### end:" + end);

			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" SELECT tt.* FROM ( ");
			sbSql.append(" SELECT ROWNUM AS ORDERID, t.* FROM ( ");
			sbSql.append(sSql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(start);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			Logger.info("####### sql:" + sbSql);

			st1 = con.createStatement();
			rs1 = st1.executeQuery(sbSql.toString());
			cachedrowset = new CachedRowSet();
			cachedrowset.populate(rs1);

		} catch (Exception e) {
			cachedrowset = null;
		} finally {
			if (st1 != null)
				st1.close();
			if (rs1 != null)
				rs1.close();
		}

		return cachedrowset;
	}

	/**
	 * 获取当前 'sql'的结果集
	 * 
	 * @param db
	 * @param sSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public static ResultSet getResult(Connection con, String sSql) throws HibernateException, SQLException {
		Statement st = null;
		ResultSet rs = null;
		CachedRowSet cachedrowset = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sSql);

			cachedrowset = new CachedRowSet();
			cachedrowset.populate(rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
		return cachedrowset;
	}
}
