package com.supporters.contents.domain;

import com.supporters.function.Paging;

public class FictionGameVO  extends Paging{

	private String fiction_seq; //	int(11)	아니오		seq
	private String user_num	; //char(10)	아니오		작성자(학생 아이디)
	private String fiction_content	; //varchar(500)	예	null	내용
	private String fiction_write_datetime	; //timestamp	예	CURRENT_TIMESTAMP	작성날짜
	
	
	
	public String getFiction_seq() {
		return fiction_seq;
	}
	public void setFiction_seq(String fiction_seq) {
		this.fiction_seq = fiction_seq;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getFiction_content() {
		return fiction_content;
	}
	public void setFiction_content(String fiction_content) {
		this.fiction_content = fiction_content;
	}
	public String getFiction_write_datetime() {
		return fiction_write_datetime;
	}
	public void setFiction_write_datetime(String fiction_write_datetime) {
		this.fiction_write_datetime = fiction_write_datetime;
	}
	
	
	
	
}
