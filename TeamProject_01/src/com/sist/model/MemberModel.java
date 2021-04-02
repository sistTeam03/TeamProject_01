package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MemberModel {
	@RequestMapping("member/join.do")//회원가입 페이지 전송
	public String signPage(HttpServletRequest request,HttpServletResponse response) {
		
		
		request.setAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("member/주소.do")//회원 중복체크
	public String idCheck(HttpServletRequest request,HttpServletResponse response) {
		
			
		return "../member/주소";
	}
	@RequestMapping("member/주소.do") //회원가입 완료
	public String Signup(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {}
		//값받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		return "redirect: ../main/main.do";
	}
	
}
