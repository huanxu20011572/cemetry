/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.entity.ApMultipickContent;
import com.topsuntech.gUnit.gEU_util.entity.Dictionary;
import com.topsuntech.gUnit.gEU_util.tools.Constants;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author zcpeng
 * 
 */
public class ShjzMultipleChoiceTag extends TagSupport {
	// 默认列数为1
	private int columns = 1;
	// 当前控件类型[默认为0]
	private int currentType = 0;
	// 当前查询类型
	private String currentMultipleType = Constants.MULTIPLE_TYPE.DICT;

	private PageContext pageContext;
	// 控件名称
	private Object name;
	// 字典typename
	private Object typename;
	// 样式表
	private Object className;
	// 列数
	private Object cols;
	// 控件类型 0：初始化 1：编辑 2：展示
	private Object type;
	// 标识 dict:查询字典 custom:自定义查询
	private Object multipleType;
	// 自定义id
	private Object customId;
	// 主表id，如果有选中值得，则此项必传
	private Object mainTableId;

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(Object name) {
		this.name = name;
	}

	/**
	 * @param typename
	 *            the typename to set
	 */
	public void setTypename(Object typename) throws JspException {
		if (typename != null)
			this.typename = ExpressionEvaluatorManager.evaluate("typename", typename.toString(), Object.class, this, pageContext);
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(Object className) {
		this.className = className;
	}

	/**
	 * @param cols
	 *            the cols to set
	 */
	public void setCols(Object cols) {
		this.cols = cols;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Object type) {
		this.type = type;
	}

	/**
	 * @param multipleType
	 *            the multipleType to set
	 */
	public void setMultipleType(Object multipleType) {
		this.multipleType = multipleType;
	}

	/**
	 * @param customId
	 *            the customId to set
	 */
	public void setCustomId(Object customId) throws JspException {
		if (customId != null)
			this.customId = ExpressionEvaluatorManager.evaluate("customId", customId.toString(), Object.class, this, pageContext);
	}

	/**
	 * @param mainTableId
	 *            the mainTableId to set
	 */
	public void setMainTableId(Object mainTableId) throws JspException {
		if (mainTableId != null)
			this.mainTableId = ExpressionEvaluatorManager.evaluate("mainTableId", mainTableId.toString(), Object.class, this, pageContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return TagSupport.EVAL_PAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		// 当前多选类型：字典/自建
		if (multipleType != null && !"".equals(multipleType.toString().trim()))
			currentMultipleType = multipleType.toString();

		try {
			List list = null;
			if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.DICT))
				// 获取字典列表
				list = Dicts.getDictListByTypeName(typename.toString());
			else if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.CUSTOM))
				// 获取自建表
				list = Dicts.queryCustomMultipleChoiseList(customId);

			// 当前多选框类型 初始/编辑/展示
			if (type == null || "".equals(type.toString().trim()))
				currentType = 0;
			else
				currentType = new Integer(type.toString()).intValue();

			String html = "";
			if (currentType == 0 || currentType == 1)
				// 初始或者可编辑
				html = buildMutipleChoiseBox(list, mainTableId);
			else if (currentType == 2)
				// 展示功能
				html = showMutipleChoiseBox(list, mainTableId);
			JspWriter out = pageContext.getOut();
			out.write(html);
		} catch (TSDBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return TagSupport.EVAL_PAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#release()
	 */
	@Override
	public void release() {
		// TODO Auto-generated method stub
		this.name = null;
		this.typename = null;
		this.className = null;
		this.cols = null;
		this.type = null;
		this.multipleType = null;
		this.customId = null;
		super.release();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.jsp.tagext.TagSupport#setPageContext(javax.servlet.jsp.
	 * PageContext)
	 */
	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		this.pageContext = pageContext;
		super.setPageContext(pageContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.jsp.tagext.TagSupport#setParent(javax.servlet.jsp.tagext
	 * .Tag)
	 */
	@Override
	public void setParent(Tag t) {
		// TODO Auto-generated method stub
		super.setParent(t);
	}

	/**
	 * 构建初始多选框[初始和编辑]
	 * 
	 * @param dictList
	 * @return
	 */
	private String buildMutipleChoiseBox(List list, Object mainTableId) throws TSDBException {
		if (list == null || list.isEmpty())
			return null;
		if (cols != null && !"".equals(cols.toString().trim()))
			columns = new Integer(cols.toString()).intValue();

		StringBuffer hql = new StringBuffer();
		hql.append("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\">");
		int i = 0;
		if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.DICT)) {
			for (Dictionary dictionary : (List<Dictionary>) list) {
				i++;
				if (i % columns == 1) {
					hql.append("<tr>");
				}
				hql.append("<td>");
				hql.append("<input type=\"checkbox\" name=\"").append(name).append("\"").append(" ");
				// 如果当前为编辑，则勾选已选中的选项
				if (currentType == 1) {
					List<ApMultipickContent> chooseList = (List<ApMultipickContent>) Dicts.queryApMultipickContentListByMainTableId(mainTableId, currentMultipleType);
					Iterator<ApMultipickContent> chooseIter = chooseList.iterator();
					while (chooseIter.hasNext()) {
						ApMultipickContent apMultipickContent = (ApMultipickContent) chooseIter.next();
						if (apMultipickContent.getChooseContent() != null && apMultipickContent.getChooseContent().longValue() == dictionary.getId())
							hql.append("checked='checked'").append(" ");
					}
				}
				if (className == null || "".equals(className.toString().trim()))
					hql.append("class=\"input\"");
				else
					hql.append("class=\"").append(className).append("\"").append(" ");
				hql.append("value=\"").append(dictionary.getId()).append("\"");
				hql.append("/>");
				hql.append(dictionary.getName());
				hql.append("</td>");
				if (i % columns == 0)
					hql.append("</tr>");
			}
		} else if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.CUSTOM)) {
			for (Map<String, Object> map : (List<Map<String, Object>>) list) {
				i++;
				if (i % columns == 1) {
					hql.append("<tr>");
				}
				hql.append("<td>");
				hql.append("<input type=\"checkbox\" name=\"").append(name).append("\"").append(" ");
				// 如果当前为编辑，则勾选已选中的选项
				if (currentType == 1) {
					List<ApMultipickContent> chooseList = (List<ApMultipickContent>) Dicts.queryApMultipickContentListByMainTableId(mainTableId, currentMultipleType);
					Iterator<ApMultipickContent> chooseIter = chooseList.iterator();
					while (chooseIter.hasNext()) {
						ApMultipickContent apMultipickContent = (ApMultipickContent) chooseIter.next();
						if (apMultipickContent.getChooseContent() != null && apMultipickContent.getChooseContent().longValue() == new Long(map.get("id").toString()).longValue())
							hql.append("checked='checked'").append(" ");
					}
				}
				if (className == null || "".equals(className.toString().trim()))
					hql.append("class=\"input\"");
				else
					hql.append("class=\"").append(className).append("\"").append(" ");
				hql.append("value=\"").append(map.get("id").toString()).append("\"");
				hql.append("/>");
				if (map.get("standardContent") != null)
					hql.append(map.get("standardContent").toString());
				hql.append("</td>");
				if (i % columns == 0)
					hql.append("</tr>");
			}
		}

		if (i % columns != 0) {
			for (int j = (i % columns); j < columns; j++) {
				hql.append("<td></td>");
				if (j == columns)
					hql.append("</tr>");
			}
		}
		hql.append("</table>");
		return hql.toString();
	}

	/**
	 * 展示多选内容[明细页面]
	 * 
	 * @param list
	 * @param mainTableId
	 * @return
	 * @throws TSDBException
	 */
	private String showMutipleChoiseBox(List list, Object mainTableId) throws TSDBException {
		if (list == null || list.isEmpty())
			return null;
		if (cols != null && !"".equals(cols.toString().trim()))
			columns = new Integer(cols.toString()).intValue();

		StringBuffer hql = new StringBuffer();
		if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.DICT)) {
			// 获取已选中的项目
			List<Long> chooseList = new ArrayList<Long>();
			List<ApMultipickContent> multipickList = (List<ApMultipickContent>) Dicts.queryApMultipickContentListByMainTableId(mainTableId, currentMultipleType);
			for (ApMultipickContent apMultipickContent : multipickList) {
				chooseList.add(apMultipickContent.getChooseContent());
			}
			List<Dictionary> dictList = Dicts.queryChooseDictListForMultipleChoise(chooseList);
			if (dictList != null && !dictList.isEmpty()) {
				hql.append("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\">");
				int i = 0;
				for (Dictionary dictionary : dictList) {
					i++;
					if (i % columns == 1) {
						hql.append("<tr>");
					}
					hql.append("<td>");
					hql.append(dictionary.getName());
					hql.append("</td>");
					if (i % columns == 0)
						hql.append("</tr>");
				}
				if (i % columns != 0) {
					for (int j = (i % columns); j < columns; j++) {
						hql.append("<td></td>");
						if (j == columns)
							hql.append("</tr>");
					}
				}
				hql.append("</table>");
			}
		} else if (currentMultipleType.equals(Constants.MULTIPLE_TYPE.CUSTOM)) {
			// 获取已选中的项目
			List<Long> chooseList = new ArrayList<Long>();
			List<ApMultipickContent> multipickList = (List<ApMultipickContent>) Dicts.queryApMultipickContentListByMainTableId(mainTableId, currentMultipleType);
			for (ApMultipickContent apMultipickContent : multipickList) {
				chooseList.add(apMultipickContent.getChooseContent());
			}
			List<Map<String, Object>> customList = Dicts.queryChooseCustomMultipleChoiseList(customId, chooseList);
			if (customList != null && !customList.isEmpty()) {
				hql.append("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\">");
				int i = 0;
				for (Map<String, Object> map : customList) {
					i++;
					if (i % columns == 1) {
						hql.append("<tr>");
					}
					hql.append("<td>");
					hql.append(map.get("standardContent").toString());
					hql.append("</td>");
					if (i % columns == 0)
						hql.append("</tr>");
				}
				if (i % columns != 0) {
					for (int j = (i % columns); j < columns; j++) {
						hql.append("<td></td>");
						if (j == columns)
							hql.append("</tr>");
					}
				}
				hql.append("</table>");
			}
		}
		return hql.toString();
	}
}
