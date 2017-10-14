package com.supporters.domain;

import com.supporters.function.Paging;

public class CommunityVO extends Paging{

	private String community_seq;  		// 아니오seq
	private String minor_cd; //게시판 구분 코드(공통코드)
	private String community_user_id ; //작성자
	private String community_title; //제목
	private String community_content; //내용
	private String community_img; //이미지
	private String community_used_price; //중고장터용 가격
	private String community_used_img1; //중고장터용 이미지1
	private String community_used_img2 ; //중고장터용 이미지2
	private String community_used_img3 ; //중고장터용 이미지3
	private String community_used_cheak ;// 판매상태 확인
	private String community_used_group; //구매 판매 구분
	private String community_meeting_date  ;//과팅용 약속 날짜
	private String community_write_datetime ;// 작성날짜
	private String community_revise_datetime ; //수정날짜
	private String community_lookupcnt; //조회수
	
	
	
	public String getCommunity_seq() {
		return community_seq;
	}
	public void setCommunity_seq(String community_seq) {
		this.community_seq = community_seq;
	}

	public String getMinor_cd() {
		return minor_cd;
	}
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	public String getCommunity_user_id() {
		return community_user_id;
	}
	public void setCommunity_user_id(String community_user_id) {
		this.community_user_id = community_user_id;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_content() {
		return community_content;
	}
	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}
	public String getCommunity_img() {
		return community_img;
	}
	public void setCommunity_img(String community_img) {
		this.community_img = community_img;
	}
	public String getCommunity_used_price() {
		return community_used_price;
	}
	public void setCommunity_used_price(String community_used_price) {
		this.community_used_price = community_used_price;
	}
	public String getCommunity_used_img1() {
		return community_used_img1;
	}
	public void setCommunity_used_img1(String community_used_img1) {
		this.community_used_img1 = community_used_img1;
	}
	public String getCommunity_used_img2() {
		return community_used_img2;
	}
	public void setCommunity_used_img2(String community_used_img2) {
		this.community_used_img2 = community_used_img2;
	}
	public String getCommunity_used_img3() {
		return community_used_img3;
	}
	public void setCommunity_used_img3(String community_used_img3) {
		this.community_used_img3 = community_used_img3;
	}
	public String getCommunity_used_cheak() {
		return community_used_cheak;
	}
	public void setCommunity_used_cheak(String community_used_cheak) {
		this.community_used_cheak = community_used_cheak;
	}
	public String getCommunity_used_group() {
		return community_used_group;
	}
	public void setCommunity_used_group(String community_used_group) {
		this.community_used_group = community_used_group;
	}
	public String getCommunity_meeting_date() {
		return community_meeting_date;
	}
	public void setCommunity_meeting_date(String community_meeting_date) {
		this.community_meeting_date = community_meeting_date;
	}
	public String getCommunity_write_datetime() {
		return community_write_datetime;
	}
	public void setCommunity_write_datetime(String community_write_datetime) {
		this.community_write_datetime = community_write_datetime;
	}
	public String getCommunity_revise_datetime() {
		return community_revise_datetime;
	}
	public void setCommunity_revise_datetime(String community_revise_datetime) {
		this.community_revise_datetime = community_revise_datetime;
	}
	public String getCommunity_lookupcnt() {
		return community_lookupcnt;
	}
	public void setCommunity_lookupcnt(String community_lookupcnt) {
		this.community_lookupcnt = community_lookupcnt;
	}

	
	
}
