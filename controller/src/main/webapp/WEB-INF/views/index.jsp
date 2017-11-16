<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>

<jsp:include page="include/sidebar.jsp" flush="false"/>
	
		
		    		<div id="mid">
		<!-- 컨텐츠 크기 맞추기 -->
				<div class="content_view">
					<div class="content_view_depth"><h3>메인화면</h3></div>
					
							<table width="100%"  id="user_list" border="0" >
									
									<tbody align="center">
									<!-- 반복되는부분 -->
										<tr>
											<td style="background-color:#ffac3f; height:150px; width:8%;">
											<i class="material-icons"  style="padding-left:10%; font-size:80px; float:left;   z-index:10;">account_box</i>
											</td>
											
											<td style="background-color:#ffac3f; width:28%;">
												<span style="font-size:16px; float:left; line-height:0px; font-weight:500;">총 회원수 :
												<font style="font-size:21px; line-height:0px; font-weight:500;">${all_join}</font></span>
												<br>
												<br>
												<span style="font-size:16px; float:left; line-height:0px; font-weight:500;">신규 회원수 :
												<font style="font-size:21px; line-height:0px; font-weight:500;">${day_join}</font></span>
											</td>
											
											<td style="background-color:#FDDA16; height:150px; width:8%;">
												<i class="material-icons" style=" padding-left:10%; font-size:80px; float:left; z-index:10;">touch_app</i>
											</td>
											
											<td style="background-color:#FDDA16; width:28%;">
												<span style="font-size:16px; float:left; line-height:0px; font-weight:500;">총 방문자수 :
												<font style="font-size:21px; line-height:0px; font-weight:500;">${all_visited}</font></span>
												<br>
												<br>
												<span style="font-size:16px; float:left; line-height:0px; font-weight:500;">금일 방문자수 : 
												<font style="font-size:21px; line-height:0px; font-weight:500;">${day_visited}</font></span>
											</td>
											
											<td style="background-color:#FFEE82; height:150px; width:8%;">
												<i class="material-icons" style=" padding-left:20%; font-size:62px;float:left;z-index:10;">border_color</i>
											</td>
	
											<td style="background-color:#FFEE82; width:28%;">
												<span style="font-size:16px; float:left; line-height:0px; font-weight:500;">신규 게시글 : 
												<font style="font-size:21px; line-height:0px; font-weight:500;">9</font></span>
												<br>
												<br>
											</td>

											
										</tr>
										   <tr >
										   <td colspan="6"></td>
										</tr> 
										<tr >
											<td colspan="6" style="margin-top:50px;">	
											<div id="container" style="min-width: 310px; width:100%;height: 400px; margin: 0 auto"></div>
											</td>
										</tr> 
									<!-- 반복되는부분 -->											
									</tbody>
									<tfoot align="center">
									</tfoot>
								</table>
					
				</div>
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

 

		  