package com.supporters.department.dao;

import java.util.List;

import com.supporters.department.domain.DecommunityVO;



public interface CommunityDAO {
	
	//커뮤니티 갯수 , 페이징
	public int count(DecommunityVO vo) throws Exception;
	
	// 커뮤니티 리스트
	public List<DecommunityVO> list(DecommunityVO vo) throws Exception;
	
	// 커뮤니티 작성하기
	public void write(DecommunityVO vo) throws Exception; 

	// 커뮤니티 삭제하기
	public void delete(DecommunityVO vo) throws Exception;
	
	// 커뮤니티 수정하기
	public void update() throws Exception;
}
