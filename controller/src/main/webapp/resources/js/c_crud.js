$(document).ready(function(){

$("input[name=delete_btn").click(function(){
		
	var confirm_delete = confirm('정말 삭제하시겠습니까?');
	
	if(confirm_delete) {
		
		document.frm_delete.submit();

	} else {
		
		return false;
		
	}
	});

	$("input[name=modify_btn]").click(function(){
		/*alert("뀨");*/
		$("#frm_modify").attr("action", "/contents/restaurant/modify");
		$("#frm_modify").submit();
	});
	
	/*오늘 뭐먹지 작성 서브밋*/
	$("input[name=modify_submit]").click(function(){
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
			/*10월 31일 작업 */
			 
			  if(!$("#file_ch").val()){
				  
				    alert( "사진을 선택하여 주세요!");
				    return false;
				    
			  }
			  
			  $("#file_ch").change(function(){
					
					 var fileExt = $("#file_ch").val().substring($("#file_ch").val().lastIndexOf('.')+1);
					  var imgCh =  ["jpg","png","bmp","gif"];
					  var imgChCount = 0;
					  fileExt = fileExt.toLowerCase();
					  
					  for(var i = 0; i<imgCh.length; i++) {
				        	if(fileExt == imgCh[i]) {
				        		imgChCount++;
				        	}
				        }
				       
				        if(imgChCount == 0) {
				        	
				        	$("#file_ch").val('');
				        	return alert(fileExt + " 확장자 명은 사용할수 없습니다 (jpg, png, bmp, gif 가능)");
				        	return false;
				        }
					
				});
			  
			  document.frm_modify.submit();
 
	});

});