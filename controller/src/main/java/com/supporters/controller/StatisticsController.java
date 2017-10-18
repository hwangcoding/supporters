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
			StatisticsVO statisticVO ) throws Exception {
		statisticVO.setDate(dc.getDateAgo(-6));
		List<StatisticsVO> join_week= statisticsService.join_week(statisticVO);  //일주일 가입자 수
		List<StatisticsVO> visited_week = statisticsService.visited_week(statisticVO); //일주일 방문자 수
		
		JSONObject jsonResponse; /* Json 선언 부분 */
		JSONArray jsonRows = new JSONArray();
		for (StatisticsVO str : join_week) {
			jsonResponse = new JSONObject();
			jsonResponse.put("date", str.getDate()); // 날짜 값
			jsonResponse.put("count", str.getWeek_cnt());// 카운트 값
			jsonRows.put(jsonResponse);
		}
		


		model.addAttribute("join",jsonRows);
		return "/statistics/join_week";
	}
	
	/*일주일치 방문자수*/
	@RequestMapping(value = "visited_week")			
	public String visited_week(
			Model model,
			StatisticsVO statisticVO) throws Exception {
		statisticVO.setDate(dc.getDateAgo(-6));
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
	
}
