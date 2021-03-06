package com.team404.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("UserService")
	private UserService userservice;
	//주소API승인키
	//devU01TX0FVVEgyMDIwMTIyMzE1MzY1NzExMDU4NzE=
	
	@RequestMapping("/userJoin")
	public String userJoin() {
		
		return "user/userJoin";
	}
	@RequestMapping("/join")
	public String join() {
		
		return "user/join";
	}
	@RequestMapping("/userLogin")
	public String userLogin() {
		
		return "user/userLogin";
	}
	@RequestMapping("/userMypage")
	public String userMypage(HttpSession session, Model model) {
		UserVO vo =(UserVO)session.getAttribute("userVO");
		String userId = vo.getUserId();
		
		//1:N관계 맵핑으로 결과를 처리
		UserVO userInfo = userservice.getInfo(userId);
		model.addAttribute("userInfo",userInfo);
		
		return "user/userMypage";
	}
	//일반컨트롤러에서는 비동기요청 메서드는 ResponeBody를 붙입니다
	//응답요청을 viewResolve로 반환하는것이 아닌, 요청이 들어온 곳으로 Response Header정보를 만들
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		System.out.println(vo.getUserId());
		int result = userservice.idCheck(vo.getUserId());
		
		return result;
	}
	
	@RequestMapping(value="Join", method=RequestMethod.POST)
	public int Join(@RequestBody UserVO vo) {
		System.out.println(vo.toString());
		int result = userservice.Join(vo);
		return result;		
	}
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String Login(UserVO vo, Model model,HttpSession session) {
//		UserVO result = userservice.Login(vo);
//		
//		if(result == null) {
//			model.addAttribute("msg","아이디 없음");
//			return "user/userLogin";
//		}else {
//			session.setAttribute("userVO", result);
//			
//			return "redirect:/";
//		}
//	}
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView Login(UserVO vo, Model model,HttpSession session) {
		
		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
		UserVO result = userservice.Login(vo);
		
		
		ModelAndView mv = new ModelAndView();//뷰와model정보를 동시에 저장
		mv.setViewName("user/userLogin");
		
		if(result != null) {//로그인			
			mv.addObject("login", result);
			
		}else {//로그인 실패
			mv.addObject("msg","아이디 비밀번호를 확인하세요");
		}
		
		return mv;
	}
		
}
