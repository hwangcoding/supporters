package com.supporters.contents.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.contents.domain.UsedVO;



@Repository("usedDAOImpl")
public class UsedDAOImpl implements UsedDAO{

	private static String namespace = "usedMapper";
	
	
	@Inject
	private SqlSession sqlsession;


	@Override
	public int count(UsedVO vo) throws Exception {
		return sqlsession.selectOne(namespace+".list_count",vo);
	}


	@Override
	public List<UsedVO> list(UsedVO vo) throws Exception {
		return  sqlsession.selectList(namespace+".list", vo);
	}


	@Override
	public void write(UsedVO vo) throws Exception {
		  sqlsession.insert(namespace+".insert",vo);
		
	}


	@Override
	public void delete(UsedVO vo) throws Exception {
		sqlsession.delete(namespace+".delete",vo);		
	}


	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<UsedVO> read(UsedVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".view", vo);
	}
	
	
	

}
