<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > QnA</h3></div>
												
												<div class="faq">
												
													<ul class="faqBody">
													<!-- 반복되는 부분 -->
													<c:forEach items="${faq}" var="fa">
														<li class="article" id='a${ fa.faq_seq }' >
															<p class="q"  value="${ fa.faq_title }"><a href="#a${ fa.faq_seq }">Q: ${ fa.faq_title }</a></p>
															<p class="a" style="padding-left:30px;" value="${ fa.faq_content }">A: ${ fa.faq_content }
															<input type="button" value="수정" class="total_btn" style="width: 60px; height: 30px;">
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
