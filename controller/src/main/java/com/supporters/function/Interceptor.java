package com.supporters.function;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Service
public class Interceptor extends HandlerInterceptorAdapter {
	 protected final Logger logger = LoggerFactory.getLogger(this.getClass());

		 /**
		     * 생성자
		     */
		    public Interceptor() {
		        // default constructor
		    }
		    /**
		     * 로그인 세션체크 예외 주소 처리
		     */
		    @Override
		    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		    	logger.info("===========================          START         ===========================");
		        logger.info(" Request URI \t:  " + request.getRequestURI());


		    	
//		        uecocity.bsp.common.exception.BSPException bs = new uecocity.bsp.common.exception.BSPException();
		        String requestURI = request.getRequestURI();
		        
		        /*회원가입이랑 통계에서 쓸 녀석들 세션 없는거 예외 처리*/
		        if(requestURI.indexOf("/student/list/add")>-1) return true;
		        if(requestURI.indexOf("/student/loginprocess")>-1) return true;
		        if(requestURI.indexOf("/statistics/join_week")>-1) return true;
		        if(requestURI.indexOf("/statistics/visited_week")>-1) return true;
		        if(requestURI.indexOf("/department/notice")>-1) return true;
		        if(requestURI.indexOf("/department/notice/view")>-1) return true;
		        if(requestURI.indexOf("/sendmail")>-1) return true;
		        if(requestURI.indexOf("/student/modifyprocess")>-1) return true;
		        
		        
		        
		        if (requestURI.indexOf("/login") > -1) { //세션체크 예외페이지
		            return true;
		        } else {//위의 예외페이지 외에는 세션값을 체크해서 있으면 그냥 페이지표시
		         
		            HttpSession session = request.getSession();
		            String result = (String)session.getAttribute("ADMIN_ID");
		            if (result != null && !result.isEmpty()) {
		                return true;
		            }
		        }
		        //정상적인 세션정보가 없으면 로그인페이지로 이동
		        response.sendRedirect("/login");
		        return false;
		    }
		}
