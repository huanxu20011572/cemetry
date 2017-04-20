package com.topsuntech.gUnit_xzqh.gEU_region.framework.actionForms;

import org.apache.struts.action.ActionForm;

public class GosRegionAdjustForm extends ActionForm {
	private Long id;
	private Long adjustType;
	private Long adjustLevel;
	private String adjustCountyIds;
	private String adjustCountyNames;
	private String adjustStreetIds;
	private String adjustStreetNames;
	private String adjustCommunityIds;
	private String adjustCommunityNames;
	private String newCountyIds;
	private String newCountyNames;
	private String newStreetIds;
	private String newStreetNames;
	private String newCommunityIds;
	private String newCommunityNames;
	private String stopDates;//ԭ����ͣ��ʱ��
	private Long isStop;

	//Ԥ������*/
	private String warnName; //Ԥ������
	private String adjustDates;//����ʱ��
	private String effectDates;//��Чʱ��
	private String warnContent;//Ԥ������
	private Long warnLevel;//Ԥ������
	private Long warnRegion;//Ԥ������
	private Long gosRegionAdjustId;//Ԥ����Ӧ��infoId
	//��ѯ����ʱ���
	private String startAdjustDate;// ��ʼ����ʱ�� 
	private String endAdjustDate; //��������ʱ�� 
	private String startEffectDate;// ��ʼ��Чʱ�� 
	private String endEffectDate; //������Чʱ��

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setAdjustType(Long adjustType){
		this.adjustType = adjustType;
	}

	public Long getAdjustType(){
		return adjustType;
	}

	public void setAdjustLevel(Long adjustLevel){
		this.adjustLevel = adjustLevel;
	}

	public Long getAdjustLevel(){
		return adjustLevel;
	}

	public void setAdjustCountyIds(String adjustCountyIds){
		this.adjustCountyIds = adjustCountyIds;
	}

	public String getAdjustCountyIds(){
		return adjustCountyIds;
	}

	public void setAdjustCountyNames(String adjustCountyNames){
		this.adjustCountyNames = adjustCountyNames;
	}

	public String getAdjustCountyNames(){
		return adjustCountyNames;
	}

	public void setAdjustStreetIds(String adjustStreetIds){
		this.adjustStreetIds = adjustStreetIds;
	}

	public String getAdjustStreetIds(){
		return adjustStreetIds;
	}

	public void setAdjustStreetNames(String adjustStreetNames){
		this.adjustStreetNames = adjustStreetNames;
	}

	public String getAdjustStreetNames(){
		return adjustStreetNames;
	}

	public void setAdjustCommunityIds(String adjustCommunityIds){
		this.adjustCommunityIds = adjustCommunityIds;
	}

	public String getAdjustCommunityIds(){
		return adjustCommunityIds;
	}

	public void setAdjustCommunityNames(String adjustCommunityNames){
		this.adjustCommunityNames = adjustCommunityNames;
	}

	public String getAdjustCommunityNames(){
		return adjustCommunityNames;
	}

	public void setNewCountyIds(String newCountyIds){
		this.newCountyIds = newCountyIds;
	}

	public String getNewCountyIds(){
		return newCountyIds;
	}

	public void setNewCountyNames(String newCountyNames){
		this.newCountyNames = newCountyNames;
	}

	public String getNewCountyNames(){
		return newCountyNames;
	}

	public void setNewStreetIds(String newStreetIds){
		this.newStreetIds = newStreetIds;
	}

	public String getNewStreetIds(){
		return newStreetIds;
	}

	public void setNewStreetNames(String newStreetNames){
		this.newStreetNames = newStreetNames;
	}

	public String getNewStreetNames(){
		return newStreetNames;
	}

	public void setNewCommunityIds(String newCommunityIds){
		this.newCommunityIds = newCommunityIds;
	}

	public String getNewCommunityIds(){
		return newCommunityIds;
	}

	public void setNewCommunityNames(String newCommunityNames){
		this.newCommunityNames = newCommunityNames;
	}

	public String getNewCommunityNames(){
		return newCommunityNames;
	}

	
	public void setIsStop(Long isStop){
		this.isStop = isStop;
	}

	public Long getIsStop(){
		return isStop;
	}


	public String getWarnName() {
		return warnName;
	}

	public void setWarnName(String warnName) {
		this.warnName = warnName;
	}


	public String getWarnContent() {
		return warnContent;
	}

	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}

	public Long getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(Long warnLevel) {
		this.warnLevel = warnLevel;
	}

	public Long getWarnRegion() {
		return warnRegion;
	}

	public void setWarnRegion(Long warnRegion) {
		this.warnRegion = warnRegion;
	}

	public String getStopDates() {
		return stopDates;
	}

	public void setStopDates(String stopDates) {
		this.stopDates = stopDates;
	}

	public String getAdjustDates() {
		return adjustDates;
	}

	public void setAdjustDates(String adjustDates) {
		this.adjustDates = adjustDates;
	}

	public String getEffectDates() {
		return effectDates;
	}

	public void setEffectDates(String effectDates) {
		this.effectDates = effectDates;
	}

	public Long getGosRegionAdjustId() {
		return gosRegionAdjustId;
	}

	public void setGosRegionAdjustId(Long gosRegionAdjustId) {
		this.gosRegionAdjustId = gosRegionAdjustId;
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
