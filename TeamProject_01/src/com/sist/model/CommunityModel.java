package com.sist.model;
import java.io.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList; 
import java.util.List;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;
import com.sist.vo.NoticeVO;
import com.sist.vo.EventBoardVO;
import com.sist.dao.EventBoardDAO;
import com.sist.vo.NoticeVO;
import java.net.URLEncoder;import java.net.http.HttpRequest;
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
		
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
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
		request.setAttribute("main_jsp", "../board/board_write.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/board_write_ok.do")
	public String board_write_ok(HttpServletRequest request,HttpServletResponse response)
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
//		request.setAttribute("main_jsp", "../board/board_write.jsp");
		return "redirect:../board/board.do";
	}
	
	@RequestMapping("board/board_update.do")
	public String board_update(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance(); 
				
		BoardVO bvo = dao.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("bvo", bvo);
		request.setAttribute("main_jsp", "../board/board_update.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/board_update_ok.do")
	public String board_update_ok(HttpServletRequest request, HttpServletResponse response)
	{
		
		try
		{
			request.setCharacterEncoding("UTF-8");
			
		}catch(Exception ex) {}
		String no = request.getParameter("no");
		int bno=Integer.parseInt("no");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String pwd=request.getParameter("pwd");
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO bvo=dao.boardUpdateData(bno);
		bvo.setName(name);
		bvo.setSubject(subject);
		bvo.setContent(content);
		bvo.setNo(bno);
		
		request.setAttribute("bvo", bvo);
		request.setAttribute("main_jsp", "../board/board_update.jsp");
		return "redirect:../board/board.do";
	}
	
	@RequestMapping("board/board_delete.do")
	public String board_delete(HttpServletRequest request, HttpServletResponse response)
	{
		
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		request.setAttribute("no", no);
		request.setAttribute("main_jsp", "../board/board_delete.jsp");
		BoardDAO dao = BoardDAO.newInstance();
		dao.boardDelete(Integer.parseInt(no), pwd);
		return "../board/board_delete.jsp";
	}
	
	@RequestMapping("board/eventboard.do")
	public String eventboard_list(HttpServletRequest request,HttpServletResponse response)
	{
		
		 String page=request.getParameter("page");
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  
		  EventBoardDAO dao=EventBoardDAO.newInstance();
		  List<EventBoardVO> list = dao.eventBoardList(curpage);
		  int totalpage=dao.eboardTotalPage();
		  
		  request.setAttribute("list", list);
		  request.setAttribute("curpage", curpage);
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("main_jsp", "../board/eventboard.jsp");
		return "../main/main.jsp";
	}
	
	
	
	
	
	@RequestMapping("board/event_detail.do")
	public String event_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		EventBoardDAO dao=EventBoardDAO.newInstance();
		
		EventBoardVO vo=dao.eventDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/event_detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/event_insert.do")
	public String eboard_insert(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../board/event_insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/event_insert_ok.do")
	public String event_insert_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			
			  request.setCharacterEncoding("UTF-8");
			  String path="C:\\WebDev\\WebStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamProject_01\\";
			  int size=1024*1024*100;
			  String enctype="UTF-8";
			  //<%= application.getRealPath("/") %>
			  MultipartRequest mr=new MultipartRequest(request, path,size,enctype,
					    new DefaultFileRenamePolicy());

			  
			  
			  String name=mr.getParameter("name");
			  String subject=mr.getParameter("subject");
			  String content=mr.getParameter("content");
			  String pwd=mr.getParameter("pwd");
			 
			  EventBoardVO vo = new EventBoardVO();
			  vo.setName(name);
			  vo.setSubject(subject);
			  vo.setContent(content);
			  vo.setPwd(pwd);
			  
			  String filename=mr.getOriginalFileName("upload");
			  if(filename==null)
			  {
				  vo.setFilename("");
				  vo.setFilesize(0);
			  }
			  else
			  {
				  File file=new File(path+filename);
				  vo.setFilename(filename);
				  vo.setFilesize((int)file.length());
				  
			  }
			  
			  EventBoardDAO dao = EventBoardDAO.newInstance();
			  dao.eventInsertData(vo);
				
		}catch(Exception ex) {}
		return "redirect:../board/eventboard.do";
		
		
	}
	
	@RequestMapping("board/download.do")
	public String eboard_download(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			String fn=request.getParameter("fn");
			File file=new File("C:\\WebDev\\WebStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamProject_01\\"+fn);
					response.setContentLength((int)file.length());
			  response.setHeader("Content-Disposition", "attachment;filename="
			                      +URLEncoder.encode(fn, "UTF-8"));
			  BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			  BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			  int i=0;
			  byte[] buffer=new byte[1024];
			  while((i=bis.read(buffer, 0, 1024))!=-1)
			  {
				  bos.write(buffer, 0, i);
			  }
			  bis.close();
			  bos.close();
		}catch(Exception ex) {}
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("board/notice.do")
	public String notice_board(HttpServletRequest request,HttpServletResponse response)
	{
		
		String page = request.getParameter("page");
		if(page==null)
			page="1";
		int curpage= Integer.parseInt(page);
		BoardDAO dao = BoardDAO.newInstance();
		List<NoticeVO> nList=dao.noticeListData(curpage);
		
		
		
		request.setAttribute("nList", nList);
		request.setAttribute("main_jsp", "../board/notice.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/notice_write.do")
	public String notice_write(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		
		request.setAttribute("main_jsp", "../board/notice_write.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/notice_write_ok.do")
	public String notice_write_ok(HttpServletRequest request, HttpServletResponse reponse)
	{
		
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String no = request.getParameter("no");
		String content=request.getParameter("content");
		String subject=request.getParameter("subject");
		String nfile=request.getParameter("nfile");
		
		BoardDAO dao=BoardDAO.newInstance();
		NoticeVO vo = new NoticeVO();
		
		
		vo.setContent(content);
		vo.setSubject(subject);
		vo.setNfile(nfile);
		dao.notice_insert(vo);
		
		request.setAttribute("main_jsp", "../board/notice_write.jsp");
		return "redirect:../board/notice.do";
	}
	@RequestMapping("board/notice_detail.do")
	public String notice_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no = request.getParameter("no");
		BoardDAO dao=BoardDAO.newInstance();
		NoticeVO vo = dao.noticeDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/notice_detail.jsp");
		return "../main/main.jsp";
	}
}









