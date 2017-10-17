<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 학과공지</h3></div>
						
								<form action="/department/notice/writeprocess" method="post" id="frm">
									
									제목 : <input type="text" name ="title">
									작성자 : <input type="text" name ='user_id' value= ${ ADMIN_ID } readonly>
								    <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:756px; height:412px;">

   								 </textarea>
								
								    <input type="button" id="savebutton" value="서버전송" />
								
								</form>
					</div>
						<!-- </div> -->

		
		
	</div>
<script src="/js/smart.js"></script>

</body>
</html>
