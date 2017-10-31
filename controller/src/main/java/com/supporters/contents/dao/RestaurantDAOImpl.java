package com.supporters.contents.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.contents.domain.RestaurantVO;


@Repository("restaurantDAOImpl")
public class RestaurantDAOImpl implements RestaurantDAO{

	private static String namespace = "rastaurantMapper";
	
	
	@Inject
	private SqlSession sqlsession;


	@Override
	public int count(RestaurantVO vo) throws Exception {
		return sqlsession.selectOne(namespace+".list_count",vo);
	}


	@Override
	public List<RestaurantVO> list(RestaurantVO vo) throws Exception {
		return  sqlsession.selectList(namespace+".list", vo);
	}


	@Override
	public void write(RestaurantVO vo) throws Exception {
		  sqlsession.insert(namespace+".insert",vo);
		
	}


	@Override
	public void delete(RestaurantVO vo) throws Exception {
		sqlsession.delete(namespace+".delete",vo);		
	}


	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void view(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.selectList(namespace+".view",vo);
		
	}
	
	
	

}
