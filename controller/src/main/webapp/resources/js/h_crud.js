$(document).ready(function(){

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
	
	

});

