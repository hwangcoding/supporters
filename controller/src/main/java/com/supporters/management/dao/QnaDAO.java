package com.supporters.management.dao;

import java.util.List;

import com.supporters.management.domain.QnaVO;

public interface QnaDAO {
	
	public void comment(QnaVO vo) throws Exception;
	
	public void update(QnaVO vo) throws Exception;
	
	public void delete(QnaVO vo) throws Exception;
	
	public List<QnaVO> list(QnaVO vo) throws Exception;
	
	public int count(QnaVO vo) throws Exception;

}
