package com.supporters.department.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.department.domain.KeyManagerVO;

@Repository("keymanagerDAOImpl")
public class KeyManagerDAOImpl implements KeyManagerDAO {
	
	private static String namespace = "keymanagerMapper";
	
	@Inject
	private SqlSession sqlsession;

	@Override
	public List<KeyManagerVO> list(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".list",vo);
	}

	@Override
	public void update(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(namespace+".update",vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.department.dao.KeyManagerDAO#count(com.supporters.department.domain.KeyManagerVO)
	 */
	@Override
	public int count(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".count",vo);
	}

	
}
