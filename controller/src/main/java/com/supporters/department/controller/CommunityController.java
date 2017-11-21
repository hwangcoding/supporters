package com.supporters.department.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.department.domain.DecommunityVO;
import com.supporters.department.domain.NoticeVO;
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
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="community_content"; break;
				case "1":searchFiled="community_user_id"; break;
				}
				
				int seq = Integer.parseInt(pageseq);
				paging.setPageNo(seq);
				paging.setPageSize(10);
				paging.setSearchValue(searchValue);
				paging.setSearchFiled(searchFiled);
				paging.setTotalCount(communityService.count(paging));
				
				List<DecommunityVO> list = communityService.list(paging);
				
				model.addAttribute("page",paging);
				model.addAttribute("cou", list);
				
				return "department/community/community_list";
		
				}
			/*커뮤니티 클릭시 보여지는곳*/
			@RequestMapping(value = "view")
			public String view(@RequestParam String seq,
					Model model,DecommunityVO paging) throws Exception {
				try {
					/*게시물의 시퀀스를 가져와 설정 함*/
					paging.setCommunity_seq(seq);
					/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
			        List<DecommunityVO> list = communityService.read(paging);
					model.addAttribute("view", list);
			        
			    } catch (Exception e) {
			    	System.out.println("파일이없떠요");
			    }
		
				return "department/community/community_view";
				
			}
			/*커뮤니티 삭제하기 */
			@RequestMapping(value="delete")
			public String delete(DecommunityVO vo,String seq) throws Exception {
				/*그 게시물의 시퀀스를 가져옴*/
				System.out.println(seq);
				vo.setCommunity_seq(seq);
				/*서비스단에 설정 해 놓은 메소드를 실행 시켜 삭제*/
				communityService.delete(vo);
				
				
				return "redirect:/department/community/list?pageseq=1";
		}
		}
	

