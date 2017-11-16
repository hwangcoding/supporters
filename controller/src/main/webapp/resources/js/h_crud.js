$(document).ready(function(){

/*커뮤니티 삭제*/
	$("#community_list_delete_btn").click(function(){
		var result = confirm('정말 삭제 하시겠습니까?');
		if(result) { 
			var vali = $("#community_seq").val();
			location.href="/department/community/delete?seq="+vali;
			alert("삭제 되었습니다.");
		}else { 
		
			
		}
	});
	
	/*FAQ 삭제 처리 버튼*/	
	$(".faq_delete").click(function(){
		var result = confirm('정말 삭제 하시겠습니까?');
		if(result) { 
			var seq = $(this).closest("li").attr("id").substring(1);
			var url = $(location).attr('pathname')+"?usernum="+seq;
			location.href="/management/faq/list/delete?faqseq="+seq;
			alert("삭제 되었습니다.");
		}else { 
		
			
		}
	});
	
	$(".alert_write_btn1").click(function(){
		document.frm_alert.submit();
		
	});
	
	
	/*통계 버튼 일주일 , 1개월 , 3개월*/
	
	$("#week").click(function(){
		location.href="/statistics/view?dateValue=week";
	});
	$("#1m").click(function(){
		location.href="/statistics/view?dateValue=one";
	});
	$("#3m").click(function(){
		location.href="/statistics/view?dateValue=three";
	});
	

});

