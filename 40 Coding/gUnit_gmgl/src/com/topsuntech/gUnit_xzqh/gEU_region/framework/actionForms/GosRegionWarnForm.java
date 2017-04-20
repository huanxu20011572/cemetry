package com.topsuntech.gUnit_xzqh.gEU_region.framework.actionForms;

import org.apache.struts.action.ActionForm;
import java.util.Date;

public class GosRegionWarnForm extends ActionForm {
	private Long id;
	private String warnName;
	private Date adjustDate;
	private Date effectDate;
	private String warnContent;
	private Long warnLevel;
	private Long warnRegion;
	private Date createDate;
	private Long useFlag;
	private Long createUserId;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setWarnName(String warnName){
		this.warnName = warnName;
	}

	public String getWarnName(){
		return warnName;
	}

	public void setAdjustDate(Date adjustDate){
		this.adjustDate = adjustDate;
	}

	public Date getAdjustDate(){
		return adjustDate;
	}

	public void setEffectDate(Date effectDate){
		this.effectDate = effectDate;
	}

	public Date getEffectDate(){
		return effectDate;
	}

	public void setWarnContent(String warnContent){
		this.warnContent = warnContent;
	}

	public String getWarnContent(){
		return warnContent;
	}

	public void setWarnLevel(Long warnLevel){
		this.warnLevel = warnLevel;
	}

	public Long getWarnLevel(){
		return warnLevel;
	}

	public void setWarnRegion(Long warnRegion){
		this.warnRegion = warnRegion;
	}

	public Long getWarnRegion(){
		return warnRegion;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setUseFlag(Long useFlag){
		this.useFlag = useFlag;
	}

	public Long getUseFlag(){
		return useFlag;
	}

	public void setCreateUserId(Long createUserId){
		this.createUserId = createUserId;
	}

	public Long getCreateUserId(){
		return createUserId;
	}

}
