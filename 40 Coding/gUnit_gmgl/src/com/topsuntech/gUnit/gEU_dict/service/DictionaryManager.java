package com.topsuntech.gUnit.gEU_dict.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;


/**
 * 节点数据管理数据操作类
 *
 * @author ZhangWei
 * @version 1.0
 */
public class DictionaryManager {
	protected static DBWrapper dbwrapper = DictDAOFactory.getInstance().getDBWrapper();

    private net.sf.hibernate.Session session = null;
    private Transaction trans = null;


    /**
     * 创建事务处理
     *
     * @throws HibernateException
     */
    protected void beginTrans() throws HibernateException {
        session = dbwrapper.openSession();
        trans = session.beginTransaction();
    }

    /**
     * 关闭事务处理
     *
     */
    protected void endTrans() {
        if (trans != null) {
            trans = null;
        }
        if (session != null) {
            try {
                session.close();
            }
            catch (HibernateException ex) {
                //session关闭失败
            }
            session = null;
        }
    }

    /**
     * 提交事务处理
     *
     * @throws HibernateException
     */
    protected void commit() throws HibernateException {
        if (trans != null) {
            if (!trans.wasCommitted()) {
                trans.commit();
            }
        }
    }

    /**
     * 取消事务处理
     *
     */
    protected void rollback() {
        if (trans != null) {
            try {
                if (!trans.wasRolledBack()) {
                    trans.rollback();
                }
            }
            catch (HibernateException ex) {
                //取消失败
            }
        }
    }

    /**
     * 获取对象
     *
     * @param tableClass Class
     * @param id long
     * @throws HibernateException
     * @return Object
     */
    protected Object getBean(java.lang.Class tableClass, long id) throws
        HibernateException {
        return dbwrapper.load(tableClass, id);
    }

    /**
     * 新添对象
     *
     * @param obj Object
     * @throws HibernateException
     */
    protected void insertBean(Object obj) throws HibernateException {
        if (session == null && trans == null)
            dbwrapper.insert(obj);
        else
            session.save(obj);
    }

    /**
     * 更新对象
     *
     * @param obj Object
     * @throws HibernateException
     */
    protected void updateBean(Object obj) throws HibernateException {
        if (session == null && trans == null)
            dbwrapper.update(obj);
        else
            session.update(obj);
    }

    /**
     * 删除对象
     *
     * @param obj Object
     * @throws TSDBException
     * @throws HibernateException
     */
    protected void deleteBean(Object obj) throws TSDBException,
        HibernateException {
        if (session == null && trans == null)
            dbwrapper.delete(obj);
        else
            session.delete(obj);
    }

    /**
     * 根据query字符串获取记录List
     *
     * @param query String
     * @return List
     */
    protected List getListByQuery(String query) {
        java.util.List list = new ArrayList();
        try {
            list = dbwrapper.query(query);
        }
        catch (TSDBException ex) {
        }
        return list;
    }
    
    
    /**
     * 根据Page获取记录
     * @param sql String : Query语句
     * @param condtionObjs Object[] : 变量对象
     * @param conditionTypes Type[] : 类型对象
     * @param page Page : Page对象
     * @return List
     */
    protected List getList(String sql, Object[] condtionObjs,
                           Type[] conditionTypes, Page page) {
        //获取记录总数，用于分页
        int count = page.getTotalCount();
        if (count == -1) {
            List countList = getListAll(sql, condtionObjs, conditionTypes);
            //设置page参数
            page.setTotalCount(countList.size());
        }
        int pageSize = page.getPageSize();
        int pageNumber = page.getCurrentPage();
        if (page.getPageCount() <= page.getCurrentPage()) {
            pageNumber = page.getPageCount();
        }
        //获取记录集
        List list = null;
        try {
            list = dbwrapper.query(sql, condtionObjs, conditionTypes, pageSize,
                            pageNumber - 1);
        } catch (TSDBException ex) {
        	ex.printStackTrace();
        }
        
        Logger.debug("\n---the list is "+ list);
        
        return list;
    }

    /**
     * 根据Page获取记录
     * @param cls Class : 指定对象
     * @param cols String[] : 对象列集合
     * @param sql String : Query语句
     * @param condtionObjs Object[] : 变量对象
     * @param conditionTypes Type[] : 类型对象
     * @param page Page : Page对象
     * @return List
     */
    protected List getList(Class cls, String[] cols, String sql,
                           Object[] condtionObjs, Type[] conditionTypes,
                           Page page) {
        List list = getList(sql, condtionObjs, conditionTypes, page);
        return getListByObject(list, cls, cols);
    }

    /**
     * 获取所有记录的List
     * @param sql String : Query语句
     * @param condtionObjs Object[] : 变量对象
     * @param conditionTypes Type[] : 类型对象
     * @return List
     */
    protected List getListAll(String sql, Object[] condtionObjs,
                              Type[] conditionTypes) {
        List list = null;
        try {
            list = dbwrapper.query(sql, condtionObjs, conditionTypes);
        } catch (TSDBException ex) {
            list = new ArrayList();
        }
        return list;
    }

    /**
     * 获取所有记录的List，用于封装多对象查询结果
     * @param cls Class : 指定对象
     * @param cols String[] : 对象列集合
     * @param sql String : Query语句
     * @param condtionObjs Object[] : 变量对象
     * @param conditionTypes Type[] : 类型对象
     * @return List
     */
    protected List getListAll(Class cls, String[] cols, String sql,
                              Object[] condtionObjs, Type[] conditionTypes) {
        List list = getListAll(sql, condtionObjs, conditionTypes);
        return getListByObject(list, cls, cols);
    }

    /**
     * 从记录集中获取指定对象的List
     * @param list List : 记录集
     * @param cls Class : 指定的对象
     * @param cols String[] : 对象列集合
     * @return List
     */
    private List getListByObject(List list, Class cls, String[] cols) {
        List returnList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            try {
                returnList.add(convertBean(cls, cols, (Object[]) iter.next()));
            } catch (Exception ex) {}
        }
        return returnList;
    }

    /**
     * 获取对象集合中指定对象的实体Bean
     * @param clazz Class : 输出对象
     * @param cols String[] : 输出对象列集合
     * @param obj Object[] : 对象集合
     * @return Object
     */
    private Object convertBean(Class clazz, String[] cols, Object[] obj) throws
        Exception {
        //if (cols.length != obj.length) {System.out.println("warning");}
        int length = cols.length <= obj.length ? cols.length : obj.length;
        Object cls = clazz.newInstance();
        for (int i = 0; i < length; i++) {
            try {
                PropertyUtils.setProperty(cls, cols[i], obj[i]);
            } catch (Exception ex) {}
        }
        return cls;
    }
}
