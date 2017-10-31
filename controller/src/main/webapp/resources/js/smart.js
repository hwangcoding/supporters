$(document).ready(function(){



		//전역변수선언
			var tx_v=$("#tx_value").val();
			if(!tx_v){tx_v="";}
		    var editor_object = [];

		    nhn.husky.EZCreator.createInIFrame({

		        oAppRef: editor_object,

		        elPlaceHolder: "smarteditor",
		       
		        
		        sSkinURI: "/smarteditor/SmartEditor2Skin.html", 

		        htParams : {

		            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)

		            bUseToolbar : true,             

		            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)

		            bUseVerticalResizer : true,     

		            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)

		            bUseModeChanger : false, 
		            fOnBeforeUnload : function(){ 
		            	
		            } 
		        	}, fOnAppLoad : function(){ 
		            	//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용 
		        		
		        		editor_object.getById["smarteditor"].exec("PASTE_HTML", [tx_v])}, 
		            	fCreator: "createSEditor2"



		    });

		     

		    //전송버튼 클릭이벤트

		    $("#savebutton").click(function(){

		        //id가 smarteditor인 textarea에 에디터에서 대입

		        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
		        // 이부분에 에디터 validation 검증
		        //폼 submit
		        if(validation()) {
		        	
		        	if(!$("#title").val()){
		    			alert("제목을 작성해 주십시오.");
		    			return false;
		    		}
		        	$("#frm").submit();
		        	}


		    })

		
//필수값 Check 
function validation(){ 
	
	if(!"#smarteditor"){
		// 기본적으로 아무것도 입력하지 않아도 값이 입력되어 있음. 
		alert("내용을 입력하세요."); 
		editor_object.getById['smarteditor'].exec('FOCUS');
		return false;
		}
		return true; 
	}
	



});