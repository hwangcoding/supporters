package com.supporters.contents.service;

import java.util.List;

import com.supporters.contents.domain.UsedVO;



public interface UsedService {
	
	//게시글 갯수 , 페이징
	public int count(UsedVO vo) throws Exception;
	
	// 게시글 리스트
	public List<UsedVO> list(UsedVO vo) throws Exception;
	
	// 게시글 작성하기
	public void write(UsedVO vo) throws Exception; 

	// 게시글 삭제하기
	public void delete(UsedVO vo) throws Exception;
	
	// 게시글 수정하기
	public void update() throws Exception;
	
	//게시글 읽기
			public List<UsedVO>  read(UsedVO vo) throws Exception;
}
