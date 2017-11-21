package com.supporters.department.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.department.domain.KeyManagerVO;
import com.supporters.department.service.DepartmentService;
import com.supporters.department.service.KeyManagerService;
import com.supporters.domain.CommunityVO;
import com.supporters.management.domain.QnaVO;
@Controller
@RequestMapping("/department/keymanager/*")
public class KeyManagerController {

	/*글쓰기만들어야함*/
	
	@Inject
	private KeyManagerService keyManagerService;
	
	
		@RequestMapping(value = "list")
		public String list(@RequestParam String pageseq,
				Model model,
				KeyManagerVO paging,
				String searchFiled,
				String searchValue,
				String tabs_ch
				) throws Exception {
			try {
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="key_num"; break;
				case "1":searchFiled="key_have"; break;
				}
				
				if(tabs_ch == null) {
					tabs_ch="";
					}else if(tabs_ch == "0") {
					tabs_ch="";
					}
				/*System.out.println("진짜 테스트 합니다 : " + tabs_ch);*/
				switch (tabs_ch) {
				case "1": searchFiled = "qna_state";
				searchValue = tabs_ch;
				break;
				case "2": searchFiled = "qna_state";
				searchValue = tabs_ch;
				break;
				}
				
				/*System.out.println(searchFiled);*/
				paging.setSearchValue(searchValue);
				paging.setSearchFiled(searchFiled);
				int seq = Integer.parseInt(pageseq);
				paging.setPageNo(seq);
				paging.setPageSize(10);
				paging.setTotalCount(keyManagerService.count(paging));
				/*System.out.println(seq);*/
				
		        List<KeyManagerVO> list = keyManagerService.list(paging);
		        
		        model.addAttribute("page",paging);
				model.addAttribute("key", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요"+ e.getMessage());
		    }
			return "department/keymanager/key_list";
			
		}
		
		@RequestMapping(value="update")
		public String update(String seq,
				Model model,
				KeyManagerVO paging)throws Exception {
					
			paging.setKey_seq(seq);
			
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			paging.setKey_return_date(mTime);
			
			keyManagerService.update(paging);

			return "redirect:/department/keymanager/list?pageseq=1";
		}
		
/*		@RequestMapping(value = "notice/view")
		public String view(@RequestParam String seq,
				Model model,CommunityVO paging,HttpSession session) throws Exception {

	
			return "department/notice_view";
			
		}
		
		
		학과공지 수정하기
		@RequestMapping(value = "notice/modify")
		public String modify(@RequestParam String seq,
				Model model,CommunityVO paging) throws Exception {

	
			return "department/notice_modify";
			
		}*/
	
}
