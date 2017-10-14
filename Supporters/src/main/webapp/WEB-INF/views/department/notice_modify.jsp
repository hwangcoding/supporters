<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 학과공지</h3></div>
						

						
							<form name="modify" method="post" enctype="multipart/form-data" action="/department/notice/modifyprocess">
							<c:forEach items="${view}" var="view" varStatus="status">
							<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
							<input type="hidden" value=${ view.community_seq} name="seq">
								<table width="100%"  id="user_list"  border="1">
																	
									<tbody align="center">
									<!-- 반복되는부분 --> 
									
									<tr>
										<td>제목</td>
										<td><input type="text" id="title" name="title"  value=${view. community_title}></input></td>
										<td>날짜</td>
										<td><input type="text" readonly id="writer" name="user_id" value=${view. community_write_datetime}></input></td>
									</tr>
									<tr>
										<td colspan="4">
										<textarea rows="20" cols="100"  title="내용" id="contents" name="contents" value=${ view.community_content }> 
										</textarea></td>
									</tr>
									</c:forEach>
									<!-- 반복되는부분 -->
																				
									</tbody>
									<tfoot align="center">  
										<tr  style="text-align:center;">
											<td colspan="4" class="table_paging" > 
												<button  id="modeify_finish">수정완료</button>
												<button class="write_button" id="list">목록</button>
											</td>
						
									</tfoot>
								
								</table>
							</form>
								
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>
