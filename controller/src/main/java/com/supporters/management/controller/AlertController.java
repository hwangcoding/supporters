package com.supporters.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.supporters.department.domain.NoticeVO;
import com.supporters.domain.AlertLogVO;
import com.supporters.service.AlertLogService;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;

@Controller
@RequestMapping("/management/alert/*")
public class AlertController {

	@Inject
	private StudentService studentService;
	
	@Inject
	private AlertLogService alertLogService;
	
	/*Alert 쓰기*/
	@RequestMapping(value = "writeprocess" ,method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			Model model,String msg,StudentVO vo,AlertLogVO log
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
	    
        log.setMinor_cd("ALET01");
        log.setAlert_content(msg);
        alertLogService.log(log);
	    
	    List<StudentVO> st = studentService.alert(vo);
	    
	    
	    for(int a =0; a<st.size();a++) {
	    	System.out.println(st.get(a).getUser_token().toString());
	    	token.add(st.get(a).getUser_token().toString()); //저장된 토큰을 가져와 ArrayList에 저장합니다.
	    }
	    
        JSONObject jsonOb = new JSONObject();
        jsonOb.put("group", "total");
        jsonOb.put("title", "전체알람");
        jsonOb.put("content", msg);
	    
        msg = new String(jsonOb.toString().getBytes("UTF-8"), "UTF-8");   //메시지 한글깨짐 처리
      
        
        Sender sender = new Sender(simpleApiKey);
        Message message = new Message.Builder()
		.collapseKey(MESSAGE_ID)
        .delayWhileIdle(SHOW_ON_IDLE)
        .timeToLive(LIVE_TIME)
        .addData("json",msg)
        .build();
        
        MulticastResult result1 = sender.send(message,token,RETRY);
        if (result1 != null) {
            List<Result> resultList = result1.getResults();
            for (Result result : resultList) {
                System.out.println(result.getErrorCodeName()); 
            }
        }
	    
	    
	    
		
		return "redirect:/management/alert/write?pageseq=1";
	}
	

		/*alert 페이지*/
		@RequestMapping(value="write")
		public String write(@RequestParam String pageseq,
				Model model,AlertLogVO paging,
				String searchValue,
				String searchFiled) throws Exception {
			try {
				
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="alert_content"; break;
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
				paging.setTotalCount(alertLogService.count(paging));
				/*서비스단에 설정 해 놓은 메소드를 실행시켜 */ 
		        List<AlertLogVO> list = alertLogService.list(paging);
		        
		        model.addAttribute("page",paging);
				model.addAttribute("log", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
			
			return "management/alert/alert_write";
		}

	
	
	}
	

