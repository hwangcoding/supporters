package com.supporters.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.domain.AlertLogVO;

@Repository("alertLogDAOImpl")
public class AlertLogDAOImpl implements AlertLogDAO {
	
	private static String namespace = "alertLogMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public void log(AlertLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".log",vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.dao.AlertLogDAO#list(com.supporters.domain.AlertLogVO)
	 */
	@Override
	public List<AlertLogVO> list(AlertLogVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.dao.AlertLogDAO#count(com.supporters.domain.AlertLogVO)
	 */
	@Override
	public int count(AlertLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".count",vo);
	}
	
	

}
