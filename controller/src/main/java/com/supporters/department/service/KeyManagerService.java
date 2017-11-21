package com.supporters.department.service;

import java.util.List;

import com.supporters.department.domain.KeyManagerVO;

public interface KeyManagerService {
	
	public List<KeyManagerVO> list(KeyManagerVO vo) throws Exception;
	
	public void update(KeyManagerVO vo) throws Exception;
	
	public int count(KeyManagerVO vo) throws Exception;

}
