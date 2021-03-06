package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.command.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	//주소API승인키
	//devU01TX0FVVEgyMDIwMTIyMzE1MzY1NzExMDU4NzE=
	
	@RequestMapping("/userJoin")
	public String userJoin() {
		
		return "user/userJoin";
	}
	@RequestMapping("/userLogin")
	public String userLogin() {
		
		return "user/userLogin";
	}
	//일반컨트롤러에서는 비동기요청 메서드는 ResponeBody를 붙입니다
	@ResponseBody//응답요청을 viewResolve로 반환하는것이 아닌, 요청이 들어온 곳으로 Response Header정보를 만들
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		
		System.out.println(vo.toString());
		//회원가입 중복체크
		return 1;
	}
	
}
