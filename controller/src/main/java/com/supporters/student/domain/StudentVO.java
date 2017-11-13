package com.supporters.student.domain;


import com.supporters.function.Paging;

public class StudentVO extends Paging {

	
	private String user_num;//	학생 아이디
	private String minor_cd;//학과 구분 코드(공통코드)
	private String user_nm;// 학생 이름
	private String user_pw;//학생 비밀번호
	private String user_phone;// 학생 전화번호
	private String user_birth;// 학생 생년월일
	private String user_gender;//학생 성별
	private String user_atten;// 학생 재학상태
	private String user_email;// 학생 이메일
	private String user_joindate;// 학생 가입 일자
	private String user_lastlogin;// 학생 마지막 로그인
	private String user_token; // 회원 토큰 정보
	
	
	
	public String getUser_token() {
		return user_token;
	}
	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getMinor_cd() {
		return minor_cd;
	}
	public void setMinor_cd(String minor_cd) {
		this.minor_cd = minor_cd;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_atten() {
		return user_atten;
	}
	public void setUser_atten(String user_atten) {
		this.user_atten = user_atten;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}
	public String getUser_lastlogin() {
		return user_lastlogin;
	}
	public void setUser_lastlogin(String user_lastlogin) {
		this.user_lastlogin = user_lastlogin;
	}
	
	
	
}
