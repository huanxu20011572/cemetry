/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.sql.RowSet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sun.jdbc.rowset.CachedRowSet;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.NullType;
import com.topsuntech.gOS.query.TSDBException;

/**
 * @author zcpeng
 * 
 */
@Repository
public class BaseDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 未使用
	 */
	public static final int LIKE_ALL = 0;
	/**
	 * 未使用
	 */
	public static final int LIKE_LEFT = 1;
	/**
	 * 未使用
	 */
	public static final int LIKE_RIGHT = 2;
	/**
	 * 未使用
	 */
	public static final String LIKE_SIGN = "%";

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public Session openSession() {
		return hibernateTemplate.getSessionFactory().openSession();
	}

	/**
	 * 保存对象
	 * 
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	public Serializable save(Object entity) throws HibernateException {
		return hibernateTemplate.save(entity);
	}

	/**
	 * 保存对象
	 * 
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	public Serializable save(String entityName, Object entity) throws HibernateException {
		return hibernateTemplate.save(entityName, entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void update(Object entity) throws HibernateException {
		hibernateTemplate.update(entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param entity
	 * @param lockMode
	 * @throws HibernateException
	 */
	public void update(Object entity, LockMode lockMode) throws HibernateException {
		hibernateTemplate.update(entity, lockMode);
	}

	/**
	 * 更新对象
	 * 
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param entity
	 * @throws HibernateException
	 */
	public void update(String entityName, Object entity) throws HibernateException {
		hibernateTemplate.update(entityName, entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param entityName映射中
	 *            <class>配置的entity-name
	 * @param entity
	 * @param lockMode
	 * @throws HibernateException
	 */
	public void update(String entityName, Object entity, LockMode lockMode) throws HibernateException {
		hibernateTemplate.update(entityName, entity, lockMode);
	}

	/**
	 * 保存或更新对象(不确定对象持久/游离状态使用)
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void saveOrUpdate(Object entity) throws HibernateException {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * 保存或更新对象
	 * 
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param entity
	 * @throws HibernateException
	 */
	public void saveOrUpdate(String entityName, Object entity) throws HibernateException {
		hibernateTemplate.saveOrUpdate(entityName, entity);
	}

	/**
	 * 保存或更新所有对象
	 * 
	 * @param entities
	 */
	public void saveOrUpdateAll(Collection<?> entities) throws HibernateException {
		hibernateTemplate.saveOrUpdateAll(entities);
	}

	/**
	 * 删除对象
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void delete(Object entity) throws HibernateException {
		hibernateTemplate.delete(entity);
	}

	/**
	 * 删除对象
	 * 
	 * @param entity
	 * @param lockMode
	 * @throws HibernateException
	 */
	public void delete(Object entity, LockMode lockMode) throws HibernateException {
		hibernateTemplate.delete(entity);
	}

	/**
	 * 删除对象
	 * 
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param entity
	 * @throws HibernateException
	 */
	public void delete(String entityName, Object entity) throws HibernateException {
		hibernateTemplate.delete(entityName, entity);
	}

	/**
	 * 删除对象
	 * 
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param entity
	 * @param lockMode
	 * @throws HibernateException
	 */
	public void delete(String entityName, Object entity, LockMode lockMode) throws HibernateException {
		hibernateTemplate.delete(entityName, entity, lockMode);
	}

	/**
	 * 删除所有对象
	 * 
	 * @param entities
	 * @throws HibernateException
	 */
	public void deleteAll(Collection<?> entities) throws HibernateException {
		hibernateTemplate.deleteAll(entities);
	}

	/**
	 * 读取对象
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Object load(Class<?> entityClass, Serializable id) throws HibernateException {
		return hibernateTemplate.load(entityClass, id);
	}

	/**
	 * 读取对象
	 * 
	 * @param entityName
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Object load(String entityName, Serializable id) throws HibernateException {
		return hibernateTemplate.load(entityName, id);
	}

	/**
	 * 读取对象
	 * 
	 * @param entityClass
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws HibernateException
	 */
	public Object load(Class<?> entityClass, Serializable id, LockMode lockMode) throws HibernateException {
		return hibernateTemplate.load(entityClass, id, lockMode);
	}

	/**
	 * 读取对象
	 * 
	 * @param entityName
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws HibernateException
	 */
	public Object load(String entityName, Serializable id, LockMode lockMode) throws HibernateException {
		return hibernateTemplate.load(entityName, id, lockMode);
	}

	/**
	 * 读取所有对象
	 * 
	 * @param entityClass
	 * @return
	 * @throws HibernateException
	 */
	public List<?> loadAll(Class<?> entityClass) throws HibernateException {
		return (List<?>) hibernateTemplate.loadAll(entityClass);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * find("from Object c")
	 * 
	 * @param queryString
	 * @return
	 * @throws HibernateException
	 */
	public List<?> find(String queryString) throws HibernateException {
		return (List<?>) hibernateTemplate.find(queryString);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * find("from Object c where c.name = ?", name);
	 * 
	 * @param queryString
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public List<?> find(String queryString, Object value) throws HibernateException {
		return (List<?>) hibernateTemplate.find(queryString, value);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * find("from Object c where c.name=? and c.password = ?", new
	 * String[]{name, password})
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 * @throws HibernateException
	 */
	public List<?> find(String queryString, Object[] values) throws HibernateException {
		return (List<?>) hibernateTemplate.find(queryString, values);
	}

	/**
	 * 查询列表
	 * 
	 * eg: <br>
	 * User user = new User(); <br>
	 * user.setName("name"); <br>
	 * user.setPassword("pasword");<br>
	 * findByExample(user);
	 * 
	 * @param exampleEntity
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByExample(Object exampleEntity) throws HibernateException {
		return (List<?>) hibernateTemplate.findByExample(exampleEntity);
	}

	/**
	 * 查询列表
	 * 
	 * @see eg:this{@link #findByExample(Object)}
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param exampleEntity
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByExample(String entityName, Object exampleEntity) throws HibernateException {
		return (List<?>) hibernateTemplate.findByExample(entityName, exampleEntity);
	}

	/**
	 * 查询列表
	 * 
	 * @see eg:this{@link #findByExample(Object)}
	 * @param exampleEntity
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByExample(Object exampleEntity, int firstResult, int maxResults) throws HibernateException {
		return hibernateTemplate.findByExample(exampleEntity, firstResult, maxResults);
	}

	/**
	 * 查询列表
	 * 
	 * @see eg:this{@link #findByExample(Object)}
	 * @param entityName
	 *            映射中<class>配置的entity-name
	 * @param exampleEntity
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByExample(String entityName, Object exampleEntity, int firstResult, int maxResults) throws HibernateException {
		return hibernateTemplate.findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * findByNamedParam("from User where name =: username", "username", "name");
	 * 
	 * @param queryString
	 * @param paramName
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedParam(String queryString, String paramName, Object value) throws HibernateException {
		return hibernateTemplate.findByNamedParam(queryString, paramName, value);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * findByNamedParam(
	 * "from User where name =: username and password =: password", new
	 * String[]{"username","password"}, new String[]{"admin","123"});
	 * 
	 * @param queryString
	 * @param paramNames
	 * @param values
	 * @return
	 * @throws HibernateException
	 */
	public List<?> find(String queryString, String[] paramNames, Object[] values) throws HibernateException {
		return hibernateTemplate.findByNamedParam(queryString, paramNames, values);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user]]><br>
	 * </query><br>
	 * 
	 * findByNamedQuery("all")
	 * 
	 * @param queryName
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQuery(String queryName) throws HibernateException {
		return hibernateTemplate.findByNamedQuery(queryName);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user where name = ?]]><br>
	 * </query><br>
	 * 
	 * findByNamedQuery("all", "username")
	 * 
	 * @param queryName
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQuery(String queryName, Object value) throws HibernateException {
		return hibernateTemplate.findByNamedQuery(queryName, value);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user where name = ? and password = ?]]><br>
	 * </query><br>
	 * 
	 * findByNamedQuery("all", new String[]{"username", "password"})
	 * 
	 * @param queryName
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQuery(String queryName, Object[] values) throws HibernateException {
		return hibernateTemplate.findByNamedQuery(queryName, values);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user where name =: name]]><br>
	 * </query><br>
	 * 
	 * findByNamedQuery("all", "name", "username")
	 * 
	 * @param queryName
	 * @param paramName
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value) throws HibernateException {
		return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, paramName, value);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user where name =: name and password =: pass]]><br>
	 * </query><br>
	 * 
	 * findByNamedQuery("all", new String[]{"name","pass"}, new
	 * String[]{"admin", "123"})
	 * 
	 * @param queryName
	 * @param paramNames
	 * @param values
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) throws HibernateException {
		return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * hbm.xml定义<br>
	 * <query name="all"><br>
	 * <![CDATA[from user where name =: username and password =: password]]><br>
	 * </query><br>
	 * 
	 * User user = new User();<br>
	 * user.setUsername("admin");<br>
	 * user.setPassword("123");<br>
	 * 
	 * findByNamedQueryAndValueBean("all", user);
	 * 
	 * 
	 * @param queryName
	 * @param valueBean
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByNamedQueryAndValueBean(String queryName, Object valueBean) throws HibernateException {
		return hibernateTemplate.findByNamedQueryAndValueBean(queryName, valueBean);
	}

	/**
	 * 查询列表
	 * 
	 * eg:<br>
	 * 
	 * User user = new User();<br>
	 * user.setUsername("admin");<br>
	 * user.setPassword("123");<br>
	 * 
	 * findByValueBean("from User where name =: name and password =: password",
	 * user);
	 * 
	 * @param queryString
	 * @param valueBean
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByValueBean(String queryString, Object valueBean) throws HibernateException {
		return hibernateTemplate.findByValueBean(queryString, valueBean);
	}

	/**
	 * 查询列表
	 * 
	 * @param criteria
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByCriteria(DetachedCriteria criteria) throws HibernateException {
		return hibernateTemplate.findByCriteria(criteria);
	}

	/**
	 * 分页查询列表
	 * 
	 * @param criteria
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws HibernateException
	 */
	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) throws HibernateException {
		return hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
	}

	/**
	 * 批量更新,需要手工清除缓存
	 * 
	 * @param queryString
	 * @return
	 * @throws HibernateException
	 */
	public int bulkUpdate(String queryString) throws HibernateException {
		return hibernateTemplate.bulkUpdate(queryString);
	}

	/**
	 * 批量更新
	 * 
	 * @param queryString
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	public int bulkUpdate(String queryString, Object value) throws HibernateException {
		return hibernateTemplate.bulkUpdate(queryString, value);
	}

	/**
	 * 批量更新
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 * @throws HibernateException
	 */
	public int bulkUpdate(String queryString, Object[] values) throws HibernateException {
		return hibernateTemplate.bulkUpdate(queryString, values);
	}

	/**
	 * 清除缓存
	 * 
	 * @throws HibernateException
	 */
	public void clear() throws HibernateException {
		hibernateTemplate.clear();
	}

	/**
	 * 关闭指定Iterator
	 * 
	 * @param iter
	 * @throws HibernateException
	 */
	public void closeIterator(Iterator<?> iter) throws HibernateException {
		hibernateTemplate.closeIterator(iter);
	}

	/**
	 * 检查Hiberante是否管理Object对象
	 * 
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	public boolean contains(Object entity) throws HibernateException {
		return hibernateTemplate.contains(entity);
	}

	/**
	 * HibernateException to DataAccessException
	 * 
	 * @param ex
	 * @return
	 * @throws HibernateException
	 */
	public DataAccessException convertHibernateAccessException(HibernateException ex) throws HibernateException {
		return hibernateTemplate.convertHibernateAccessException(ex);
	}

	/**
	 * 清除指定对象的缓存
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void evict(Object entity) throws HibernateException {
		hibernateTemplate.evict(entity);
	}

	/**
	 * 查询中启用由createFilter()创建的过滤器
	 * 
	 * @param filterName
	 * @return
	 * @throws HibernateException
	 */
	public Filter enableFilder(String filterName) throws HibernateException {
		return hibernateTemplate.enableFilter(filterName);
	}

	/**
	 * 强制加载关联对象
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void initialize(Object entity) throws HibernateException {
		hibernateTemplate.initialize(entity);
	}

	/**
	 * execute
	 * 
	 * @param action
	 * @return
	 * @throws HibernateException
	 */
	public Object execute(HibernateCallback action) throws HibernateException {
		return hibernateTemplate.execute(action);
	}

	/**
	 * executeFind
	 * 
	 * @param action
	 * @return
	 * @throws HibernateException
	 */
	public List<?> executeFind(HibernateCallback action) throws HibernateException {
		return hibernateTemplate.executeFind(action);
	}

	/**
	 * executeWithNativeSession
	 * 
	 * @param action
	 * @return
	 * @throws HibernateException
	 */
	public Object executeWithNativeSession(HibernateCallback action) throws HibernateException {
		return hibernateTemplate.executeWithNativeSession(action);
	}

	/**
	 * executeWithNewSession
	 * 
	 * @param action
	 * @return
	 * @throws HibernateException
	 */
	public Object executeWithNewSession(HibernateCallback action) throws HibernateException {
		return hibernateTemplate.executeWithNewSession(action);
	}

	/**
	 * 根据id获取对象
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Object get(Class<?> entityClass, Serializable id) throws HibernateException {
		return hibernateTemplate.get(entityClass, id);
	}

	/**
	 * 根据id获取对象
	 * 
	 * @param entityName
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Object get(String entityName, Serializable id) throws HibernateException {
		return hibernateTemplate.get(entityName, id);
	}

	/**
	 * 根据id获取对象
	 * 
	 * @param entityClass
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws HibernateException
	 */
	public Object get(Class<?> entityClass, Serializable id, LockMode lockMode) throws HibernateException {
		return hibernateTemplate.get(entityClass, id, lockMode);
	}

	/**
	 * 根据id获取对象
	 * 
	 * @param entityName
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws HibernateException
	 */
	public Object get(String entityName, Serializable id, LockMode lockMode) throws HibernateException {
		return hibernateTemplate.get(entityName, id, lockMode);
	}

	/**
	 * getEntityInterceptor
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Interceptor getEntityInterceptor() throws HibernateException {
		return hibernateTemplate.getEntityInterceptor();
	}

	/**
	 * getFetchSize
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public int getFetchSize() throws HibernateException {
		return hibernateTemplate.getFetchSize();
	}

	/**
	 * getFilterNames
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public String[] getFilterNames() throws HibernateException {
		return hibernateTemplate.getFilterNames();
	}

	/**
	 * getFLushMode
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public int getFlushMode() throws HibernateException {
		return hibernateTemplate.getFlushMode();
	}

	/**
	 * getJdbcExceptionTranslator
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public SQLExceptionTranslator getJdbcExceptionTranslator() throws HibernateException {
		return hibernateTemplate.getJdbcExceptionTranslator();
	}

	/**
	 * getMaxResults
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public int getMaxResults() throws HibernateException {
		return hibernateTemplate.getMaxResults();
	}

	/**
	 * getQueryCacheRegion
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public String getQueryCacheRegion() throws HibernateException {
		return hibernateTemplate.getQueryCacheRegion();
	}

	/**
	 * getSessionFactory
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public SessionFactory getSessionFactory() throws HibernateException {
		return hibernateTemplate.getSessionFactory();
	}

	/**
	 * isAllowCreate
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public boolean isAllowCreate() throws HibernateException {
		return hibernateTemplate.isAllowCreate();
	}

	/**
	 * isAlwaysUseNewSession
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public boolean isAlwaysUseNewSession() throws HibernateException {
		return hibernateTemplate.isAlwaysUseNewSession();
	}

	/**
	 * isCacheQueries
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public boolean isCacheQueries() throws HibernateException {
		return hibernateTemplate.isCacheQueries();
	}

	/**
	 * isCheckWriteOperations
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public boolean isCheckWriteOperations() throws HibernateException {
		return hibernateTemplate.isCheckWriteOperations();
	}

	/**
	 * isExposeNativeSession
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public boolean isExposeNativeSession() throws HibernateException {
		return hibernateTemplate.isExposeNativeSession();
	}

	/**
	 * 将瞬时对象持久化
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void persist(Object entity) throws HibernateException {
		hibernateTemplate.persist(entity);
	}

	/**
	 * 将瞬时对象持久化
	 * 
	 * @param entityName
	 * @param entity
	 * @throws HibernateException
	 */
	public void persist(String entityName, Object entity) throws HibernateException {
		hibernateTemplate.persist(entityName, entity);
	}

	/**
	 * 操作entity的代理对象
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void merge(Object entity) throws HibernateException {
		hibernateTemplate.merge(entity);
	}

	/**
	 * 操作entity的代理对象
	 * 
	 * @param entityName
	 * @param entity
	 * @throws HibernateException
	 */
	public void merge(String entityName, Object entity) throws HibernateException {
		hibernateTemplate.merge(entityName, entity);
	}

	/**
	 * refresh
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	public void refresh(Object entity) throws HibernateException {
		hibernateTemplate.refresh(entity);
	}

	/**
	 * refresh
	 * 
	 * @param entity
	 * @param lockMode
	 * @throws HibernateException
	 */
	public void refresh(Object entity, LockMode lockMode) throws HibernateException {
		hibernateTemplate.refresh(entity, lockMode);
	}

	/**
	 * replicate
	 * 
	 * @param entity
	 * @param replicationMode
	 * @throws HibernateException
	 */
	public void replicate(Object entity, ReplicationMode replicationMode) throws HibernateException {
		hibernateTemplate.replicate(entity, replicationMode);
	}

	/**
	 * replicate
	 * 
	 * @param entityName
	 * @param entity
	 * @param replicationMode
	 * @throws HibernateException
	 */
	public void replicate(String entityName, Object entity, ReplicationMode replicationMode) throws HibernateException {
		hibernateTemplate.replicate(entityName, entity, replicationMode);
	}

	/**
	 * setAllowCreate
	 * 
	 * @param allowCreate
	 * @throws HibernateException
	 */
	public void setAllowCreate(boolean allowCreate) throws HibernateException {
		hibernateTemplate.setAllowCreate(allowCreate);
	}

	/**
	 * setBeanFactory
	 * 
	 * @param beanFactory
	 * @throws HibernateException
	 */
	public void setBeanFactory(BeanFactory beanFactory) throws HibernateException {
		hibernateTemplate.setBeanFactory(beanFactory);
	}

	/**
	 * setCacheQueries
	 * 
	 * @param cacheQueries
	 * @throws HibernateException
	 */
	public void setCacheQueries(boolean cacheQueries) throws HibernateException {
		hibernateTemplate.setCacheQueries(cacheQueries);
	}

	/**
	 * setCheckWriteOperations
	 * 
	 * @param checkWriteOperations
	 * @throws HibernateException
	 */
	public void setCheckWriteOperations(boolean checkWriteOperations) throws HibernateException {
		hibernateTemplate.setCheckWriteOperations(checkWriteOperations);
	}

	/**
	 * setEntityInterceptor
	 * 
	 * @param entityInterceptor
	 * @throws HibernateException
	 */
	public void setEntityInterceptor(Interceptor entityInterceptor) throws HibernateException {
		hibernateTemplate.setEntityInterceptor(entityInterceptor);
	}

	/**
	 * setEntityInterceptorBeanName
	 * 
	 * @param entityInterceptorBeanName
	 * @throws HibernateException
	 */
	public void setEntityInterceptorBeanName(String entityInterceptorBeanName) throws HibernateException {
		hibernateTemplate.setEntityInterceptorBeanName(entityInterceptorBeanName);
	}

	/**
	 * setExposeNativeSession
	 * 
	 * @param exposeNativeSession
	 * @throws HibernateException
	 */
	public void setExposeNativeSession(boolean exposeNativeSession) throws HibernateException {
		hibernateTemplate.setExposeNativeSession(exposeNativeSession);
	}

	/**
	 * setFetchSize
	 * 
	 * @param fetchSize
	 * @throws HibernateException
	 */
	public void setFetchSize(int fetchSize) throws HibernateException {
		hibernateTemplate.setFetchSize(fetchSize);
	}

	/**
	 * setFilterName
	 * 
	 * @param filter
	 * @throws HibernateException
	 */
	public void setFilterName(String filter) throws HibernateException {
		hibernateTemplate.setFilterName(filter);
	}

	/**
	 * setFilterNames
	 * 
	 * @param filterNames
	 * @throws HibernateException
	 */
	public void setFilterNames(String[] filterNames) throws HibernateException {
		hibernateTemplate.setFilterNames(filterNames);
	}

	/**
	 * setFlushMode
	 * 
	 * @param flushMode
	 * @throws HibernateException
	 */
	public void setFlushMode(int flushMode) throws HibernateException {
		hibernateTemplate.setFlushMode(flushMode);
	}

	/**
	 * setFlushModeName
	 * 
	 * @param constantName
	 * @throws HibernateException
	 */
	public void setFlushModeName(String constantName) throws HibernateException {
		hibernateTemplate.setFlushModeName(constantName);
	}

	/**
	 * setJdbcExceptionTranslator
	 * 
	 * @param jdbcExceptionTranslator
	 * @throws HibernateException
	 */
	public void setJdbcExceptionTranslator(SQLExceptionTranslator jdbcExceptionTranslator) throws HibernateException {
		hibernateTemplate.setJdbcExceptionTranslator(jdbcExceptionTranslator);
	}

	/**
	 * setMaxResults
	 * 
	 * @param maxResults
	 * @throws HibernateException
	 */
	public void setMaxResults(int maxResults) throws HibernateException {
		hibernateTemplate.setMaxResults(maxResults);
	}

	/**
	 * setQueryCacheRegion
	 * 
	 * @param queryCacheRegion
	 * @throws HibernateException
	 */
	public void setQueryCacheRegion(String queryCacheRegion) throws HibernateException {
		hibernateTemplate.setQueryCacheRegion(queryCacheRegion);
	}

	/**
	 * setSessionFactory
	 * 
	 * @param sessionFactory
	 * @throws HibernateException
	 */
	public void setSessionFactory(SessionFactory sessionFactory) throws HibernateException {
		hibernateTemplate.setSessionFactory(sessionFactory);
	}

	/**
	 * 使用原生SQL查询结果集
	 * 
	 * @param sql
	 * @return
	 */
	public RowSet executeQuery(String sql) {
		CachedRowSet cachedrowset = null;
		try {
			Session session = hibernateTemplate.getSessionFactory().openSession();
			Statement st = null;
			ResultSet rs = null;
			try {
				Connection connection = session.connection();
				st = connection.createStatement();
				rs = st.executeQuery(sql);
				cachedrowset = new CachedRowSet();
				cachedrowset.populate(rs);
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (session != null)
						session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (HibernateException hibernateexception) {
			hibernateexception.printStackTrace();
		}
		return cachedrowset;
	}

	/**
	 * 获取当前 'sql'的分页结果集
	 * 
	 * @param page
	 * @param sql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public ResultSet getPageResult(Page page, String sql, String countSql) throws HibernateException, SQLException {
		ResultSet rs = null;
		int count = 0;
		try {
			rs = executeQuery(countSql);
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
				sqle.printStackTrace();
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
			sbSql.append(sql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(start);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			rs1 = executeQuery(sbSql.toString());
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
	 * 根据页码查询
	 * 
	 * @param s
	 * @param i
	 * @param j
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(String s, int i, int j) throws TSDBException {
		Session session = null;
		Query query1;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			query1 = session.createQuery(s);

			query1.setMaxResults(i);
			query1.setFirstResult(i * j);
			return query1.list();
		} catch (HibernateException hibernateexception1) {
			throw new TSDBException(hibernateexception1.getMessage(), hibernateexception1);
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (HibernateException hibernateexception2) {
				throw new TSDBException(hibernateexception2.getMessage(), hibernateexception2);
			}
		}
	}

	/**
	 * queryList
	 * 
	 * @param sql
	 *            Serializable
	 * @throws TSDBException
	 * @return List
	 */
	public List<?> queryList(String sql) throws TSDBException {
		try {
			return find(sql);
		} catch (HibernateException ex) {
			Logger.error("query list Exception " + ex.getMessage());
			throw new TSDBException("query error !", ex);
		}
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
	public List<?> queryList(String sql, int pageSize, int pageNumber) throws TSDBException {
		try {
			return query(sql, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error("query list Exception " + ex.getMessage());
			throw new TSDBException("query error !" + ex);
		}
	}

	/**
	 * 查询列表
	 * 
	 * @param sql
	 * @param objs
	 * @param types
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws TSDBException
	 */
	public List<?> queryList(String sql, Object[] objs, Type[] types, int pageSize, int pageNumber) throws TSDBException {
		try {
			return query(sql, objs, types, pageSize, pageNumber);
		} catch (HibernateException ex) {
			Logger.error("query list Exception " + ex.getMessage());
			throw new TSDBException("query error !" + ex);
		}
	}

	public List<?> query(String s, Object aobj[], Type atype[], int i, int j) throws TSDBException {
		Session session = null;
		Query query1 = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			query1 = session.createQuery(s);
			query1.setMaxResults(i);
			query1.setFirstResult(i * j);
			for (int k = 0; k < aobj.length; k++)
				query1.setParameter(k, aobj[k], atype[k]);
			return query1.list();
		} catch (HibernateException hibernateexception) {
			throw new TSDBException(hibernateexception.getMessage(), hibernateexception);
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (HibernateException hibernateexception2) {
				throw new TSDBException(hibernateexception2.getMessage(), hibernateexception2);
			}
		}
	}

	public List<?> query(String s, Object aobj[], Type atype[]) throws TSDBException {
		Session session = null;
		Query query1 = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			query1 = session.createQuery(s);
			for (int k = 0; k < aobj.length; k++)
				query1.setParameter(k, aobj[k], atype[k]);
			return query1.list();
		} catch (HibernateException hibernateexception) {
			throw new TSDBException(hibernateexception.getMessage(), hibernateexception);
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (HibernateException hibernateexception2) {
				throw new TSDBException(hibernateexception2.getMessage(), hibernateexception2);
			}
		}
	}

	public int count(String sql, Type atype[], Object aobj[]) throws TSDBException {
		Session session = null;
		Query query = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			query = session.createQuery(sql);

			for (int k = 0; k < aobj.length; k++)
				query.setParameter(k, aobj[k], atype[k]);

			List<?> list = query.list();
			if (list == null || list.size() != 1)
				throw new TSDBException("\u67E5\u8BE2[" + sql + "]\u4E0D\u662F\u6B63\u786E\u7684\u542B\u6709count\u7684\u67E5\u8BE2\u8BED\u53E5");

			Object obj = list.get(0);
			if (obj instanceof Integer)
				return ((Integer) obj).intValue();
			else if (obj instanceof Long)
				return ((Long) obj).intValue();
			else {
				throw new TSDBException("\u67E5\u8BE2[" + sql + "]\u8FD4\u56DE\u7684\u4E0D\u662F\u6574\u6570\u7C7B\u578B");
			}
		} catch (HibernateException hibernateexception1) {
			throw new TSDBException(hibernateexception1.getMessage(), hibernateexception1);
		} finally {
			try {
				session.close();
			} catch (HibernateException hibernateexception2) {
				throw new TSDBException(hibernateexception2.getMessage(), hibernateexception2);
			}
		}
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
		int count = count(sql, types, objs);
		return count;
	}

	public int count(String s) throws TSDBException {
		try {
			List<?> list = hibernateTemplate.find(s);
			if (list == null || list.size() != 1)
				throw new TSDBException("\u67E5\u8BE2[" + s + "]\u4E0D\u662F\u6B63\u786E\u7684\u542B\u6709count\u7684\u67E5\u8BE2\u8BED\u53E5");
			Object obj = list.get(0);
			if (obj instanceof Integer)
				return ((Integer) obj).intValue();
			else if (obj instanceof Long)
				return ((Long) obj).intValue();
			else {
				throw new TSDBException("\u67E5\u8BE2[" + s + "]\u8FD4\u56DE\u7684\u4E0D\u662F\u6574\u6570\u7C7B\u578B");
			}
		} catch (HibernateException hibernateexception1) {
			throw new TSDBException(hibernateexception1.getMessage(), hibernateexception1);
		}
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
		int count = count(sql);
		return count;
	}

	/**
	 * 查询记录总数
	 * 
	 * @param criteria
	 * @param projection
	 * @return
	 * @throws TSDBException
	 */
	public int queryListSize(DetachedCriteria criteria, Projection projection) throws TSDBException {
		if (criteria == null)
			return 0;
		criteria.setProjection(Projections.rowCount());
		List<Integer> list = hibernateTemplate.findByCriteria(criteria);
		// 还原projection
		criteria.setProjection(projection);
		if (list == null || list.isEmpty())
			return 0;
		return ((Integer) list.get(0)).intValue();
	}

	/**
	 * 查询记录总数
	 * 
	 * @param criteria
	 * @param projection
	 * @return
	 * @throws TSDBException
	 */
	public int queryListSize(Criteria criteria, Projection projection) throws TSDBException {
		if (criteria == null)
			return 0;
		criteria.setProjection(Projections.rowCount());
		List<Integer> list = criteria.list();
		// 还原projection
		criteria.setProjection(projection);
		if (list == null || list.isEmpty())
			return 0;
		return ((Integer) list.get(0)).intValue();
	}

	/**
	 * 分页查询
	 * 
	 * @param queryHql
	 * @param countHql
	 * @param params
	 * @param types
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(String queryHql, String countHql, Object[] params, Type[] types, Page page) throws TSDBException {
		int count = 0;
		if (page.getTotalCount() < 0) {
			count = queryListSize(countHql, params, types);
			page.setTotalCount(count);
		} else
			count = page.getTotalCount();

		if (count == 0)
			return null;
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return query(queryHql, params, types, pageSize, (pageNumber - 1));
	}

	/**
	 * 分页查询
	 * 
	 * @param queryHql
	 * @param countHql
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(String queryHql, String countHql, Page page) throws TSDBException {
		int count = 0;
		if (page.getTotalCount() < 0) {
			count = queryListSize(countHql);
			page.setTotalCount(count);
		} else
			count = page.getTotalCount();

		if (count == 0)
			return null;
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return query(queryHql, pageSize, (pageNumber - 1));
	}

	/**
	 * 分页查询
	 * 
	 * @param criteria
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(DetachedCriteria criteria, Page page) throws TSDBException {
		int count = queryListSize(criteria, null);
		page.setTotalCount(count);

		if (count == 0)
			return null;
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return hibernateTemplate.findByCriteria(criteria, (pageSize * (pageNumber - 1)), pageSize);
	}

	/**
	 * 分页查询，带Projection
	 * 
	 * @param criteria
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(DetachedCriteria criteria, Projection projection, Page page) throws TSDBException {
		int count = queryListSize(criteria, projection);
		page.setTotalCount(count);

		if (count == 0)
			return null;
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		return hibernateTemplate.findByCriteria(criteria, (pageSize * (pageNumber - 1)), pageSize);
	}

	/**
	 * 查询列表
	 * 
	 * @param criteria
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(DetachedCriteria criteria) throws TSDBException {
		return hibernateTemplate.findByCriteria(criteria);
	}

	public RowSet executePreparedQuery(String s, Object aobj[]) {
		CachedRowSet cachedrowset = null;
		try {
			Session session = openSession();
			try {
				Connection connection = session.connection();
				PreparedStatement preparedstatement = connection.prepareStatement(s);
				for (int i = 0; i < aobj.length; i++)
					preparedstatement.setObject(i + 1, aobj[i]);
				ResultSet resultset = preparedstatement.executeQuery();
				cachedrowset = new CachedRowSet();
				cachedrowset.populate(resultset);
				preparedstatement.close();
				resultset.close();
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			} finally {
				session.close();
			}
		} catch (HibernateException hibernateexception) {
			hibernateexception.printStackTrace();
		}
		return cachedrowset;
	}

	public RowSet executePreparedQuery(String s, Object aobj[], int ai[]) {
		CachedRowSet cachedrowset = null;
		try {
			Session session = openSession();
			try {
				Connection connection = session.connection();
				PreparedStatement preparedstatement = connection.prepareStatement(s);
				for (int i = 0; i < aobj.length; i++)
					preparedstatement.setObject(i + 1, aobj[i], ai[i]);

				ResultSet resultset = preparedstatement.executeQuery();
				cachedrowset = new CachedRowSet();
				cachedrowset.populate(resultset);
				preparedstatement.close();
				resultset.close();
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			} finally {
				session.close();
			}
		} catch (HibernateException hibernateexception) {
			hibernateexception.printStackTrace();
		}
		return cachedrowset;
	}

	public int executePreparedUpdate(String s, Object aobj[]) {
		int i = -1;
		try {
			Session session = openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Connection connection = session.connection();
				PreparedStatement preparedstatement = connection.prepareStatement(s);
				for (int j = 0; j < aobj.length; j++)
					if (aobj[j] instanceof NullType)
						preparedstatement.setNull(j + 1, ((NullType) aobj[j]).getSqlType());
					else
						preparedstatement.setObject(j + 1, aobj[j]);

				i = preparedstatement.executeUpdate();
				preparedstatement.close();
				transaction.commit();
			} catch (HibernateException hibernateexception1) {
				if (transaction != null)
					transaction.rollback();
				throw hibernateexception1;
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			} finally {
				session.close();
			}
		} catch (HibernateException hibernateexception) {
			hibernateexception.printStackTrace();
		}
		return i;
	}

	public int executePreparedUpdate(String s, Object aobj[], int ai[]) {
		int i = -1;
		try {
			Session session = openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Connection connection = session.connection();
				PreparedStatement preparedstatement = connection.prepareStatement(s);
				for (int j = 0; j < aobj.length; j++)
					if (aobj[j] == null)
						preparedstatement.setNull(j + 1, ai[j]);
					else
						preparedstatement.setObject(j + 1, aobj[j], ai[j]);

				i = preparedstatement.executeUpdate();
				preparedstatement.close();
				transaction.commit();
			} catch (HibernateException hibernateexception1) {
				if (transaction != null)
					transaction.rollback();
				throw hibernateexception1;
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			} finally {
				session.close();
			}
		} catch (HibernateException hibernateexception) {
			hibernateexception.printStackTrace();
		}
		return i;
	}

	protected String filteHqlParamter(String arg) {
		arg = arg.replaceAll("\\'", "");
		return arg;
	}

	protected Object setLikeFlag(Object bean, String property, int likeFlag) {
		if (bean == null)
			return null;
		try {
			String propertyValue = BeanUtils.getProperty(bean, property);
			if (propertyValue != null) {
				switch (likeFlag) {
				case LIKE_ALL:
					propertyValue = LIKE_SIGN + propertyValue + LIKE_SIGN;
					break;
				case LIKE_LEFT:
					propertyValue = LIKE_SIGN + propertyValue;
					break;
				case LIKE_RIGHT:
					propertyValue = propertyValue + LIKE_SIGN;
					break;
				}
				BeanUtils.setProperty(bean, property, propertyValue);
				return bean;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return bean;
	}

	protected String setOrder(String sql, String order) {
		if (sql.indexOf("order by") != -1 || sql.indexOf("ORDER BY") != -1) {
			// 用现有排序替换原有排序
			sql = sql.replaceAll("([order by|ORDER BY] .*)\\..*", "$1\\." + order);
		} else {
			sql += " order by " + order;
		}
		return sql;
	}

	protected Query setParameter(Query query, Object obj) throws HibernateException {
		if (obj != null && query != null) {
			String[] params = query.getNamedParameters();
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					try {
						query.setParameter(params[i], PropertyUtils.getProperty(obj, params[i]));
					} catch (IllegalAccessException e) {
					} catch (InvocationTargetException e) {
					} catch (NoSuchMethodException e) {
						Logger.error("参数" + params[i] + "在" + obj.getClass().getName() + "未找到");
					}
				}
			}
		}
		return query;
	}

	protected List query(String hql, Object queryBean) throws TSDBException {
		Session session = null;
		try {
			session = openSession();
			Query query = session.createQuery(hql);
			query = setParameter(query, queryBean);
			List result = query.list();
			return result;
		} catch (HibernateException e) {
			throw new TSDBException(e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取当前查询的结果集
	 * 
	 * @param page
	 * @param countSql
	 * @param sSql
	 * @return
	 * @throws TSDBException
	 */
	protected List getPageList(Page page, String sSql, String countSql) throws TSDBException {
		if (page == null) {
			return queryList(sSql);
		} else {
			int count = 0;
			count = queryListSize(countSql);
			page.setTotalCount(count);

			if (count == 0)
				return new ArrayList();

			int pageSize = page.getPageSize();
			int pageNumber = page.getCurrentPage();
			if (page.getPageCount() <= page.getCurrentPage()) {
				pageNumber = page.getPageCount();
			}
			// 排序功能
			if (page.getOrder() != null) {
				sSql = setOrder(sSql, page.getOrder());
			}
			List ptList = null;
			try {
				ptList = queryList(sSql, pageSize, pageNumber - 1);
				if (ptList.size() == 0)
					ptList = null;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return ptList;
		}
	}

	public int delete(String s, Object aobj[], Type atype[]) {
		try {
			return remove(s, aobj, atype);
		} catch (TSDBException tsdbexception) {
			return -1;
		}
	}

	public int remove(String s, Object aobj[], Type atype[]) throws TSDBException {
		int i = 0;
		Transaction transaction = null;
		Session session;
		try {
			session = openSession();
		} catch (HibernateException hibernateexception) {
			throw new TSDBException(hibernateexception.getMessage(), hibernateexception);
		}
		try {
			transaction = session.beginTransaction();
			List list = query(s, aobj, atype);
			hibernateTemplate.deleteAll(list);
			transaction.commit();
		} catch (HibernateException hibernateexception1) {
			if (transaction != null)
				try {
					transaction.rollback();
				} catch (HibernateException hibernateexception2) {
					throw new TSDBException(hibernateexception2.getMessage(), hibernateexception2);
				}
			throw new TSDBException(hibernateexception1.getMessage(), hibernateexception1);
		} finally {
			try {
				session.close();
			} catch (HibernateException hibernateexception3) {
				throw new TSDBException(hibernateexception3.getMessage(), hibernateexception3);
			}
		}
		return i;
	}

	public void remove(String s) throws TSDBException {
		Transaction transaction = null;
		Session session;
		try {
			session = openSession();
		} catch (HibernateException hibernateexception) {
			throw new TSDBException(hibernateexception.getMessage(), hibernateexception);
		}
		try {
			transaction = session.beginTransaction();
			session.delete(s);
			transaction.commit();
		} catch (HibernateException hibernateexception1) {
			if (transaction != null)
				try {
					transaction.rollback();
				} catch (HibernateException hibernateexception2) {
					throw new TSDBException(hibernateexception2.getMessage(), hibernateexception1);
				}
			throw new TSDBException(hibernateexception1.getMessage(), hibernateexception1);
		} finally {
			try {
				session.close();
			} catch (HibernateException hibernateexception3) {
				throw new TSDBException(hibernateexception3.getMessage(), hibernateexception3);
			}
		}
	}

	/**
	 * 分页查询
	 * 
	 * @param criteria
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(Criteria criteria, Page page) throws TSDBException {
		int count = queryListSize(criteria, null);
		page.setTotalCount(count);

		if (count == 0)
			return null;
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page.getPageCount() : page.getCurrentPage();
		criteria.setFirstResult((pageSize * (pageNumber - 1)));
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	/**
	 * 查询列表
	 * 
	 * @param criteria
	 * @return
	 * @throws TSDBException
	 */
	public List<?> query(Criteria criteria) throws TSDBException {
		return criteria.list();
	}
}
