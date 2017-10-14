<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<span class="paging_span">
    <a href="#" onclick="goPage(${page.firstPageNo})" class="first"> <i class="material-icons">first_page</i> </a>
    <a href="#" onclick="goPage(${page.prevPageNo})" class="prev"><i class="material-icons">chevron_left</i></a>
    <span class="paging_num">
        <c:forEach var="i" begin="${page.startPageNo}" end="${page.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq page.pageNo}"><a href="#" onclick="goPage(${i})" class="choice">${i}</a></c:when>
                <c:otherwise><a href="#" onclick="goPage(${i})">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
    <a href="#" onclick="goPage(${page.nextPageNo})" class="next"><i class="material-icons">chevron_right</i></a>
    <a href="#"onclick="goPage(${page.finalPageNo})" class="last"><i class="material-icons">last_page</i></a>
</span> 