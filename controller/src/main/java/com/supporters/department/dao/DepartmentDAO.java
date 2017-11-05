package com.supporters.department.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.supporters.department.domain.NoticeVO;




public interface DepartmentDAO {

	
	//게시글 작성
	public void create(NoticeVO vo) throws Exception;
	
	//게시글 읽기
	public List<NoticeVO>  read(NoticeVO vo) throws Exception;
	
	//게시글 수정하기
	public void update(NoticeVO vo) throws Exception;
	
	//게시글 삭제
	public void delete(NoticeVO vo) throws Exception;
	
	//게시글 리스트
	public List<NoticeVO> list(NoticeVO vo) throws Exception;
	
	//페이징 처리하기 위해 게시글 총 갯수 확인하기
	public int count(NoticeVO vo) throws Exception;
	
	
}
