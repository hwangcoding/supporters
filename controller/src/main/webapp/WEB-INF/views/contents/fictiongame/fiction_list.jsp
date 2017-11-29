<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>컨텐츠관리 > 끝말잇기 관리</h3></div>
						
							<center>
								<table width="100%"  id="user_list"  border="0">
									<thead align="center">
										<tr style="text-align:right; background:#fff; height:50px; border-top:0px; ">
											<td colspan="5">
											<form method="post" action="/contents/fictiongame/fiction_list?pageseq=1">
											<select  name="searchFiled" class="search_select">
												 <option value="0">내용</option>
												 <option value="1">작성자</option>
												</select>
												<input type="text" name="searchValue"class="search_text">
												<input type="submit" class="search_button" value="검색">
												</form>
											</td>
										</tr>
										<tr width="100%">
											<th width="10%">번호</th>
											<th width="50%">내용</th>
											<th width="15%">작성자</th>
											<th width="15%">작성일</th>
											<th width="10%">삭제</th>
										</tr>									
									</thead>
									
									<tbody align="center">
										<!-- 반복되는부분 -->
										<!-- jstl을 이용하여 forEach 로 값이 있는 동안 계속 반복 됨. -->
										
										<!-- 값이없을때 -->
									<c:if test="${empty fiction}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="5">게시물이 없습니다.</td>
										</tr>
										
									</c:if>
										
										<!-- 값이있을때-->
										<c:if test="${fiction!= '' || notice ne null}">
												<c:forEach items="${fiction}" var="fi" varStatus="status"> 
												
													<tr width="100%">	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
														<td width="10%">${fi.fiction_seq}</td>
														<td width="50%">${fi.fiction_content}</td>
														<td width="15%">${fi.user_num }</td>
														<td width="15%">${fi.fiction_write_datetime}</td>
														<td width="10%"><i class="material-icons" id="drop_button_fic" style="cursor:pointer;" name="${fi.fiction_seq }">close</i></td>
													</tr>
												
												</c:forEach>
											</c:if>	
												<!-- 반복되는부분 -->							
									
											</tbody>
											
											
										
											<tfoot align="center">
											<!-- 글쓰기 버튼을 누르면 제이쿼리로 정의 해 놓은 이벤트가 발생합니다 -->
												
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
								<center>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>
