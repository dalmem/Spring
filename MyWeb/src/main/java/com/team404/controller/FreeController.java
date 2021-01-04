package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.lookup.BeanFactoryDataSourceLookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.common.util.PageVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeController {
	
	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {

		//1. 기본방식
//		ArrayList<FreeBoardVO> list = freeBoardService.getList();
//		model.addAttribute("list",list);
		
		//페이지 방식
		
		
//		int total = freeBoardService.getTotal();
//		PageVO pageVO = new PageVO(cri, total);		
//		ArrayList<FreeBoardVO> list =  freeBoardService.getList(cri);
//		
//		//화면에 전달할 값들
//		model.addAttribute("list",list);
//		model.addAttribute("pageVO",pageVO);
		
		//3. 검색과 페이지
		System.out.println(cri.toString());
		
		ArrayList<FreeBoardVO> list =  freeBoardService.getList(cri);
		System.out.println(list.toString());
		int total = freeBoardService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);		
		//화면에 전달할 값들
		model.addAttribute("list",list);
		model.addAttribute("pageVO",pageVO);
		
		
		return "freeBoard/freeList";
	}
	
	
	//글 등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	//글등록
	@RequestMapping(value = "/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		freeBoardService.regist(vo); //insert실행
		RA.addFlashAttribute("msg","게시글이 등록 되었습니다");
		return "redirect:/freeBoard/freeList";
	}
	//상세
//	@RequestMapping(value="/freeDetail",method=RequestMethod.GET)
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//
//		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("list",vo);
//		return "freeBoard/freeDetail";
//	}
	@RequestMapping(value={"/freeModify", "/freeDetail"}, method=RequestMethod.GET)
	public void freeModify(@RequestParam("bno") int bno , Model model) {
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo",vo);
		
	}
	@RequestMapping(value="/freeUpdate", method=RequestMethod.POST)
	public String freeUpdate(FreeBoardVO vo ,RedirectAttributes RA ) {
		
		int result = freeBoardService.update(vo);
		if(result==1) {
			RA.addFlashAttribute("msg","수정 성공");
		}else {
			RA.addFlashAttribute("msg","수정 실패");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	@RequestMapping(value="/freeDelete", method=RequestMethod.POST)
	public String freeDelete(@RequestParam("bno") int bno,RedirectAttributes RA) {
		
		
		int result = freeBoardService.delete(bno);
		if(result==1) {
			RA.addFlashAttribute("msg","삭제 성공");
		}else {
			RA.addFlashAttribute("msg","삭제 실패");
		}
		return "redirect:/freeBoard/freeList";
	}
}
