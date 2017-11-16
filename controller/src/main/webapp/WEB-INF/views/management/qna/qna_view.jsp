<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>QnA 관리 > QnA 질문 및 답변 확인</h3></div>
						
							<form name="qna_frm_delete" id="qna_frm_delete" method="post" enctype="multipart/form-data" action="/management/qna/delete" >
								<table width="100%"  id="qna_list_view"  border="0">
								<c:forEach items="${view}" var="view" varStatus="status">
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value=${ view.qna_seq} name="seq">
									<tbody align="center" class="number_ch">
									<!-- 반복되는부분 --> 
									
									<tr style="text-align: center;">
											<th width="15%">제 목 :</th>
											<th align="left" width="35%" >${view.qna_title}</th>
											<th width="10%">질문자 :</th>
											<th  width="15%" colspan="2">${view.user_num}</th>
											<th width="10%">답변상태 :</th>
											<th width="15%">
											<c:choose>
											
												<c:when test="${view.qna_state eq '1'}">
												
													답변대기
												
												</c:when>
												
												<c:otherwise>
												
													답변완료
												
												</c:otherwise>
											
											</c:choose>
											</th>
									</tr> 
									<tr>
										<th>질문종류 :</th>
										<th>${view.qna_type }</th>
										<th>질문날짜 :</th>  
										<th width="10%" colspan="5">${view.qna_write_datetime}</th>
									</tr>
									<tr >
										<td>내 용</td>
										<td colspan="6" height="300px" style="text-align:left;">${view.qna_content }</td>
									</tr>
																				
									
								
									<c:choose>
									
										<c:when test="${view.qna_state eq 2 }">
										
										<tr>
										
											<td>답변내용</td>
											<td colspan="6"  align="left" height="300px">${view.qnasr_content }</td>
										
										</tr>
										
										<tr>
										
											<td>답변날짜</td>
											<td colspan="6"  align="left">
											
												<c:choose>
					
															<c:when test="${view.qnasr_write_datetime < view.qnasr_revise_datetime}">
															
																 ${view.qnasr_revise_datetime}
																 
															</c:when>
																
															<c:otherwise>
															
																  ${view.qnasr_write_datetime}
																  
															</c:otherwise>
					
														</c:choose>
											
											</td>
										
										</tr>
										
										</c:when>
									
									</c:choose>
									
									</tbody>
									
									<tfoot align="center"> 
									
										<tr  style="text-align:center;">
											<td colspan="7" class="table_paging">
											<c:choose>
												<c:when test="${view.qna_state eq '1'}">
													<input type="button" class="total_btn" id="qna_write_button" value="작성">
												</c:when>
												
												<c:otherwise>
													<input type="button" class="total_btn" id="qna_modify_button" value="수정">
												</c:otherwise>
											</c:choose>
												<input type="button" class="total_btn"  id="qna_list_btn" value="목록" style="margin-left: 5px; margin-right: 5px;">
												<input type="button" class="total_btn"  id="qna_delete_button" value="답변삭제">
						 				</td>
						 				</tr>
									</tfoot>
								</c:forEach>
								</table>
								
								</form>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>