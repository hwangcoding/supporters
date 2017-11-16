<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<title>재능마당 관리자페이지</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <style>
		@media screen and (max-width: 478px) {
		    h1 { font-size: 70px; padding: 1px; }
		    h2 { font-size: 13px; padding: 1px; }
		    body { font-size: 13px; }
		    		    img {
		    max-width: 100%;
		    height: 30%;
		    width: 30%; /* ie8 */
		}
		}
		 
		@media screen and (max-width: 740px) {
		    .left-col { width: 100%; }
		    .sidebar { width: 100%; }
		    img {
		    max-width: 100%;
		    height: 30%;
		    width: 30%; /* ie8 */
		}
		}
		 
		
		
		</style>
	
</head>
<body >
		
		
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
						
							<form name="fr_write" id="fr_write" method="post" enctype="multipart/form-data" action="/department/notice/modify" >
								<table width="100%"  id="user_list"  border="0">
								<c:forEach items="${view}" var="view" varStatus="status">
									<tbody align="left">
									<!-- 반복되는부분 --> 
									
									<tr> 
										<td width="15%"><h2>제목 :</h2></td> 
										<td align="left" style="padding-left:5%;"width="40%" ><h2>${view.department_notice_title}</h2></td>
									</tr> 
									<tr >
										<td colspan="7" height="400px" style="text-align:left;">${ view.department_notice_content }</td>
									</tr>
									</c:forEach>
									<!-- 반복되는부분 --> 
																				
									</tbody>
								
								</table>
								
								</form>
							</div>
						<!-- </div> -->
		
		
	</div>

</body>
</html>
