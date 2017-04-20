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

public class DeptTag extends TagSupport {

	private static DBWrapper defaultDb = DBRegistry.getDefaultDBWrapper();
	
	private String deptCode;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) throws JspException {
		this.deptCode = (String) ExpressionEvaluatorManager.evaluate(
				"deptCode", deptCode, Object.class, this, pageContext);
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
//		try {
//			printName(out);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return SKIP_BODY;
	}

	private void  printName( JspWriter out) throws SQLException, IOException {
		// SQL”Ôæ‰
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" select (select t.name from gos_dept t where t.dept_code='" + this.deptCode+"')");
				sbHql.append(" from gos_dept d where d.id in ( ");
				sbHql.append(" select t.parent_id from gos_dept t ");

		sbHql.append(" where t.dept_code='" + this.deptCode+"')");
		System.out.println(sbHql);
		// ÷¥––≤È—Ø
		ResultSet rs = defaultDb.executeQuery(sbHql.toString());
		rs.next();
		String deptName = rs.getString(1);
		rs.close();
		out.print(deptName);
	}

}
