<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 커뮤니티 글 확인</h3></div>
						
								<table width="100%"  id="user_list"  border="1">
								<c:forEach items="${view}" var="view" varStatus="status">
									<!-- 히든으로 게시물의 고유 번호를 숨겨 놨다가 수정하거나 삭제 할 때 값을 넘겨줌 -->
									<input type="hidden" value=${ view.community_seq} id="community_seq" name="seq">
									<tbody align="center">
									<!-- 반복되는부분 --> 
									
									<tr>
										<td width="10%" colspan="1">작성자</td>
										<td  width="20%" colspan="2">${view. community_user_id}</td>
										<td colspan="1" >작성일</td>  
										<td width="10%" colspan="2">${view. community_write_datetime }</td>
									</tr> 
									<tr >
										<td>내용</td>
										<td colspan="5" height="400px" style="vertical-align: top; padding:5px; text-align:left;">
										${ view.community_content }</td>
									</tr>
									
									<tr>
										<td>이미지</td>
										<td colspan="5"  class="img_sort" width="33%" style=" text-align:left; ">
										<c:if test="${view.community_img1!= '' && view.community_img1 ne null}">
										<img src="/resources/img/${ view.community_img1 }" style="width:300px;height:300px;">
										</c:if>
										<c:if test="${view.community_img2!= '' && view.community_img2 ne null}">
										<img src="/resources/img/${ view.community_img2 }" style="width:300px;height:300px;">
										</c:if>
										<c:if test="${view.community_img3!= '' && view.community_img3 ne null}">
										<img src="/resources/img/${ view.community_img3 }" style="width:300px;height:300px;">
										</c:if>
										<c:if test="${view.community_img4!= '' && view.community_img4 ne null}">
										<img src="/resources/img/${ view.community_img4 }" style="width:300px;height:300px;">
										</c:if>
										<c:if test="${view.community_img5!= '' && view.community_img5 ne null}">
										<img src="/resources/img/${ view.community_img5 }" style="width:300px;height:300px;">
										</c:if>
										</td>
									</tr>
									
									<!-- 반복되는부분 --> 
																				
									</tbody>
									<tfoot align="center">  
										<tr  style="text-align:center;">
											<td colspan="7" class="table_paging" > 
												<input type="button"  id="community_list_btn" value="목록">
												<input type="button"  id="community_list_delete_btn" value="삭제">
						 
									</tfoot>
								
								</table>
								
								</c:forEach>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>
