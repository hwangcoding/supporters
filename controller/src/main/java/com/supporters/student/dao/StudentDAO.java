package com.supporters.student.dao;

import java.util.List;

import com.supporters.student.domain.StudentVO;



public interface StudentDAO {

	
	public void create(StudentVO vo) throws Exception;
	
	public StudentVO read() throws Exception;
	
	public void update(StudentVO vo) throws Exception;
	
	public void delete(StudentVO vo) throws Exception;
	
	public List<StudentVO> list(StudentVO vo) throws Exception;
	
	public int count(StudentVO vo) throws Exception;

	public void add(StudentVO vo) throws Exception;
	
	public int search(StudentVO vo) throws Exception;
	
	public void pwUpdate(StudentVO vo) throws Exception;
	
	public StudentVO login(StudentVO vo) throws Exception;
	
	public void token(StudentVO vo) throws Exception;
}
