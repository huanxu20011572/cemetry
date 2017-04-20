/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.RowSet;

import org.apache.struts.util.LabelValueBean;

import net.sf.hibernate.HibernateException;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.entity.AjDept;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;
import com.topsuntech.gUnit.gEU_util.methods.PBMethod;

/**
 * @author ibm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeptService {
    static SJBaseDAO dao = new SJBaseDAO();
    private static DBWrapper db = DBRegistry.getDefaultDBWrapper();
    
    public static AjDept getDept (Long deptId) throws TSDBException{        
        return (AjDept) dao.getEntity(AjDept.class, deptId);         
	 }    
    
    public static void insertDept (AjDept deptInfo) throws TSDBException{        
        dao.addEntity(deptInfo);         
    }    
    
    public static void updateDept(AjDept deptInfo) throws TSDBException{        
        dao.updateEntity(deptInfo);         
	 }
    
    /**
     * 获取机构信息
     * @param approveUnitCode  审批标识
     * @param countryId        区县ID
     * @return
     * @throws HibernateException
     */
	public AjDept getDeptByApproveUnitCode(Long countryId,String approveUnitCode) throws HibernateException {
	    AjDept dept = null;
	    StringBuffer hsql = new StringBuffer();
	    
	    hsql.append(" FROM AjDept d WHERE 1=1 ");
	    if(countryId != null && countryId.longValue() > 0)
	        hsql.append(" AND d.regionId=").append(countryId);
	    hsql.append(" AND d.approveUnitCode='").append(approveUnitCode).append("'");
	    
	    List list = dao.queryList(hsql.toString());
	    if(list != null && list.size() > 0){
	        dept = (AjDept) list.get(0);
	    }
	    return dept; 
	}
	
	public int getDeptCodeSize(String deptCode) throws HibernateException {	   
	    StringBuffer hsql = new StringBuffer();	    
	    hsql.append(" FROM AjDept d WHERE 1=1 ");
	    if(deptCode != null && !deptCode.equals(""))	      
	    hsql.append(" AND d.approveUnitCode like '").append(deptCode).append("%'");	    
	    List list = dao.queryList(hsql.toString());	   
	    return list.size(); 
	}
	
	public String  getDeptNameById(Long deptId) throws HibernateException {
	    AjDept dept = null;	  
	    StringBuffer hsql = new StringBuffer();
	    
	    hsql.append(" FROM AjDept d WHERE 1=1 ");
	    if(deptId != null && deptId.longValue() > 0)
	        hsql.append(" AND d.id=").append(deptId);	   
	    
	    List list = dao.queryList(hsql.toString());
	    if(list != null && list.size() > 0){
	        dept = (AjDept) list.get(0);
	    }
	    return dept.getName(); 
	}
	
	public String  getDeptNameByParentId(Long deptId) throws HibernateException {
	    AjDept dept = null;	  
	    StringBuffer hsql = new StringBuffer();
	    StringBuffer idArray = new StringBuffer();
	    
	    hsql.append(" FROM AjDept d WHERE 1=1 ");
	    if(deptId != null && deptId.longValue() > 0)
	        hsql.append(" AND d.parentId=").append(deptId);	   
	    
	    List list = dao.queryList(hsql.toString());
	    if(list.size()>0){
	    	for(Object o : list){
	    		dept = (AjDept) o;
	    		idArray.append(dept.getId()).append(",");
	    	}
	    	return idArray.substring(0, idArray.length()-1); 
	    }else{
	    	return ""; 
	    }
	    
	}
	public static List queryDeptByUpCode(String deptid,Page page) throws TSDBException{
    	List list=null;
    
    	StringBuffer sql=new StringBuffer();
    	
    		sql.append(" select * from gos_dept t where  t.use_flag=1 ");
    	if(deptid!=null&&!deptid.equals("")){
    		sql.append(" and t.parent_id=").append(deptid);
    	}
    	
    	sql.append(" order by t.id asc ");
        RowSet rs;
 		try {
 			rs = PBMethod.queryForOracle(sql.toString(), page, dao.getDBWrapper());
 			list = PBMethod.rs2MapListAndClose(rs);
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}		
          return list;     	
    }
	public static List queryDeptByZf(Long deptid) throws TSDBException{
		    AjDept dept = null;	  
		    StringBuffer hsql = new StringBuffer();
		    StringBuffer idArray = new StringBuffer();
		    
		    hsql.append(" FROM AjDept d WHERE 1=1 and d.useFlag=1");
		    if(deptid != null && deptid.longValue() > 0)
		        hsql.append(" AND d.parentId=").append(deptid);	   
		    
		    List list = dao.queryList(hsql.toString());
		    List options= new ArrayList();
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				dept = (AjDept) iter.next();
				options.add(new LabelValueBean(dept.getId().toString(),dept.getName()));
			}	
 		
          return options;     	
    }
//	 /**
//     * 1根据ID 去查区域表第一个顺序号是多少
//     * 2如果要移的比最小的大 那进行上移
//     * 3否则 不进行上移
//     * 3.1 根据区县编码与排序字段 查要进行上移的上一条记录的排序字段是多少；
//     * 3.2 根据3.1 查出这个记录 并把其它的排序字段SET 为接到的orderByItem  
//     * 3.3 根据ID 修改区域表的排序字段 值为3.1所定义序号
//     * @throws SQLException 
//     */
//    public  void toMoveUp(String id,String orderByItem,String country) throws TSDBException, SQLException{
//    	
//        //1
//    	AjDept ajDept=queryMinDeptByFDeptid(country,null);
//    	int minItem=ajDept.getOrderByItem();//得到该区域排序第一个的序号
//    	int orderItem = Integer.parseInt(orderByItem);//要进行上移操作的  当前的序号
//    	//2
//    	AjDept upAjDept=new AjDept();
//    	AjDept toUpAjDept=new AjDept();
//    	if(orderItem==minItem){
//    	}else{
//    	//3
//    	  //3.1
//    		AjDept maxAjDept=queryMaxDeptByFDeptid(country,orderByItem);
//    		int temItem=maxAjDept.getOrderByItem();//目标序号
//    	  //3.2
//    		upAjDept=queryAjDeptByUpItem(country,String.valueOf(temItem));
//    		upAjDept.setOrderByItem(orderItem);
//    		dao.updateEntity(upAjDept);
//    	 //3.3	
//    		toUpAjDept=getDept(new Long(id));
//    		toUpAjDept.setOrderByItem(temItem);
//    		dao.updateEntity(toUpAjDept);
//    	}
//    	
//    }
//    
//    
//	public  void toMoveDown(String id,String orderByItem,String country) throws TSDBException, SQLException{
//	    	
//	        //1
//	    	AjDept ajDept=queryMinDeptByFDeptid(country,orderByItem);
//	    	int minItem=ajDept.getOrderByItem();//得到该区域排序第一个的序号
//	    	int orderItem = Integer.parseInt(orderByItem);//要进行上移操作的  当前的序号
//	    	//2
//	    	AjDept upAjDept=new AjDept();
//	    	AjDept toUpAjDept=new AjDept();
//	    	if(minItem!=0){
//		    	if(orderItem==minItem){
//		    	}else{
//		    	//3
//		    	  //3.1
//		    		AjDept maxAjDept=queryMinDeptByFDeptid(country,orderByItem);
//		    		int temItem=maxAjDept.getOrderByItem();//目标序号
//		    	  //3.2
//		    		upAjDept=queryAjDeptByUpItem(country,String.valueOf(temItem));
//		    		upAjDept.setOrderByItem(orderItem);
//		    		dao.updateEntity(upAjDept);
//		    	 //3.3	
//		    		toUpAjDept=getDept(new Long(id));
//		    		toUpAjDept.setOrderByItem(temItem);
//		    		dao.updateEntity(toUpAjDept);
//		    	}
//	    	}
//	    	
//	  }
//	    
//    
//    
//    
//    
//   public  AjDept queryMinDeptByFDeptid(String deptid,String item) throws TSDBException, SQLException{
//
//    	AjDept ajDept=new AjDept();
//    	StringBuffer sql=new StringBuffer();
//    	if(deptid!=null&&!deptid.equals("")){
//    		sql.append(" select min(t.orderby_item) as orderby_item from gos_dept t where  t.use_flag=1");    		
//    		sql.append(" and t.parent_id=").append(deptid);
//    		
//    		if(item!=null&&!item.equals(""))
//    	    	sql.append(" and t.orderby_item>").append(item);
//    		sql.append(" order by t.orderby_item asc");    
//    	}
////    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
////    	System.out.println(">>>>>>>>>>>>>>>queryMinDeptByFDeptid>>>>>>>>>>>>>>>>"+sql);
////    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//    	
//    	if(sql!=null&&!sql.equals("")){
//    		ResultSet rs = dao.getDBWrapper().executeQuery(sql.toString());	
//    		while(rs.next()){    			
//    			ajDept.setOrderByItem(rs.getInt("orderby_item"));
//    		}
//    	}    	
//    	return ajDept;     	
//    }
//	
//   
//   public  AjDept queryMaxDeptByFDeptid(String deptid,String item) throws TSDBException, SQLException{
//
//   	AjDept ajDept=new AjDept();
//   	StringBuffer sql=new StringBuffer();
//   	if(deptid!=null&&!deptid.equals("")){
//   		sql.append(" select max(t.orderby_item) as orderby_item from gos_dept t where  t.use_flag=1");    		
//   		sql.append(" and t.parent_id=").append(deptid);
//   		
//   		if(item!=null&&!item.equals(""))
//   	    	sql.append(" and t.orderby_item<").append(item);
//   		sql.append(" order by t.orderby_item asc");    
//   	}
////   	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
////   	System.out.println(">>>>>>>>>>>>>>>queryMaxDeptByFDeptid>>>>>>>>>>>>>>>>"+sql);
////   	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//   	
//   	if(sql!=null&&!sql.equals("")){
//   		ResultSet rs = dao.getDBWrapper().executeQuery(sql.toString());	
//   		while(rs.next()){    			
//   			ajDept.setOrderByItem(rs.getInt("orderby_item"));
//   		}
//   	}    	
//   	return ajDept;     	
//   }
//   
//   public  AjDept queryAjDeptByUpItem(String country,String item) throws TSDBException, SQLException{
//   	
//	   	List list=null;
//	   	AjDept ajDept=new AjDept();
//	   	StringBuffer sql=new StringBuffer();
//	   	if(item!=null&&!item.equals("")){
//	   		sql.append("  from AjDept r where   1=1 ");
//	   		sql.append(" and r.orderByItem=").append(item);    
//	   		sql.append(" and r.parentId=").append(country);    
//	   	    sql.append(" order by r.orderByItem asc");    
//	   	}
//	   	if(sql!=null&&!sql.equals("")){
//	   		list = dao.queryList(sql.toString());	
//	   		if(list!=null&&list.size()>0)
//	   			ajDept=(AjDept)list.get(0);
//	   	}
//	   	
//	   	return ajDept;     	
//   }
//		   
//   /**
//	 * 查询用户的最大的排序值
//	 * 
//	 * @param
//	 * @return
//	 */
//public  int getMaxOrderItem() {
//	int maxOrderItem = 0;
//	ResultSet rs = null;
//	StringBuffer sql = new StringBuffer();
//	sql.append(" select max(u.orderby_item) from gos_dept u  ");
//	try {
//		rs = db.executeQuery(sql.toString());
//		if (rs.next()) {
//			maxOrderItem = rs.getInt(1);
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	return maxOrderItem;
//}
	
	/**
	 * 根据用户ID得到所在区县ID（针对街乡用户）
	 * @param userid
	 * @return
	 */
	public  Long getUserQuDeptidByUserId(Long userid) {
		Long deptid = null ;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("  select rr.parent_id from gos_dept rr where rr.id in" +
				"( select d.parent_id from gos_dept d where d.id in" +
				"( select  u.workdeptid from gos_user u where u.id=" );
		sql.append(userid).append(") )  ");
			
		try {
			rs = db.executeQuery(sql.toString());
			if (rs.next()) {
				deptid = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptid;
	}
	
	/**
	 * 根据用户ID得到所在区域ID（针对街乡用户）
	 * @param userid
	 * @return
	 */
	public  Long getUserRegionIdByUserId(Long userid) {
		Long regionid = null ;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("  select w.regionid from gos_dept w where w.id in(" +
				" select rr.parent_id from gos_dept rr where rr.id in" +
				"( select d.parent_id from gos_dept d where d.id in" +
				"( select  u.workdeptid from gos_user u where u.id=" );
		sql.append(userid).append(") ) ) ");
			
		try {
			rs = db.executeQuery(sql.toString());
			if (rs.next()) {
				regionid = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return regionid;
	}
	
}
