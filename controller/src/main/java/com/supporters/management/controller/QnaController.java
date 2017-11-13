package com.supporters.management.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.management.domain.FaqVO;
import com.supporters.management.domain.QnaVO;
import com.supporters.management.service.FaqService;
import com.supporters.management.service.QnaService;

@Controller
@RequestMapping("/management/qna/*")

public class QnaController {
	
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "list" ,method={RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam String pageseq,
			Model model,
			QnaVO paging
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
			paging.setTotalCount(qnaService.count(paging));
			System.out.println(seq);
	       
	        List<QnaVO> list = qnaService.list(paging);
	        
	        model.addAttribute("page",paging);
			model.addAttribute("qna", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요"+ e.getMessage());
	    }

		return "management/qna/qna_list";
	}
}

	
