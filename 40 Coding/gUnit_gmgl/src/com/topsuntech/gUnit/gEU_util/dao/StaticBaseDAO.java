/**
 * 用于静态方法使用
 */
package com.topsuntech.gUnit.gEU_util.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.topsuntech.gUnit.gEU_util.listener.BeanListener;

/**
 * @author zcpeng
 * 
 */
public class StaticBaseDAO extends BaseDAO {
	private HibernateTemplate hibernateTemplate;

	/**
	 * @param hibernateTemplate
	 *            the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		if (hibernateTemplate == null)
			hibernateTemplate = (HibernateTemplate) BeanListener.getBean("hibernateTemplate");
		else
			this.hibernateTemplate = hibernateTemplate;
	}
}
