package com.team404.common.util.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

public class BoardAuthHandler extends HandlerInterceptorAdapter{

	//게시글 변경, 수정, 삭제에 대한 권한처리 핸들러
	//세션값과 writer(작성자) 정보가 같다면, 컨트롤러를 실행, 그렇지 않으면 권한이 없습니다 출력
	//화면에서 변경, 수정, 삭제가 일어날 때, writer값을 넘겨주도록 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		System.out.println("넘어온 작성자 = "+writer);
		System.out.println("세션에 저장된 값 = " + userVO);
		if(userVO != null) {
			if(writer != null) {
				if(userVO.getUserId().equals(writer)) {//세션에 저장된 id와 작성자가 동일할 때
					return true; //컨트롤러 실행
				}
				
			}
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('권한이 없습니다');");
		out.println("history.go(-1);");		
		out.println("</script>");
		
		//response.sendRedirect(request.getContextPath()+"/user/userLogin");
		return false;
	}
	
}
