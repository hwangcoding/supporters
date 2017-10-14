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
							<li><a href="#">커뮤니티</a></li>
							<li><a href="#">열쇠관리</a></li>
						</ul>
					</li>
					<li><a href="#"><span>컨텐츠관리</span><i class="material-icons">add</i></a>
						<ul>
							<li><a href="#">중고장터</a></li>
							<li><a href="#">오늘뭐먹지</a></li>
							<li><a href="#">끝말잇기</a></li>
						</ul>
					</li>		
					<li><a href="#">통계</a></li>
					<li><a href="#">관리</a></li>
				</ul>
			</div>
		</div>