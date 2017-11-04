<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > FAQ</h3></div>
												
												
												<div id= "faq_write" >
												<form method="post" action="/management/faq/list/write" name="frm_faq">
													<table width="100%" height="200px" border="0" style="border:groove">
														<tr>
															<td width="10%" style="font-size:18px; text-align:center;">제목</td>
															<td width="80%"><input type="text" name="faq_title" style="width:100%;height:60%; "></td>
														</tr>
														
														<tr>
															<td style="font-size:18px; text-align:center;">내용</td>
															<td><input type="text" name="faq_contents"  style="width:100%;height:60%; " ></td>
														</tr>
														<tr>
															<td colspan="2" align="center">
																<input type="button" class="faq_write_btn1" value="작성">
															</td>
														</tr>
													</table>
													</form>
												</div>
												<div class="faqHeader" style="float:right;">
													<input type="button" class="faq_write_btn" value="글 추가">
													<input type="button" class="showviewAll" value="답변 열기">
												</div>
												
												
												
												
												<div class="faq">
												
													<ul class="faqBody">
													<!-- 반복되는 부분 -->
													<c:forEach items="${faq}" var="fa">
														<li class="article" id='a${ fa.faq_seq }' >
															<p class="q"  value="${ fa.faq_title }"><a href="#a${ fa.faq_seq }">Q: ${ fa.faq_title }</a>
															 <input type="button" class="faq_delete" value="삭제"></p>
															<p class="a" style="padding-left:30px;" value="${ fa.faq_content }">A: ${ fa.faq_content }</p>
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
