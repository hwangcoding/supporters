<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > QnA</h3></div>
												
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
																
															<a href="#a${ qna.qna_seq }">제목: ${ qna.qna_title } </a>

															<input type="button" value="답변삭제" class="total_btn" style="width: 60px; height: 30px; float: right; margin-top: 5px;">
															
															</p>
																
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
