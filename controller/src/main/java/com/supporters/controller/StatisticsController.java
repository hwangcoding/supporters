package com.supporters.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supporters.domain.StatisticsVO;
import com.supporters.function.DateCalculator;
import com.supporters.service.StatisticsService;


@Controller
@RequestMapping(value="/statistics/*")
public class StatisticsController {

	
	
	
	@Inject
	private StatisticsService statisticsService;
	
	
	/*function에 만들어 놓은 데이터 클래스
	 * 통계 부분에서 사용*/
	DateCalculator dc;
	
	/*일주일치 회원수*/
	@RequestMapping(value = "join_week")		
	public String join_week( 
			Model model,
			String dateValue,
			StatisticsVO statisticVO ) throws Exception {
		if(dateValue==null) {dateValue="week";}
		switch(dateValue) {
		case "week": statisticVO.setDate(dc.getDateAgo(-6)); break;
		case "one":statisticVO.setDate(dc.getDateAgo(-29));break;
		case "three":statisticVO.setDate(dc.getDateAgo(-87));break;
		default:statisticVO.setDate(dc.getDateAgo(-6));break;
		}
		List<StatisticsVO> join_week= statisticsService.join_week(statisticVO);  //일주일 가입자 수
		System.out.println("내가날린값!!"+statisticVO.getDate());
		List<StatisticsVO> visited_week = statisticsService.visited_week(statisticVO); //일주일 방문자 수
		System.out.println("내가날린값!!"+statisticVO.getDate());
		
		
		
		JSONObject jsonResponse; /* Json 선언 부분 */
		JSONArray jsonRows = new JSONArray();
		
		// 통계 부분  , 날짜 별 회원의 데이터가 없으면 0 을 찍도록 하는 알고리즘
	    for (StatisticsVO str : visited_week) {
			jsonResponse = new JSONObject();
			// 회원수에 날짜 값이 있는지 판단
			boolean fa = true;
			for (StatisticsVO str2 : join_week) {
				if(str.getDate().equals(str2.getDate())) {
					jsonResponse.put("count", str2.getWeek_cnt());// 카운트 값
					fa=false;
				}
			}
			jsonResponse.put("date", str.getDate()); // 날짜 값
			if(fa!=false) {
				jsonResponse.put("count", "0");// 카운트 값
			}
			jsonRows.put(jsonResponse);
		}
		


		model.addAttribute("join",jsonRows);
		
		return "/statistics/join_week";
	}
	
	/*일주일치 방문자수*/
	@RequestMapping(value = "visited_week")			
	public String visited_week(
			Model model,
			String dateValue,
			StatisticsVO statisticVO) throws Exception {
		if(dateValue==null) {dateValue="week";}
		switch(dateValue) {
		case "week": statisticVO.setDate(dc.getDateAgo(-6)); break;
		case "one":statisticVO.setDate(dc.getDateAgo(-29));break;
		case "three":statisticVO.setDate(dc.getDateAgo(-87));break;
		default:statisticVO.setDate(dc.getDateAgo(-6));break;
		}
		List<StatisticsVO> visited_week = statisticsService.visited_week(statisticVO); //일주일 방문자 수
		
		JSONObject jsonResponse; /* Json 선언 부분 */
		JSONArray jsonRows = new JSONArray();
		for (StatisticsVO str : visited_week) {
			jsonResponse = new JSONObject();
			jsonResponse.put("date", str.getDate()); // 날짜 값
			jsonResponse.put("count", str.getWeek_cnt());// 카운트 값
			jsonRows.put(jsonResponse);
		}
		


		model.addAttribute("visited",jsonRows);
		return "/statistics/visited_week";
	}
	
	
	
	@RequestMapping(value = "view")
	public String view(
			String dateValue,
			Model model,StatisticsVO statisticVO
	
			) throws Exception {
		if(dateValue==null) {dateValue="6";}
		if(dateValue==null) {dateValue="week";}
		switch(dateValue) {
		case "week": statisticVO.setDate(dc.getDateAgo(-6)); break;
		case "one":statisticVO.setDate(dc.getDateAgo(-29));break;
		case "three":statisticVO.setDate(dc.getDateAgo(-87));break;
		default:statisticVO.setDate(dc.getDateAgo(-6));break;
		}
		
		List<StatisticsVO> join_week= statisticsService.join_week(statisticVO);  //일주일 가입자 수
		
		List<StatisticsVO> visited_week = statisticsService.visited_week(statisticVO); //일주일 방문자 수
		
		
		
		int b= 0; // join_week 인덱스 값 돌면서 확인
		// 통계 부분  , 날짜 별 회원의 데이터가 없으면 0 을 찍도록 하는 알고리즘
	    for (StatisticsVO str : visited_week) {
	    	int a= 0; // join_week 인덱스 값 돌면서 확인
	    	
			boolean fa = true;
			for (StatisticsVO str2 : join_week) {
				
				if(str.getDate().equals(str2.getDate())) {
					visited_week.get(b).setJoin(str2.getWeek_cnt());// 카운트 값
					fa=false;
				}
				a++;
			}
			if(fa==true) {
				visited_week.get(b).setJoin("0");// 카운트 값
			}
			b++;
		}
		model.addAttribute("join",visited_week);
		
		return "statistics/statistics_view";

		}
	
	@RequestMapping(value="qna")
	public String qna_select(Model model) {
		try {
			String a = Integer.toString(statisticsService.qna_select());
			model.addAttribute("qna",a);
			return "statistics/qna_select";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("qna","0");
			return "statistics/qna_select";
		}
	}
	
	
	
}
