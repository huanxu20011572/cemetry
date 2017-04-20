package com.topsuntech.gUnit_xzqh.gEU_region.service.vo;

import java.util.Date;

public class GosRegionWarnQueryBean{
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
	private Long gosRegionAdjustId;
	private Long adjustType;
	private Long adjustLevel;
	//查询所用时间段
	private String startAdjustDate;// 开始调整时间 
	private String endAdjustDate; //结束调整时间 
	private String startEffectDate;// 开始生效时间 
	private String endEffectDate; //结束生效时间
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

	public Long getGosRegionAdjustId() {
		return gosRegionAdjustId;
	}

	public void setGosRegionAdjustId(Long gosRegionAdjustId) {
		this.gosRegionAdjustId = gosRegionAdjustId;
	}

	public Long getAdjustType() {
		return adjustType;
	}

	public void setAdjustType(Long adjustType) {
		this.adjustType = adjustType;
	}

	public Long getAdjustLevel() {
		return adjustLevel;
	}

	public void setAdjustLevel(Long adjustLevel) {
		this.adjustLevel = adjustLevel;
	}

	public String getStartAdjustDate() {
		return startAdjustDate;
	}

	public void setStartAdjustDate(String startAdjustDate) {
		this.startAdjustDate = startAdjustDate;
	}

	public String getEndAdjustDate() {
		return endAdjustDate;
	}

	public void setEndAdjustDate(String endAdjustDate) {
		this.endAdjustDate = endAdjustDate;
	}

	public String getStartEffectDate() {
		return startEffectDate;
	}

	public void setStartEffectDate(String startEffectDate) {
		this.startEffectDate = startEffectDate;
	}

	public String getEndEffectDate() {
		return endEffectDate;
	}

	public void setEndEffectDate(String endEffectDate) {
		this.endEffectDate = endEffectDate;
	}

}
