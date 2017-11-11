package com.supporters.contents.domain;

import com.supporters.function.Paging;

public class UsedVO extends Paging {

	
	private String used_seq	;//int(6)	아니오 	 	 	 
	private String minor_cd;//	char(6)	예 	null 	minor_code_administrator -> minor_cd 	 
	private String used_user_id;//	varchar(20)	예 	null 	 	 
	private String used_title;//	varchar(100)	예 	null 	 	 
	private String used_content;//	varchar(800)	예 	null 	 	 
	private String used_price;//	int(7)	아니오 	 	 	 
	private String used_cheak;//	char(1)	예 	1 	 	 
	private String used_group;//	char(1)	아니오 	 	 	 
	private String used_img1;//	varchar(50)	예 	null 	 	 
	private String used_img2;//	varchar(50)	예 	null 	 	 
	private String used_img3;//	varchar(50)	예 	null 	 	 
	private String used_write_datetime;//	timestamp	아니오 	current_timestamp 	 	 
	private String used_revise_datetime;//	timestamp	아니오 	0000-00-00 00:00:00 	 	 
	private String used_lookupcnt;//	int(4)	예 	0 	 	 
	private String used_delete_ch;//
	
	
	
	public String getUsed_user_id() {
		return used_user_id;
	}
	public void setUsed_user_id(String used_user_id) {
		this.used_user_id = used_user_id;
	}
	public String getUsed_seq() {
		return used_seq;
	}
	public void setUsed_seq(String used_seq) {
		this.used_seq = used_seq;
	}
	public String getMinor_cd() {
		return minor_cd;
	}
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	public String getUsed_title() {
		return used_title;
	}
	public void setUsed_title(String used_title) {
		this.used_title = used_title;
	}
	public String getUsed_content() {
		return used_content;
	}
	public void setUsed_content(String used_content) {
		this.used_content = used_content;
	}
	public String getUsed_price() {
		return used_price;
	}
	public void setUsed_price(String used_price) {
		this.used_price = used_price;
	}
	public String getUsed_cheak() {
		return used_cheak;
	}
	public void setUsed_cheak(String used_cheak) {
		this.used_cheak = used_cheak;
	}
	public String getUsed_group() {
		return used_group;
	}
	public void setUsed_group(String used_group) {
		this.used_group = used_group;
	}
	public String getUsed_img1() {
		return used_img1;
	}
	public void setUsed_img1(String used_img1) {
		this.used_img1 = used_img1;
	}
	public String getUsed_img2() {
		return used_img2;
	}
	public void setUsed_img2(String used_img2) {
		this.used_img2 = used_img2;
	}
	public String getUsed_img3() {
		return used_img3;
	}
	public void setUsed_img3(String used_img3) {
		this.used_img3 = used_img3;
	}
	public String getUsed_write_datetime() {
		return used_write_datetime;
	}
	public void setUsed_write_datetime(String used_write_datetime) {
		this.used_write_datetime = used_write_datetime;
	}
	public String getUsed_revise_datetime() {
		return used_revise_datetime;
	}
	public void setUsed_revise_datetime(String used_revise_datetime) {
		this.used_revise_datetime = used_revise_datetime;
	}
	public String getUsed_lookupcnt() {
		return used_lookupcnt;
	}
	public void setUsed_lookupcnt(String used_lookupcnt) {
		this.used_lookupcnt = used_lookupcnt;
	}
	public String getUsed_delete_ch() {
		return used_delete_ch;
	}
	public void setUsed_delete_ch(String used_delete_ch) {
		this.used_delete_ch = used_delete_ch;
	}
	
	
	
}
