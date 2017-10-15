package com.supporters.contents.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.contents.dao.FictionGameDAO;
import com.supporters.contents.domain.FictionGameVO;



@Service
public class FictionGameServiceImpl implements FictionGameService{

	@Inject
	private FictionGameDAO fictionGameDAO;
	
	@Override
	public int count(FictionGameVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fictionGameDAO.count(vo);
	}

	@Override
	public List<FictionGameVO> list(FictionGameVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fictionGameDAO.list(vo);
	}

	@Override
	public void write(FictionGameVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FictionGameVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}

	


}
