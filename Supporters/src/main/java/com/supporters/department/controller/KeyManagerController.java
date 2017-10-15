package com.supporters.department.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/department/keymanager/*")
public class KeyManagerController {

	/*글쓰기만들어야함*/
	
	@Inject
	private DepartmentService departmentService;
	
	
		@RequestMapping(value = "list")
		public String list(@RequestParam String pageseq,
				Model model,CommunityVO paging) throws Exception {

	
			return "department/keymanager/key_list";
			
		}
		@RequestMapping(value = "notice/view")
		public String view(@RequestParam String seq,
				Model model,CommunityVO paging,HttpSession session) throws Exception {

	
			return "department/notice_view";
			
		}
		
		
		/*학과공지 수정하기*/
		@RequestMapping(value = "notice/modify")
		public String modify(@RequestParam String seq,
				Model model,CommunityVO paging) throws Exception {

	
			return "department/notice_modify";
			
		}
		
	
	
}
