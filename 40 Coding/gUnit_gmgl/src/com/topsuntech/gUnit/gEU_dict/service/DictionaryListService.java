package com.topsuntech.gUnit.gEU_dict.service;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.Type;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.utils.ConditionUtil;

/**
 * Service
 *
 * @author shaojingze
 * @version 1.0
 */
public class DictionaryListService extends DictionaryManager {
	
	private DBWrapper wrapper = DictDAOFactory.getInstance().getDBWrapper();


    /**
     * �ڵ����ݼ򵥲�ѯ
     * @param nodeTypeName String :�����������ƣ�""Ϊ��ȡ���нڵ�����
     * @param parentID String :���ڵ�ID��0Ϊ��ȡ���и��ڵ�����
     * @return List
     */
    public List findNode(String nodeTypeName, String parentID,String institutionId) {
        //���û�������
        Class table = MetaData.class;
        String tableName = " MetaData o ";
        String whereSql = "";
        String orderBy = "";
        //���ѯ���ֶ�
        String[] cols = new String[] {"id", "parentid", "node_name",
            "node_value", "node_index","state"};
        //��ѯsql���
        String sql = "SELECT o.id,o.parentid,o.node_name"
            + ",o.node_value, o.node_index, o.state"
            + " FROM " + tableName;

        ConditionUtil condition = new ConditionUtil();
        if (nodeTypeName!=null && parentID.length() != 0) { //���ڵ�ID
            whereSql += " AND o.parentid = ?";
            condition.addLong(parentID);
        }
        
        if (nodeTypeName!=null && nodeTypeName.length() > 0) { //��������
            whereSql += " AND o.node_typename = ?";
            condition.addString(nodeTypeName);
        }
        if(institutionId!=null && institutionId.length()>0){
        	whereSql += " AND o.institutionid=" + institutionId; //���ղ��Ź���        
        }
        
        //���where���
        if (!"".equalsIgnoreCase(whereSql))
            whereSql = " where " + whereSql.substring(4);
        orderBy += " ORDER BY  o.state, o.node_index,o.id";
        //���orderBy���
        sql += whereSql + orderBy;
        //��ȡ��¼��
        List list = getListAll(table, cols, sql, condition.getParams(),
                               condition.getTypes());
        return list;
    }

    /**
     * �ڵ����ݼ򵥲�ѯ
     * @param nodeTypeName String :�����������ƣ�""Ϊ��ȡ���нڵ�����
     * @param parentID String :���ڵ�ID��0Ϊ��ȡ���и��ڵ�����
     * @param page Page
     * @return List
     */
    public List findNode(String nodeTypeName, String parentID, Page page,String institutionId) {
        //���û�������
        Class table = MetaData.class;
        String tableName = " MetaData o ";
        String whereSql = "";
        String orderBy = "";
        //���ѯ���ֶ�
        String[] cols = new String[] {"id", "parentid", "node_name",
            "node_value", "node_index","state"};
        //��ѯsql���
        String sql = "SELECT o.id,o.parentid,o.node_name"
            + ",o.node_value, o.node_index ,o.state"
            + " FROM " + tableName;

        ConditionUtil condition = new ConditionUtil();
        if (parentID!=null && parentID.length() != 0) { //���ڵ�ID
            whereSql += " AND o.parentid = ?";
            condition.addLong(parentID);
        }
        if (nodeTypeName!=null && nodeTypeName.length() > 0) { //��������
            whereSql += " AND o.node_typename = ?";
            condition.addString(nodeTypeName);
        }
        
        //��������
        if (institutionId != null && institutionId.length() != 0) { 
            whereSql += " AND o.institutionid = ?";
            condition.addLong(institutionId);
        }
        //���where���
        if (!"".equalsIgnoreCase(whereSql))
            whereSql = " where " + whereSql.substring(4);
        orderBy += " ORDER BY o.node_index,o.id,o.state" +
        		" ";
        //���orderBy���
        sql += whereSql + orderBy;
        //��ȡ��¼��
        List list = getList(table, cols, sql, condition.getParams(),
                            condition.getTypes(), page);
        return list;
    }


    
    /**
     * ����code��ȡID
     * add by ������
     * @param code
     * @return
     * @throws HibernateException
     */
    public Long getIdByCode(String code)throws HibernateException{
    	String hsql = "select o.id from MetaData o where o.node_value='" + code + "'";
    	//String hsql = "select o.id from MetaData o";
    	List re = wrapper.query(hsql);
    	
    	System.out.println("============size:" + re.size());
    	
    	if(re == null || re.size() == 0){
    		return null;
    	}
    	return (Long)re.get(0);
    }
    
    /**
     * �ı��������״̬
     * @param id �������ID
     * @param oldState ԭ״̬
     * @param newState ��״̬
     * @return 0,����³ɹ���1�����ܸ��£�2�����ܸ��µ�����ʧ��
     */
    public int changeState(String id,String oldState,String newState)throws HibernateException{
    	//״̬˵����1,�½� 2������ 3��ͣ��
    	int oldst = oldState == null ? 0 : Integer.parseInt(oldState);
    	int newst = Integer.parseInt(newState);
    	if((oldst == 2 || oldst == 3) && (newst == 1)){
    		//�������ˣ����ܱ�Ϊ�½���
    		System.out.println("�����õĻ�ͣ�õĲ��ܸ�Ϊ�½�");
    		return 1;
    	}
    	MetaData bean = (MetaData)wrapper.load(MetaData.class,Long.parseLong(id));
    	bean.setState(Integer.valueOf(newState));
    	wrapper.update(bean);
    	return 0;
    }
    
    /**
     * ɾ������
     * @param id
     * @param state
     * @return
     */
    public void deleteMeteData(String id)throws HibernateException{
    	if(id == null){
    		return;
    	}
    	wrapper.deleteById(MetaData.class,Long.parseLong(id));
    }
    
    /**
     * ���ݸ��ڵ����Ͳ������е��ӽڵ�
     * @param id
     * @return
     * @throws HibernateException
     */
    public List queryByParentNodeTypeName(String parentNodeTypeName)throws HibernateException{
    	String hsql = "select m from MetaData m where m.parentid=(select t.id from MetaData t where t.node_typename=? and  t.parentid=0) and m.state=2 order by m.node_index";
    	Type[] types = new Type[] { Hibernate.STRING };
		Object[] objs = new Object[] { parentNodeTypeName };


		return wrapper.query(hsql, objs, types);
    	//List re = wrapper.query(hsql);
    }
}




