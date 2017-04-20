package com.topsuntech.gUnit.common.web.util;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.type.Type;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;



public abstract class DAOBase {	
	protected Log logger = LogFactory.getLog(getClass());
	protected DBWrapper dbWrapper;

	
	/**
	 * @param schema
	 */
	public DAOBase(String schema) {
		dbWrapper = DBRegistry.getDBWrapper(schema);
	}
	


	/**
	 * @return DBWrapper
	 */
	public DBWrapper getDBWrapper() {
		return dbWrapper;
	}

	// ����Ϊͨ�÷���
	/**
	 * ����һ��ʵ����Ϣ
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void addEntity(Serializable object) throws TSDBException {
		dbWrapper.insert(object);
	}

	/**
	 * ���ӻ��߸���һ��ʵ����Ϣ
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void addOrUpdateEntity(Serializable object) throws TSDBException {
		dbWrapper.insertOrUpdate(object);
	}

	/**
	 * ���ӻ��߸���һ��ʵ����Ϣ����������������
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void addOrUpdateEntityForExchange(Serializable object)
			throws TSDBException {
		dbWrapper.insertOrUpdate(object);

	}

	/**
	 * �õ�һ��ʵ����Ϣ -----������(XzxkUser) db.getEntity(XzxkUser.class, new
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
	 * ����һ��ʵ����Ϣ ������db.updateEntity(XzxkUser);
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void updateEntity(Serializable object) throws TSDBException {
		dbWrapper.update(object);
	}

	/**
	 * ����һ��ʵ����Ϣ������������ ������db.updateEntity(XzxkUser);
	 * 
	 * @param object
	 *            Serializable
	 * @throws TSDBException
	 */
	public void updateEntityForExchange(Serializable object)
			throws TSDBException {
		dbWrapper.update(object);

	}

	/**
	 * ɾ��һ��ʵ����Ϣ
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 */
	public void delete(Class clazz, Serializable id) throws TSDBException {
		dbWrapper.removeById(clazz, ((Long) id).intValue());
	}

	/**
	 * ɾ��һ��ʵ����Ϣ
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 */
	public boolean delete(Serializable obj) throws TSDBException {
		return dbWrapper.delete(obj);
	}

	/**
	 * ɾ��һ��ʵ����Ϣ��������ͬ��ɾ��
	 * 
	 * @param clazz
	 *            Class
	 * @param id
	 *            Serializable
	 * @throws TSDBException
	 */
	public void removeEntityForExchange(Class clazz, Serializable id)
			throws TSDBException {
		dbWrapper.removeById(clazz, ((Long) id).intValue());

	}

	/**
	 * 
	 * @param queryHql
	 * @param countHql
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List query(String queryHql, String countHql, Page page)
			throws TSDBException {
		int count = 0;
		//if (page.getTotalCount() < 0) {
			count = queryListSize(countHql);
			page.setTotalCount(count);
		//} else {
		//	count = page.getTotalCount();
		//}

		if (count == 0) {
			return new ArrayList();
		}
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page
				.getPageCount() : page.getCurrentPage();
		return dbWrapper.query(queryHql, pageSize, (pageNumber - 1));
	}

	/**
	 * �õ��������������е�ʵ���б�
	 * 
	 * @param sql
	 *            Serializable
	 * @throws TSDBException
	 * @return List
	 */
	public List queryList(Serializable sql) throws TSDBException {
		String strSQL = "";
		if (!(sql instanceof String)) {
			throw new TSDBException(" sql error !");
		} else {
			strSQL = (String) sql;
		}

		List list = null;
		try {
			list = dbWrapper.query(strSQL);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception ", ex);
			throw new TSDBException(" DBWrapper query error !", ex);
		}

		return list;
	}

	/**
	 * ���һ��ʵ�����
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
	 * ���һ��ʵ����𲢽���������
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void addEntityForExchange(Serializable[] object)
			throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.insertOrUpdate(object);

	}

	/**
	 * ��ӻ��߸���һ��ʵ��
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
	 * ��ӻ��߸���һ��ʵ�壬��������һ��
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void addOrUpdateEntityForExchange(Serializable[] object)
			throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.insertOrUpdate(object);

	}

	/**
	 * ����һ��ʵ��
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
	 * ����һ��ʵ�岢������������Ϣ
	 * 
	 * @param object
	 *            Serializable[]
	 * @throws TSDBException
	 */
	public void updateEntityForExchange(Serializable[] object)
			throws TSDBException {
		if (object == null) {
			return;
		}
		dbWrapper.update(object);

	}

	/**
	 * �õ�����������ʵ���б�
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
	public List queryList(Serializable sql, int pageSize, int pageNumber)
			throws TSDBException {
		String strSQL = "";
		if (!(sql instanceof String)) {
			throw new TSDBException(" sql error !");
		} else {
			strSQL = (String) sql;
		}

		List list = null;
		try {
			list = dbWrapper.query(strSQL, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception " + ex.getMessage());
			throw new TSDBException(" DBWrapper query error !" + ex);
		}

		return list;
	}

	/**
	 * �õ�����������ʵ���б��еĸ���
	 * 
	 * @param sql
	 *            Serializable
	 * @return int
	 */
	public int queryListSize(Serializable sql) throws TSDBException {

		List list = dbWrapper.query((String) sql);
		return (list != null && list.size() != 0) ? ((Integer) list.get(0))
				.intValue() : 0;
	}

	/**
	 * �õ�����������ʵ���б���ҳ��ʾ��
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
	public List queryList(Serializable sql, Object[] objs, Type[] types,
			int pageSize, int pageNumber) throws TSDBException {
		String strSQL = "";
		if (!(sql instanceof String)) {
			throw new TSDBException(" sql error !");
		} else {
			strSQL = (String) sql;
		}

		List list = null;
		try {
			list = dbWrapper.query(strSQL, objs, types, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception " + ex.getMessage());
			throw new TSDBException(" DBWrapper query error !" + ex);
		}

		return list;
	}

	/**
	 * �õ�����������ʵ���б�
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
	public List queryList(Serializable sql, Object[] objs, Type[] types)
			throws TSDBException {
		String strSQL = "";
		if (!(sql instanceof String)) {
			throw new TSDBException(" sql error !");
		} else {
			strSQL = (String) sql;
		}

		List list = null;
		try {
			list = dbWrapper.query(strSQL, objs, (Type[]) types

			);
		} catch (HibernateException ex) {
			Logger.error(" DBWrapper query list Exception " + ex.getMessage());
			throw new TSDBException(" DBWrapper query error !" + ex);
		}

		return list;
	}

	/**
	 * �õ�����������ʵ��ĸ���
	 * 
	 * @param sql
	 *            Serializable
	 * @param objs
	 *            Serializable[]
	 * @param types
	 *            Serializable[]
	 * @return int
	 */
	public int queryListSize(Serializable sql, Serializable[] objs,
			Serializable[] types) throws TSDBException {
		List list = dbWrapper.query((String) sql, objs, (Type[]) types);
		return (list != null && list.size() != 0) ? ((Integer) list.get(0))
				.intValue() : 0;
	}

	/**
	 * ���ô洢����ɾ������ʵ�������ʵ��
	 * 
	 * @throws HibernateException
	 * @throws
	 */
	public void deleteAll(String procedureName, String objectId)
			throws HibernateException {
		Session session = null;
		Transaction tx = null;
		try {
			session = dbWrapper.openSession();
			tx = session.beginTransaction();
			Connection con = session.connection();
			String procedure = "{call " + procedureName + "(?) }";
			CallableStatement cstmt = con.prepareCall(procedure);
			cstmt.setString(1, objectId);
			cstmt.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			Logger.debug("\n\n=================" + e.getMessage());
		} catch (SQLException se) {
			Logger.debug("\n\n=================" + se.getMessage());
		} finally {
			if (tx != null) {
				tx = null;
			}
			session.close();
		}

	}

	/**
	 * ����ʵ���ѯ�����б�Թ�˾������
	 */
	public List query(Class class1, Criterion criterion) throws TSDBException {

		return dbWrapper.query(class1, criterion);
	}
	
	public List querySql(String sql) throws TSDBException {

		return dbWrapper.query(sql);
	}

	/**
	 * ���ݶ��������ѯ�б�
	 * 
	 * @param class1
	 * @param map
	 * @return
	 * @throws HibernateException
	 * @throws TSDBException
	 */
	public List query(Class class1, Map map) throws HibernateException {
		Criteria criteria = dbWrapper.openSession().createCriteria(class1);		
		if (map != null && !map.isEmpty()) {
			Set keys = map.entrySet();
			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				Map.Entry value = (Map.Entry) iter.next();
				if (StringUtils.isNotBlank((String) value.getKey()))
					criteria.add(Expression.eq((String) value.getKey(), value
							.getValue()));
			}
		}
		return criteria.list();
	}

	/**
	 * ����Map��ʽ��ѯ����.
	 * 
	 * @throws HibernateException
	 */
	public void criteriaMap(Criteria criteria, Map filter) {
		if (filter != null && !filter.isEmpty()) {
			Set keys = filter.entrySet();
			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				Map.Entry value = (Map.Entry) iter.next();
				if (StringUtils.isNotBlank((String) value.getKey()))
					criteria.add(Expression.eq((String) value.getKey(), value
							.getValue()));
			}

		}

	}

	/**
	 * �ж϶���ĳ�е�ֵ�����ݿ��в������ظ�
	 * 
	 * @param names
	 *            ��POJO�����Ӧ��������,�����ʱ�Զ��ŷָ�<br>
	 *            ��"name,loginid,password"
	 * @throws HibernateException
	 * @throws net.sf.hibernate.HibernateException
	 * @throws IllegalStateException
	 * @throws Exception
	 */

	public boolean isNotUnique(Object entity, String names, String exclude)
			throws Exception {
		Assert.hasText(names);

		Criteria criteria = dbWrapper.openSession().createCriteria(entity.getClass());
		String[] nameList = names.split(",");
		try {
			for (int i = 0; i < nameList.length; i++) {

				if (nameList[i].equalsIgnoreCase(exclude)) {
					continue;
				}
				criteria.add(Expression.eq(nameList[i], PropertyUtils
						.getProperty(entity, nameList[i])));

			}
			// ���Ԫ����
			String keyName = dbWrapper.getIdentifier(entity.getClass());
			if (keyName != null) {
				Object id = PropertyUtils.getProperty(entity, keyName);
				// �����update,�ų�����
				if (id != null)
					criteria.add(Expression.not(Expression.eq(keyName, id)));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		List queryList = criteria.list();

		return queryList.size() > 0 ? true : false;
	}

	/**
	 * �ж϶���ĳ�е�ֵ�����ݿ��в������ظ�
	 * 
	 * @param names
	 *            ��POJO�����Ӧ��������,�����ʱ�Զ��ŷָ�<br>
	 *            ��"name,loginid,password" exclude POJOû��ӳ�������ݱ���ֶ�
	 *            ���:pojo����endDate û�к����ݿ��Ӧ���ֶ�
	 * @throws Exception
	 * @throws HibernateException
	 * @throws net.sf.hibernate.HibernateException
	 * @throws IllegalStateException
	 * @throws Exception
	 */

	public boolean isNotUnique(Object entity, String names) throws Exception {
		return isNotUnique(entity, names, "");

	}

	/**
	 * ����Criteria����������Ĭ�Ϻ���.�ɹ�������ѯ��������
	 * 
	 * @param criteria
	 *            Criteriaʵ��.
	 * @param sortMap
	 *            ��������.
	 * @param entity
	 *            entity����,����ʹ�÷�������ȡĳЩ������Ϣ
	 * @throws HibernateException
	 */
	protected void sortCriteria(Criteria criteria, Map sortMap, Object entity)
			throws HibernateException {
		if (!sortMap.isEmpty()) {
			for (Iterator iter = sortMap.entrySet().iterator(); iter.hasNext();) {

				Map.Entry value = (Map.Entry) iter.next();

				String orderType = (String) value.getKey();
				String fieldName = (String) value.getValue();

				// ����Ƕ��������category.name,modify_user.id,��ʱֻ����һ��Ƕ��
				if (fieldName.indexOf('.') != -1) {
					String alias = StringUtils.substringBefore(fieldName, ".");
					String aliasType = alias;
					try {
						aliasType = PropertyUtils.getProperty(entity, alias)
								.getClass().getName();
					} catch (Exception e) {
						logger.error("Get property" + alias + " error");
					}
					criteria.createAlias(aliasType, alias);
				}

				if ("asc".equalsIgnoreCase(orderType)) {
					criteria.addOrder(Order.asc(fieldName));
				} else {
					criteria.addOrder(Order.desc(fieldName));
				}
			}
		}
	}

	/**
	 * ����������������ֵ��ѯ����.
	 * 
	 * @return ���������Ķ����б�
	 * @throws Exception
	 */
	public List findBy(String name, Object value, Class aclass)
			throws Exception {
		Assert.hasText(name);
		Session sesson = dbWrapper.openSession();
		List list = null;
		Criteria criteria = sesson.createCriteria(aclass);
		criteria.add(Expression.eq(name, value));
		
		list = criteria.list();
		sesson.close();
		return list;
	}
	/**
	 * ����������������ֵ��ѯ����.
	 * 
	 * @return ���������Ķ����б�
	 * @throws Exception
	 */
	public Object findByValue(String name, Object value, Class aclass)
			throws Exception {
		
		Assert.hasText(name);
		Session sesson = dbWrapper.openSession();		
		Criteria criteria = sesson.createCriteria(aclass);
		criteria.add(Expression.eq(name, value));		
		Object obj = criteria.uniqueResult();
		sesson.close();
		return obj;
	}
	/**
	 * ����������������ֵ��,�ָ����Ҷ��ֵ��ʽ��ѯ����.
	 * 
	 * 
	 * @throws HibernateException
	 */
	public List findByEqMore(String[] tempstr, Object[] obj ,Class aclass)
			throws HibernateException {
		List list =null;
		Session sesson = dbWrapper.openSession();
		Criteria criteria = sesson.createCriteria(aclass);
		for (int i = 0; i < tempstr.length; i++) {
			criteria.add(Expression.eq(tempstr[i], obj[i]));
		}	
		list= criteria.list();
		sesson.close();
		return list;
	}

	

	/**
	 * ����Criteria����.
	 * 
	 * @param criterions
	 *            �ɱ��Restrictions�����б�,��{@link #createQuery(String,Object...)}
	 * @throws HibernateException
	 */
	public Criteria createCriteria(Class entityClass, Criterion[] criterion)
			throws HibernateException {

		Criteria criteria = dbWrapper.openSession().createCriteria(entityClass);
		for (int i = 0; i < criterion.length; i++) {
			criteria.add(criterion[i]);
		}
		return criteria;
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

	public List query(String queryHql, Object[] params, Type[] types)
			throws TSDBException {
		return dbWrapper.query(queryHql, params, types);
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
	 * ȥ��hql��select �Ӿ䣬δ����union�����,����pagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	protected  String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	
	/**
	 * ִ��SQL���
	 * 
	 * @throws HibernateException
	 * @throws
	 */
	public void executeSql(String sql)
			throws HibernateException {
		Session session =  null;
		Transaction tx = null;
		try {
			session = dbWrapper.openSession();
			tx = session.beginTransaction();
			Connection con = session.connection();
			con.createStatement().execute(sql);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (tx != null) {
				tx = null;
			}
			session.close();
		}

	}
}