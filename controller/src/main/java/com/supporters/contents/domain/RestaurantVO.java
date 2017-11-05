package com.supporters.contents.domain;

import com.supporters.function.Paging;

public class RestaurantVO extends Paging {

	private String restaurant_seq; /*맛집 seq*/
	private String restaurant_nm; /*맛집 이름*/
	private String minor_cd; /*식당 종류 구분 코드*/
	private String minor_nm; /*식당 종류 구분 코드*/
	private String restaurant_phone; /*맛집 전화번호*/
	private String restaurant_mainimg; /*맛집 메인 이미지*/
	private String restaurant_address; /*맛집 주소*/
	private String restaurant_delivery; /*배달 가능 유무 확인*/
	private String restaurant_latitude; /*맛집 위도*/
	private String restaurant_lognitode; /*맛집 경도*/
	private String restaurant_displacement; /*재능대까지의 거리*/
	private String restaurant_write_datetime; /*작성날짜*/
	private String restaurant_revise_datetime; /*수정날짜*/
	private String user_num;
	private String review_content;
	/**
	 * @return the restaurant_seq
	 */
	public String getRestaurant_seq() {
		return restaurant_seq;
	}
	/**
	 * @param restaurant_seq the restaurant_seq to set
	 */
	public void setRestaurant_seq(String restaurant_seq) {
		this.restaurant_seq = restaurant_seq;
	}
	/**
	 * @return the restaurant_nm
	 */
	public String getRestaurant_nm() {
		return restaurant_nm;
	}
	/**
	 * @param restaurant_nm the restaurant_nm to set
	 */
	public void setRestaurant_nm(String restaurant_nm) {
		this.restaurant_nm = restaurant_nm;
	}
	/**
	 * @return the minor_cd
	 */
	public String getMinor_cd() {
		return minor_cd;
	}
	/**
	 * @param minor_cd the minor_cd to set
	 */
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	/**
	 * @return the minor_nm
	 */
	public String getMinor_nm() {
		return minor_nm;
	}
	/**
	 * @param minor_nm the minor_nm to set
	 */
	public void setMinor_nm(String minor_nm) {
		this.minor_nm = minor_nm;
	}
	/**
	 * @return the restaurant_phone
	 */
	public String getRestaurant_phone() {
		return restaurant_phone;
	}
	/**
	 * @param restaurant_phone the restaurant_phone to set
	 */
	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}
	/**
	 * @return the restaurant_mainimg
	 */
	public String getRestaurant_mainimg() {
		return restaurant_mainimg;
	}
	/**
	 * @param restaurant_mainimg the restaurant_mainimg to set
	 */
	public void setRestaurant_mainimg(String restaurant_mainimg) {
		this.restaurant_mainimg = restaurant_mainimg;
	}
	/**
	 * @return the restaurant_address
	 */
	public String getRestaurant_address() {
		return restaurant_address;
	}
	/**
	 * @param restaurant_address the restaurant_address to set
	 */
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	/**
	 * @return the restaurant_delivery
	 */
	public String getRestaurant_delivery() {
		return restaurant_delivery;
	}
	/**
	 * @param restaurant_delivery the restaurant_delivery to set
	 */
	public void setRestaurant_delivery(String restaurant_delivery) {
		this.restaurant_delivery = restaurant_delivery;
	}
	/**
	 * @return the restaurant_latitude
	 */
	public String getRestaurant_latitude() {
		return restaurant_latitude;
	}
	/**
	 * @param restaurant_latitude the restaurant_latitude to set
	 */
	public void setRestaurant_latitude(String restaurant_latitude) {
		this.restaurant_latitude = restaurant_latitude;
	}
	/**
	 * @return the restaurant_lognitode
	 */
	public String getRestaurant_lognitode() {
		return restaurant_lognitode;
	}
	/**
	 * @param restaurant_lognitode the restaurant_lognitode to set
	 */
	public void setRestaurant_lognitode(String restaurant_lognitode) {
		this.restaurant_lognitode = restaurant_lognitode;
	}
	/**
	 * @return the restaurant_displacement
	 */
	public String getRestaurant_displacement() {
		return restaurant_displacement;
	}
	/**
	 * @param restaurant_displacement the restaurant_displacement to set
	 */
	public void setRestaurant_displacement(String restaurant_displacement) {
		this.restaurant_displacement = restaurant_displacement;
	}
	/**
	 * @return the restaurant_write_datetime
	 */
	public String getRestaurant_write_datetime() {
		return restaurant_write_datetime;
	}
	/**
	 * @param restaurant_write_datetime the restaurant_write_datetime to set
	 */
	public void setRestaurant_write_datetime(String restaurant_write_datetime) {
		this.restaurant_write_datetime = restaurant_write_datetime;
	}
	/**
	 * @return the restaurant_revise_datetime
	 */
	public String getRestaurant_revise_datetime() {
		return restaurant_revise_datetime;
	}
	/**
	 * @param restaurant_revise_datetime the restaurant_revise_datetime to set
	 */
	public void setRestaurant_revise_datetime(String restaurant_revise_datetime) {
		this.restaurant_revise_datetime = restaurant_revise_datetime;
	}
	/**
	 * @return the user_num
	 */
	public String getUser_num() {
		return user_num;
	}
	/**
	 * @param user_num the user_num to set
	 */
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	/**
	 * @return the review_content
	 */
	public String getReview_content() {
		return review_content;
	}
	/**
	 * @param review_content the review_content to set
	 */
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	
	
	

}
