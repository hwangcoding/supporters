package com.supporters.domain;

public class StatisticsVO {
	
	private String date;        // 날짜 값
	private String week_cnt; // 일주일 치 값
	private String all_cnt;     // 총 카운트 값
	
	
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
