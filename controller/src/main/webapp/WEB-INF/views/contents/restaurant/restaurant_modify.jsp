<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>오늘 뭐먹지 관리 > 오늘 뭐먹지 글 수정</h3></div>
							
							<c:forEach items="${modiview}" var="modiview">
							<form name="frm_modify" method="post" enctype="multipart/form-data"  action="/contents/restaurant/modify/modifyprocess">
								<table width="100%" class="restaurant_list" border="0">
								  <thead>	
										<tr height="40px">
											<td>
											<input type="hidden" name="seq" value="${modiview.restaurant_seq}" readonly="readonly"
											style="background-color:#FFFFFF; border:1px; text-decoration: none; width:50px; height:30px;">
											맛집 종류 :
												<select name="searchFiled" id = "res_filed" class="search_select_res_write">
														 <option value="0" ${modiview.minor_nm eq "한식" ? 'selected="selected"' : '' }>한식</option>
														 <option value="1" ${modiview.minor_nm eq "중식" ? 'selected="selected"' : '' }>중식</option>
														 <option value="2" ${modiview.minor_nm eq "패스트푸드" ? 'selected="selected"' : '' }>패스트푸드</option>
														 <option value="3" ${modiview.minor_nm eq "카페" ? 'selected="selected"' : '' }>카페</option>
												</select>
												<input type="hidden" name="select_ch1" value="${modiview.minor_nm}" readonly = "readonly">
											</td>
										</tr>
						                <tr height="50px">
						                    <th align="center">식당이름</th>
						                    <th colspan="3" align="left"><input type="text" class="res_text_title" name="title" value="${modiview.restaurant_nm}"></th>
						                </tr>
						                
						          </thead>
						                
						          <tbody>
						                
						                <tr height="120px" align="center">
						                    <td width="15%">주소</td>
						                    <td width="40%"><textarea style="resize: none;" name = "res_addr" id = "res_addr" class="res_text_addr">${modiview.restaurant_address}</textarea></td>
						                    <td width="15%">전화번호</td>
						                    <td width="30%"><input type="text"  name = "res_phone" id = "res_phone"  class="res_text" value="${modiview.restaurant_phone }"></td>
						                    
						                </tr>

						                
						                <tr height="120px" align="center">
						                	<td align="center">위도</td>
						                    <td><input type="text" name="latitude" id = "res_latitude"  class="res_text" value="${modiview.restaurant_latitude }"></td>
						                    <td align="center">경도</td>
						                    <td><input type="text" name="lognitode" id = "res_lognitode"  class="res_text" value="${modiview.restaurant_lognitode }"></td>
						                </tr>
						                
						                <tr height="80px">
						                    <td align="center">배달유무</td>
						                    <td align="center">
						                    
						                    	<select name="searchFiled1" class="search_select_res_write_dele">
														 <option value="0" ${modiview.restaurant_delivery eq "Y" ? 'selected="selected"' : '' }>배달가능</option>
														 <option value="1" ${modiview.restaurant_delivery eq "N" ? 'selected="selected"' : '' }>배달불가능</option>
												</select>
						                    
						                    </td>
						                    
						                    <td align="center">재능대화의 거리 (미터)</td>
						                    <td align="center"></td>
						                </tr>
						               	
										<tr style="text-align:center;">
											<td>현재 이미지</td>
											<td colspan="3" style="overflow: hidden;">
												<img style="margin:auto; width: auto; height: 230px;" src="/img/${modiview.restaurant_mainimg}">
											</td>
										</tr>
										
										</tbody>
										
										<tfoot align="center">
										
										<tr style="float: left; margin-top: 20px;">
											<td><input type="file" name="file" id="file_ch"><input type="hidden" name="file_ch_num" id="file_ch_num" value="1"></td>
										</tr>
										
									   <tr style="text-align:center;">
											<td colspan="4" class="table_paging"> 
												<input type="button" name="modify_submit" class="total_btn" value="수정완료" style="margin-right:20px;"><input type="button" class="total_btn" value="목록" name="go_list">
												<!-- 현재 작성이 학과 공지로 가니 바꿔줘야함 버튼 두개는 total_btn으로 클래스 바꿔줌 원래 클래스로 하면 그냥 학과공지로감 그래서 바꿧고 여기 클릭 이벤트는 name으로 처리함 -->
											</td>
										</tr>   
									</tfoot>
								</table>
							</form>
							
							</c:forEach>
								
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>