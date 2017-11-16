package com.supporters.department.dao;

import java.util.List;

import com.supporters.department.domain.KeyManagerVO;

public interface KeyManagerDAO {
	
	public List<KeyManagerVO> list(KeyManagerVO vo) throws Exception;
	
	public void update(KeyManagerVO vo) throws Exception;

	public int count(KeyManagerVO vo) throws Exception;

}
