package com.supporters.department.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.department.dao.CommunityDAO;
import com.supporters.department.domain.DecommunityVO;



@Service
public class CommunityServiceImpl implements CommunityService{

	@Inject
	private CommunityDAO communityDAO;

	
	
	@Override
	public List<DecommunityVO> read(DecommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.read(vo);
	}

	@Override
	public int count(DecommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.count(vo);
	}

	@Override
	public List<DecommunityVO> list(DecommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.list(vo);
	}

	@Override
	public void write(DecommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DecommunityVO vo) throws Exception {

		communityDAO.delete(vo);

		
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}

	


}
