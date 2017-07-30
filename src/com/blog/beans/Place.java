package com.blog.beans;

public class Place  {

	private Integer placeId;
	private String province;
	private String city;
	private String area;

	public Place() {
	}

	public Place(String province, String city, String area) {
		this.province = province;
		this.city = city;
		this.area = area;
	}

	public Integer getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
