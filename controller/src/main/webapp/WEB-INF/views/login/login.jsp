<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/css/main.css" type="text/css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script src="/webjars/jquery/2.1.1/dist/jquery.min.js"></script>
	<script src="/js/script.js"></script>
</head>

<body>

 	<div id = login_background>
        <form method="post" action="/loginProcess" name="login" id="login">
        		
        		<div class="con_wrapper">
        			<div class="wrapper_img"></div>
        			
       			 
			 	<div class="wrapper" style=" 
							    margin-left: 100px;
							    border-left-width: 5px;
							    padding-left: 90px;">
			 	
			        <div class="wrap-input">
			        <h2>재능마당 관리자</h2>  
			        	<!-- ID 를 입력하는 칸  -->
			            <input class="login_text" type="text" name="adminId" id="adminId" placeholder="username"></input>
			        </div>
			        <div class="wrap-input">
			        	<!-- PW 를 입력하는 칸 -->
			            <input class="login_text" type="password" name="adminPw" id="adminPw" placeholder="password"></input>
			        </div>
			        <button class="btn" id="loginBtn">로그인</button>
			    </div>
			    </div>
		</form>
	</div>
</body>
</html>