<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 학과공지 글 확인</h3></div>
						
							<form name="fr_write" id="fr_write" method="post" enctype="multipart/form-data" action="/department/notice/modify" >
								<table width="100%"  id="user_list"  border="1">
								<c:forEach items="${view}" var="view" varStatus="status">
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value=${ view.department_notice_seq} name="seq">
									<tbody align="center">
									<!-- 반복되는부분 --> 
									
									<tr>
										<td width="15%">제목</td>
										<td align="left" style="padding-left:20px;"width="40%" >${view.department_notice_title}</td>
										<td width="10%">작성자</td>
										<td  width="20%" colspan="2">${view. department_notice_user_id}</td>
										<td >조회수</td>
										<td width="10%"> ${view.department_notice_lookupcnt } </td>
									</tr> 
									<tr>
										<td colspan="4"  align="left" style="padding-left:20px;"></td>
										<td colspan="2" >작성일</td>  
										<td width="10%">${view. department_notice_write_datetime}</td>
										  
									</tr>
									<tr >
										<td colspan="7" height="400px" style="text-align:left;">${ view.department_notice_content }</td>
									</tr>
									</c:forEach>
									<!-- 반복되는부분 --> 
																				
									</tbody>
								
								</table>
								
								</form>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>
