package com.team404.controller;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//메인화면 가져갈 데이터가 있다면, Model에 담아서 처리
		
		return "home";
	}
	
	@RequestMapping("/aaa")
	public String aaa() {
		return "aaa";
	}
	
	@RequestMapping("/test/bbb")
	public String bbb() {
		return "test/bbb";
	}
	
}
