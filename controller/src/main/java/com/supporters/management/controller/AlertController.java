package com.supporters.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;

@Controller
@RequestMapping("/management/alert/*")
public class AlertController {

	@Inject
	private StudentService studentService;
	
	/*Alert 쓰기*/
	@RequestMapping(value = "writeprocess" ,method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			Model model,String msg,StudentVO vo
			) throws Exception {
		ArrayList<String> token = new ArrayList<String>();    //token값을 ArrayList에 저장
	    String MESSAGE_ID = String.valueOf(Math.random() % 100 + 1);    //메시지 고유 ID
	    //String used_token = request.getParameter("username"); 
	    boolean SHOW_ON_IDLE = false;    //옙 활성화 상태일때 보여줄것인지
	    int LIVE_TIME = 1;    //옙 비활성화 상태일때 FCM가 메시지를 유효화하는 시간입니다.
	    int RETRY = 2;    //메시지 전송에 실패할 시 재시도 횟수입니다.

		
	    String simpleApiKey = "AAAASEAVc8I:APA91bEMNWNbwScDYKuCflIkiMlF"
	    		+ "_ctrYSC8c8noyOCm2h52CwP7yyKzUSnn5DMia2Lzf6UkH7SMyXOtwDzSJMPOgsNNDJu3Y0uRDkWbnxKSaaoqHHA"
	    		+ "_AmEae1rfSSuKfZeP7rsrcQWT";
	    String gcmURL = "https://android.googleapis.com/fcm/send";  

		
	    
	    List<StudentVO> st = studentService.alert(vo);
	    
	    
	    for(int a =0; a<st.size();a++) {
	    	token.add(st.get(a).getUser_token().toString()); //저장된 토큰을 가져와 ArrayList에 저장합니다.
	    }
	    
        msg = new String(msg.getBytes("UTF-8"), "UTF-8");   //메시지 한글깨짐 처리
      
        
        Sender sender = new Sender(simpleApiKey);
        Message message = new Message.Builder()
		.collapseKey(MESSAGE_ID)
        .delayWhileIdle(SHOW_ON_IDLE)
        .timeToLive(LIVE_TIME)
        .addData("message",msg)
        .build();
        MulticastResult result1 = sender.send(message,token,RETRY);
        if (result1 != null) {
            List<Result> resultList = result1.getResults();
            for (Result result : resultList) {
                System.out.println(result.getErrorCodeName()); 
            }
        }
	    
	    
	    
		
		return "management/alert/alert_write";
	}
	

		/*alert 페이지*/
		@RequestMapping(value="write")
		public String write() throws Exception {
			
			return "management/alert/alert_write";
		}

	
	
	}
	

