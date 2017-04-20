package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

public class BzhhChooseTag extends KeyValueTag {

	// 对象名称
	// private String obj;

	// 对象名称
	private String name;

	// 分类名称
	private String typeName;

	// 字符串值
	private Object selected;

	private String selected_;

	// 行显示个数
	private long rowNum;

	// 显示类型
	private long showType;

	// 数据类型
	private String valueType;

	// 显示
	private String showPercentage;

	private String onclick;

	private String percentNum;

	public void setShowPercentage(String showPercentage) {
		this.showPercentage = showPercentage;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public void setShowType(long showType) {
		this.showType = showType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setRowNum(long rowNum) {
		this.rowNum = rowNum;
	}

	public void setSelected(String selected_) {
		this.selected_ = selected_;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	private void evaluateExpressions() {
		try {
			if (selected_ != null) {
				selected = ExpressionEvaluatorManager.evaluate("selected",
						selected_, java.lang.Object.class, this, pageContext);
				selected_ = selected.toString();
			}

		} catch (Exception e) {
			;
		}
	}

	public int doStartTag() throws JspException {
		evaluateExpressions();
		return super.doStartTag();
	}

	public Object getValue(Object param1, Map param2) {
		String ctValue = "";
		if (param1 == null) {
			return null;
		}

		try {
			ctValue = Dicts.getChoosesStr(param1.toString(), name, typeName,
					selected_, rowNum, showType, valueType, showPercentage,
					onclick, percentNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ctValue;

	}

	/**
	 * @return the percentNum
	 */
	public String getPercentNum() {
		return percentNum;
	}

	/**
	 * @param percentNum the percentNum to set
	 */
	public void setPercentNum(String percentNum) {
		this.percentNum = percentNum;
	}

}
