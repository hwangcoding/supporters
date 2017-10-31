package com.supporters.contents.service;

import java.util.List;

import com.supporters.domain.CommunityVO;


public interface UsedService {
	
	//게시글 갯수 , 페이징
	public int count(CommunityVO vo) throws Exception;
	
	// 게시글 리스트
	public List<CommunityVO> list(CommunityVO vo) throws Exception;
	
	// 게시글 작성하기
	public void write(CommunityVO vo) throws Exception; 

	// 게시글 삭제하기
	public void delete(CommunityVO vo) throws Exception;
	
	// 게시글 수정하기
	public void update() throws Exception;
	
	//게시글 읽기
			public List<CommunityVO>  read(CommunityVO vo) throws Exception;
}
