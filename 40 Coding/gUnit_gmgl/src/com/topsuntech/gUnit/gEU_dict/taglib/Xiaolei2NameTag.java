package com.topsuntech.gUnit.gEU_dict.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.util.ExpressionEvaluationUtils;

import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryService;

public class Xiaolei2NameTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6462431488006176854L;

	private String nodeValue = "";

	private String insi = "";

	public String getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}

	public int doStartTag() throws JspException {
		nodeValue = (String) ExpressionEvaluationUtils.evaluate("nodeValue",
				nodeValue, String.class, pageContext);
		insi = (String) ExpressionEvaluationUtils.evaluate("insi", insi,
				String.class, pageContext);
		DictionaryService dao = new DictionaryService();
		JspWriter writer = pageContext.getOut();
		try {
			if (nodeValue == null || "".equals(nodeValue)) {
				writer.print("");
				return SKIP_BODY;
			}
			MetaData region = dao.getNodeValue(nodeValue, insi);
			nodeValue = region.getNode_name();
			if (nodeValue == null) {
				nodeValue = "";
			}

			writer.print(nodeValue);
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getInsi() {
		return insi;
	}

	public void setInsi(String insi) {
		this.insi = insi;
	}

}
