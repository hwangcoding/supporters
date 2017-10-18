<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>회원 관리</h3></div>
								
								<table width="100%"  id="user_list" >
									<thead align="center">
										<tr  style="text-align:right; background:#fff; height:50px; border-top:0px; "> 
											<td colspan="8">
											<form method="post" action="/student/list?pageseq=1">
												<select name="searchFiled" class="search_select">
													 <option value="0">학번</option>
													 <option value="1">이름</option>
													 <option value="2">상태</option>
												</select>
												<input type="text" name="searchValue"class="search_text">
												<input type="submit" class="search_button" value="검색">
											</form>
											</td>
										</tr>
										<tr width="100%">
											<th width="17%">학번</th>
											<th width="10%">이름</th>
											<th width="5%">성별</th>
											<th width="12%">생년월일</th>
											<th width="15%">핸드폰</th>
											<th width="10%">상태</th>
											<th width="26%">이메일</th>
											<th width="5%">탈퇴</th>
										</tr>									
									</thead>
									
									<tbody align="center">
									
									<c:if test="${empty student}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="8">회원정보가 없습니다.</td>
										</tr>
										</tbody>
										<tfoot align="center">
											
											<tr>
												<td colspan="8" class="table_paging"> </td>
											</tr>
										</tfoot>
										
									</c:if>
									
									
									<c:if test="${student!= '' || student ne null}">
									<!-- 반복되는부분 -->
									<c:forEach items="${student}" var="st">
									
										<tr width="100%">
											<td width="17%">${st.user_num }</td>
											<td width="10%">${st.user_nm }</td>
											<td width="5%">${st.user_gender}</td>
											<td width="12%">${st.user_birth }</td>
											<td width="15%">${st.user_phone }</td>
											<td width="10%">${st.user_atten }</td>
											<td width="26%">${st.user_email }</td>
											<td width="5%"><i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td>
										</tr>
									
									</c:forEach>	
									<!-- 반복되는부분 -->											
									</tbody>
									<tfoot align="center">
										
										<tr>
											<td colspan="8" class="table_paging">
												<jsp:include page="../include/paging.jsp" flush="true">
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
								</c:if>
								</table>
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>
