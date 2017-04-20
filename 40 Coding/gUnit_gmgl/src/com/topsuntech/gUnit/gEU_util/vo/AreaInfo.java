package com.topsuntech.gUnit.gEU_util.vo;

public class AreaInfo {

	/** nullable persistent field */
	private Long provinceId;

	/** nullable persistent field */
	private Long cityId;

	/** nullable persistent field */
	private Long countyId;

	/** nullable persistent field */
	private Long streetId;

	/** nullable persistent field */
	private Long communityId;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}

	public AreaInfo(Long provinceId, Long cityId, Long countyId, Long streetId, Long communityId) {
		super();
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.countyId = countyId;
		this.streetId = streetId;
		this.communityId = communityId;
	}

	public AreaInfo() {
		super();
	}

}
