package com.supporters.service;

import com.supporters.domain.LoginVO;

public interface LoginService {

		public LoginVO login(LoginVO vo) throws Exception;
		
		public void logout(LoginVO vo) throws Exception;
		
		public void dateLogin(LoginVO vo) throws Exception;
		
}
