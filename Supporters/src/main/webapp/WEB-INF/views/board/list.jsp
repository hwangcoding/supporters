<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<table>
	<tr>
		<th>이름</th>
		<th>이메일</th>
	</tr>

	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.username}</td>
			<td>${vo.email}
		</tr>
	</c:forEach>

</table>