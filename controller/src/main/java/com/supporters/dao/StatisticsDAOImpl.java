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
	public int qna_select() throws Exception {
		// TODO Auto-generated method stub
		
		return session.selectOne(namespace+".qna_select");
	}


	@Override
	public List<StatisticsVO>  visited_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".visited_week",vo);
	}


	@Override
	public List<StatisticsVO> join_week(StatisticsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".join_week",vo);
	}


	@Override
	public int all_visited() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".all_visited");
	}


	@Override
	public int all_join() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".all_join");
	}


	@Override
	public int day_visited() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".day_visited");
	}


	@Override
	public int day_join() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".day_join");
	}

}
