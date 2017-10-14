$(document).ready(function(){
	/*글쓰기버튼클릭*/
	$(".write_button").click(function(){
		location.href="/department/notice/write";
	});
	
	/*글작성하고서브밋*/
	$(".write_process").click(function(){
		$(document).write.submit();
	});
	/*글수정페이지로서브밋*/
	$("#modify_button").click(function(){
		var result = confirm('수정 하시겠습니까?');
		if(result) { 
			/*폼의 속성중 action 의 속성 값을 변경*/
			$("#fr_write").attr("action", "/department/notice/modify");
			/*폼안에 있는 것은 서브밋*/ 
			$(document).write.submit();
			alert("삭제 되었습니다.");
		}else { 
		
			
		}
	});
	
	/*글수정완료서브밋*/
	$("#modeify_finish").click(function(){
		$(document).modify.submit();
	});
	
	$("#delete_button").click(function(){
		var result = confirm('정말 삭제 하시겠습니까?');
		if(result) { 
			$("#fr_write").attr("action", "/department/notice/delete");
			$(document).write.submit();
			alert("삭제 되었습니다.");
		}else { 
		
			
		}
	});
});
