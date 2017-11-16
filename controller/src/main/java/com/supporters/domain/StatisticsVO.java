package com.supporters.domain;

import com.supporters.function.Paging;

public class StatisticsVO  extends Paging{
	
	private String date;        // 날짜 값
	private String week_cnt; // 일주일 치 값
	private String all_cnt;     // 총 카운트 값
	private String join;			// 회원수값
	
	
	
	
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek_cnt() {
		return week_cnt;
	}
	public void setWeek_cnt(String week_cnt) {
		this.week_cnt = week_cnt;
	}
	public String getAll_cnt() {
		return all_cnt;
	}
	public void setAll_cnt(String all_cnt) {
		this.all_cnt = all_cnt;
	}
	

}
