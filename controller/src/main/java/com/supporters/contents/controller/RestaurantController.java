package com.supporters.contents.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.contents.domain.RestaurantVO;
import com.supporters.contents.service.RestaurantService;
import com.supporters.domain.CommunityVO;
import com.supporters.function.Convert;


@Controller
@RequestMapping(value="/contents/restaurant/*")
public class RestaurantController {

	
	@Inject
	private RestaurantService restaurantService;
	
	@Inject
	private Convert ct;
	
	
	@RequestMapping(value = "list")
	public String list(
			@RequestParam String pageseq, 
			Model model,
			RestaurantVO paging,
			String searchValue,
			String searchFiled) throws Exception {
		
			/*검색 조건 , 검색어 확인 하는 알고리즘*/
			if(searchValue==null) {searchValue="";}
			if(searchFiled==null) {searchFiled="";}
		/*	switch(searchFiled) {
			case "0": searchFiled="fiction_content"; break;
			case "1":searchFiled="user_num"; break;
			}
			*/
			int seq = Integer.parseInt(pageseq);
			paging.setPageNo(seq);
			paging.setPageSize(10);
			paging.setSearchValue(searchValue);
			paging.setSearchFiled(searchFiled);
			paging.setTotalCount(restaurantService.count(paging));
			
			List<RestaurantVO> list = restaurantService.list(paging);
			
			model.addAttribute("page",paging);
			model.addAttribute("rest", list);
			
		return "contents/restaurant/restaurant_list";

		}
	
	@RequestMapping(value = "write")
	public String write(
			Model model,
			RestaurantVO paging) throws Exception {
		return "contents/restaurant/restaurant_write";

		}
	
	@RequestMapping(value = "write/writeprocess",method={RequestMethod.GET, RequestMethod.POST})
	public String write(MultipartHttpServletRequest request, HttpSession session,
			Model model,
			String searchFiled, // 가게분류
			String title, //가게이름
			String user_id, //작성자
			String res_addr, //가게주소
			String res_phone, //가게번호
			String latitude, // 위도
			String lognitode, // 경도
			String searchFiled1, //배달 유무
/*			String file, //파일이름
*/			RestaurantVO paging) throws Exception {
		/*	vo.setUser_num(usernum);
		departmentService.remove(vo);*/
		switch(searchFiled) {
		case "0": searchFiled="REST01"; break;
		case "1":searchFiled="REST02"; break;
		case "2":searchFiled="REST03"; break;
		case "3":searchFiled="REST04"; break;
		}
		paging.setMinor_cd(searchFiled); // 가게 분류
		paging.setRestaurant_nm(title); //가게 이름
		paging.setRestaurant_address(res_addr); //가게 주소
		paging.setRestaurant_phone(res_phone); //가게 번호
		paging.setRestaurant_latitude(latitude); //가게 위도
		paging.setRestaurant_lognitode(lognitode); //가게 경도
		double je_la1 = Double.parseDouble(latitude);
		double je_lo1 = Double.parseDouble(lognitode);
		double je_la2=37.4755561;  // 재능대 x
		double je_lo2=126.6496396; // 재능대 y
		String dis = Double.toString(ct.distance(je_la1, je_lo1, je_la2, je_lo2)); 
		paging.setRestaurant_displacement(dis);
		switch(searchFiled1) {
		case "0": searchFiled1="Y"; break;
		case "1":searchFiled1="N"; break;
		}
		paging.setRestaurant_delivery(searchFiled1);
		paging.setRestaurant_mainimg(restaurantService.fileUpload(request, session));
		restaurantService.write(paging);
		return "redirect:/contents/restaurant/list?pageseq=1";

		}
	
	@RequestMapping(value = "view")
	public String view(
			String seq,
			Model model,
			RestaurantVO paging) throws Exception {
		try {
			/*게시물의 시퀀스를 가져와 설정 함*/
			paging.setRestaurant_seq(seq);
			/*설정한 시퀀스를 파라미터로 넘겨 줘서 원하는 값을 가져옴*/
	        List<RestaurantVO> view = restaurantService.view(paging);
	        List<RestaurantVO> comment = restaurantService.comment(paging);
	        model.addAttribute("comment",comment);
	        model.addAttribute("page",paging);
			model.addAttribute("view", view);
	        
	    } catch (Exception e) {
	    	System.out.println("파일이없떠요");
	    	System.out.println(e.getMessage());
	    }

		return "/contents/restaurant/restaurant_view";

	}
	
	@RequestMapping(value = "delete")
	public String delete(
			String seq,
			Model model,
			RestaurantVO paging) throws Exception {
		
		try {
			
			/*System.out.print(seq);*/
			paging.setRestaurant_seq(seq);
			restaurantService.delete(paging);

		}catch (Exception e) {
			System.out.println("해당글 없음");
		}
		
		return "redirect:/contents/restaurant/list?pageseq=1";
	}
	
	@RequestMapping(value = "modify")
	public String modify(
			String seq,
			Model model,
			RestaurantVO paging
			) throws Exception{
		
		try {
			
			/*System.out.print(seq);*/
			paging.setRestaurant_seq(seq);
			List<RestaurantVO> modiView = restaurantService.view(paging);
			model.addAttribute("modiview", modiView);

		}catch (Exception e) {
			System.out.println("해당글 없음");
		}

		return "contents/restaurant/restaurant_modify";
	}
	
	@RequestMapping(value = "modify/modifyprocess", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyprocess(
			MultipartHttpServletRequest request, HttpSession session,
			Model model,
			String seq, //seq
			String searchFiled, // 가게분류
			String title, //가게이름
			String user_id, //작성자
			String res_addr, //가게주소
			String res_phone, //가게번호
			String latitude, // 위도
			String lognitode, // 경도
			String searchFiled1, //배달 유무
			String file_ch_num,
			RestaurantVO paging)throws Exception{
		
		switch(searchFiled) {
		case "0": searchFiled="REST01"; break;
		case "1":searchFiled="REST02"; break;
		case "2":searchFiled="REST03"; break;
		case "3":searchFiled="REST04"; break;
		}
		
		paging.setRestaurant_seq(seq); //seq
		paging.setMinor_cd(searchFiled); // 가게 분류
		paging.setRestaurant_nm(title); //가게 이름
		paging.setRestaurant_address(res_addr); //가게 주소
		paging.setRestaurant_phone(res_phone); //가게 번호
		paging.setRestaurant_latitude(latitude); //가게 위도
		paging.setRestaurant_lognitode(lognitode); //가게 경도
		double je_la1 = Double.parseDouble(latitude);
		double je_lo1 = Double.parseDouble(lognitode);
		double je_la2=37.4755561;  // 재능대 x
		double je_lo2=126.6496396; // 재능대 y
		String dis = Double.toString(ct.distance(je_la1, je_lo1, je_la2, je_lo2)); 
		paging.setRestaurant_displacement(dis);
		switch(searchFiled1) {
		case "0": searchFiled1="Y"; break;
		case "1":searchFiled1="N"; break;
		}
		paging.setFile_ch_num(file_ch_num);
		paging.setRestaurant_delivery(searchFiled1);
		paging.setRestaurant_mainimg(restaurantService.fileUpload(request, session));
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		paging.setRestaurant_revise_datetime(mTime);
		
		restaurantService.update(paging);
		
		return "redirect:/contents/restaurant/view?seq="+seq;
	}
	
	
}