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
     * 节点数据简单查询
     * @param nodeTypeName String :所属种类名称，""为获取所有节点数据
     * @param parentID String :父节点ID，0为获取所有父节点数据
     * @return List
     */
    public List findNode(String nodeTypeName, String parentID,String institutionId) {
        //设置基础参数
        Class table = MetaData.class;
        String tableName = " MetaData o ";
        String whereSql = "";
        String orderBy = "";
        //需查询的字段
        String[] cols = new String[] {"id", "parentid", "node_name",
            "node_value", "node_index","state"};
        //查询sql语句
        String sql = "SELECT o.id,o.parentid,o.node_name"
            + ",o.node_value, o.node_index, o.state"
            + " FROM " + tableName;

        ConditionUtil condition = new ConditionUtil();
        if (nodeTypeName!=null && parentID.length() != 0) { //父节点ID
            whereSql += " AND o.parentid = ?";
            condition.addLong(parentID);
        }
        
        if (nodeTypeName!=null && nodeTypeName.length() > 0) { //分类名称
            whereSql += " AND o.node_typename = ?";
            condition.addString(nodeTypeName);
        }
        if(institutionId!=null && institutionId.length()>0){
        	whereSql += " AND o.institutionid=" + institutionId; //按照部门过虑        
        }
        
        //添加where语句
        if (!"".equalsIgnoreCase(whereSql))
            whereSql = " where " + whereSql.substring(4);
        orderBy += " ORDER BY  o.state, o.node_index,o.id";
        //添加orderBy语句
        sql += whereSql + orderBy;
        //获取记录集
        List list = getListAll(table, cols, sql, condition.getParams(),
                               condition.getTypes());
        return list;
    }

    /**
     * 节点数据简单查询
     * @param nodeTypeName String :所属种类名称，""为获取所有节点数据
     * @param parentID String :父节点ID，0为获取所有父节点数据
     * @param page Page
     * @return List
     */
    public List findNode(String nodeTypeName, String parentID, Page page,String institutionId) {
        //设置基础参数
        Class table = MetaData.class;
        String tableName = " MetaData o ";
        String whereSql = "";
        String orderBy = "";
        //需查询的字段
        String[] cols = new String[] {"id", "parentid", "node_name",
            "node_value", "node_index","state"};
        //查询sql语句
        String sql = "SELECT o.id,o.parentid,o.node_name"
            + ",o.node_value, o.node_index ,o.state"
            + " FROM " + tableName;

        ConditionUtil condition = new ConditionUtil();
        if (parentID!=null && parentID.length() != 0) { //父节点ID
            whereSql += " AND o.parentid = ?";
            condition.addLong(parentID);
        }
        if (nodeTypeName!=null && nodeTypeName.length() > 0) { //分类名称
            whereSql += " AND o.node_typename = ?";
            condition.addString(nodeTypeName);
        }
        
        //所属机构
        if (institutionId != null && institutionId.length() != 0) { 
            whereSql += " AND o.institutionid = ?";
            condition.addLong(institutionId);
        }
        //添加where语句
        if (!"".equalsIgnoreCase(whereSql))
            whereSql = " where " + whereSql.substring(4);
        orderBy += " ORDER BY o.node_index,o.id,o.state" +
        		" ";
        //添加orderBy语句
        sql += whereSql + orderBy;
        //获取记录集
        List list = getList(table, cols, sql, condition.getParams(),
                            condition.getTypes(), page);
        return list;
    }


    
    /**
     * 根据code获取ID
     * add by 李星亮
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
     * 改变数据项的状态
     * @param id 数据项的ID
     * @param oldState 原状态
     * @param newState 新状态
     * @return 0,表更新成功，1，表不能更新，2，表能更新但更新失败
     */
    public int changeState(String id,String oldState,String newState)throws HibernateException{
    	//状态说明：1,新建 2，启用 3，停用
    	int oldst = oldState == null ? 0 : Integer.parseInt(oldState);
    	int newst = Integer.parseInt(newState);
    	if((oldst == 2 || oldst == 3) && (newst == 1)){
    		//被启用了，不能变为新建的
    		System.out.println("被启用的或停用的不能改为新建");
    		return 1;
    	}
    	MetaData bean = (MetaData)wrapper.load(MetaData.class,Long.parseLong(id));
    	bean.setState(Integer.valueOf(newState));
    	wrapper.update(bean);
    	return 0;
    }
    
    /**
     * 删除数据
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
     * 根据父节点类型查找所有的子节点
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




