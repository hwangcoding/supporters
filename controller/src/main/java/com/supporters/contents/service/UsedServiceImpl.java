package com.supporters.contents.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.contents.dao.FictionGameDAO;
import com.supporters.contents.dao.UsedDAO;
import com.supporters.contents.domain.UsedVO;



@Service
public class UsedServiceImpl implements UsedService{

	@Inject
	private UsedDAO usedDAO;
	
	@Override
	public int count(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.count(vo);
	}

	@Override
	public List<UsedVO> list(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.list(vo);
	}

	@Override
	public void write(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsedVO>  read(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		return usedDAO.read(vo);
	}
	


}
