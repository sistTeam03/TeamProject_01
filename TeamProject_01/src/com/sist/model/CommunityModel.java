package com.sist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Controller
public class CommunityModel {
	@RequestMapping("board/board.do")
	public String boardList(HttpServletRequest request,HttpServletResponse response)
	{
//		response.setCharacterEncoding("UTF-8");
		final int BLOCK = 10;
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		 
		BoardDAO dao = BoardDAO.newInstance();
		List<BoardVO> bList=dao.boardListData(curpage);
		int count=dao.boardCount();
		int totalpage=(int)(Math.ceil(count)/12.0);
		
		int startPage=((curpage-1)/BLOCK*BLOCK);
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage > totalpage)
			endPage = totalpage;
		
		request.setAttribute("count", count);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("bList", bList);
		request.setAttribute("page", page);
		
		
		request.setAttribute("main_jsp", "../board/board.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/board_detail.do")
	public String board_detail(HttpServletRequest request,HttpServletResponse response)
	{
		
		String no = request.getParameter("no");
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO bvo = dao.boardDetailData(Integer.parseInt(no));
		request.setAttribute("bvo", bvo);
		request.setAttribute("main_jsp", "../board/board_detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/board_write.do")
	public String board_write(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String no=request.getParameter("no");
		String content=request.getParameter("content");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		
		String pwd=request.getParameter("pwd");
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO bvo=new BoardVO();
		bvo.setName(name);
		bvo.setContent(content);
		bvo.setSubject(subject);
		bvo.setPwd(pwd);
		dao.boardInsert(bvo);
		request.setAttribute("main_jsp", "../board/board_write.jsp");
		return "../main/main.jsp";
	}
	/*
	 * @RequestMapping("board/board_update.do") public String
	 * boardUpdate(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * try { request.setCharacterEncoding("UTF-8"); }catch(Exception ex) {} String
	 * no = request.getParameter("no"); String
	 * content=request.getParameter("content"); String
	 * subject=request.getParameter("subject");
	 * 
	 * BoardVO vo = new BoardVO(); BoardDAO dao=BoardDAO.newInstance();
	 * dao.boardUpdate(vo);
	 * 
	 * request.setAttribute("main_jsp", "../board/board_update.jsp"); return
	 * "../board/board.jsp"; }
	 */
		
	
}









