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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.supporters.contents.domain.FictionGameVO;
import com.supporters.contents.service.FictionGameService;
import com.supporters.domain.StatisticsVO;
import com.supporters.function.DateCalculator;
import com.supporters.service.StatisticsService;


@Controller
@RequestMapping(value="/sub_menu/*")
public class ComplainController {
	
	/*@RequestMapping(value = "complain/write")
	public String list(
			Model model,
			FictionGameVO paging) throws Exception {
		
		return "sub_menu/complain/complain_write";

		}*/

}
