package com.supporters.department.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.supporters.domain.CommunityVO;



public interface DepartmentDAO {

	
	//게시글 작성
	public void create(CommunityVO vo) throws Exception;
	
	//게시글 읽기
	public List<CommunityVO>  read(CommunityVO vo) throws Exception;
	
	//게시글 수정하기
	public void update(CommunityVO vo) throws Exception;
	
	//게시글 삭제
	public void delete(CommunityVO vo) throws Exception;
	
	//게시글 리스트
	public List<CommunityVO> list(CommunityVO vo) throws Exception;
	
	//페이징 처리하기 위해 게시글 총 갯수 확인하기
	public int count(CommunityVO vo) throws Exception;
	
	
}
