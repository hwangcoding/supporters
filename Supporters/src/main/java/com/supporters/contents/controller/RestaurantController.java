package com.supporters.contents.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supporters.contents.domain.FictionGameVO;

@Controller
@RequestMapping(value="/contents/restaurant/*")
public class RestaurantController {

	@RequestMapping(value = "restaurant_list")		
	public String fictionGame(
			Model model,
			FictionGameVO paging) throws Exception {
		
		
		return "contents/restaurant/restaurant_list";

		}
		
	
	
	
}
