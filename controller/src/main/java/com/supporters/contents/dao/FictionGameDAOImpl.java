package com.supporters.contents.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.contents.domain.FictionGameVO;

@Repository("fictionGameDAOImpl")
public class FictionGameDAOImpl implements FictionGameDAO{

	private static String namespace = "fictionGameMapper";
	
	
	@Inject
	private SqlSession sqlsession;


	@Override
	public int count(FictionGameVO vo) throws Exception {
		return sqlsession.selectOne(namespace+".list_count",vo);
	}


	@Override
	public List<FictionGameVO> list(FictionGameVO vo) throws Exception {
		return  sqlsession.selectList(namespace+".list", vo);
	}


	@Override
	public void write(FictionGameVO vo) throws Exception {
		  sqlsession.insert(namespace+".insert",vo);
		
	}


	@Override
	public void delete(FictionGameVO vo) throws Exception {
		sqlsession.update(namespace+".delete",vo);		
	}


	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
