package com.topsuntech.gUnit.gEU_util.taglib;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;

public class AjDeptTag extends TagSupport {

private static DBWrapper defaultDb = DBRegistry.getDefaultDBWrapper();	
	
	private Long _deptId;
	
	private String deptId;
	
	public void setDeptId(String deptId)throws JspException {
		this.deptId = deptId;
		this._deptId = (Long)ExpressionEvaluatorManager.evaluate("deptId", deptId, Long.class, this, pageContext); 		
	}


	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
	
			try {
					printNameByDeptId(out);
				} catch (SQLException e) {					
					e.printStackTrace();
				} catch (IOException e) {				
					e.printStackTrace();
				}		
		
		return SKIP_BODY;
	}
	/*
	 * select (select w.name from gos_dept w where w.id in(select u.parent_id from gos_dept u where u.id = 872) )|| t.name
  from gos_dept t
 where t.id = 872
	 */
	private void printNameByDeptId(JspWriter out) throws SQLException, IOException {
		// SQL”Ôæ‰
		StringBuffer sbHql = new StringBuffer();
//		sbHql.append(" select (select w.name from gos.gos_dept w where w.id in(select u.parent_id from gos.gos_dept u where u.id =");
//		sbHql.append(this._deptId+") )|| t.name from gos.gos_dept t where t.id ="+this._deptId);
		sbHql.append("select t.name from gos_dept t where t.id ="+this._deptId);
		System.out.println(sbHql);
		// ÷¥––≤È—Ø
		ResultSet rs = defaultDb.executeQuery(sbHql.toString());
		rs.next();
		String deptName = rs.getString(1);
		rs.close();
		out.print(deptName);
		
	}
	



}
