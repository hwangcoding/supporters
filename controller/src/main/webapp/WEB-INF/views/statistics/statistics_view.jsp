<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<jsp:include page="../include/sidebar.jsp" flush="false"/>


		
		<!-- <div id = "content"> -->
		<!-- 컨텐츠 크기 맞추기 -->
		<div id="mid">
			<div class="content_view">
				<div class="content_view_depth"><h3>통계 > 통계보기</h3></div>
				<input type="button" id="week" value="일주일" >
				<input type="button" id="1m" value="1개월">
				<input type="button" id="3m" value="3개월">
				<div id="container" style="min-width: 310px; width:100%;height: 400px; margin: 0 auto"></div>
								
								<table width="100%" class="restaurant_list" border="0" style="margin-top:500px;">
								
								<thead align="center">
										<tr>
											<td colspan="3" align="left" height="90px"><h3>  상세 통계</h3></td>
										</tr>
								
								
										<!-- 작성된 글을 담아 디비로 보내 데이터를 가져와 해당 검색에 맞는 데이터를 뿌려준다 -->
										<tr width="100%">
											<th width="10%">날짜</th>
											<th width="45%">방문자수</th>
											<th width="45%">회원수</th>
										</tr>
								</thead>
								<tbody align="center">
									<c:if test="${empty join}">
										<tr width="100%" >	<!-- db에 따로 시퀀스가 없어 jstl 을 이용 -->
												<td width="10%" colspan="8">통계정보가 없습니다.</td>
										</tr>
										</tbody>
										<tfoot align="center">
											<tr>
												<td colspan="8" class="table_paging"> </td>
											</tr>
										</tfoot>
									</c:if> 
									<c:if test="${join!= '' || join ne null}">
									<!-- 반복되는부분 -->
									<c:forEach items="${join}" var="join"> 
										<!-- 반복해서 리스트로 값을 받아와 뿌려줘야함 -->
										<tr height="50px">
											<td>${ join.date}</td>
											<td>${ join.week_cnt}</td>
											<td>${ join.join}</td>
										</tr>
									</c:forEach>	
									<!-- 반복되는부분 -->											
									</tbody>
									
								</c:if> 
								
								</table>
								
							</div>
						<!-- </div> -->
		
	</div>
<script>

var join= new Array(); //회원수
var datax= new Array(); // 날짜값
var datay= new Array(); // 방문자수
$(document).ready(function() {
	
	function getQuerystring(key, default_)
	{
	  if (default_==null) default_=""; 
	  key = key.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	  var regex = new RegExp("[\\?&]"+key+"=([^&#]*)");
	  var qs = regex.exec(window.location.href);
	  if(qs == null)
	    return default_;
	  else
	    return qs[1];
	}
	var valuUrl = getQuerystring("dateValue");
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
			url : "/statistics/join_week?dateValue="+valuUrl,
			dataType : "json",
			success : function response(data) {
				 $.each(data, function(index, item){
					
					
					 join.push(Number(data[index].count));  //회원수 파싱 
				       
				      })
				      $.ajax({ 
							type : "POST",
							url : "/statistics/visited_week?dateValue="+valuUrl,
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