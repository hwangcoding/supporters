package com.supporters.contents.service;

import java.util.List;

import com.supporters.contents.domain.FictionGameVO;

public interface FictionGameService {
	
	//댓글 갯수 , 페이징
	public int count(FictionGameVO vo) throws Exception;
	
	// 댓글 리스트
	public List<FictionGameVO> list(FictionGameVO vo) throws Exception;
	
	// 댓글 작성하기
	public void write(FictionGameVO vo) throws Exception; 

	// 댓글 삭제하기
	public void delete(FictionGameVO vo) throws Exception;
	
	// 댓글 수정하기
	public void update() throws Exception;
}
