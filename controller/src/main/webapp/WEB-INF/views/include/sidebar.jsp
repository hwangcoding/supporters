<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
 -->
	
		<div id = "sidebar">
			<div class="sidebar_user"> 	
				<div class="sidebar_user alert">
					<ul>
					
						<li>문의 사항 :<span>10</span></li>
						<li>최근 로그인 :${date } </li>
					</ul>
				</div>
			</div>
	
	
	
			<div class="sidebar_menu">
				<ul>
					<li><a href="/">홈</a></li>
					<li><a href="/student/list?pageseq=1">회원관리</a></li>
					<li><a href="#"><span>학과관리</span><i class="material-icons">add</i></a>
						<ul>
							<li><a href="/department/notice?pageseq=1">학과공지</a></li>
							<li><a href="/department/community/list?pageseq=1">커뮤니티</a></li>
							<li><a href="/department/keymanager/list?pageseq=1">열쇠관리</a></li>
						</ul>
					</li>
					<li><a href="#"><span>콘텐츠관리</span><i class="material-icons">add</i></a>
						<ul>
							<li><a href="/contents/used/list?pageseq=1">중고장터</a></li>
							<li><a href="/contents/restaurant/list?pageseq=1">오늘뭐먹지</a></li>
							<li><a href="/contents/fictiongame/fiction_list?pageseq=1">끝말잇기</a></li>
						</ul>
					</li>		
					<li><a href="/statistics/view">통계</a></li>
					<li><a href="#"><span>관리</span><i class="material-icons">add</i></a>
						<ul>
							<li><a href="/management/faq/list?pageseq=1">FAQ</a></li>
							<li><a href="/management/qna/list?pageseq=1">QnA</a></li>
							<li><a href="/management/alert/write">알림 관리</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>