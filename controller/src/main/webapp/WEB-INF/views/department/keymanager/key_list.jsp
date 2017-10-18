<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
		  <div class="modal-dialog" style="width:550px; background-color:#ffffff;"  >
		    <div  style="width:550px; background-color:#ffffff;" >
		      <div class="modal-header"  >
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>
		        
		      
		      <div class="modal-body" >
		      
		      
		        <form method="post" action="" name="">
				<table width="100%"  id="user_list"  border="0">
									<thead align="center">
										<tr style="text-align:right; background:#fff; height:50px; border-top:0px; ">
											<td colspan="5"><select class="search_select">
												 <option value="0">1</option>
												 <option value="1">2</option>
												 <option value="2">3</option>
												 <option value="3">4</option>
												</select>
												<input type="text" class="search_text">
												<button type="button" class="search_button">검색</button>
											</td>
										</tr>
										<tr width="100%">
											<td width="10%">강의실 호수</td>
											<td width="40%">사유</td>
											<td width="10%">학번</td>
											<td width="20%">신청일</td>
											<td width="20%">반납일</td>
										</tr>									
									</thead>
									
									<tbody align="center">
										<!-- 반복되는부분 -->
										<!-- 값이없을때 -->
									<c:if test="${empty notice}">
										
										<tr width="100%" >
												<td width="10%" colspan="5">게시물이 없습니다.</td>
										</tr>
										
									</c:if>
										
										<!-- 값이있을때-->
										<c:if test="${notice!= '' || notice ne null}">
												<c:forEach items="${notice}" var="no" varStatus="status"> 
												
													<tr width="100%">	
														<td width="10%">302호</td>
														<td width="40%">학교 끝나고 좀 더 공부 하기 위해</td>
														<td width="10%">20141414080</td>
														<td width="20%">2017-10-15</td>
														<td width="20%">2017-10-16</td>
													</tr>
												
												</c:forEach>
											</c:if>	
												<!-- 반복되는부분 -->							
									
											</tbody>
		        </table>
				</form>
		       
		        
		      </div>
		    </div>
		  </div>
		</div>
		
		
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 열쇠관리</h3></div>
						
							
								<table width="100%"  id="user_list"  border="0">
									<thead align="center">
										<tr style="text-align:right; background:#fff; height:50px; border-top:0px; ">
											<td colspan="5">
												<select class="search_select">
													 <option value="0">1</option>
													 <option value="1">2</option>
													 <option value="2">3</option>
													 <option value="3">4</option>
												</select>
												<input type="text" class="search_text">
												<button type="button" class="search_button">검색</button>
											</td>
										</tr>
										<tr width="100%">
											<td width="10%">강의실 호수</td>
											<td width="40%">사유</td>
											<td width="10%">학번</td>
											<td width="20%">신청일</td>
											<td width="20%">반납일</td>
										</tr>									
									</thead>
									
									<tbody align="center">
										<!-- 반복되는부분 -->
										<!-- 값이없을때 -->
									<c:if test="${empty notice}">
										
										<tr width="100%" >
												<td width="10%" colspan="5">게시물이 없습니다.</td>
										</tr>
										
									</c:if>
										
										<!-- 값이있을때-->
										<c:if test="${notice!= '' || notice ne null}">
												<c:forEach items="${notice}" var="no" varStatus="status"> 
												
													<tr width="100%">	
														<td width="10%">302호</td>
														<td width="40%">학교 끝나고 좀 더 공부 하기 위해</td>
														<td width="10%">20141414080</td>
														<td width="20%">2017-10-15</td>
														<td width="20%">2017-10-16</td>
													</tr>
												
												</c:forEach>
											</c:if>	
												<!-- 반복되는부분 -->							
									
											</tbody>
											
											
										
											<tfoot align="center">
											<!-- 글쓰기 버튼을 누르면 제이쿼리로 정의 해 놓은 이벤트가 발생합니다 -->
												<tr  style="text-align:right;">
													<td colspan="5" class="table_paging" class="fancyBox" > 
														<a class='btn btn-primary btn-lg' data-toggle='modal' data-target='#myModal'>글쓰기</a>
													</td>
												</tr>
												
													<tr>
													<!-- 페이징을 위한 녀석 -->
													
														<td colspan="5" class="table_paging">
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
