package com.supporters.student.cotroller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.function.KISA_SHA256;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;

@Controller
@RequestMapping("/student/*")
public class StudentController {

 
	@Inject
	private StudentService studentService;
	private KISA_SHA256 kisa;
	
	
	
	/*회원리스트*/
	@RequestMapping(value = "list" ,method={RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam String pageseq,
			Model model,
			StudentVO paging,
			String searchValue,
			String searchFiled) throws Exception {
		try {
			if(searchValue==null) {searchValue="";}
			if(searchFiled==null) {searchFiled="";}
			switch(searchFiled) {
			case "0": searchFiled="user_num"; break;
			case "1":searchFiled="user_nm"; break;
			case "2":searchFiled="user_atten"; break;
			}
			System.out.println(searchFiled);
			int seq = Integer.parseInt(pageseq);
			paging.setPageNo(seq);
			paging.setPageSize(10);
			paging.setSearchValue(searchValue);
			paging.setSearchFiled(searchFiled);
			paging.setTotalCount(studentService.count(paging));
			System.out.println(seq);
	       
	        List<StudentVO> list = studentService.list(paging);
	        
	        model.addAttribute("page",paging);
			model.addAttribute("student", list);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요");
	    }

		return "student/student_list";
	}
	
	
	/*회원가입 */
	@RequestMapping(value="list/add")
	public String add(
			@RequestParam String user_id,
			@RequestParam String user_pw,
			@RequestParam String user_gender,
			@RequestParam String user_name,
			@RequestParam String user_phone,
			@RequestParam String user_email1,
			@RequestParam String user_email2,
			@RequestParam String user_birth,
			@RequestParam String state,
			Model model,StudentVO vo) throws Exception {
		
		
		
		
		
		/*안드로이드에서 파라미터 값 보내준걸 받아서 StudentVO 객체에 담아준다.*/
		vo.setUser_num(user_id);
		vo.setUser_pw(user_pw);
		vo.setUser_gender(user_gender);
		vo.setUser_nm(user_name);
		vo.setUser_phone(user_phone);
		vo.setUser_email(user_email1+"@"+user_email2);
		vo.setUser_birth(user_birth);
		switch(state) {
		case "0" :state="재학"; break;
		case "1" :state="휴학";break;
		case "2" :state="졸업";break;
		case "3" :state="전괴";break;
		}
		vo.setUser_atten(state);
		
		/*회원가입시 아이디가 중복되었는지 확인 하는 것*/
		int a= studentService.search(vo);
		if (a==1) {
			/*아이디가 있으면 model 에 false 라는 값을 넣음*/
			model.addAttribute("add", "false");
			return "student/student_add" ;
		}else {
			/*아이디가 없으면 model 에 true 라는 값을 넣음*/
			studentService.add(vo);
			model.addAttribute("add", "true");
			return "student/student_add";
		}
	}
	
	@RequestMapping(value="list/delete")
	public String delete(@RequestParam String usernum,StudentVO vo) throws Exception {
		
		vo.setUser_num(usernum);
		studentService.remove(vo);
		
		
		return "redirect:/student/list?pageseq=1";
	}
	@RequestMapping(value="list/search")
	public String search(@RequestParam String usernum,StudentVO vo) throws Exception {
		
		vo.setUser_num(usernum);
		studentService.remove(vo);
		
		
		return "redirect:/student/list?pageseq=1";
		
	
	
	}
	

}
