package com.supporters.contents.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.contents.domain.RestaurantVO;

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
	public void update() throws Exception;
	
	public void view(RestaurantVO vo) throws Exception;
	
	public String fileUpload(MultipartHttpServletRequest request,HttpSession session) throws Exception;
}
