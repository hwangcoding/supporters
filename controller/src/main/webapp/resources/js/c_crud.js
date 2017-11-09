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
	
	/*오늘 뭐먹지 수정 서브밋*/
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
			
			document.frm_modify.submit();

	});
	
	$("#file_ch").change(function(){
		
		$("#file_ch_num").val('2');
		
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


    $("ul.tabs li").click(function () {
    	
        $("ul.tabs li").removeClass("active").css("color", "#333");
        $(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
        $("#tabs_ch").val($(this).val())
        
        /*$(".restaurant_list").hide()*/
      var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn()
        
        document.frm_tabs.submit();
    });
    
/*    if($("#tabs_ch").text() == $("ul.tabs li").val()){
    	
    }*/
	

});