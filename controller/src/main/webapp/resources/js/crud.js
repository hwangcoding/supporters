$(document).ready(function(){
	/*공지사항글쓰기버튼클릭*/
	$(".write_button").click(function(){
		
		location.href="/department/notice/write";
	});
	
	/*공지사항 글 목록*/
	$("#notice_list_btn").click(function(){
		location.href='	/department/notice?pageseq=1';
	});
		
		
		
	
	/*공지사항글수정페이지로서브밋*/
	$("#modify_button").click(function(){
		
		var result = confirm('수정 하시겠습니까?');
		if(result) { 
			/*폼의 속성중 action 의 속성 값을 변경*/
			$("#fr_write").attr("action", "/department/notice/modify");
			/*폼안에 있는 것은 서브밋*/ 
			$("#fr_write").submit();
		}else { 
		
			
		}
	});
	
	/*공지사항 글수정완료서브밋*/
	$("#modeify_finish").click(function(){
		if(!$("#title").val()){
			alert("제목을 작성해 주십시오.");
			return false;
		}
		if(!$("#contents").val()){
			alert("내용을 작성해 주십시오.");
			return false;
		}
		var result = confirm('수정 하시겠습니까?');
		if(result) { 
			/*폼안에 있는 것은 서브밋*/ 
			$(document).modify.submit();
			alert("수정 되었습니다.");
		}else { 
			return false;		
			
		}
		
		
	});
	/*공지사항 삭제*/
	$("#delete_button").click(function(){
		var result = confirm('정말 삭제 하시겠습니까?');
		if(result) { 
			$("#fr_write").attr("action", "/department/notice/delete");
			$("#fr_write").submit();
			alert("삭제 되었습니다.");
		}else { 
			return false;
		u
			
		}
	});
	
	/*커뮤니티 글쓰기버튼클릭*/
	$("#community_write_btn").click(function(){
		
		location.href="/department/community/write";
	});
	
	/*커뮤니티  글 목록*/
	$("#community_list_btn").click(function(){
		location.href='	/department/community/list?pageseq=1';
	});
	
	/*중고장터 글쓰기버튼클릭*/
	$("#used_write_btn").click(function(){
		
		location.href="/department/community/write";
	});
	
	/*중고장터  글 목록*/
	$("#used_list_btn").click(function(){
		location.href='	/department/community/list?pageseq=1';
	});
	

	/*오늘 뭐먹지 추가 클릭*/
	$("input[name=attend_btn]").click(function(){
		location.href="/contents/restaurant/write";
	});
	
	/*오늘 뭐먹지 작성 서브밋*/
	$("input[name=write_submit]").click(function(){
		if(!$(".res_text_title").val()){
			alert("가게 이름을 작성해 주십시오.");
			return false;
		}
			if(!$("#res_addr").val()){
				alert("주소를 작성해 주십시오.");
				return false;
			}
			if(!$("#res_phone").val()){
				alert("전화번호를 작성해 주십시오.");
				return false;
			}
			if(!$("#res_latitude").val()){
				alert("위도를 작성해 주십시오.");
				return false;
			}
			if(!$("#res_lognitode").val()){
				alert("경도를 작성해 주십시오.");
				return false;
			}
			document.frm_write.submit();
	});
	
	
	/*오늘 뭐먹지 목록 클릭*/
    $("input[name=go_list]").click(function(){
        location.href="/contents/restaurant/list?pageseq=1";
    });
	
	

	

	/*FAQ*/
	var article = $('.faq>.faqBody>.article'); 
	article.addClass('hideview');
	article.find('.a').hide();
	article.eq(0).removeClass('hideview');
	article.eq(0).find('.a').show();
	$('.faq>.faqBody>.article>.q>a').click(function(){
		var myArticle = $(this).parents('.article:first');
		if(myArticle.hasClass('hideview')){
			article.addClass('hideview').removeClass('showview');
			article.find('.a').slideUp(100);
			myArticle.removeClass('hideview').addClass('showview');
			myArticle.find('.a').slideDown(100);
		} else {
			myArticle.removeClass('showview').addClass('hideview');
			myArticle.find('.a').slideUp(100);
		}
		return false;
	});
	/*전체 답변 열고 닫기*/
	$('.showviewAll').click(function(){
		var hidden = $('.faq>.faqBody>.article.hideview').length;
		if(hidden > 0){
			$(this).attr("value","답변 닫기");
			article.removeClass('hideview').addClass('showview');
			article.find('.a').slideDown(100);
		} else {
			$(this).attr("value","답변 열기");
			article.removeClass('showview').addClass('hideview');
			article.find('.a').slideUp(100);
		}
	});
	/*글 추가 버튼 */
	$('#faq_write').hide();
	$('.faq_write_btn').click(function () {
	    if($("#faq_write").css("display") == "none"){   
	        $('#faq_write').show();
	        $('.faq_write_btn').attr("value" , "닫기");
	    } else {  
	        $('#faq_write').hide();
	        $('.faq_write_btn').attr("value" , "글 추가");
	    }  
	});  
	
	
	/*글 추가 버튼 */
	$(".faq_write_btn1").click(function(){
		
		if(!$("input[name=faq_title]").val()){
			alert("제목을 작성해 주십시오.");
			return false;
		}
		
		if(!$("input[name=faq_contents]").val()){
			alert("내용을 작성해 주십시오.");
			return false;
		}
		var result = confirm('작성 하시겠습니까?');
		if(result) { 
			document.frm_faq.submit();
			alert("작성 되었습니다.");
		}else { 
			return false;
		
			
		}
	});
/*
규빈아 너 여기 제이쿼리 만들어야 한다 ^^ 뭐 바꾸냐면 
1. 수정 버튼 누르면 펼쳐지고 안에꺼 인풋타입 바꾸면 되 ㅎㅎ 나머지는 자바딴 
*//*
	$(".faq_modify").click(function(){
	//	
		
		alert("a");
			$(this).closest("li").prepend('<form method="post" name="faq_frm" action="/management/faq/list/modify" style="display:inline-flex;width:88%;display:inline-flex;" >');
			
			$(this).parent().parent().attr("class",'article showview');
			$(this).parent().parent().children(".a").css("display",'block');
			var title = $(this).parent(".q").attr("value");
			var contents = $(this).parent().parent().children(".a").attr("value");
			$(this).parent().children("a").replaceWith(' <input type="text"  style="width:100%;display:inline-flex;   padding: .7em 1em;" value= " '+title+' " >');
			$(this).parent().parent().children(".a").replaceWith('<input type="text" class="a" style="width:100%; padding-left:30px;" value=" '+contents+' " > </form>');
			$(this).attr("class","faq_modifyS");
			
		
	});
	$(".faq_modifyS").click(function(){
		var result = confirm('수정 하시겠습니까?');
		if(result) { 
			
		}else { 
			return false;
		
			
		}
		
	});*/
/*
 * 	$(this).parent().parent().attr("class",'article hideview');
	$(this).parent().parent().children(".a").css("display",'none');
*/	
	
	/*FAQ 끝*/
	
	

});

