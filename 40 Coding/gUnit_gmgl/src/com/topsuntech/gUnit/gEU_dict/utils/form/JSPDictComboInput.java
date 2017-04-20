/*
 * Created on 2004-10-9
 * 
 */
package com.topsuntech.gUnit.gEU_dict.utils.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.HibernateException;


import com.topsuntech.gOS.autocode.generator.castor.Attribute;
import com.topsuntech.gOS.autocode.generator.castor.Inputtype;
import com.topsuntech.gOS.autocode.generator.castor.Properties;
import com.topsuntech.gOS.autocode.generator.castor.Property;
import com.topsuntech.gOS.autocode.generator.presentation.plugins.AbstractInput;
import com.topsuntech.gOS.autocode.generator.presentation.plugins.IJSPInput;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_dict.en.NodeVO;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryQuery;

/**
 * @author Shaojingze
 * @date 2005-11-9
 *  
 */
public class JSPDictComboInput extends AbstractInput implements IJSPInput {

	private static final String DEFAULT_PROP_LIST = "";
	private String deptid = null;
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.topsuntech.gOS.autocode.generator.presentation.plugins.IJSPInput#createInput(com.topsuntech.gOS.autocode.generator.castor.Attribute,
	 *      java.lang.String)
	 */
	public String createInput(Attribute attr, String tableNameEN, Map requestMap) {
		
		
		
		
		StringBuffer buf = new StringBuffer();
		String propList = DEFAULT_PROP_LIST;
		String attrName = attr.getName();
		Properties prop = attr.getProperties();
		if (prop != null) {
			propList = attrString(prop);
		}
		Inputtype input = attr.getInputtype();
		String defaultValue = null;
		if (input != null) {
			defaultValue = input.getDefault();
		}
		String isCombo = "", bigTypeCode = "";
		Property[] properties = prop.getProperty();
		for (int j = 0; j < properties.length; j++) {
			if (properties[j].getName().equalsIgnoreCase("isCombo")) {
				isCombo = properties[j].getValue();
			} else if (properties[j].getName().equalsIgnoreCase("bigTypeCode")) {
				bigTypeCode = properties[j].getValue();
				Logger.debug("\n---w---the bigTypeCode = " + bigTypeCode);
			}
		}

		if ("true".equals(isCombo)) {
			buf
				.append("<select name='")
				.append(genInputName(tableNameEN, attrName))
				.append("' ")
				.append(propList)
				.append(">\n");
			//insert blank
			buf.append("<option value=' '>--</option>\n");
			try {
				List items = DictionaryQuery.findDicnyByCode(bigTypeCode,null);
				
				for (Iterator iter = items.iterator(); iter.hasNext();) {
					NodeVO element = (NodeVO) iter.next();
					String value = element.getCode();
					String name = element.getName();
					if (value.equalsIgnoreCase(defaultValue)) {
						buf
							.append("<option value='")
							.append(value)
							.append("' selected>")
							.append(name)
							.append("</option>\n");
					} else {
						buf.append("<option value='").append(value).append(
							"'>").append(name).append("</option>\n");
					}
				}
			} catch (TSDBException e) {
				e.printStackTrace();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buf.append("</select>\n");
		} else {
			try {
				List items = DictionaryQuery.findDicnyByCode(bigTypeCode,null);					
				for (Iterator iter = items.iterator(); iter.hasNext();) {
					NodeVO element = (NodeVO) iter.next();
					String value = element.getCode();
					String name = element.getName();
					if (value.equalsIgnoreCase(defaultValue)) {
						buf
							.append("        <input type='radio' value='")
							.append(value)
							.append("' name='")
							.append(genInputName(tableNameEN, attrName))
							.append("'")
							.append(propList)
							.append(" checked>")
							.append(name)
							.append("\n");
					} else {
						buf
							.append("        <input type='radio' value='")
							.append(value)
							.append("' name='")
							.append(genInputName(tableNameEN, attrName))
							.append("'")
							.append(propList)
							.append(">")
							.append(name)
							.append("\n");
					}
				}
			} catch (TSDBException e) {
				e.printStackTrace();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buf.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.topsuntech.gOS.autocode.generator.presentation.plugins.IJSPInput#createHTMLInput(com.topsuntech.gOS.autocode.generator.castor.Attribute)
	 */
	public String createHTMLInput(Attribute attr) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.topsuntech.gOS.autocode.generator.presentation.plugins.IJSPInput#createReadOnlyInput(com.topsuntech.gOS.autocode.generator.castor.Attribute, java.lang.String, java.lang.String)
	 */
	public String createReadOnlyInput(
		Attribute attr,
		String tableNameEN,
		String value, Map requestMap) {
		
		Logger.debug("=====\n\n======begin");
		
	   String propList = DEFAULT_PROP_LIST;
	   Properties prop = attr.getProperties();
		
		if (prop != null) {
			propList = attrString(prop);
		}
		
		if (value == null || value.trim().equals("")) {
			value = "&nbsp;";
		}
		
		String bigTypeCode = "";
		
		boolean useStatic = Boolean.valueOf(getPropertyString(prop, "static")).booleanValue();
		boolean isCombo = Boolean.valueOf(getPropertyString(prop, "isCombo")).booleanValue();
		bigTypeCode =getPropertyString(prop, "bigTypeCode");
		
		Logger.debug("\n---r-in plugin--the bigTypeCode = " + bigTypeCode);
		StringBuffer buf = new StringBuffer();
		
		if(useStatic){
			try {
				value = DictionaryQuery.findNameByType_Code(value,bigTypeCode);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			buf.append(value);
		}else if (isCombo) {
			try {
				value = DictionaryQuery.findNameByType_Code(value,bigTypeCode);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			buf.append(value);
		}else{
			
			List items = new ArrayList();
			try {
				items = DictionaryQuery.findDicnyByCode(bigTypeCode,null);
			} catch (HibernateException e1) {
				e1.printStackTrace();
			}
			for (Iterator iter = items.iterator(); iter.hasNext();) {
				NodeVO element = (NodeVO) iter.next();
				String elementValue = element.getCode();
				if (value.equalsIgnoreCase(elementValue)) {
					buf
							.append(
									"<img src='../images/checkbox_black.gif' width='10' height='10'>&nbsp;")
							.append(element.getName()).append("\n");
				} else {
					buf
							.append(
									"<img src='../images/checkbox_white.gif' width='10' height='10'>&nbsp;")
							.append(element.getName()).append("\n");
				}
			}
		}
		
		if(buf.length() > 0 && !buf.toString().equals("null")){			
			return buf.toString();
		}else{
			return "&nbsp;";
		}
		
	}
	
	
}