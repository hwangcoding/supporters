package com.supporters.department.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.department.domain.NoticeVO;




public interface DepartmentService {
	 
	//이미지 업로드
	public String fileInsert( HttpServletRequest request, HttpServletResponse response) throws Exception;
	//게시글 작성	
	public void regist(NoticeVO vo) throws Exception;
	
	//게시글 읽기
	public List<NoticeVO>  read(NoticeVO vo) throws Exception;
	
	//게시글 수정하기
	public void modify(NoticeVO vo) throws Exception;
	
	//게시글 삭제
	public void remove(NoticeVO vo) throws Exception;
	
	//게시글 리스트
	public List<NoticeVO> list(NoticeVO vo) throws Exception;
	
	//페이징 처리하기 위해 게시글 총 갯수 확인하기
	public int count(NoticeVO vo) throws Exception;
	

	
}
