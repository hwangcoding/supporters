package com.supporters.management.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.department.domain.NoticeVO;
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
			QnaVO paging,
			String searchFiled,
			String searchValue
			) throws Exception {
		try {
			if(searchValue==null) {searchValue="";}
			if(searchFiled==null) {searchFiled="";}
			switch(searchFiled) {
			case "0": searchFiled="qna_title"; break;
			case "1":searchFiled="user_num"; break;
			case "2":searchFiled="qna_state"; break;
			}
			/*System.out.println(searchFiled);*/
			paging.setSearchValue(searchValue);
			paging.setSearchFiled(searchFiled);
			int seq = Integer.parseInt(pageseq);
			paging.setPageNo(seq);
			paging.setPageSize(10);
			paging.setTotalCount(qnaService.count(paging));
			/*System.out.println(seq);*/
	       
	        List<QnaVO> list = qnaService.list(paging);
	        
	        model.addAttribute("page",paging);
			model.addAttribute("qna", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요"+ e.getMessage());
	    }

		return "management/qna/qna_list";
	}
	
	/*qna view 보여지는곳*/
	@RequestMapping(value = "view")
	public String view(@RequestParam String seq,
			Model model,QnaVO paging) throws Exception {
		try {
			/*게시물의 시퀀스를 가져와 설정 함*/
			paging.setQna_seq(seq);
			/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
	        List<QnaVO> list = qnaService.view(paging);
			model.addAttribute("view", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요");
	    }

		return "management/qna/qna_view";
		
	}
	
	/*qna 글작성 페이지 이동*/
	@RequestMapping(value="write")
	public String write(String seq, Model model, QnaVO vo) throws Exception {
		
		try{
			
			vo.setQna_seq(seq);
			List<QnaVO> list = qnaService.view(vo);
			model.addAttribute("write", list);
			
		}catch (Exception e) {
			System.out.println("글없음");
		}
		
		
		return "management/qna/qna_write";
}
	
	/*qna 글작성*/
	@RequestMapping(value="write/process")
	public String writeProcess(String seq,String wite_content, Model model, QnaVO vo ) throws Exception{
		
		try {
			
			vo.setQna_seq(seq);
			vo.setQnasr_content(wite_content);
			qnaService.write(vo);

		} catch (Exception e) {
			System.out.println("글없음");
		}
		
		return "redirect:/management/qna/view?seq="+seq;
		
	}
	
	@RequestMapping(value="delete")
	public String delete(String seq, QnaVO vo) throws Exception{
		
		try {
			
			vo.setQna_seq(seq);
			qnaService.delete(vo);
			
		} catch (Exception e) {
			System.out.println("글없음");
		}
		
		return  "redirect:/management/qna/view?seq="+seq;
	}
	
	/*qna 수정 페이지 이동*/
	@RequestMapping(value="modify")
	public String modify(String seq, Model model, QnaVO vo) throws Exception {
		
		try{
			
			vo.setQna_seq(seq);
			List<QnaVO> list = qnaService.view(vo);
			model.addAttribute("modify", list);
			
		}catch (Exception e) {
			System.out.println("글없음");
		}
		
		
		return "management/qna/qna_modify";
}
	
	/*qna 수정 이동*/
	@RequestMapping(value="modify/process")
	public String modifyProcess(String seq, String modify_content, Model model, QnaVO vo) throws Exception {
		
		try{
			
			vo.setQna_seq(seq);
			vo.setQnasr_content(modify_content);
			
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			vo.setQnasr_revise_datetime(mTime);
			
			qnaService.update(vo);
		}catch (Exception e) {
			System.out.println("글없음");
		}
		
		
		return "redirect:/management/qna/view?seq="+seq;
}
	
	
	/*
	
	학과공지 수정하기
	@RequestMapping(value = "notice/modify")
	public String modify(@RequestParam String seq,
			Model model,QnaVO paging) throws Exception {
		try {
			게시물의 시퀀스를 가져와 설정 함
			paging.setDepartment_notice_seq(seq);
	        List<NoticeVO> list = departmentService.read(paging);
	         
			model.addAttribute("view", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요");
	    }

		return "department/notice_modify";
		
	}
	

	
	
	
	
	학과공지 삭제하기 
	@RequestMapping(value="notice/delete")
	public String delete(QnaVO vo,String seq) throws Exception {
		그 게시물의 시퀀스를 가져옴
		vo.setDepartment_notice_seq(seq);
		서비스단에 설정 해 놓은 메소드를 실행 시켜 삭제
		departmentService.remove(vo);
		
		
		return "redirect:/department/notice?pageseq=1";
}


글 작성하기 프로세스
@RequestMapping(value="notice/writeprocess",method={RequestMethod.GET, RequestMethod.POST})
public String writeProcess(HttpServletRequest request, HttpServletResponse response,QnaVO vo,
		String user_id,
		String title,
		String smarteditor) throws Exception {
	System.out.println("들어옴");

	
	학과 공지사항 코드 DBB001을 기본으로 설정
	vo.setMinor_cd("DEB001");
	vo.setDepartment_notice_title(title);
	vo.setDepartment_notice_content(smarteditor);
	vo.setDepartment_notice_user_id(user_id);
	후에 등록해준다
	departmentService.regist(vo);
	
	
	return "redirect:/department/notice?pageseq=1";
}
학과공지 수정 프로세스
@RequestMapping(value="notice/modifyprocess",method={RequestMethod.GET, RequestMethod.POST})
public String modifyProcess(HttpServletRequest request, HttpServletResponse response,QnaVO vo,
		String seq,
		String title,
		String smarteditor) throws Exception {
	
	
	
	데이터베이스에 수정된 날짜 컬럼 부분에 넣기 위해 현재날짜와 시간을 구함
	long time = System.currentTimeMillis(); 
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String str = dayTime.format(new Date());
	
	파라미터로 넘어온 값을 넣음
	vo.setDepartment_notice_seq(seq);
	vo.setDepartment_notice_title(title);
	vo.setDepartment_notice_content(smarteditor);
	서비스단에 설정 해 놓은 메소드를 실행
	vo.setDepartment_notice_revise_datetime(str);
	departmentService.modify(vo);
	
	
	return "redirect:/department/notice?pageseq=1";
}*/
}

	
