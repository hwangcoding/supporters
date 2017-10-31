package com.supporters.management.dao;

import java.util.List;

import com.supporters.management.domain.FaqVO;




public interface FaqDAO {

	
	public void create(FaqVO vo) throws Exception;
	
	public void update(FaqVO vo) throws Exception;
	
	public void delete(FaqVO vo) throws Exception;
	
	public List<FaqVO> list(FaqVO vo) throws Exception;
	
	public int count(FaqVO vo) throws Exception;

	
	
	
}
