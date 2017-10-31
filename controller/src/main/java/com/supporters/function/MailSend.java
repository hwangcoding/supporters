package com.supporters.function;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;


@Controller
public class MailSend {

	
	@Inject
	private StudentService studentService;
	
	//메일발송 테스트
    @RequestMapping("/sendmail")
    public String navermailtest(HttpServletRequest request,StudentVO vo,Model model,
    		String mail,
    		String user_num) throws Exception{
    	/*/sendmail?mail=gosomi8877@gmail.com&user_num=2014141080*/
        // 메일 관련 정보
        String host = "smtp.naver.com";
        final String username = "hwangcoding";       //네이버 이메일 주소중 @ naver.com앞주소만 기재합니다.
        final String password = "1q2w3e4r!@";   //네이버 이메일 비밀번호를 기재합니다.
        int port=465;
         
        String newPw=RandomName.getRandomPw();
        // 메일 내용
        String recipient = mail;    //메일을 발송할 이메일 주소를 기재해 줍니다.
        String subject = "재능마당 임시 비밀번호 입니다.";
        String body = "재능 마당 비밀번호 :"+newPw+"입니다.";
    	
        vo.setUser_num(user_num);
        vo.setUser_pw(newPw);
        vo.setSearchFiled("user_num");
        vo.setSearchValue(user_num);
        vo.setPageSize(10);
        List<StudentVO> values = studentService.list(vo);
        if(values.isEmpty()) {
        	model.addAttribute("pass",false); // 등록된 회원이 아님
        }else {
        studentService.pwUpdate(vo);
        
        model.addAttribute("pass",true);  // 등록된 회원임
        }
        Properties props = System.getProperties();
          
          
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
           
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            String un=username;
            String pw=password;
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(un, pw);
            }
        });
        session.setDebug(true); //for debug
           
        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("hwangcoding@naver.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(body);
        Transport.send(mimeMessage);
        
        return "/student/student_modify";
    }


	
	
	
}
