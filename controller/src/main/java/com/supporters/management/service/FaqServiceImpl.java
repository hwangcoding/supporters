package com.supporters.management.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.management.dao.FaqDAO;
import com.supporters.management.domain.FaqVO;


@Service
public class FaqServiceImpl implements FaqService{

	
	@Inject
    private 	FaqDAO faqDAO; 
	
	@Override
	public void create(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		faqDAO.create(vo);
		
	}

	@Override
	public void update(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FaqVO> list(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		return faqDAO.list(vo);
	}

	@Override
	public int count(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		return faqDAO.count(vo);
	}

}
