package com.supporters.department.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.department.domain.DecommunityVO;



@Repository("communityDAOImpl")
public class CommunityDAOImpl implements  CommunityDAO{

	private static String namespace = "communityMapper";
	
	
	@Inject
	private SqlSession sqlsession;

	
	

	@Override
	public List<DecommunityVO> read(DecommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".view",vo);
	}


	@Override
	public int count(DecommunityVO vo) throws Exception {
		return sqlsession.selectOne(namespace+".list_count",vo);
	}


	@Override
	public List<DecommunityVO> list(DecommunityVO vo) throws Exception {
		return  sqlsession.selectList(namespace+".list", vo);
	}


	@Override
	public void write(DecommunityVO vo) throws Exception {
		  sqlsession.insert(namespace+".insert",vo);
		
	}


	@Override
	public void delete(DecommunityVO vo) throws Exception {
		sqlsession.delete(namespace+".delete",vo);		
	}


	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
