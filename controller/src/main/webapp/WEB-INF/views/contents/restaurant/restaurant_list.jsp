<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>컨텐츠관리 > 오늘 뭐먹지 관리</h3></div>
				
				<div style="text-align:right; background:#fff; height:50px; border-top:0px;">
				
					<form method="post" name="delete_frm" action="/contents/restaurant/list?pageseq=1">
		
									<select name="searchFiled" class="search_select"> <!-- 이거 css안먹어서 다시 바꾸밍 -->
											<option value="0">선택</option>
											<option value="1">맛집종류</option>
											<option value="2">이름</option>
									</select>
													
									<!-- 검색 버튼 행위 -->
									<input type="text" name="searchValue"class="search_text">
									<input type="submit" class="search_button" value="검색">
																	
								</form>
				
				</div>
				<!-- 맛집 탭 부분 구현 진행중 http://jsfiddle.net/3n74v/ 여기 참고해서 할수 있도록 -->
				<div id="container">
							
								<ul class="tabs">
													
									<li class="active">전체</li>
									<!-- 맛집 종류별로 반복될 부분 -->
									<li class="">실험용 1</li>
													
								</ul>
						
								<table width="90%" class="restaurant_list" border="0" style="margin: 0px auto;">
								
								<thead align="center">
										<!-- 작성된 글을 담아 디비로 보내 데이터를 가져와 해당 검색에 맞는 데이터를 뿌려준다 -->
										<tr width="100%">
											<th width="5%">글번호</th>
											<th width="8%">맛집종류</th>
											<th width="12%">이름</th>
											<th width="22%">메인이미지</th>
											<th width="23%">주소</th>
											<th width="13%">전화번호</th>
											<th width="10%">배달유무</th>
											<th width="14%">작성일자</th>
										</tr>
										
								</thead>
								
								<tbody align="center">
									
									 <c:if test="${empty rest}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="8">맛집정보가 없습니다.</td>
										</tr>
										</tbody>
										<tfoot align="center">
											
											<tr>
												<td colspan="8" class="table_paging"> </td>
											</tr>
										</tfoot>
										
									</c:if> 
									
									
									<c:forEach items="${rest}" var="st"> 
									<!-- 10월 31일 작업 -->
										<!-- 반복해서 리스트로 값을 받아와 뿌려줘야함 -->
										<tr height="120px">
											<td height="80px">${st.restaurant_seq }</td>
											<td>${st.minor_nm }</td>
											<td><a href="/contents/restaurant/view?seq=${st.restaurant_seq }">${st.restaurant_nm }</a></td>
											<td width="22%" height="120px" style="overflow: hidden;"><img style="width: auto; height: 90px; margin:auto;" src="/img/${st.restaurant_mainimg}"></td>
											<td>${st.restaurant_address }</td>
											<td>${st.restaurant_phone }</td>
											<td><c:if test="${st.restaurant_delivery eq 'Y'}">배달가능</c:if>
												<c:if test="${st.restaurant_delivery eq 'N'}">배달불가능</c:if>
											</td>
											<td>
					
											<c:choose>

										    <c:when test="${st.restaurant_write_datetime < st.restaurant_revise_datetime}">
										        ${st.restaurant_revise_datetime}
										    </c:when>
										
										    <c:otherwise>
										        ${st.restaurant_write_datetime}
										    </c:otherwise>

										</c:choose>
									
									</td> 
									</tr>
									
									 </c:forEach>
									<!-- 반복되는부분 -->
									</tbody>
									
									<tfoot align="center">
										
										<tr align="center">
											<td colspan="8" style="vertical-align: center; padding-top: 20px;" align="center">
												<!-- 추가 및 삭제로 보내기 -->
												<input type="button" name="attend_btn" class="total_btn" value="추가">
											
											</td>
										</tr>
										
										<tr> <!-- 페이징 -->
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
								<%-- </c:if> --%>
								
								</table>
								
								</div>
								
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>