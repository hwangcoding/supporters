<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>QnA 질문 및 답변 확인 > QnA 답변 작성</h3></div>
												
							<form name="fr_write" id="fr_write" method="post" enctype="multipart/form-data" action="/management/qna/write/process" >
								<table width="100%"  id="qna_list_view"  border="0">
								<c:forEach items="${write}" var="write" varStatus="status">
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value=${ write.qna_seq} name="seq">
									<tbody align="center" class="number_ch">
									<!-- 반복되는부분 --> 
									
									<tr style="text-align: center;">
											<th width="15%">제 목 :</th>
											<th align="left" width="35%" >${write.qna_title}</th>
											<th width="10%">질문자 :</th>
											<th  width="15%" colspan="2">${write.user_num}</th>
											<th width="10%">답변상태 :</th>
											<th width="15%">
											<c:choose>
											
												<c:when test="${write.qna_state eq '1'}">
												
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
										<th>${write.qna_type }</th>
										<th>질문날짜 :</th>  
										<th width="10%" colspan="5">${write.qna_write_datetime}</th>
									</tr>
									<tr >
										<td>질문내용</td>
										<td colspan="6" height="300px" style="text-align:left;">${write.qna_content }</td>
									</tr>

										<tr>
										
											<td>답변내용</td>
											<td colspan="6"  align="left" height="300px"><textarea placeholder="답변을 적어주세요" rows="10" cols="100" class="res_text_addr" name="wite_content"
											 style="resize: none; width: 100%; height: 300px;"></textarea></td>

										</tr>
									</tbody>
									
									<tfoot align="center"> 
									
										<tr  style="text-align:center;">
											<td colspan="7" class="table_paging">
											<c:choose>
												<c:when test="${write.qna_state eq '1'}">
													<input type="button" class="total_btn" id="qna_write_submit_button" value="작성하기">
												</c:when>
												
												<c:otherwise>
													<input type="button" class="total_btn" id="qna_modify_button" value="수정">
												</c:otherwise>
											</c:choose>
												<input type="button" class="total_btn"  id="qna_list_btn" value="목록" style="margin-left: 5px; margin-right: 5px;">
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