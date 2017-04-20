/**
 * 
 */
package com.topsuntech.gUnit_gmgl.core;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.util.CollectionUtils;

/**
 * @author baiweiming
 * 
 */
public class HibernateBaseService {

	protected static final Log logger = LogFactory.getLog(HibernateBaseService.class);

	private HibernateBaseDao hibernateDao;

	public HibernateBaseDao getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateBaseDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	public Serializable save(Object entity) {
		return hibernateDao.getHibernateTemplate().save(entity);
	}

	public void saveOrUpdate(Object entity) {
		hibernateDao.getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Object entity) {
		hibernateDao.getHibernateTemplate().update(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T load(Class<T> tclass, Serializable id) {
		return (T) hibernateDao.getHibernateTemplate().load(tclass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> tclass, Serializable id) {
		return (T) hibernateDao.getHibernateTemplate().get(tclass, id);
	}

	public void delete(Object entity) {
		hibernateDao.getHibernateTemplate().delete(entity);
	}

	public Object merge(Object entity) {
		return hibernateDao.getHibernateTemplate().merge(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T execute(HibernateCallback action) {
		return (T) hibernateDao.getHibernateTemplate().execute(action);
	}

	@SuppressWarnings("unchecked")
	public <T> T execute(HibernateCallback action, boolean cacheQueries) {
		hibernateDao.getHibernateTemplate().setCacheQueries(cacheQueries);
		return (T) hibernateDao.getHibernateTemplate().execute(action);
	}

	public List<?> executeFind(HibernateCallback action) {
		return hibernateDao.getHibernateTemplate().executeFind(action);
	}

	public List<?> executeFind(HibernateCallback action, boolean cacheQueries) {
		hibernateDao.getHibernateTemplate().setCacheQueries(cacheQueries);
		return hibernateDao.getHibernateTemplate().executeFind(action);
	}

	@SuppressWarnings("unchecked")
	public <T> T executeWithNewSession(HibernateCallback action) {
		return (T) hibernateDao.getHibernateTemplate().executeWithNewSession(action);
	}

	/**
	 * 该方法可以执行SQL语句
	 * 
	 * @param <T>
	 * @param action
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T executeWithNativeSession(HibernateCallback action) {
		return (T) hibernateDao.getHibernateTemplate().executeWithNativeSession(action);
	}

	public List<?> find(String queryString, Object value) {
		hibernateDao.getHibernateTemplate().setCacheQueries(true);
		return hibernateDao.getHibernateTemplate().find(queryString, value);
	}

	public List<?> find(String queryString, Object... values) {
		hibernateDao.getHibernateTemplate().setCacheQueries(true);
		return hibernateDao.getHibernateTemplate().find(queryString, values);
	}

	public List<?> find(String queryString) {
		hibernateDao.getHibernateTemplate().setCacheQueries(true);
		return hibernateDao.getHibernateTemplate().find(queryString);
	}

	public List<?> findByNamedParam(String queryString, String paramName, Object value) {
		hibernateDao.getHibernateTemplate().setCacheQueries(true);
		return hibernateDao.getHibernateTemplate().findByNamedParam(queryString, paramName, value);
	}

	/**
	 * 防止SQL注入使用HQL语句,如
	 * 
	 * @param queryString
	 *            "FROM Entity entity WHERE entity.name= :u AND entity.password= :p"
	 * @param paramNames
	 *            new String[] { "u", "p" };
	 * @param values
	 *            new Object[] { new String(name), new String(password) };
	 * @return
	 */
	public List<?> findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return hibernateDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	public List<?> findByNamedParam(String queryString, String[] paramNames, Object[] values, boolean cacheQueries) {
		hibernateDao.getHibernateTemplate().setCacheQueries(cacheQueries);
		return hibernateDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	/**
	 * 返回记录总条数
	 * 
	 * @param countSql
	 *            使用Count()查询
	 * @return int 记录条数
	 */
	public int getTotalCount(String countSql) {
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) find(countSql);
		if (!CollectionUtils.isEmpty(list)) {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext()) {
				return it.next().intValue();
			}
		}
		return 0;
	}

	/**
	 * 取条数,防止SQL注入使用HQL语句
	 * 
	 * @param countSql
	 * @param object
	 * @param type
	 * @param cacheQueries
	 *            :是否使用缓存
	 * @return
	 */
	public int getTotalCount(final String countSql, final Object[] object, final Type[] type, final boolean cacheQueries) {
		Long ll = (Long) execute(new HibernateCallback() {
			public Long doInHibernate(Session session) {
				Query query = session.createQuery(countSql);
				query.setParameters(object, type);
				@SuppressWarnings("unchecked")
				List<Long> list = query.list();
				if (!CollectionUtils.isEmpty(list)) {
					Iterator<Long> it = list.iterator();
					if (it.hasNext()) {
						return it.next().longValue();
					}
				}
				return 0l;
			}
		}, cacheQueries);
		return ll.intValue();
	}

	/**
	 * 分页,防止SQL注入使用HQL语句，默认不使用缓存
	 * 
	 * @param page
	 * @param queryString
	 * @param countSql
	 * @param object
	 * @param type
	 * @return
	 */
	public List<?> getPageList(final Page page, final String queryString, String countSql, final Object[] object, final Type[] type) {
		return getPageList(page, queryString, countSql, object, type, false);
	}

	/**
	 * 分页,防止SQL注入使用HQL语句
	 * 
	 * @param page
	 * @param queryString
	 * @param countSql
	 * @param object
	 * @param type
	 * @param cacheQueries
	 *            :是否使用缓存
	 * @return
	 */
	public List<?> getPageList(final Page page, final String queryString, String countSql, final Object[] object, final Type[] type,
			boolean cacheQueries) {
		int totalCount = getTotalCount(countSql, object, type, cacheQueries);
		page.setTotalCount(totalCount);
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(queryString);
				query.setParameters(object, type);
				// 每页记录数
				query.setMaxResults(page.getPagenum());
				// 记录的开始的条数
				query.setFirstResult((page.getCurrentPage() - 1) * page.getPagenum());
				return query.list();
			}
		}, cacheQueries);
	}

	public void flush(){
		hibernateDao.getHibernateTemplate().flush();
	}
}
