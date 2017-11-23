$(document).ready(function(){
	$.ajax({
		type : "POST",
		url : "/statistics/qna",
		dataType : "text",
		success : function response(data) {
				$(".qna_value").text(data);
	
		}
	});
	 function a(){
		 var domainUrl=$(location).attr('pathname');
		 var value = domainUrl.split("/"); // 슬러쉬로 된 부분 다 끊어 가져옴 /department/notice   
		 var cssValue='css("color","#C9182B")';
			 if(value[1]=="department"){
				 $(".sidebar_menu>ul>li:eq(2)").addClass("open");
					 if(value[2] =="notice"){
					 $(".sidebar_menu>ul>li:eq(2)>ul>li:eq(0)>a").css("color","#C9182B"); /*학과공지*/
					 }if(value[2] =="community"){
						 $(".sidebar_menu>ul>li:eq(2)>ul>li:eq(1)>a").css("color","#C9182B"); /*학과 > 커뮤니티*/
					 }if(value[2] =="keymanager"){
						 $(".sidebar_menu>ul>li:eq(2)>ul>li:eq(2)>a").css("color","#C9182B"); /*학과 > 열쇠관리*/
					 }
			 }else if(value[1]=="student"){
				 $(".sidebar_menu>ul>li:eq(1)").addClass("open"); /*회원관리*/
			 }else if(value[1]==""){
				 $(".sidebar_menu>ul>li:eq(0)").addClass("open"); /*홈클릭시*/
			 }else if(value[1]=="contents"){
				 $(".sidebar_menu>ul>li:eq(3)").addClass("open"); /*콘텐츠관리*/
				 	if(value[2] =="used"){
				 		$(".sidebar_menu>ul>li:eq(3)>ul>li:eq(0)>a").css("color","#C9182B"); /*콘텐츠 > 중고장터*/
					 }if(value[2] =="restaurant"){
						 $(".sidebar_menu>ul>li:eq(3)>ul>li:eq(1)>a").css("color","#C9182B"); /*콘텐츠 >오늘 뭐 먹지*/
					 }if(value[2] =="fictiongame"){
						 $(".sidebar_menu>ul>li:eq(3)>ul>li:eq(2)>a").css("color","#C9182B"); /*콘텐츠 > 끝말잇기*/
					 }
			 }else if(value[1]=="statistics"){
				 $(".sidebar_menu>ul>li:eq(4)").addClass("open"); /*통계*/
			 }else if(value[1]=="management"){
				 $(".sidebar_menu>ul>li:eq(5)").addClass("open"); /*관리*/
				 if(value[2] =="faq"){
					 $(".sidebar_menu>ul>li:eq(5)>ul>li:eq(0)>a").css("color","#C9182B"); /*관리 > FAQ*/
					 }
				 if(value[2] =="qna"){
					 $(".sidebar_menu>ul>li:eq(5)>ul>li:eq(1)>a").css("color","#C9182B"); /*관리 > FAQ*/
					 }
				 if(value[2] =="alert"){
					 $(".sidebar_menu>ul>li:eq(5)>ul>li:eq(2)>a").css("color","#C9182B"); /*관리 > FAQ*/
					 }
			 }
			 
	 };
	 
	
	
	 a();
	
	
	
	/*로그인부분*/
	$("#loginBtn").click(
			function (){
				var adminId = $("#adminId").val();
				var adminPw = $("#adminPw").val();
				
				
				if(!adminId){
					
					$("#adminId").focus();
					alert("아이디를 입력 해주십시오.");
					return false;
					
				}
				if(!adminPw){
					
					$("#adminPw").focus();
					alert("비밀번호를 입력 해주십시오.")
					return false;
				
				}
			
		$("#login").submit();
	
			});
	/*로그인부분*/
	
	/*로그아웃*/
	$(".logout").click(function(){
		alert("정상적으로 로그아웃 되었습니다.");
	});
	
	
	/*회원정보 삭제 */
	$(document).on('click', '#drop_button', function () {
		var result = confirm('정말 삭제 하시겠습니까?');
		if(result) { 
			var num = $(this).attr('name');
			var url = $(location).attr('pathname')+"?usernum="+num;
			location.href="list/delete?usernum="+num;
			alert("삭제 되었습니다.");
		}else { 
		
			
		}
	});
	/*회원정보 삭제 끝 */
	
	
	/*아코디언*/
	//1레벨 메뉴 클릭 시 하위 메뉴 펼치기/접기
	$(".sidebar_menu>ul>li>a").on("click", function(){
		var element = $(this).parent("li");
		
		//하위 메뉴가 펼쳐져 있는 경우
		//현재의 하위 메뉴는 접음
		if(element.hasClass("open")){
			element.removeClass("open");
			element.find("li").removeClass("open");
			element.find("ul").slideUp();
		}
		
		//하위 메누가 접혀 있는 경우
		//현재의 하위 메뉴는 펼치면서 다른 하위 메뉴는 접음
		else{
			element.addClass("open");
			element.children("ul").slideDown();
			element.siblings("li").children("ul").slideUp();
			element.siblings("li").removeClass("open");
			
			element.siblings("li").find("li").removeClass("open");
			element.siblings("li").find("ul").slideUp();
		}
	});
	
		//문서 로드 후 처리
		//2레벨 메뉴를 모두 접음
		$(".sidebar_menu ul ul").hide();
		//1레벨 메뉴 중 "open"으로 되어 있는 메뉴의 하위 메뉴를 펼침
		$(".open").children("ul").slideDown();
		
		/*아코디언 끝*/
		
		
		
		//1레벨 메뉴 클릭 시 하위 메뉴 펼치기/접기
	$(".header_setting>ul>li>span").on("click", function(){
		var element = $(this).parent("li");
		
		if(element.hasClass("div_open")){
			element.removeClass("div_open");
			element.find("li").removeClass("div_open");
			element.find("ul").hide();
		}

		//하위 메누가 접혀 있는 경우
		//현재의 하위 메뉴는 펼치면서 다른 하위 메뉴는 접음
		else{
			element.addClass("div_open");
			element.children("ul").show();
			element.siblings("li").children("ul").hide();
			element.siblings("li").removeClass("div_open");

			element.siblings("li").find("li").removeClass("div_open");
			element.siblings("li").find("ul").hide();
		}

	});

	
		//문서 로드 후 처리
		//2레벨 메뉴를 모두 접음
		$(".header_setting ul ul").hide();
		//1레벨 메뉴 중 "open"으로 되어 있는 메뉴의 하위 메뉴를 펼침
		$(".div_open").children("ul").hide();

		
});

	function goPage(index) {
		 var url =$(location).attr('pathname')+"?pageseq="+index;
		    location.href =url;
		};
		