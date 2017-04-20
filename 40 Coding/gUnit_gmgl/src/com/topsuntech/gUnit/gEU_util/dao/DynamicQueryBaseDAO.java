/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;

/**
 * @author zcpeng
 * 
 */
public class DynamicQueryBaseDAO extends FactoryDAO {
	private DBWrapper dbWrapper;

	private final static String DEFAULT_SCHEMA = "dynamicquery";

	public DynamicQueryBaseDAO() {
		this(DEFAULT_SCHEMA);
	}

	public DynamicQueryBaseDAO(String schema) {
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
}
