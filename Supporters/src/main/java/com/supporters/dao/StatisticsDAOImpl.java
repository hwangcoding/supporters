package com.supporters.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.domain.StatisticsVO;

@Repository("statisticsDAOImpl")
public class StatisticsDAOImpl implements StatisticsDAO {

	private static String namespace = "statisticsMapper";
	
	
	
	@Inject
	private SqlSession session;
	
	

	@Override
	public List<StatisticsVO>  visited_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".visited_week",vo);
	}


	@Override
	public int visited_count() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".visited_count");
	}


	@Override
	public List<StatisticsVO> join_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".join_week",vo);
	}

}
