package com.supporters.contents.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.contents.domain.UsedVO;
import com.supporters.contents.service.UsedService;


@Controller
@RequestMapping(value="/contents/used/*")
public class UsedController {

	
	

	@Inject
	private UsedService usedService;
	
	
	/*중고장터 리스트*/
		@RequestMapping(value = "list")
		public String list(@RequestParam String pageseq,
				Model model,UsedVO paging,
				String searchValue,
				String searchFiled) throws Exception {
			try {
				
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="used_title"; break;
				case "1":searchFiled="used_user_id"; break;
				default:searchFiled=""; break;
				}
				/*페이지 처리를 하기 위해 현재 몇 번째 페이지인지 파라미터 값을 받아와 Integer로 바꿔주는 작업*/
				int seq = Integer.parseInt(pageseq);
				/*paging 을 하기위해 설정 해줌*/
				paging.setPageNo(seq);
				/*페이지에서 보여줄 갯수*/
				paging.setPageSize(10);
				paging.setSearchValue(searchValue);
				paging.setSearchFiled(searchFiled);
				/*학과 공지 관련 게시물의 총 갯수를 가져와 페이징 처리를 어떻게 할 것인가 설정 하는것.*/
				paging.setTotalCount(usedService.count(paging));
				/*서비스단에 설정 해 놓은 메소드를 실행시켜 */ 
		        List<UsedVO> list = usedService.list(paging);
		        
		        model.addAttribute("page",paging);
				model.addAttribute("used", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "contents/used/used_list";
			
		}
		/*중고장터 클릭시 보여지는곳*/
		@RequestMapping(value = "view")
		public String view(@RequestParam String seq,
				Model model,UsedVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setUsed_seq(seq);
				/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
		        List<UsedVO> list = usedService.read(paging);
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "contents/used/used_view";
			
		}
		
		
		/*중고장터 수정하기*/
		@RequestMapping(value = "modify")
		public String modify(@RequestParam String seq,
				Model model,UsedVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setUsed_seq(seq);
		        List<UsedVO> list = usedService.read(paging);
		         
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "contents/used/used_modify";
			
		}
		
		/*중고장터 글 작성하기 */
		@RequestMapping(value="write")
		public String write() throws Exception {
			
			return "contents/used/used_write";
	}
		
		
		

			
		}
	

