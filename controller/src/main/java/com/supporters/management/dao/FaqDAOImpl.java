package com.supporters.management.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.management.domain.FaqVO;


@Repository("faqDAOImpl")
public class FaqDAOImpl implements FaqDAO{

private static String namespace = "faqMapper";
	
	@Inject
	private SqlSession session;
	
	
	@Override
	public void create(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".write",vo);
		
	}

	@Override
	public void update(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",vo);
	}

	@Override
	public List<FaqVO> list(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",vo);
	}

	@Override
	public int count(FaqVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".list_count",vo);
	}

}
