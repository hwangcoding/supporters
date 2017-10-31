package com.supporters.department.service;

import java.util.List;

import com.supporters.domain.CommunityVO;


public interface CommunityService {
	
	//댓글 갯수 , 페이징
	public int count(CommunityVO vo) throws Exception;
	
	// 댓글 리스트
	public List<CommunityVO> list(CommunityVO vo) throws Exception;
	
	// 댓글 작성하기
	public void write(CommunityVO vo) throws Exception; 

	// 댓글 삭제하기
	public void delete(CommunityVO vo) throws Exception;
	
	// 댓글 수정하기
	public void update() throws Exception;
}
