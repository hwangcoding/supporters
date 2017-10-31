package com.supporters.department.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.department.service.DepartmentService;
import com.supporters.domain.CommunityVO;
@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	/*글쓰기만들어야함*/
	
	@Inject
	private DepartmentService departmentService;
	
	
	/*학과공지 리스트*/
		@RequestMapping(value = "notice")
		public String list(@RequestParam String pageseq,
				Model model,CommunityVO paging,
				String searchValue,
				String searchFiled) throws Exception {
			try {
				
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="community_title"; break;
				case "1":searchFiled="community_user_id"; break;
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
				paging.setTotalCount(departmentService.count(paging));
				/*서비스단에 설정 해 놓은 메소드를 실행시켜 */ 
		        List<CommunityVO> list = departmentService.list(paging);
		        
		        model.addAttribute("page",paging);
				model.addAttribute("notice", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "/department/notice_list";
			
		}
		/*학과공지 클릭시 보여지는곳*/
		@RequestMapping(value = "notice/view")
		public String view(@RequestParam String seq,
				Model model,CommunityVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setCommunity_seq(seq);
				/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
		        List<CommunityVO> list = departmentService.read(paging);
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "department/notice_view";
			
		}
		
		
		/*학과공지 수정하기*/
		@RequestMapping(value = "notice/modify")
		public String modify(@RequestParam String seq,
				Model model,CommunityVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setCommunity_seq(seq);
		        List<CommunityVO> list = departmentService.read(paging);
		         
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "department/notice_modify";
			
		}
		
	
		
		
		
		
		/*학과공지 삭제하기 */
		@RequestMapping(value="notice/delete")
		public String delete(CommunityVO vo,String seq) throws Exception {
			/*그 게시물의 시퀀스를 가져옴*/
			vo.setCommunity_seq(seq);
			/*서비스단에 설정 해 놓은 메소드를 실행 시켜 삭제*/
			departmentService.remove(vo);
			
			
			return "redirect:/department/notice?pageseq=1";
	}
		/*학과공지 글 작성하기 */
		@RequestMapping(value="notice/write")
		public String write() throws Exception {
			
			return "department/notice_write";
	}
	
	/*글 작성하기 프로세스*/
	@RequestMapping(value="notice/writeprocess",method={RequestMethod.GET, RequestMethod.POST})
	public String writeProcess(HttpServletRequest request, HttpServletResponse response,CommunityVO vo,
			String user_id,
			String title,
			String smarteditor) throws Exception {
		System.out.println("들어옴");

		
		/*학과 공지사항 코드 DBB001을 기본으로 설정*/
		vo.setMinor_cd("DEB001");
		vo.setCommunity_title(title);
		vo.setCommunity_content(smarteditor);
		vo.setCommunity_user_id(user_id);
		/*후에 등록해준다*/
		departmentService.regist(vo);
		
		
		return "redirect:/department/notice?pageseq=1";
}
	/*학과공지 수정 프로세스*/
	@RequestMapping(value="notice/modifyprocess",method={RequestMethod.GET, RequestMethod.POST})
	public String modifyProcess(HttpServletRequest request, HttpServletResponse response,CommunityVO vo,
			String seq,
			String title,
			String smarteditor) throws Exception {
		
		
		
		/*데이터베이스에 수정된 날짜 컬럼 부분에 넣기 위해 현재날짜와 시간을 구함*/
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dayTime.format(new Date());
		
		/*파라미터로 넘어온 값을 넣음*/
		vo.setCommunity_seq(seq);
		vo.setCommunity_title(title);
		vo.setCommunity_content(smarteditor);
		/*서비스단에 설정 해 놓은 메소드를 실행*/
		vo.setCommunity_revise_datetime(str);
		departmentService.modify(vo);
		
		
		return "redirect:/department/notice?pageseq=1";
}
		
}
