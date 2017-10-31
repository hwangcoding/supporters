package com.supporters.department.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.domain.CommunityVO;


@Repository("communityDAOImpl")
public class CommunityDAOImpl implements  CommunityDAO{

	private static String namespace = "communityMapper";
	
	
	@Inject
	private SqlSession sqlsession;


	@Override
	public int count(CommunityVO vo) throws Exception {
		return sqlsession.selectOne(namespace+".list_count",vo);
	}


	@Override
	public List<CommunityVO> list(CommunityVO vo) throws Exception {
		return  sqlsession.selectList(namespace+".list", vo);
	}


	@Override
	public void write(CommunityVO vo) throws Exception {
		  sqlsession.insert(namespace+".insert",vo);
		
	}


	@Override
	public void delete(CommunityVO vo) throws Exception {
		sqlsession.delete(namespace+".delete",vo);		
	}


	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
