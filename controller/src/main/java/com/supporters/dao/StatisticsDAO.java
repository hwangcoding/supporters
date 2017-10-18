package com.supporters.dao;

import java.util.List;

import com.supporters.domain.StatisticsVO;

public interface StatisticsDAO {

	
	public List<StatisticsVO>  join_week(StatisticsVO vo) throws Exception;
	
	public List<StatisticsVO>  visited_week(StatisticsVO vo) throws Exception;
	
	public int visited_count() throws Exception;
	
	
}
