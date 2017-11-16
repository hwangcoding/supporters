<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>QnA > QnA 관리</h3></div>
									
									<div style="text-align:right; background:#fff; height:50px; border-top:0px;">
				
										<form method="post" action="/management/qna/list?pageseq=1">
											
											<select name="searchFiled" class="search_select" style="width: 75px;">
											
												 <option value="0">제목</option>
												 <option value="1">작성자</option>
												 <option value="2">질문종류</option>
												 
											</select>
											
												<input type="text" name="searchValue" class="search_text">
												<input type="submit" class="search_button" value="검색">
										</form>
				
									</div>
					<div>
						<form name="frm_tabs" method="post" action="/management/qna/list?pageseq=1">
								<ul class="tabs">
								<c:forEach begin="0" end="0" varStatus="status">
								
										<li rel="tab1" ${page.searchValue eq "" ? 'class="active"' : '' } value="0">전체</li>
										<li rel="tab2" ${page.searchValue eq "1" ? 'class="active"' : '' } value="1">답변 대기</li>
										<li rel="tab3" ${page.searchValue eq "2" ? 'class="active"' : '' } value="2">답변 완료</li>
										
								</c:forEach>
								</ul>
								
								<input type="hidden" id="tabs_ch" name="tabs_ch">
						
						</form>
					</div>			
								<table width="100%" id="user_list"  border="0">
									<thead align="center">
										<tr width="100%" >
											<th width="5%">글번호</th>
											<th width="13%">답변 상태</th>
											<th width="12%">질문 종류</th>
											<th width="30%">제목</th>
											<th width="15%">작성자</th>	
											<th width="25%">질문일</th>
										</tr>									
									</thead>
									
									<tbody align="center">
										<!-- 반복되는부분 -->
										<!-- jstl을 이용하여 forEach 로 값이 있는 동안 계속 반복 됨. -->
										
										<!-- 값이없을때 -->
									<c:if test="${empty qna}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="6">글이 없습니다.</td>
										</tr>
										
									</c:if>
										
										<!-- 값이있을때-->
										<c:if test="${qna!= '' || qna ne null}">
												<c:forEach items="${qna}" var="qna" varStatus="status"> 
													<tr width="100%">	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
														<td width="5%">${qna.qna_seq }</td>
														<td width="13%">

														<c:choose>
																
															<c:when test="${qna.qna_state eq '1'}">
															답변 대기
															</c:when>
																	
															<c:when test="${qna.qna_state eq '2'}">
															답변 완료
															</c:when>
																				
														</c:choose>

														</td>
														<td width="12%">${qna.qna_type }</td>
														<td width="30%"><a href="/management/qna/view?seq=${qna.qna_seq}">
														${ qna.qna_title }</a></td>
														<td width="15%">${ qna.user_num } </td>
														<td width="25%"> ${qna.qna_write_datetime}</td>
													</tr>
												</c:forEach>
											</c:if>	
												<!-- 반복되는부분 -->							
									
											</tbody>
											
											
										
											<tfoot align="center">
											<!-- 글쓰기 버튼을 누르면 제이쿼리로 정의 해 놓은 이벤트가 발생합니다 -->
												
													<tr>
													<!-- 페이징을 위한 녀석 -->
													
														<td colspan="6" class="table_paging">
															<jsp:include page="../../include/paging.jsp" flush="true">
															    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
															    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
															    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
															    <jsp:param name="pageNo" value="${paging.pageNo}" />
															    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
															    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
															    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
															</jsp:include>
														</td>
													</tr>
											</tfoot>
										
								</table>
								
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>
