package com.supporters.service;

import java.util.List;

import com.supporters.domain.AlertLogVO;

public interface AlertLogService {
	
	public void log(AlertLogVO vo)throws Exception;
	
	public List<AlertLogVO> list(AlertLogVO vo)throws Exception;
	
	public int count(AlertLogVO vo)throws Exception;

}
