<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" flush="false"/>

<jsp:include page="../../include/sidebar.jsp" flush="false"/>
		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>관리 > FAQ</h3></div>
												
												
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
												
												
												
												
											
										
							</div>
						<!-- </div> -->
		
	</div>

</body>
</html>
