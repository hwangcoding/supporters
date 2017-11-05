package com.supporters.department.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.department.domain.DecommunityVO;
import com.supporters.department.service.CommunityService;


@Controller
@RequestMapping(value="/department/community/*")
public class CommunityController {

	
	
	
	@Inject
	private CommunityService communityService;
	
	
	/*function에 만들어 놓은 데이터 클래스
	 * 통계 부분에서 사용*/

	
			/*게시물  리스트*/
			@RequestMapping(value = "list")		
			public String list(
					@RequestParam String pageseq, 
					Model model,
					String searchValue,
					String searchFiled,
					DecommunityVO paging) throws Exception {
				
				
				/*검색 조건 , 검색어 확인 하는 알고리즘*/
				/*if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="user_title"; break;
				case "1":searchFiled="community_user_id"; break;
				}*/
				
				int seq = Integer.parseInt(pageseq);
				paging.setPageNo(seq);
				paging.setPageSize(10);
				paging.setSearchValue(searchValue);
				paging.setSearchFiled(searchFiled);
				paging.setTotalCount(communityService.count(paging));
				
				List<DecommunityVO> list = communityService.list(paging);
				
				model.addAttribute("page",paging);
				model.addAttribute("fiction", list);
				
				return "department/community/community_list";
		
				}
			
			
		}
	

