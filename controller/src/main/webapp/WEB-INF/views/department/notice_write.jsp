<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>학과관리 > 학과공지 작성</h3></div>
						
								<form action="/department/notice/writeprocess" method="post" id="frm">
									<table width="100%"  id="write_table"  border="0">
																	
									<tbody>
						                <tr height="50px" class="titletop">
						                    <td align="center" width="10%">제목</td>
						                    <td width="60%"><input type="text" id="title" name="title"></input></td>
						                    <td width="10%" align="center">작성자</td>
						                    <td width="20%"><input type="text" readonly id="writer" name="user_id" value="${ADMIN_ID}"></input></td>
						                </tr>
						                <tr>
						                    <td colspan="4" class="view_text">
						                       <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:500px;">

   											 </textarea>
						                    </td>
						                </tr>
						            </tbody>
									<tfoot align="center">  
									   <tr style="text-align:center;">
											<td colspan="4" class="table_paging" > 
												<input type="button"  id="savebutton" value="작성"><input type= "button" class="notice_list_btn" value="목록">
											</td>
										</tr>     
									</tfoot>
								</table>
								</form>
					</div>
						<!-- </div> -->

		
		
	</div>
<script src="/js/smart.js"></script>

</body>
</html>
