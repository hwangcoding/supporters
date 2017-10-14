package com.supporters.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.dao.LoginDAO;
import com.supporters.dao.StatisticsDAO;
import com.supporters.domain.StatisticsVO;

@Service
public class StatisticsServiceImpl implements StatisticsService{

	
	@Inject
    private	StatisticsDAO statisticsDAO;
	

	@Override
	public List<StatisticsVO>  visited_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return  statisticsDAO.visited_week(vo);
	}

	@Override
	public int visited_count() throws Exception {
		// TODO Auto-generated method stub
		return  statisticsDAO.visited_count();
	}

	@Override
	public List<StatisticsVO> join_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.join_week(vo);
	}
	
	
	
}
