package com.supporters.contents.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.contents.domain.RestaurantVO;
import com.supporters.domain.CommunityVO;

public interface RestaurantService {
	
	//맛집 갯수 , 페이징
	public int count(RestaurantVO vo) throws Exception;
	
	// 맛집 리스트
	public List<RestaurantVO> list(RestaurantVO vo) throws Exception;
	
	// 맛집 작성하기
	public void write(RestaurantVO vo) throws Exception; 

	// 맛집 삭제하기
	public void delete(RestaurantVO vo) throws Exception;
	
	// 맛집 수정하기
	public void update(RestaurantVO paging) throws Exception;
	
	/*맛집 보기*/
	public List<RestaurantVO> view(RestaurantVO vo) throws Exception;
	
	/*이미지 업로드*/
	public String fileUpload(MultipartHttpServletRequest request,HttpSession session) throws Exception;

	/*댓글*/
	public List<RestaurantVO> comment(RestaurantVO paging) throws Exception;
}
