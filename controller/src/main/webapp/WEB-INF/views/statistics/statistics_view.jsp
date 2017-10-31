<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>


		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>통계보기</h3></div>
				
				<div id="container" style="min-width: 310px; width:100%;height: 400px; margin: 0 auto"></div>
								
								<table width="100%" class="restaurant_list" border="0" style="margin-top: 60px;">
								
								<thead align="center">
										<!-- 작성된 글을 담아 디비로 보내 데이터를 가져와 해당 검색에 맞는 데이터를 뿌려준다 -->
										<tr width="100%">
											<th width="10%">날짜</th>
											<th width="45%">방문자수</th>
											<th width="45%">조회수</th>
										</tr>
										
								</thead>
								
								<tbody align="center">
									
									<%-- <c:if test="${empty student}">
										
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="8">회원정보가 없습니다.</td>
										</tr>
										</tbody>
										<tfoot align="center">
											
											<tr>
												<td colspan="8" class="table_paging"> </td>
											</tr>
										</tfoot>
										
									</c:if> --%>
									
									
									<%-- <c:if test="${student!= '' || student ne null}">
									<!-- 반복되는부분 -->
									<c:forEach items="${student}" var="st"> --%>
									
										<!-- 반복해서 리스트로 값을 받아와 뿌려줘야함 -->
										<tr height="50px">
											<td>2017-10-14</td>
											<td>3</td>
											<td>4</td>
											<%-- <td>ICON<i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td> --%>
										</tr>
										<tr height="50px">
											<td>2017-10-15</td>
											<td>2</td>
											<td>3</td>
											<%-- <td>ICON<i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td> --%>
										</tr>
										<tr height="50px">
											<td>2017-10-16</td>
											<td>1</td>
											<td>1</td>
											<%-- <td>ICON<i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td> --%>
										</tr>
										<tr height="50px">
											<td>2017-10-17</td>
											<td>2</td>
											<td>1</td>
											<%-- <td>ICON<i class="material-icons" id="drop_button" style="cursor:pointer;" name="${st.user_num }">close</i></td> --%>
										</tr>
									
									<%-- </c:forEach>	 --%>
									<!-- 반복되는부분 -->											
									</tbody>
									
								<%-- </c:if> --%>
								
								</table>
								
							</div>
						<!-- </div> -->
		
	</div>
<script>

var join= new Array(); //회원수
var datax= new Array(); // 날짜값
var datay= new Array(); // 방문자수
$(document).ready(function() {
	
			// define the options
			options = {
			chart: {
			renderTo: 'container',
			defaultSeriesType: 'line'
			},
			exporting: {
			enabled : false
			},
			title: {
			text: "재능마당 통계자료"
			}, 
			subtitle: {
			text: '회원 , 방문 , 게시글'
			, align : 'left' 
			},
			xAxis: {
			categories: datax  //날짜 값 7일치
			},
			yAxis: {
			title: {
			text: '명수'
			}
			},
			plotOptions: {
			series: {
			dataLabels: {
			enabled: false
			}}
			},
			tooltip: {
	            valueSuffix: '명'
	        },
	        legend: {  //범례
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	
			series: [{
			name: '금일 회원수' ,
			data: join
			}, {
			name: '금일 방문자수',
			data: datay
			}]  
			}
			$.ajax({
			type : "POST",
			url : "/statistics/join_week",
			dataType : "json",
			success : function response(data) {
				 $.each(data, function(index, item){
				
					 join.push(Number(data[index].count));  //회원수 파싱 
				       
				      })
				      $.ajax({
							type : "POST",
							url : "/statistics/visited_week",
							dataType : "json",
							success : function response(data) {
								 $.each(data, function(index, item){
								       datax.push(data[index].date); //날짜값 파싱
								       datay.push(Number(data[index].count)); //가입수 파싱
								      })
								      chart = new Highcharts.Chart(options); //차트생성
							} 
						
						
							}); 
				      
			} 
			}); 
		
		
		});

		</script>
</body>
</html>