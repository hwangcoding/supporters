package com.supporters.department.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.department.domain.NoticeVO;



@Repository("departmentDAOImpl")
public class DepartmentDAOImpl implements DepartmentDAO{

	private static String namespace = "departmentMapper";
	
	
	@Inject
	private SqlSession sqlsession;
	
	
	@Override
	public void create(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.insert(namespace+".fileInsert", vo);
		
	}

	@Override
	public List<NoticeVO> read(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".view", vo);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(namespace+".modify",vo);
		
	}

	@Override
	public void delete(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.update(namespace+".delete",vo);
	}

	@Override
	public List<NoticeVO> list(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".list",vo);
	}

	@Override
	public int count(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".list_count", vo);
	}



	
	
	
	
	
}
