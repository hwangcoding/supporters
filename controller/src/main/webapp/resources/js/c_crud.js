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
/*    	
        $("ul.tabs li").removeClass("active").css("color", "#333");
        $(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
        
        
        $(".restaurant_list").hide()
      var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn()*/
        $("#tabs_ch").val($(this).val());
        document.frm_tabs.submit();
    });
    
    
    /*qna 목록으로 가기*/
    $("#qna_list_btn").click(function(){
    	location.href="/management/qna/list?pageseq=1";
    	
    })
    
    /*qna 작성페이지로 이동*/
    $("#qna_write_button").click(function(){
    	
    	$("#qna_frm_delete").attr("action", "/management/qna/write");
    	$("#qna_frm_delete").submit();
    	
    });
    
    /*qna 답변 작성*/
    $("#qna_write_submit_button").click(function(){
    	
    	$("#fr_write").submit();
    	
    });
    
    /*qna 답변 삭제*/
    $("#qna_delete_button").click(function(){
    	
    	var qna_confirm_delete = confirm('정말 삭제하시겠습니까?');
    	
    	if(qna_confirm_delete) {
    		
    		$("#qna_frm_delete").submit();

    	} else {
    		
    		return false;
    		
    	}
    	
    });
    
    /*qna 답변 수정 페이지로 이동*/
    $("#qna_modify_button").click(function(){
    	
    	$("#qna_frm_delete").attr("action", "/management/qna/modify");
    	$("#qna_frm_delete").submit();
    	
    });
    
    /*qna 수정 작성*/
    $("#qna_modify_submit_button").click(function(){
    	
    	$("#fr_modify_submit").submit();
    	
    });
    
    
    
    
/*    if($("#tabs_ch").text() == $("ul.tabs li").val()){
    	
    }*/
    
/*    var article_qna = $('.qna>.qnaBody>.article'); 
    article_qna.addClass('hideview');
    article_qna.find('.a').hide();
    article_qna.eq(0).removeClass('hideview');
    article_qna.eq(0).find('.a').show();
    $('.qna>.qnaBody>.article>.q>a').click(function(){
    	var myArticle_qna = $(this).parents('.article:first');
    	if(myArticle_qna.hasClass('hideview')){
    		article_qna.addClass('hideview').removeClass('showview');
    		article_qna.find('.a').slideUp(100);
    		myArticle_qna.removeClass('hideview').addClass('showview');
    		myArticle_qna.find('.a').slideDown(100);
    	} else {
    		myArticle_qna.removeClass('showview').addClass('hideview');
    		myArticle_qna.find('.a').slideUp(100);
    	}
    	return false;
    });
    전체 답변 열고 닫기
    $('.showviewAll_qna').click(function(){
    	var hidden_qna = $('.qna>.qnaBody>.article.hideview').length;
    	if(hidden_qna > 0){
    		$(this).attr("value","모두 닫기");
    		article_qna.removeClass('hideview').addClass('showview');
    		article_qna.find('.a').slideDown(100);
    	} else {
    		$(this).attr("value","모두 열기");
    		article_qna.removeClass('showview').addClass('hideview');
    		article_qna.find('.a').slideUp(100);
    	}
    });*/
	

});
