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
	public List<StatisticsVO> join_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.join_week(vo);
	}


	@Override
	public int all_visited() throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.all_visited();
	}


	@Override
	public int all_join() throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.all_join();
	}


	@Override
	public int day_visited() throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.day_visited();
	}


	@Override
	public int day_join() throws Exception {
		// TODO Auto-generated method stub
		return statisticsDAO.day_join();
	}
	
	
	
}
