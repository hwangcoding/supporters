<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>컨텐츠관리 > 오늘 뭐먹지 관리</h3></div>
								
								<table width="100%" id="restaurant_list" border="0">
								
								<thead align="center">
										<!-- 작성된 글을 담아 디비로 보내 데이터를 가져와 해당 검색에 맞는 데이터를 뿌려준다 -->
										<tr style="text-align:right; background:#fff; height:50px; border-top:0px;"> 
											<td colspan="8">
												<form method="post" action="/contents/restaurant/restaurant_list">
												
													<select name="searchFiled" class="restaurant_search_select">
														 <option value="0">선택</option>
														 <option value="1">맛집종류</option>
														 <option value="2">이름</option>
													</select>
													
													<!-- 검색 버튼 행위 -->
													<input type="text" name="searchValue"class="search_text">
													<input type="submit" class="search_button" value="검색">
													
												</form>
											</td>
										</tr>
										
										<tr width="100%">
											<th width="5%">선택</th>
											<th width="5%">순번</th>
											<th width="8%">맛집종류</th>
											<th width="12%">이름</th>
											<th width="22%">메인이미지</th>
											<th width="28%">주소</th>
											<th width="13%">전화번호</th>
											<th width="14%">배달유무</th>
										</tr>
										
								</thead>
								
								<tbody align="center">
									
									<%-- <c:if test="${empty student}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="8">회원정보가 없습니다.</td>
										</tr>
										</tbody>
										<tfoot align="center">
											
											<tr>
												<td colspan="8" class="table_paging"> </td>
											</tr>
										</tfoot>
										
									</c:if> --%>
									
									
									<%-- <c:if test="${student!= '' || student ne null}">
									<!-- 반복되는부분 -->
									<c:forEach items="${student}" var="st"> --%>
									
										<!-- 반복해서 리스트로 값을 받아와 뿌려줘야함 -->
										<tr height="120px">
											<td><input type="checkbox" id=""></td>
											<td height="80px">1</td>
											<td>패스트푸드</td>
											<td><a href="/contents/restaurant/view">엄마손길</a></td>
											<td>img_1.jpg</td>
											<td>인천시 서구 송림3동 521-1 현준빌딩 34호</td>
											<td>010-2668-9376</td>
											<td>배달가능</td>
											<%-- <td>ICON<i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td> --%>
										</tr>
									
									<%-- </c:forEach>	 --%>
									<!-- 반복되는부분 -->											
									</tbody>
									
									<tfoot align="center">
										
										<tr>
											<td colspan="7" style="vertical-align: center; padding-top: 30px;">
												<!-- 추가 및 삭제로 보내기 -->
												<input type="button" name="attend_btn" class="total_btn" value="추가" style="margin-right:20px;">
												<input type="button" name="revise_btn" class="total_btn" value="수정">
												<input type="button" name="delete_btn" class="total_btn" value="삭제" style="margin-left:20px;">
											
											</td>
										</tr>
										
										<tr> <!-- 페이징 -->
											<%-- <td colspan="8" class="table_paging">
												<jsp:include page="../include/paging.jsp" flush="true">
												    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
												    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
												    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
												    <jsp:param name="pageNo" value="${paging.pageNo}" />
												    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
												    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
												    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
												</jsp:include>
											</td> --%>
										</tr>
										
									</tfoot>
								<%-- </c:if> --%>
								
								</table>
								
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>