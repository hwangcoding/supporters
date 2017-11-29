package com.supporters.domain;

import com.supporters.function.Paging;

public class AlertLogVO extends Paging {
	
	private String alert_seq;
	private String minor_cd;
	private String alert_content;
	private String alert_write_datetime;
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
	 * @return the alert_content
	 */
	public String getAlert_content() {
		return alert_content;
	}
	/**
	 * @param alert_content the alert_content to set
	 */
	public void setAlert_content(String alert_content) {
		this.alert_content = alert_content;
	}
	/**
	 * @return the alert_seq
	 */
	public String getAlert_seq() {
		return alert_seq;
	}
	/**
	 * @param alert_seq the alert_seq to set
	 */
	public void setAlert_seq(String alert_seq) {
		this.alert_seq = alert_seq;
	}
	/**
	 * @return the alert_write_datetime
	 */
	public String getAlert_write_datetime() {
		return alert_write_datetime;
	}
	/**
	 * @param alert_write_datetime the alert_write_datetime to set
	 */
	public void setAlert_write_datetime(String alert_write_datetime) {
		this.alert_write_datetime = alert_write_datetime;
	}

	
	
}
