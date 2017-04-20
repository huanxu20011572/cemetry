package com.topsuntech.gUnit.gEU_dict.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.ExpressionEvaluationUtils;

import com.topsuntech.gUnit.gEU_dict.service.DynamicSelectDao;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;

public class RegionCode2NameTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8748890736946775796L;
	private String regionCode="";
	
	
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public int doStartTag() throws JspException{
		regionCode = (String) ExpressionEvaluationUtils.evaluate("regionCode",
				regionCode, String.class, pageContext);
		DynamicSelectDao dao=new DynamicSelectDao();
		 JspWriter writer = pageContext.getOut();
		 if(StringUtils.isNotBlank(regionCode)){
			try {
				if(regionCode!=null &&  !"".equals(regionCode)){
				SjRegion region=dao.findByStandardNo(regionCode);				
				regionCode=region.getName();
				}else{
					regionCode="";
				}
				writer.print(regionCode);
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			} catch (Exception e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
		 }
		return SKIP_BODY;
		}
}
