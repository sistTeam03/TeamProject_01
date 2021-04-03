package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

@Controller
public class MemberModel {
	@RequestMapping("member/join.do")//회원가입 페이지 전송
	public String signPage(HttpServletRequest request,HttpServletResponse response) {
		
		
		request.setAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("member/idCheck_result.do")//회원 중복체크
	public String idCheck(HttpServletRequest request,HttpServletResponse response) {
			String id=request.getParameter("id");
			MemberDAO dao=MemberDAO.newInstance();
			int count=dao.idCheck(id);
			request.setAttribute("count", count);
			
		return "../member/idCheck_result.jsp";
	}
	@RequestMapping("member/join_ok.do") //회원가입 완료
	public String Signup(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {}
		//값받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nick");
		String email=request.getParameter("email");
		String birth=request.getParameter("birth");
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String phone1=request.getParameter("phone1");
		String phone2=request.getParameter("phone2");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		MemberDAO dao=MemberDAO.newInstance();
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNickname(nickname);
		vo.setName(name);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setTel(tel1+"-"+tel2);
		vo.setPhone(phone1+"-"+phone2);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		dao.insertMember(vo);
		
		
		return "redirect: ../main/main.do";
	}
	@RequestMapping("member/post_result.do")//주소 출력
	public String loginPage(HttpServletRequest request,HttpServletResponse response) {
		String dong=request.getParameter("dong");
		MemberDAO dao=MemberDAO.newInstance();
		List<ZipcodeVO> list=dao.joinAddress(dong);
		
		request.setAttribute("list", list);
		return "../member/fost_find.jsp";
	}
}
