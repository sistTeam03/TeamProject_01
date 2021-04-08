package com.sist.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
		
		count=count-((10*curpage)-10);
		String msg="삭제한 게시물 입니다";
        
		request.setAttribute("msg", msg);
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
	public String qnaInsert_ok(HttpServletRequest request,HttpServletResponse response)
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
	public String qnaDetail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		QnaBoardVO vo=dao.qnaDetailData(Integer.parseInt(no),1);  // type=1
		//boolean bCheck=dao.qnaReplyCheck(Integer.parseInt(no));
		//request.setAttribute("bCheck", bCheck);
		request.setAttribute("no", no);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("main_jsp", "../board/qnaDetail.jsp");
		return "../main/main.jsp";
	}
	// 수정
		@RequestMapping("board/qnaUpdate.do")
		public String boardreply_update(HttpServletRequest request,HttpServletResponse response)
		{
			String no=request.getParameter("no");
			String page=request.getParameter("page");
			QnaBoardDAO dao=QnaBoardDAO.newInstance();
			QnaBoardVO vo=dao.qnaDetailData(Integer.parseInt(no),2);  // type=2 수정
			request.setAttribute("vo", vo);
			request.setAttribute("page", page);
			request.setAttribute("main_jsp","../board/qnaUpdate.jsp");
			return "../main/main.jsp";
		}
		
		// 수정 등록
		@RequestMapping("board/qnaUpdate_ok.do")
		public String qnaUpdate_ok(HttpServletRequest request,HttpServletResponse response) throws IOException
		{
			try
			{
				request.setCharacterEncoding("UTF-8");   // get방식은 tomcat에서 진행하기 때문에 안 받아도 되지만,
													 	 // post 방식은 따로 적어줘야 한글 받을 수 있음
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			// 값 받기
			String name=request.getParameter("name");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			String pwd=request.getParameter("pwd");
			
			String no=request.getParameter("no");
			String page=request.getParameter("page");
			
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("sesson_id");
			// DAO 전송
			QnaBoardVO vo=new QnaBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			vo.setId(id);
			vo.setNo(Integer.parseInt(no));
			// DAO 연결
			QnaBoardDAO dao=QnaBoardDAO.newInstance();
			boolean bCheck=dao.qnaUpdate(vo);
			
			if(bCheck==true)
			{
				response.sendRedirect("qnaDetailData.jsp?no="+no+"&page="+page);
			}
			else
			{
				System.out.println("비밀번호가 틀립니다");
			}
//			request.setAttribute("main_jsp", "board/qnaList.jsp");
			return "redirect:../board/qnaList.do";   // list를 다시 수행하기 위함
		}
	// 답변
	@RequestMapping("board/qnaReply.do")
	public String qnaGetGroupId(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		// db연동
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		int group_id=dao.boardReplyGetGroupId(Integer.parseInt(no));
		request.setAttribute("group_id", group_id);
		request.setAttribute("no", no);
		request.setAttribute("page", page);
		request.setAttribute("main_jsp", "../board/qnaReply.jsp");
		return "../main/main.jsp"; 
	}
	// 답변등록
	@RequestMapping("board/qnaReply_ok.do")
	public String qnaReplyInsert_ok(HttpServletRequest request,HttpServletResponse response)
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
//		String group_id=request.getParameter("group_id");
		String pno=request.getParameter("pno");  // 상위
		String page=request.getParameter("page");
		
		QnaBoardVO vo=new QnaBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
//		vo.setGroup_id(Integer.parseInt(group_id));
		// db연동
		QnaBoardDAO dao=QnaBoardDAO.newInstance();
		// 처리
		dao.qnaReplyInsert(Integer.parseInt(pno), vo);
		return "redirect:../board/qnaList.do";   // 목록 출력
	}
	
	// 삭제
	@RequestMapping("board/qnaDelete_ok")
	public String qnaDelete_ok(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		// 1. 사용자가 요청한 값을 받는다
		String pwd=request.getParameter("pwd");
		String no=request.getParameter("no");
		//String page=request.getParameter("page");
		// 2. 오라클 연결(DAO)
		QnaBoardDAO dao=new QnaBoardDAO();
		boolean bCheck=dao.qnaDelete(Integer.parseInt(no), pwd);
		// 3. 이동
		if(bCheck==true){
			request.setAttribute("main_jsp", "board/qnaList.jsp");
		}
		else {
			System.out.println("비밀번호가 틀립니다");
		}
		return "redirect:../board/qnaList.do";   // list를 다시 수행하기 위함
	}
}
