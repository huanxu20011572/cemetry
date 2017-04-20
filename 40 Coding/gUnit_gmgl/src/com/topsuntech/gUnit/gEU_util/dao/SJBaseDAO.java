/**
 * #Title: gEU_bjdb
 * #Company: 清华紫光·数字政府事业部
 * #datetime: 2007 2007-11-19 下午03:09:45
 * #author: jiangtao
 */
package com.topsuntech.gUnit.gEU_util.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;
import sun.jdbc.rowset.CachedRowSet;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;


/**
 * @author jt[bjsj]
 *
 */


public class SJBaseDAO {

	private DBWrapper dbWrapper;

	private final static String DEFAULT_SCHEMA = "gos";

	public SJBaseDAO() {
		this(DEFAULT_SCHEMA);
	}

	public SJBaseDAO(String schema) {
		dbWrapper = DBRegistry.getDBWrapper(schema);
	}

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
	public List queryList(String sql, int pageSize, int pageNumber)
			throws TSDBException {

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
	public List queryList(String sql, Object[] objs, Type[] types,
			int pageSize, int pageNumber) throws TSDBException {

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
	public int queryListSize(String sql, Object[] objs, Type[] types)
			throws TSDBException {
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

	public List query(String queryHql, String countHql, Object[] params,
			Type[] types, Page page) throws TSDBException {
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
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page
				.getPageCount() : page.getCurrentPage();
		return dbWrapper.query(queryHql, params, types, pageSize,
				(pageNumber - 1));
	}

	public List query(String queryHql, String countHql, Page page)
            throws TSDBException {
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
        int pageNumber = page.getPageCount() < page.getCurrentPage() ? page
                .getPageCount() : page.getCurrentPage();
        return dbWrapper.query(queryHql, pageSize, (pageNumber - 1));
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
	public static ResultSet getPageResult(Page page, DBWrapper db, String sSql,
			String countSql) throws HibernateException, SQLException {
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
			int end = page.getCurrentPage() * page.getPageSize();
			int start = end - page.getPageSize();
			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" SELECT tt.* FROM ( ");
			sbSql.append(" SELECT ROWNUM AS ORDERID, t.* FROM ( ");
			sbSql.append(sSql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(start);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			rs1 = db.executeQuery(sbSql.toString());
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
	public static ResultSet getResult(DBWrapper db, String sSql)
			throws HibernateException, SQLException {
		return db.executeQuery(sSql.toString());
	}

	
}
