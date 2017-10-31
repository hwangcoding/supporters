package com.supporters.contents.domain;

import com.supporters.function.Paging;

public class RestaurantVO extends Paging {

	private String restaurant_seq;//	int(3)	아니오		seq
	private String restaurant_nm;//	varchar(30)	아니오		맛집 이름
	private String minor_cd;//	char(6)	예	null	맛집 종류 코드(공통코드)
	private String restaurant_phone;//	varchar(13)	예	null	맛집 번호
	private String restaurant_mainimg;//	varchar(100)	예	null	맛집 메인 이미지
	private String restaurant_address;//	varchar(150)	예	null	맛집 주소
	private String restaurant_delivery;//	char(1)	아니오		배달 유무
	private String restaurant_latitude;//	varchar(20)	아니오		위도
	private String restaurant_lognitode	;//varchar(20)	아니오		경도
	private String restaurant_displacement;//	int(11)	예	null
	private String minor_nm;
	
	
	
	public String getMinor_nm() {
		return minor_nm;
	}
	public void setMinor_nm(String minor_nm) {
		this.minor_nm = minor_nm;
	}
	public String getRestaurant_seq() {
		return restaurant_seq;
	}
	public void setRestaurant_seq(String restaurant_seq) {
		this.restaurant_seq = restaurant_seq;
	}
	public String getRestaurant_nm() {
		return restaurant_nm;
	}
	public void setRestaurant_nm(String restaurant_nm) {
		this.restaurant_nm = restaurant_nm;
	}
	public String getMinor_cd() {
		return minor_cd;
	}
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	public String getRestaurant_phone() {
		return restaurant_phone;
	}
	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}
	public String getRestaurant_mainimg() {
		return restaurant_mainimg;
	}
	public void setRestaurant_mainimg(String restaurant_mainimg) {
		this.restaurant_mainimg = restaurant_mainimg;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public String getRestaurant_delivery() {
		return restaurant_delivery;
	}
	public void setRestaurant_delivery(String restaurant_delivery) {
		this.restaurant_delivery = restaurant_delivery;
	}
	public String getRestaurant_latitude() {
		return restaurant_latitude;
	}
	public void setRestaurant_latitude(String restaurant_latitude) {
		this.restaurant_latitude = restaurant_latitude;
	}
	public String getRestaurant_lognitode() {
		return restaurant_lognitode;
	}
	public void setRestaurant_lognitode(String restaurant_lognitode) {
		this.restaurant_lognitode = restaurant_lognitode;
	}
	public String getRestaurant_displacement() {
		return restaurant_displacement;
	}
	public void setRestaurant_displacement(String restaurant_displacement) {
		this.restaurant_displacement = restaurant_displacement;
	}
	
	
	
	
	
	
}
