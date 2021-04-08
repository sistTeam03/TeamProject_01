package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class QnaModel {
	// qna 목록
	@RequestMapping("board/qnaList.do")
	public String qnaListData(HttpServletRequest request,HttpServletResponse response)
	{
		String page = request.getParameter("page");
		if (page == null) // 첫 페이지
			page = "1";
		int curpage = Integer.parseInt(page);
		QnaBoardDAO dao = QnaBoardDAO.newInstance();
		List<QnaBoardVO> list = dao.qnaListData(curpage);
		int count = dao.qnaTotalCount();

		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", count); // ${count }
		request.setAttribute("main_jsp", "../board/qnaList.jsp");
		return "../main/main.jsp";
	}
	// qna 작성
	@RequestMapping("board/qnaInsert.do")
	public String qnaInsert(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../board/qnaInsert.jsp");
		return "../main/main.jsp";
	}
	// qna 글등록
	@RequestMapping("board/qnaInsert_ok.do")
	public String boardReply_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");   // get방식은 tomcat에서 진행하기 때문에 안 받아도 되지만,
												 	 // post 방식은 따로 적어줘야 한글 받을 수 있음
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("sesson_id");
		QnaBoardVO vo=new QnaBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setId(id);
		System.out.println(id);
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		dao.qnaInsert(vo);
		return "redirect:../board/qnaList.do";   // list를 다시 수행하기 위함
	}
	// 상세페이지
	@RequestMapping("board/qnaDetail.do")
	public String boardreply_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		QnaBoardVO vo=dao.qnaDetailData(Integer.parseInt(no));
		boolean bCheck=dao.qnaReplyCheck(Integer.parseInt(no));
		request.setAttribute("bCheck", bCheck);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/qnaDetail.jsp");
		return "../main/main.jsp";
	}
	// 답변
	@RequestMapping("board/qnaReply.do")
	public String boardreply_reply(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		// db연동
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		int group_id=dao.qnaGetGroupId(Integer.parseInt(no));
		request.setAttribute("group_id", group_id);
		request.setAttribute("no", no);
		request.setAttribute("main_jsp", "../board/qnaReply.jsp");
		return "../main/main.jsp"; 
	}
	// 답변등록
	@RequestMapping("board/qnaReply_ok.do")
	public String boardreply_reply_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		String group_id=request.getParameter("group_id");
		
		QnaBoardVO vo=new QnaBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setGroup_id(Integer.parseInt(group_id));
		// db연동
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		dao.qnaReplyInsert(vo);
		return "redirect:../board/qnaList.do";   // 목록 출력
	}
	
}
