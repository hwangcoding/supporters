package com.supporters.dao;

import com.supporters.domain.LoginVO;

public interface LoginDAO {

	
	public LoginVO login(LoginVO vo) throws Exception;
	
	public void logout(LoginVO vo) throws Exception;
	
	public void dateLogin(LoginVO vo) throws Exception;
	
}
