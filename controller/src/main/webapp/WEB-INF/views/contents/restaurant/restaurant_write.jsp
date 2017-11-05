<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>오늘 뭐먹지 관리 > 오늘 뭐먹지 작성</h3></div>
								
							<form name="frm_write" method="post" enctype="multipart/form-data"  action="/contents/restaurant/write/writeprocess">
								<table width="100%" class="restaurant_list" border="0">
								  <thead>	
										<tr height="40px">
											<td>
											맛집 종류 : 
												<select name="searchFiled" id = "res_filed" class="search_select_res_write">
														 <option value="0">한식</option>
														 <option value="1">중식</option>
														 <option value="2">패스트푸드</option>
														 <option value="3">카페</option>
												</select>
											</td>
										</tr>
						                <tr height="50px">
						                    <th align="center">식당이름</th>
						                    <th colspan="3" align="left"><input type="text" class="res_text_title" name="title"></th>
						                </tr>
						                
						          </thead>
						                
						          <tbody>
						                
						                <tr height="120px" align="center">
						                    <td>주소</td>
						                    <td><textarea style="resize: none;" name = "res_addr" id = "res_addr" class="res_text_addr"></textarea></td>
						                    <td>전화번호</td>
						                    <td ><input type="text"  name = "res_phone" id = "res_phone"  class="res_text"></td>
						                    
						                </tr>

						                
						                <tr height="120px" align="center">
						                	<td align="center">위도</td>
						                    <td><input type="text" name="latitude" id = "res_latitude"  class="res_text"></td>
						                    <td align="center">경도</td>
						                    <td><input type="text" name="lognitode" id = "res_lognitode"  class="res_text"></td>
						                </tr>
						                
						                <tr height="80px">
						                    <td align="center">배달유무</td>
						                    <td align="center">
						                    
						                    	<select name="searchFiled1" class="search_select_res_write_dele">
														 <option value="0">배달가능</option>
														 <option value="1">배달불가능</option>
												</select>
						                    
						                    </td>
						                    
						                    <td align="center">재능대화의 거리 (미터)</td>
						                    <td align="center"></td>
						                </tr>
						               	
						            </tbody>
									<tfoot align="center">  
										<tr style="text-align:center;">
											<td colspan="4" class="table_paging">
												<input type="file" name="file" id="file_ch"> <!-- 10월 31일 작업 (아이디 추가) -->
											</td>
										</tr>
									   <tr style="text-align:center;">
											<td colspan="4" class="table_paging"> 
												<input type="button" name="write_submit" class="total_btn" value="작성" style="margin-right:20px;"><input type="button" class="total_btn" value="목록" name="go_list">
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