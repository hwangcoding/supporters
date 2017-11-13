<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > QnA</h3></div>
				
												<div class="faqHeader" style="float:right;">
													<input type="button" class="showviewAll_qna" value="모두 열기">
												</div>
												
												<div class="qna">
												
													<ul class="qnaBody">
													<!-- 반복되는 부분 -->
													<c:forEach items="${qna}" var="qna">
														<li class="article" id='a${ qna.qna_seq }' >

															<p class="q"  value="${ qna.qna_title }" style="font-weight:bold; background:#f5f5f5; color:#000; text-decoration:none !important;">
																
																<c:choose>
																
																    <c:when test="${qna.qna_state eq '1'}">
																       [답변 대기]
																    </c:when>
																	
																    <c:when test="${qna.qna_state eq '2'}">
																      [답변 완료]
																    </c:when>
																				
																</c:choose>
																
															<a href="#a${ qna.qna_seq }"> ${ qna.qna_title } </a>
															
																<c:choose>
																
																    <c:when test="${qna.qna_state eq '1'}">
																       <input type="button" value="답변작성" id="qna_write_btn" class="total_btn" style="width: 60px; height: 30px;">
																    </c:when>
																	
																    <c:when test="${qna.qna_state eq '2'}">
																      <input type="button" value="답변수정" id="qna_modify_btn" class="total_btn" style="width: 60px; height: 30px;">
																    </c:when>
																				
																</c:choose>
																
															<input type="button" value="삭제" class="total_btn" style="width: 60px; height: 30px;">
															</p>
															<p class="a" style="padding-left:30px; border-bottom: 1px solid #ddd;" value="${ qna.qna_content }">내용: ${ qna.qna_content }</p>
																
																<c:choose>
																
																    <c:when test="${qna.qnasr_content != null}">
																      <p class="a" style="padding-left:30px;" value="${ qna.qnasr_content }">답변: ${ qna.qnasr_content }</p>
																    </c:when>
																				
																</c:choose>
																
														</li>
													</c:forEach>
													<!-- 반복되는 부분 -->
													</ul>
												</div>	
										
											<span  class="table_paging">
												<jsp:include page="../../include/paging.jsp" flush="true">
												    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
												    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
												    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
												    <jsp:param name="pageNo" value="${paging.pageNo}" />
												    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
												    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
												    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
												</jsp:include>
											</span>
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>
