package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	//quiz1, quiz2, quiz3 화면을 동시에 처리
	//반환유형 void형으로 맞추고 맵핑값을 배열로 전달하면
	
	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
	public void views() {}
	
	
	//문제1 생략..
	//문제2 생략..
		
	//문제3폼처리
	@RequestMapping("/join2")
	public String join2(@RequestParam(value = "id", required = false, defaultValue="") String id,
						@RequestParam(value = "pw") String pw, 
						@RequestParam(value = "pw_check") String pw_check,
						RedirectAttributes RA,
						Model model
						) {
		
		if(id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check) ) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else { //정상적으로 처리된 경우
			
			model.addAttribute("id", id); //다음 화면으로 id를 넘긴다.
			return "quiz/quiz03_ok";
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
