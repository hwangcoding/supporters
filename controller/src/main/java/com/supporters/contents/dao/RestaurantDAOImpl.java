package com.supporters.contents.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.contents.domain.RestaurantVO;
import com.supporters.domain.CommunityVO;


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
	public void update(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(namespace+".update",vo);	
	}


	@Override
	public List<RestaurantVO> view(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList(namespace+".view",vo);
		
	}


	/* (non-Javadoc)
	 * @see com.supporters.contents.dao.RestaurantDAO#comment(com.supporters.contents.domain.RestaurantVO)
	 */
	@Override
	public List<RestaurantVO> comment(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".comment",vo);
	}
	
	
	

}
