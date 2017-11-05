package com.supporters.controller;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supporters.domain.CommunityVO;
import com.supporters.domain.LoginVO;
import com.supporters.domain.StatisticsVO;
import com.supporters.function.DateCalculator;
import com.supporters.service.LoginService;
import com.supporters.service.StatisticsService;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;


/**
 * @author Hwangcoding
 * 작업기간 : 17.08.23 ~ 
 * 작업내용 : 재능마당 관리자 페이지
 *  
 *
 */
@Controller
public class HomeController {

	@Inject
	private LoginService loginService;
	@Inject
	private StudentService studentService;
	@Inject
	private StatisticsService statisticsService;
	
	
	/*function에 만들어 놓은 데이터 클래스
	 * 통계 부분에서 사용*/
	DateCalculator dc;
	
	@RequestMapping(value = "/")
	public String home( Model model,
			CommunityVO vo,StudentVO stuVo,StatisticsVO statisticVO) throws Exception {

		return "index";
	}
	
	@RequestMapping(value = "/login")			// 로그인 화면
	public String home() {
		return "/login/login";
	}
	
	
	
	@RequestMapping(value = "/loginProcess")			//로그인 절차
	public String  loginProcess(
			@RequestParam String adminId,
			@RequestParam String adminPw,Locale locale,LoginVO vo,
			HttpSession session, Model model) throws Exception {
		/*adminId , adminPw 파라미터를 받아서 변수를 설정했음.*/ 
		/*SHA-256 비밀번호 암호화*/
		StringBuffer hexString = new StringBuffer();
		  try{
			  
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(adminPw.getBytes("UTF-8"));
	            
	 
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
		vo.setAdministrator_id(adminId);
		vo.setAdministrator_pw(hexString.toString());
		 
		/*LoginVO 라고 지은 모델에 서비스단( LoginService )에 만들어 놓은  메소드를 불러서
		 *  loginMapper.xml 에 등록해 놓은 쿼리를 실행하고 나온 결과 값을 result 객체에 넣는다.*/
		LoginVO result = loginService.login(vo);
		
		
		//result 에 결과 값이 있는지 없느지 판단하는 문장.
		if (result != null) {
			
			String date = result.getAdministrator_lastlogin();
			if(date != null) {
				if(date.equals(dc.getTodayDate())) {
					
				}else {
					result.setAdministrator_lastlogin(dc.getTodayDate());
					loginService.dateLogin(result);
					
				}
			}else {
				result.setAdministrator_lastlogin(dc.getTodayDate());
				loginService.dateLogin(result);}
			
			
		//result 에 결과 값을 sessionNm 에 할당, getFaculty_name 는 LoginVO에 선언 했음. 
		//ADMIN_NM 이라는 변수명에 sessionNm 을 넣어 세션을 잡아줌
		session.setAttribute("date",result.getAdministrator_lastlogin());
		session.setAttribute("ADMIN_ID", result.getAdministrator_id()); 
		}else {
			System.out.println("값없음");
		}
		
		return "redirect:/";
	}
	
	/*로그아웃 하는 메소드
	 * 세션에 잡힌 ADMIN_ID 값을 제거 해준다.*/
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("ADMIN_ID");
		return "redirect:/";
		
	}
	
	
	
}
