package com.supporters.student.service;

import java.util.List;

import com.supporters.student.domain.StudentVO;


public interface StudentService {
	
	
	public void regist(StudentVO vo) throws Exception;

	public StudentVO read() throws Exception;

	public void modify(StudentVO vo) throws Exception;

	public void remove(StudentVO vo) throws Exception;

	public List<StudentVO> list(StudentVO vo) throws Exception;
	
	public int count(StudentVO vo) throws Exception;
	
	public void add(StudentVO vo) throws Exception;
	
	public int search(StudentVO vo) throws Exception;

	public void pwUpdate(StudentVO vo) throws Exception;
	
}
