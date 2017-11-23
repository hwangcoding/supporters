package com.supporters.department.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.supporters.department.domain.NoticeVO;
import com.supporters.department.service.DepartmentService;
import com.supporters.student.domain.StudentVO;
import com.supporters.student.service.StudentService;
@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	/*글쓰기만들어야함*/
	
	@Inject
	private DepartmentService departmentService;
	
	@Inject
	private StudentService studentService;
	
	
	/*학과공지 리스트*/
		@RequestMapping(value = "notice")
		public String list(@RequestParam String pageseq,
				Model model,NoticeVO paging,
				String searchValue,
				String searchFiled) throws Exception {
			try {
				
				if(searchValue==null) {searchValue="";}
				if(searchFiled==null) {searchFiled="";}
				switch(searchFiled) {
				case "0": searchFiled="department_notice_title"; break;
				case "1":searchFiled="department_notice_user_id"; break;
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
		        List<NoticeVO> list = departmentService.list(paging);
		        
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
				Model model,NoticeVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setDepartment_notice_seq(seq);
				/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
		        List<NoticeVO> list = departmentService.read(paging);
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "department/notice_view";
			
		}
		
		/*학과공지  클릭시 안드로이드 보여지는곳*/
		@RequestMapping(value = "notice/android_view")
		public String android_view(@RequestParam String seq,
				Model model,NoticeVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setDepartment_notice_seq(seq);
				/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
		        List<NoticeVO> list = departmentService.read(paging);
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "department/android_view";
			
		}
		
		
		/*학과공지 수정하기*/
		@RequestMapping(value = "notice/modify")
		public String modify(@RequestParam String seq,
				Model model,NoticeVO paging) throws Exception {
			try {
				/*게시물의 시퀀스를 가져와 설정 함*/
				paging.setDepartment_notice_seq(seq);
		        List<NoticeVO> list = departmentService.read(paging);
		         
				model.addAttribute("view", list);
		        
		    } catch (Exception e) {
		    	System.out.println("파일이없떠요");
		    }
	
			return "department/notice_modify";
			
		}
		
	
		
		
		
		
		/*학과공지 삭제하기 */
		@RequestMapping(value="notice/delete")
		public String delete(NoticeVO vo,String seq) throws Exception {
			/*그 게시물의 시퀀스를 가져옴*/
			vo.setDepartment_notice_seq(seq);
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
	public String writeProcess(HttpServletRequest request, HttpServletResponse response,NoticeVO vo,
			String user_id,
			String title,
			String smarteditor,
			StudentVO stuvo) throws Exception {
		System.out.println("들어옴");

		
		/*학과 공지사항 코드 DBB001을 기본으로 설정*/
		vo.setMinor_cd("DEB001");
		vo.setDepartment_notice_title(title);
		vo.setDepartment_notice_content(smarteditor);
		vo.setDepartment_notice_user_id(user_id);
		/*후에 등록해준다*/
		departmentService.regist(vo);
		
		/*작성과 동시에 전체 학생에게 메세지를 보냅니다*/
		
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

		
	    
	    List<StudentVO> st = studentService.alert(stuvo);
	    
	    
	    for(int a =0; a<st.size();a++) {
	    	System.out.println(st.get(a).getUser_token().toString());
	    	token.add(st.get(a).getUser_token().toString()); //저장된 토큰을 가져와 ArrayList에 저장합니다.
	    }
	    
        JSONObject jsonOb = new JSONObject();
        jsonOb.put("group", "notice_dep");
        jsonOb.put("notice_title", "공지사항 알림");
        jsonOb.put("notice_content", title);

	    title = new String(jsonOb.toString().getBytes("UTF-8"), "UTF-8");   //메시지 한글깨짐 처리

        Sender sender = new Sender(simpleApiKey);
        Message message = new Message.Builder()
		.collapseKey(MESSAGE_ID)
        .delayWhileIdle(SHOW_ON_IDLE)
        .timeToLive(LIVE_TIME)
        .addData("json",title)
        .build();
        

        
        MulticastResult result1 = sender.send(message,token,RETRY);
        if (result1 != null) {
            List<Result> resultList = result1.getResults();
            for (Result result : resultList) {
                System.out.println(result.getErrorCodeName()); 
            }
        }
		
		
		return "redirect:/department/notice?pageseq=1";
}
	/*학과공지 수정 프로세스*/
	@RequestMapping(value="notice/modifyprocess",method={RequestMethod.GET, RequestMethod.POST})
	public String modifyProcess(HttpServletRequest request, HttpServletResponse response,NoticeVO vo,
			String seq,
			String title,
			String smarteditor) throws Exception {
		
		
		
		/*데이터베이스에 수정된 날짜 컬럼 부분에 넣기 위해 현재날짜와 시간을 구함*/
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dayTime.format(new Date());
		
		/*파라미터로 넘어온 값을 넣음*/
		vo.setDepartment_notice_seq(seq);
		vo.setDepartment_notice_title(title);
		vo.setDepartment_notice_content(smarteditor);
		/*서비스단에 설정 해 놓은 메소드를 실행*/
		vo.setDepartment_notice_revise_datetime(str);
		departmentService.modify(vo);
		
		
		return "redirect:/department/notice?pageseq=1";
}
		
}
