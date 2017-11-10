package com.supporters.department.domain;

import com.supporters.function.Paging;

public class NoticeVO extends Paging {


	private String department_notice_seq;//	int(11)	아니오 	 	 	 
	private String minor_cd	;//char(6)	예 	null 	minor_code_administrator -> minor_cd 	 
	private String department_notice_user_id;//	varchar(20)	예 	null 	 	 
	private String department_notice_title	;//varchar(100)	예 	null 	 	 
	private String department_notice_content;//	varchar(800)	예 	null 	 	 
	private String department_notice_img;//	varchar(50)	예 	null 	 	 
	private String department_notice_write_datetime;//	timestamp	아니오 	current_timestamp 	 	 
	private String department_notice_revise_datetime;//	timestamp	아니오 	0000-00-00 00:00:00 	 	 
	private String department_notice_delete_ch;//
	private String department_notice_lookupcnt ;
	
	
	
	public String getDepartment_notice_lookupcnt() {
		return department_notice_lookupcnt;
	}
	public void setDepartment_notice_lookupcnt(String department_notice_lookupcnt) {
		this.department_notice_lookupcnt = department_notice_lookupcnt;
	}
	public String getDepartment_notice_seq() {
		return department_notice_seq;
	}
	public void setDepartment_notice_seq(String department_notice_seq) {
		this.department_notice_seq = department_notice_seq;
	}
	public String getMinor_cd() {
		return minor_cd;
	}
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	public String getDepartment_notice_user_id() {
		return department_notice_user_id;
	}
	public void setDepartment_notice_user_id(String department_notice_user_id) {
		this.department_notice_user_id = department_notice_user_id;
	}
	public String getDepartment_notice_title() {
		return department_notice_title;
	}
	public void setDepartment_notice_title(String department_notice_title) {
		this.department_notice_title = department_notice_title;
	}
	public String getDepartment_notice_content() {
		return department_notice_content;
	}
	public void setDepartment_notice_content(String department_notice_content) {
		this.department_notice_content = department_notice_content;
	}
	public String getDepartment_notice_img() {
		return department_notice_img;
	}
	public void setDepartment_notice_img(String department_notice_img) {
		this.department_notice_img = department_notice_img;
	}
	public String getDepartment_notice_write_datetime() {
		return department_notice_write_datetime;
	}
	public void setDepartment_notice_write_datetime(String department_notice_write_datetime) {
		this.department_notice_write_datetime = department_notice_write_datetime;
	}
	public String getDepartment_notice_revise_datetime() {
		return department_notice_revise_datetime;
	}
	public void setDepartment_notice_revise_datetime(String department_notice_revise_datetime) {
		this.department_notice_revise_datetime = department_notice_revise_datetime;
	}
	public String getDepartment_notice_delete_ch() {
		return department_notice_delete_ch;
	}
	public void setDepartment_notice_delete_ch(String department_notice_delete_ch) {
		this.department_notice_delete_ch = department_notice_delete_ch;
	}
		
		
	
	
	
	
	
	
}
