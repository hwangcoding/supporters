package com.supporters.contents.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.contents.dao.FictionGameDAO;
import com.supporters.contents.dao.UsedDAO;
import com.supporters.domain.CommunityVO;



@Service
public class UsedServiceImpl implements UsedService{

	@Inject
	private UsedDAO usedDAO;
	
	@Override
	public int count(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.count(vo);
	}

	@Override
	public List<CommunityVO> list(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.list(vo);
	}

	@Override
	public void write(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommunityVO>  read(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.read(vo);
	}
	


}
