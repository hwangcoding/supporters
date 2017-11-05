package com.supporters.department.domain;

import com.supporters.function.Paging;

public class DecommunityVO extends Paging {

	
	private String community_seq;						//	int(6)	아니오 	 	 	seq 
	private String minor_cd;								//char(6)	예 	null 	minor_code_administrator -> minor_cd 	게시판 구분 코드(공통코드) 
	private String community_user_id;					//	varchar(20)	예 	null 	 	작성자 
	private String community_title;						//	varchar(100)	예 	null 	 	제목 
	private String community_content;				//	varchar(800)	예 	null 	 	내용 
	private String community_img;						//	varchar(50)	예 	null 	 	이미지 
	private String community_write_datetime;		//	timestamp	예 	current_timestamp 	 	작성날짜 
	private String community_revise_datetime;		//	timestamp	예 	null 	 	수정날짜 
	private String community_lookupcnt;				//	int(4)	예 	0 	 	조회수 
	private String community_delete_ch;				//
	
	
	
	
	
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
	public String getCommunity_delete_ch() {
		return community_delete_ch;
	}
	public void setCommunity_delete_ch(String community_delete_ch) {
		this.community_delete_ch = community_delete_ch;
	}
	
	
	
	
	
	
}
