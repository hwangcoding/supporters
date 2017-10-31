<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div class="modal fade" id="light_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		
		<div id="mid_complain" style="border:1px solid #000000;">
		
			<div class="complain_write_view" style="margin-top:150px; width:39%; margin-left: auto; margin-right: auto; margin-bottom: auto;">

							<form name="write" method="post" enctype="multipart/form-data" action="#">
								<table width="50%;" class="complain_write" border="0" style="margin:auto;">
																	
								  <thead>
									  <tr>
									  
									  	<th colspan="4" align="center">문의하기</th>
									  
									  </tr>
								 		
						                <tr align="center" height="50px">
						                    <th align="center">문의 제목</th>
						                    <th><input type="text" class="res_text" name="title"></input></th>
						                    <th align="center">작성자</th>
						                    <th align="center"><input type="text" readonly class="res_text" name="user_id" value="${ADMIN_ID}"></input></th>
						                </tr>
						                
						          </thead>
						                
						          <tbody>
						                <tr>
						                    <td colspan="4" height="500px" style="background-color:#F8F8F8;"><textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:756px; height:500px; resize: none;"></textarea></td>
						                </tr>
						          </tbody>
								  <tfoot align="center">  
										<tr style="text-align:center;">
											<td colspan="4" class="table_paging">
												<input type="file" name="file">
											</td>
										</tr>
									   <tr style="text-align:center;">
											<td colspan="4" class="table_paging"> 
												<input type="button" class="total_btn" value="보내기" style="margin-right:20px;">
											</td>
										</tr>   
								  </tfoot>
								</table>
							</form>
								
							</div>
						<!-- </div> -->
		
	</div>
	</div>

