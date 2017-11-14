package com.supporters.management.service;

import java.util.List;

import com.supporters.management.domain.QnaVO;

public interface QnaService {
	
	public void comment(QnaVO vo) throws Exception;
	
	public void update(QnaVO vo) throws Exception;
	
	public void delete(QnaVO vo) throws Exception;
	
	public List<QnaVO> list(QnaVO vo) throws Exception;
	
	public int count(QnaVO vo) throws Exception;

	public List<QnaVO> view(QnaVO vo) throws Exception;

	public void write(QnaVO vo) throws Exception;

}
