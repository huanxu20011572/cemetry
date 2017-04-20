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
 * �ڵ����ݹ������ݲ�����
 *
 * @author ZhangWei
 * @version 1.0
 */
public class DictionaryManager {
	protected static DBWrapper dbwrapper = DictDAOFactory.getInstance().getDBWrapper();

    private net.sf.hibernate.Session session = null;
    private Transaction trans = null;


    /**
     * ����������
     *
     * @throws HibernateException
     */
    protected void beginTrans() throws HibernateException {
        session = dbwrapper.openSession();
        trans = session.beginTransaction();
    }

    /**
     * �ر�������
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
                //session�ر�ʧ��
            }
            session = null;
        }
    }

    /**
     * �ύ������
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
     * ȡ��������
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
                //ȡ��ʧ��
            }
        }
    }

    /**
     * ��ȡ����
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
     * �������
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
     * ���¶���
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
     * ɾ������
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
     * ����query�ַ�����ȡ��¼List
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
     * ����Page��ȡ��¼
     * @param sql String : Query���
     * @param condtionObjs Object[] : ��������
     * @param conditionTypes Type[] : ���Ͷ���
     * @param page Page : Page����
     * @return List
     */
    protected List getList(String sql, Object[] condtionObjs,
                           Type[] conditionTypes, Page page) {
        //��ȡ��¼���������ڷ�ҳ
        int count = page.getTotalCount();
        if (count == -1) {
            List countList = getListAll(sql, condtionObjs, conditionTypes);
            //����page����
            page.setTotalCount(countList.size());
        }
        int pageSize = page.getPageSize();
        int pageNumber = page.getCurrentPage();
        if (page.getPageCount() <= page.getCurrentPage()) {
            pageNumber = page.getPageCount();
        }
        //��ȡ��¼��
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
     * ����Page��ȡ��¼
     * @param cls Class : ָ������
     * @param cols String[] : �����м���
     * @param sql String : Query���
     * @param condtionObjs Object[] : ��������
     * @param conditionTypes Type[] : ���Ͷ���
     * @param page Page : Page����
     * @return List
     */
    protected List getList(Class cls, String[] cols, String sql,
                           Object[] condtionObjs, Type[] conditionTypes,
                           Page page) {
        List list = getList(sql, condtionObjs, conditionTypes, page);
        return getListByObject(list, cls, cols);
    }

    /**
     * ��ȡ���м�¼��List
     * @param sql String : Query���
     * @param condtionObjs Object[] : ��������
     * @param conditionTypes Type[] : ���Ͷ���
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
     * ��ȡ���м�¼��List�����ڷ�װ������ѯ���
     * @param cls Class : ָ������
     * @param cols String[] : �����м���
     * @param sql String : Query���
     * @param condtionObjs Object[] : ��������
     * @param conditionTypes Type[] : ���Ͷ���
     * @return List
     */
    protected List getListAll(Class cls, String[] cols, String sql,
                              Object[] condtionObjs, Type[] conditionTypes) {
        List list = getListAll(sql, condtionObjs, conditionTypes);
        return getListByObject(list, cls, cols);
    }

    /**
     * �Ӽ�¼���л�ȡָ�������List
     * @param list List : ��¼��
     * @param cls Class : ָ���Ķ���
     * @param cols String[] : �����м���
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
     * ��ȡ���󼯺���ָ�������ʵ��Bean
     * @param clazz Class : �������
     * @param cols String[] : ��������м���
     * @param obj Object[] : ���󼯺�
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
