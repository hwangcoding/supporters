<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>오늘 뭐먹지 관리 > 오늘 뭐먹지 작성</h3></div>
								
							<form name="write" method="post" enctype="multipart/form-data" action="/department/notice/writeprocess" >
								<table width="100%"  id="write_table"  border="0">
																	
									<tbody>
						                <tr>
						                    <td align="center">제목</td>
						                    <td><input type="text" id="title" name="title"></input></td>
						                    <td align="center">작성자</td>
						                    <td><input type="text" readonly id="writer" name="user_id" value="${ADMIN_ID}"></input></td>
						                </tr>
						                <tr>
						                    <td colspan="4" class="view_text">
						                        <textarea rows="20" cols="100"  title="내용" id="contents" name="contents" style="border: 1px solid #F8F8F8;"></textarea>
						                    </td>
						                </tr>
						            </tbody>
									<tfoot align="center">  
										<tr  style="text-align:center;">
											<td colspan="4" class="table_paging" > 
												<input type="file" name="file">
											</td>
										</tr>
									   <tr  style="text-align:center;">
											<td colspan="4" class="table_paging" > 
												<button class="write_process">작성</button><button class="write_button">목록</button>
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