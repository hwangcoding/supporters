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
						
							<form name="write" method="post" enctype="multipart/form-data" action="/contents/restaurant/view">
								<table width="100%" class="restaurant_list" border="0">
																	
								  <thead>	
								  
										<tr height="50px">
										
											<th colspan="4" align="left" style="text-align: left;">
											
												<!-- <select name="searchFiled" class="search_select_res_write">
														 <option value="0">한식</option>
														 <option value="1">중식</option>
														 <option value="2">패스트푸드</option>
														 <option value="3">카페</option>
														 이거 select 지우고 형이 jstl로 받아오면 됨
												</select> -->
												
												맛집 종류 : 패스트푸드
											
											</th>
										
										</tr>
									
						                <tr align="center" height="50px">
						                    <th align="center" width="10%">가게이름</th>
						                    <th width="40%" align="center">맘스터치</th>
						                    <th align="center" width="15%">작성자</th>
						                    <th align="center" width="35%">홍길동</th>
						                </tr>
						                
						          </thead>
						                
						          <tbody>
						                
						                <tr height="100px" align="center">
						                    <td>주소</td>
						                    <td>인천 서구 송림동 352-1</td>
						                    <td>전화번호</td>
						                    <td colspan="2">032-677-2222</td>
						                    
						                </tr>

						                
						                <tr height="100px" align="center">
						                	<td align="center">위도</td>
						                    <td>32.1254786</td>
						                    <td align="center">경도</td>
						                    <td>68.8563745</td>
						                </tr>
						                
						                <tr height="80px">
						                    <td align="center">배달유무</td>
						                    <td align="center">
						                    
						                    	<!-- <select name="searchFiled" class="search_select_res_write_dele">
														 <option value="0">배달가능</option>
														 <option value="1">배달불가능</option>
												</select>
												이것도 위에 select랑 동일 -->
												배달가능
						                    
						                    </td>
						                    
						                    <td align="center">재능대화의 거리 (미터)</td>
						                    <td align="center">500m</td>
						                </tr>
						               	
						            </tbody>
									<tfoot align="center">  
										<tr style="text-align:center;">
											<td colspan="4" class="table_paging">
												<input type="file" name="file">
												<!-- 이건 없애야 할것 같지만 일단 놔둠 -->
											</td>
										</tr>
									   <tr style="text-align:center;" align="center">
											<td colspan="4" class="table_paging"> 
												<input type="button" class="total_btn" value="수정" style="margin-right:20px;"><input type="button" class="total_btn" value="목록" name="go_list">
												<!-- 현재 작성이 학과 공지로 가니 바꿔줘야함 버튼 두개는 total_btn으로 클래스 바꿔줌 원래 클래스로 하면 그냥 학과공지로감 그래서 바꿧고 여기 클릭 이벤트는 name으로 처리함 -->
											</td>
										</tr>   
									</tfoot>
								</table>
							</form>
							
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>