package com.supporters.student.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.student.dao.StudentDAO;
import com.supporters.student.domain.StudentVO;

@Service
public class StudentServiceImpl implements StudentService{

	

	@Inject
	private StudentDAO studentDAO;
	
	@Override
	public void token(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		studentDAO.token(vo);
	}
	
	@Override
	public void regist(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentVO read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(StudentVO vo) throws Exception {
		
		studentDAO.delete(vo);
		
	}

	@Override
	public List<StudentVO> list(StudentVO vo) throws Exception {
		
		return studentDAO.list(vo);
	}

	@Override
	public int count(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.count(vo);
	}

	@Override
	public void add(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		studentDAO.add(vo);
		
	}

	@Override
	public int search(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
			return studentDAO.search(vo);
		
	}

	@Override
	public void pwUpdate(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		studentDAO.pwUpdate(vo);
	}

	@Override
	public StudentVO login(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.login(vo);
	}	
	
	
	
	@Override
	public List<StudentVO>  alert(StudentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.alert(vo);
	}
	

	
	
	
}
