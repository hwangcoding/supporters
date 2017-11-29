package com.supporters.contents.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.supporters.contents.domain.FictionGameVO;
import com.supporters.contents.service.FictionGameService;
import com.supporters.domain.StatisticsVO;
import com.supporters.function.DateCalculator;
import com.supporters.service.StatisticsService;


@Controller
@RequestMapping(value="/contents/fictiongame/*")
public class FictionGameController {

	
	
	
	@Inject
	private FictionGameService fictionGameService;
	
	
	/*function에 만들어 놓은 데이터 클래스
	 * 통계 부분에서 사용*/

	
			/*일주일치 회원수*/
			@RequestMapping(value = "fiction_list")		
			public String fictionGame(
					@RequestParam String pageseq, 
					Model model,
					String searchValue,
					String searchFiled,
					FictionGameVO paging) throws Exception {
				
				
				/*검색 조건 , 검색어 확인 하는 알고리즘*/
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="fiction_content"; break;
				case "1":searchFiled="user_num"; break;
				}
				
				int seq = Integer.parseInt(pageseq);
				paging.setPageNo(seq);
				paging.setPageSize(20);
				paging.setSearchValue(searchValue);
				paging.setSearchFiled(searchFiled);
				paging.setTotalCount(fictionGameService.count(paging));
				
				List<FictionGameVO> list = fictionGameService.list(paging);
				
				model.addAttribute("page",paging);
				model.addAttribute("fiction", list);
				
				return "contents/fictiongame/fiction_list";
		
				}
			
			@RequestMapping(value = "list/delete")
			public String delete(String usernum, 
					FictionGameVO paging)throws Exception{
				
				paging.setFiction_seq(usernum);
				fictionGameService.delete(paging);
				
				return "redirect:/contents/fictiongame/fiction_list?pageseq=1";
			}
				
		
			
		}
	

