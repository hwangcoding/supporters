package com.supporters.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.dao.LoginDAO;
import com.supporters.domain.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Inject
    private	LoginDAO loginDAO;

	@Override
	public LoginVO login(LoginVO vo) throws Exception {
		/*컨트롤러에서 요청하면  서비스단에 와서 서비스단에서 DAO 로 요청을 합니다*/ 
		return loginDAO.login(vo);
		
	}

	@Override
	public void logout(LoginVO vo)throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dateLogin(LoginVO vo) throws Exception {
		// TODO Auto-generated method stub
		loginDAO.dateLogin(vo);
		
	}
    
    

}
