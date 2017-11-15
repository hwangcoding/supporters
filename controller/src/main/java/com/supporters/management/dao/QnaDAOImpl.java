package com.supporters.management.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.management.domain.QnaVO;

@Repository("qnaDAOImpl")

public class QnaDAOImpl implements QnaDAO {
	
	private static String namespace = "qnaMapper";
	
	@Inject
	private SqlSession session;

	@Override
	public void comment(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".modify", vo);
	}

	@Override
	public void delete(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",vo);
		session.update(namespace+".delete_state",vo);
	}

	@Override
	public List<QnaVO> list(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",vo);
	}

	@Override
	public int count(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".list_count",vo);
	}

	@Override
	public List<QnaVO> view(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".view",vo);
	}

	@Override
	public void write(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".write",vo);
		session.update(namespace+".write_state",vo);
	}
	
	
	

}
