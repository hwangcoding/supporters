<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > 알림 관리</h3></div>
												
												
												<div id= "alert_write" >
												<form method="post" action="/management/alert/writeprocess" name="frm_alert">
													<table width="100%" height="200px" border="0" style="border:groove">
														<tr>
															<td width="10%" style="font-size:18px; text-align:center;">내용</td>
															<td width="80%"><input type="text" name="msg" style="width:100%;height:60%; "></td>
														</tr>
														
														<tr>
															<td colspan="2" align="center">
																<input type="button" class="alert_write_btn1" value="작성">
															</td>
														</tr>
													</table>
													</form>
												</div>
												
												<h3 style="margin-top: 60px;">알림 기록</h3>
												
												<div style="float: right; margin-bottom: 10px;">
												
													<form method="post" action="/management/alert/write?pageseq=1">
													
													<select name="searchFiled" style="width: 65px;" class="search_select">
														 <option value="0">제목</option>
														</select>
														<input type="text" name="searchValue" class="search_text">
														<input type="submit" class="total_btn" style="width: 60px; height: 30px;" value="검색">
														
													</form>
													
												</div>
								<table class="alert_tbl" width="100%" border="0">
								
								<thead>
			
									<tr align="center">
									
										<th>알람번호</th>
										<th>알람구분</th>
										<th>알람내용</th>
										<th>알람날짜</th>
									
									</tr>
									
								</thead>
								
								<tbody>
									<c:forEach items="${log }" var="log">
										<tr align="center">
										
											<td>${log.alert_seq }</td>
											<td>
											
												<c:choose>
												
													<c:when test="${log.minor_cd eq 'ALET01' }">일반 알람</c:when>
													
													<c:otherwise>학과공지 알림</c:otherwise>
												
												</c:choose>
											
											</td>
											<td>${log.alert_content }</td>
											<td>${log.alert_write_datetime }</td>
										
										</tr>
										
									</c:forEach>
								</tbody>
								
								<tfoot>
								
									<tr>
														<!-- 페이징을 위한 녀석 -->
														
															<td colspan="4" class="table_paging">
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
