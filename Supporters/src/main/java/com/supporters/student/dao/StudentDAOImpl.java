package com.supporters.student.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supporters.student.domain.StudentVO;

@Repository("studentDAOImpl")
public class StudentDAOImpl  implements StudentDAO{
	
	private static String namespace = "studentMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public void create(StudentVO  vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentVO read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StudentVO vo) throws Exception {
		session.delete(namespace + ".delete",vo);
		
	}

	@Override
	public List<StudentVO> list(StudentVO vo) throws Exception {
		System.out.println(vo.getPageNo());
		return session.selectList(namespace + ".list",vo);
	}
	@Override
	public int count(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".list_count",vo);
	}

	@Override
	public void add(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(namespace+".list_add",vo);
		
	}

	@Override
	public int search(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
			return session.selectOne(namespace+".search", vo);

	}
	

}
