<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>오늘 뭐먹지 관리 > 오늘 뭐먹지 글 확인</h3></div>
						
							<form id="frm_modify" name="frm_delete" method="post" enctype="multipart/form-data" action="/contents/restaurant/delete">
								<table width="100%" class="restaurant_list" border="0">
								
								<c:forEach items="${view}" var="view" varStatus="status">
												
								  <thead>
								  
										<tr height="50px">
											<th align="center" style="text-align: center;">글 번호 : <input type="text" name="seq" value="${view.restaurant_seq}" readonly style="background-color:#F8F8F8; border:0px; width:70px; height:30px;"></th>
											<th colspan="4" align="left" style="text-align: left;">
											
												<!-- <select name="searchFiled" class="search_select_res_write">
														 <option value="0">한식</option>
														 <option value="1">중식</option>
														 <option value="2">패스트푸드</option>
														 <option value="3">카페</option>
														 이거 select 지우고 형이 jstl로 받아오면 됨
												</select> -->
												
												맛집 종류 : ${view.minor_nm}
											
											</th>
										
										</tr>
									
						                <tr align="center" height="50px">
						                    <th align="center" width="15%">가게이름</th>
						                    <th width="40%" align="center">${view.restaurant_nm}</th>
						                    <th align="center" width="15%">작성자</th>
						                    <th align="center" width="30%">관리자</th>
						                </tr>
						                
						          </thead>
						                
						          <tbody>
						                
						                <tr height="100px" align="center">
						                    <td>주소</td>
						                    <td>${view.restaurant_address}</td>
						                    <td>전화번호</td>
						                    <td colspan="2">${view.restaurant_phone}</td>
						                    
						                </tr>

						                
						                <tr height="100px" align="center">
						                	<td align="center">위도</td>
						                    <td>${view.restaurant_latitude}</td>
						                    <td align="center">경도</td>
						                    <td>${view.restaurant_lognitode}</td>
						                </tr>
						                
						                <tr height="80px">
						                    <td align="center">배달유무</td>
						                    <td align="center">
						                    
						                    	<!-- <select name="searchFiled" class="search_select_res_write_dele">
														 <option value="0">배달가능</option>
														 <option value="1">배달불가능</option>
												</select>
												이것도 위에 select랑 동일 -->
												
												<c:choose>

												    <c:when test="${view.restaurant_delivery eq 'Y'}">
												        배달가능
												    </c:when>
												
												    <c:when test="${view.restaurant_delivery eq 'N'}">
												        배달 불가능
												    </c:when>

												</c:choose>
												
						                    </td>
						                    
						                    <td align="center">재능대화의 거리 (미터)</td>
						                    <td align="center">${view.restaurant_displacement}</td>
						                </tr>
						                
						                <tr height="250px">
						                	<!-- 이쪽 작업해야함 -->
						                	<td align="center">메인 이미지</td>
						                	<td align="center" colspan="3" style="overflow: hidden;">
						                	<img style="margin:auto; width: auto; height: 230px;" src="/img/${view.restaurant_mainimg}"></td>
						                
						                </tr>
						               	
						            </tbody>
						            
						            </c:forEach>
						            
									<tfoot align="center">  
										<!-- <tr style="text-align:center;">
											<td colspan="4" class="table_paging">
												<input type="file" name="file">
												이건 없애야 할것 같지만 일단 놔둠
											</td>
										</tr> -->
									   <tr style="text-align:center;" align="center">
											<td colspan="4" class="table_paging">
												<input type="button" class="total_btn" name="modify_btn" value="수정" style="margin-right:20px;">
												<input type="button" name="delete_btn" id="delete_btn" class="total_btn" value="삭제">
												<input type="button" class="total_btn" value="목록" name="go_list" style="margin-left:20px;">
												<!-- 현재 작성이 학과 공지로 가니 바꿔줘야함 버튼 두개는 total_btn으로 클래스 바꿔줌 원래 클래스로 하면 그냥 학과공지로감 그래서 바꿧고 여기 클릭 이벤트는 name으로 처리함 -->
											</td>
										</tr>
										
										<table class="restaurant_comment_list" width="100%" class="restaurant_list" border="0" style="margin: auto; margin-top: 20px;">
										
										<thead>
										
											<tr>
											
												<td>리뷰</td>
												
											</tr>
											
											<tr align="center">
											
												<th width="30%">작성자</th>
												<th colspan="2" width="40%">내용</th>
												<th width="30%">작성날짜</th>
											
											</tr>
										
										</thead>
										
										<tbody>
										
										<c:choose>
											
											<c:when test="${empty comment}">
												    
												<tr>
													<td colspan="4" align="center">리뷰가 없습니다</td>
												</tr>
												        
											</c:when>
												
											<c:otherwise>
												    
											<c:forEach items="${comment}" var="comment" varStatus="status">
												    
												<tr align="center">

											
													<td>${comment.user_num }</td>
													<td colspan="2">${comment.review_content }</td>
														<td>
															
														<c:choose>
					
															<c:when test="${comment.restaurant_write_datetime < comment.restaurant_revise_datetime}">
															
																 ${comment.restaurant_revise_datetime}
																 
															</c:when>
																
															<c:otherwise>
															
																  ${comment.restaurant_write_datetime}
																  
															</c:otherwise>
					
														</c:choose>
															
														</td>
															
													</tr>
														
														</c:forEach>
														
											</c:otherwise>

										</c:choose>

										
										
										</tbody>
										<%-- <tr> <!-- 페이징 -->
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
										</tr> --%>
										
										</table>
										
									</tfoot>
								</table>
							</form>
							
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>