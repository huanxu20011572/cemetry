/*
 * Created on 2008-1-1
 * @author lixirong
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_tree.service.dao;

/**
 * @author lixirong
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;

public class GnmkDAO {
    
    private static DBWrapper db = DBRegistry.getDBWrapper("gos");
	
	public List getGnmkByParent(String gnmksj) {
		List list = new ArrayList();
		String sql = "select * from GNMK where gnmksj = '" + 
				gnmksj + "' order by gnmkdm";
			
		Connection c = null;
		Statement stmt = null;
		try {
			try {
                c = db.openSession().connection();
            } catch (HibernateException e1) {
                e1.printStackTrace();
            }
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				treeBean bean = this.getBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private treeBean getBean(ResultSet rs) throws SQLException {
	    treeBean bean = new treeBean(
	            	rs.getLong("id"), 
	            	rs.getString("gnmkmc"),
	                rs.getString("gnmkbz"),
	                rs.getString("gnmkdm"),
	                rs.getString("gnmktb"),
	                rs.getString("gnmklj")
	                );
		return bean;
	}
	
	
	public  static void main(String[] strs){
	    GnmkDAO dao = new GnmkDAO();
	    List list = dao.getGnmkByParent("02");   
	    System.out.println("\n ---list : "  + list);
	}
}