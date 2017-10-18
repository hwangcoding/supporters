<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>오늘 뭐먹지 관리 > 오늘 뭐먹지 글 확인</h3></div>
						
							<form name="write" id="fr_write" method="post" enctype="multipart/form-data" action="/department/notice/modify" >
								<table width="100%"  id="user_list"  border="1">
								<%-- <c:forEach items="${view}" var="view" varStatus="status"> --%>
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value="1" name="seq">
									<tbody align="center">
									<!-- 반복되는부분 --> 
									
									<tr>
										<td width="15%">제목</td>
										<td align="left" style="padding-left:20px;"width="40%" >테스트1</td>
										<td width="10%">작성자</td>
										<td width="20%" colspan="4">admin</td>
										<!-- 조회수 부분 컬럼 제거 -->
									</tr> 
									<tr>
										<td colspan="4" align="left" style="padding-left:20px;"><input type="file" value="이미지 이름1"></td>
										<td colspan="2">작성일</td>  
										<td width="10%">2017-10-18</td>
										  
									</tr>
									<tr >
										<td>내용</td>
										<td colspan="6" height="400px" >내용부분<%-- <img src="/img/${ view.community_img}"> 이미지 부분 처리 부탁--%></td>
									</tr>
									<%-- </c:forEach> --%>
									<!-- 반복되는부분 --> 
																				
									</tbody>
									<tfoot align="center">  
										<tr  style="text-align:center;">
											<td colspan="7" class="table_paging" > 
												<button class="write_button" id="list" name="go_list">목록</button>
											</td>
						 
									</tfoot>
								
								</table>
								
								</form>
							
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>