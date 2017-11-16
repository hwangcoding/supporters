<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 열쇠관리</h3></div>
								<table width="100%"  id="user_list"  border="0">
									<thead align="center">
										<tr style="text-align:right; background:#fff; height:50px; border-top:0px; ">
											<td colspan="8">
											<form id="submit_key_ch" method="post" action="/department/keymanager/list?pageseq=1">
											<select name="searchFiled" class="search_select" style="width: 90px;">
												 <option value="0">강의실 호수</option>
												 <option value="1">대여자</option>
												</select>
												<input type="text" name="searchValue" class="search_text">
												<input type="submit" class="search_button" value="검색">
												</form>
											</td>
										</tr>
										<tr width="100%" >
											<th width="10%">번호</th>
											<th width="11%">강의실 호수</th>
											<th width="14%">키 상태</th>
											<th width="15%">대여자</th>
											<th width="15%">인계자</th>
											<th width="12%">대여일</th>
											<th width="12%">반납 및 인계일</th>
											<th width="10%">반납처리</th>
										</tr>									
									</thead>
									
									<tbody align="center">
										<!-- 반복되는부분 -->
										<!-- jstl을 이용하여 forEach 로 값이 있는 동안 계속 반복 됨. -->
										
										<!-- 값이없을때 -->
									<c:if test="${empty key}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="7">관리할 키가 없습니다</td>
										</tr>
										
									</c:if>
										
										<!-- 값이있을때-->
										<c:if test="${key!= '' || key ne null}">
												<c:forEach items="${key}" var="key" varStatus="status"> 
													<tr width="100%">	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
														<td width="10%">${key.key_seq }</td>
														<td width="10%">${key.key_num }</td>
														<td width="11%">
														
														<c:choose>
														
															<c:when test="${key.key_state == '0'}">
															
																대여중
																
															</c:when>
															
															<c:when test="${key.key_state == '1'}">
															
																반납완료
															
															</c:when>

															<c:when test="${key.key_state == '2'}">
															
																학생에게 인계
															
															</c:when>
														
														</c:choose>
														
														</td>
														<td width="15%">${key.key_have }</td>
														<td width="15%">
														
														<c:choose>
														
															<c:when test="${key.key_apply eq null }">
															
																-
															
															</c:when>
														
															<c:otherwise>
															
																${key.key_apply}
															
															</c:otherwise>
														</c:choose>
														
														</td>
														<td width="12%">${key.key_date }</td>
														<td width="12%">
														
															<c:choose>
															
																<c:when test="${key.key_return_date == '0000-00-00 00:00:00' }">
																
																	-
																
																</c:when>
																
																<c:otherwise>
															
																${key.key_return_date}
															
															</c:otherwise>
															
															</c:choose>

														</td>
														<td width="10%">
														
														<c:choose>
														
															<c:when test="${key.key_state == '0'}">
															
																<input type="button" style="width: 60px; height: 30px;" rel="${key.key_seq }" value="처리" id="submit_key" class="total_btn">
																
															</c:when>
														
															<c:otherwise>
															
																완료
															
															</c:otherwise>
														
														</c:choose>
														</td>
													</tr>
												</c:forEach>
											</c:if>	
												<!-- 반복되는부분 -->							
									
											</tbody>
											
											
										
											<tfoot align="center">
												
													<tr>
													<!-- 페이징을 위한 녀석 -->
													
														<td colspan="8" class="table_paging">
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
