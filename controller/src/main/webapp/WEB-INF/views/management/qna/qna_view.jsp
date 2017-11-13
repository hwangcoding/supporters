<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>QnA 관리 > QnA 글 확인</h3></div>
						
							<form name="fr_write" id="fr_write" method="post" enctype="multipart/form-data" action="/department/notice/modify" >
								<table width="100%"  id="user_list"  border="1">
								<c:forEach items="${view}" var="view" varStatus="status">
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value=${ view.qna_seq} name="seq">
									<tbody align="center">
									<!-- 반복되는부분 --> 
									
									<tr>
										<td width="15%">제목</td>
										<td align="left" style="padding-left:20px;"width="40%" >${view.qna_title}</td>
										<td width="10%">작성자</td>
										<td  width="20%" colspan="2">${view.user_num}</td>
										<td>답변상태</td>
										<td width="10%">${view.qna_state }</td>
									</tr> 
									<tr>
										<td>질문종류</td>
										<td>${view.qna_type }</td>
										<td colspan="3" >작성일</td>  
										<td width="10%" colspan="2">${view.qna_write_datetime}</td>
									</tr>
									<tr >
										<td>내용</td>
										<td colspan="6" height="400px" style="text-align:left;">${view.qna_content }</td>
									</tr>
									</c:forEach>
									<!-- 반복되는부분 --> 
																				
									</tbody>
									<tfoot align="center">  
										<tr  style="text-align:center;">
											<td colspan="7" class="table_paging">
											<%-- <c:choose>
												<c:when test="${view.qnasr_content == null }">
													<input type="button" id="modify_button" value="작성">
												</c:when>
												
												<c:otherwise>
													<input type="button" id="modify_button" value="수정">
												</c:otherwise>
											</c:choose> --%>
												<input type="button"  id="notice_list_btn" value="목록">
												<input type="button"  id="delete_button" value="삭제">
						 
									</tfoot>
								
								</table>
								
								</form>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>