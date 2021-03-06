<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>재능마당 관리자페이지</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/css/main.css" type="text/css">
	<link rel="stylesheet" href="/css/curd.css" type="text/css">
	<link rel="stylesheet" href="/css/c_crud.css" type="text/css">
	<link rel="stylesheet" href="/css/h_crud.css" type="text/css">
	<link rel="stylesheet" href="/css/jquery-syaku.lightbox.css" type="text/css">
	<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/series-label.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script src="/webjars/jquery/2.1.1/dist/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/script.js"></script>
	<script src="/js/crud.js"></script>
	<script src="/js/c_crud.js"></script>
	<script src="/js/h_crud.js"></script>
	<script src="/js/jquery-syaku.lightbox.js"></script>
	<script src="/js/HuskyEZCreator.js"></script>
	 
	
</head>
<body >
							<%-- <jsp:include page="../sub_menu/complain/complain_write.jsp" flush="false"/> --%>  


<div id = "header">
		<div class="header_intro">
			<div class="header_intro background"></div>
			<b><a href="/" style="font-size:17px; color:#fff; " >재능마당 관리자센터</a></b>
		</div> <!-- 이 부분에 로고 이미지 넣던지 글씨 이뿐거 만들던지  -->
		
		<div class= "header_setting"><!-- 버튼은 이미지 형식으로 만들 것 -->
				<ul>
					<li > <span><i class="material-icons">settings</i></span>
						<ul>
							<li><a href="/logout" class="logout">로그아웃</a></li>
						</ul>
					</li>
				</ul>
		</div>

		
		<div class= "header_null">			
				<!-- 넣고싶은것생각나면넣어랑 -->
		</div>
</div>
