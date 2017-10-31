package com.supporters.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.domain.LoginVO;
@Repository("loginDAOImpl")
public class LoginDAOImpl implements LoginDAO{

	
	private static String namespace = "loginMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public LoginVO login(LoginVO vo) throws Exception  {
		
		/*서비스단에서 온 요청을  통해 */ 
		return session.selectOne(namespace+".login",vo);
	}

	@Override
	public void logout(LoginVO vo) throws Exception  {
		// TODO Auto-generated method stub
	}

	@Override
	public void dateLogin(LoginVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".datelogin",vo);
		
	}

}
