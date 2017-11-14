package com.supporters.student.cotroller;

import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supporters.domain.LoginVO;
import com.supporters.function.KISA_SHA256;
import com.supporters.function.RandomName;
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
			@RequestParam String user_token,
			Model model,StudentVO vo) throws Exception {
		
		
		/*SHA-256 비밀번호 암호화*/
		StringBuffer hexString = new StringBuffer();
		  try{
			  
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(user_pw.getBytes("UTF-8"));
	            
	 
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	 
	            //출력
	            System.out.println(hexString.toString());
	 
	        } catch(Exception ex){
	            throw new RuntimeException(ex);
	        }
		
		
		
		/*안드로이드에서 파라미터 값 보내준걸 받아서 StudentVO 객체에 담아준다.*/
		vo.setUser_token(user_token);
		vo.setUser_num(user_id);
		vo.setUser_pw(hexString.toString());
		vo.setUser_gender(user_gender);
		vo.setUser_nm(user_name);
		vo.setUser_phone(user_phone);
		vo.setUser_email(user_email1+"@"+user_email2);
		vo.setUser_birth(user_birth);
		switch(state) {
		case "0" :state="재학"; break;
		case "1" :state="휴학";break;
		case "2" :state="졸업";break;
		case "3" :state="전과";break;
		default : state="재학";break;
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
	
	//로그인 절차
	@RequestMapping(value = "loginprocess")		
	public String  loginProcess(
			@RequestParam String userid,
			@RequestParam String userpw,
			@RequestParam String user_token,
			Locale locale,StudentVO vo,
			HttpSession session, Model model) throws Exception {
		/*adminId , adminPw 파라미터를 받아서 변수를 설정했음.*/ 
		/*SHA-256 비밀번호 암호화*/
		StringBuffer hexString = new StringBuffer();
		  try{
			  
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(userpw.getBytes("UTF-8"));
	            
	 
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	 
	            //출력
	            System.out.println(hexString.toString());
	 
	        } catch(Exception ex){
	            throw new RuntimeException(ex);
	        }
		
		/*파라미터 값을 VO에 주입 */
		vo.setUser_num(userid);
		vo.setUser_pw(hexString.toString());
		vo.setUser_token(user_token);
		int a= studentService.search(vo);
		if (a==1) {
			/*아이디가 있으면 여기로 */
			StudentVO str = studentService.login(vo);
				if(str!=null) {
					
				if(!(str.getUser_token().equals(user_token))) {
					System.out.println("토큰정보다름");
					studentService.token(vo);
				}	
				JSONObject item;   // 제이손 변수 선언
				JSONArray items = new JSONArray();  //제이손어레이 생성
				
				item = new JSONObject();  //제이손오브젝 선언
				item.put("회원이름" , str.getUser_nm());  
				item.put("회원아이디" , str.getUser_num());	
				items.put(item);
			
				model.addAttribute("login", items);
				return "student/student_login" ;
				}else {
					/*아이디가 없으면 model 에 false 라는 값을 넣음*/
					model.addAttribute("login", "false");
					return "student/student_login";
				}
		}else {
			/*아이디가 없으면 model 에 false 라는 값을 넣음*/
			model.addAttribute("login", "false");
			return "student/student_login";
		}
		
		}
	
	
	//메일발송 테스트
    @RequestMapping("/modifyprocess")
    public String modify(StudentVO vo,Model model,
    		String num,
    		String password) throws Exception{
         
        	/*SHA-256 비밀번호 암호화*/
    		StringBuffer hexString = new StringBuffer();
    		  try{
    			  
    	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
    	            byte[] hash = digest.digest(password.getBytes("UTF-8"));
    	            
    	 
    	            for (int i = 0; i < hash.length; i++) {
    	                String hex = Integer.toHexString(0xff & hash[i]);
    	                if(hex.length() == 1) hexString.append('0');
    	                hexString.append(hex);
    	            }
    	        } catch(Exception ex){
    	            throw new RuntimeException(ex);
    	        }
	    vo.setUser_num(num);	  
    	vo.setUser_pw(hexString.toString());
        studentService.pwUpdate(vo);
        
        model.addAttribute("pass",true);  // 등록된 회원임
        
        return "/student/student_modify";
    }
			
	
}
