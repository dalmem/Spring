package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //해당 어노테이션이 붙어있는 클래스를 bean으로 생성해줍니다
public class MainController {
	
	public MainController() {
		System.out.println("생성됨");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("실행됨");
		//실행시킬 코드를 작성
		//return "/WEB-INF/views/home.jsp"; //디스패쳐서블릿으로 반환
		return "home";
	}
}
