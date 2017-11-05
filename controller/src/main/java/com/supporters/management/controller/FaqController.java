package com.supporters.management.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.management.domain.FaqVO;
import com.supporters.management.service.FaqService;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;

@Controller
@RequestMapping("/management/faq/*")
public class FaqController {

 
	@Inject
	private FaqService faqService;
	
	
	/*FAQ리스트*/
	@RequestMapping(value = "list" ,method={RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam String pageseq,
			Model model,
			FaqVO paging
			) throws Exception {
		try {
			/*if(searchValue==null) {searchValue="";}
			if(searchFiled==null) {searchFiled="";}
			switch(searchFiled) {
			case "0": searchFiled="user_num"; break;
			case "1":searchFiled="user_nm"; break;
			case "2":searchFiled="user_atten"; break;
			}
			System.out.println(searchFiled);
			paging.setSearchValue(searchValue);
			paging.setSearchFiled(searchFiled);*/
			int seq = Integer.parseInt(pageseq);
			paging.setPageNo(seq);
			paging.setPageSize(20);
			paging.setTotalCount(faqService.count(paging));
			System.out.println(seq);
	       
	        List<FaqVO> list = faqService.list(paging);
	        
	        model.addAttribute("page",paging);
			model.addAttribute("faq", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요");
	    }

		return "management/faq/faq_list";
	}
	

		/*FAQ 글 등록*/
		@RequestMapping(value="list/write")
		public String write(FaqVO paging,
				String faq_title,
				String faq_contents) throws Exception {
			
			paging.setFaq_title(faq_title);
			paging.setFaq_content(faq_contents);
			
			faqService.create(paging);
			return "redirect:/management/faq/list?pageseq=1";
		}
		
		/*FAQ 글 삭제*/
		@RequestMapping(value="list/delete")
		public String delete(FaqVO paging,
				String faqseq
				) throws Exception {
			
			paging.setFaq_seq(faqseq);
			
			faqService.delete(paging);
			return "redirect:/management/faq/list?pageseq=1";
		}
			
	
	
	}
	

