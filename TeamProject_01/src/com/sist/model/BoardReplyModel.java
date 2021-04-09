package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardReplyDAO;
import com.sist.vo.BoardReplyVO;

@Controller
public class BoardReplyModel {
	  @RequestMapping("boardreply/list.do")
	  public String boardreply_list(HttpServletRequest request,HttpServletResponse response)
	  {
		  String page=request.getParameter("page");
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  List<BoardReplyVO> list=dao.boardReplyListData(curpage);
		  int totalpage=dao.boardReplyTotalPage();
		  
		  request.setAttribute("list", list);
		  request.setAttribute("curpage", curpage);
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("main_jsp", "../boardreply/list.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("boardreply/insert.do")
	  public String boardReply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  request.setAttribute("main_jsp", "../boardreply/insert.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("boardreply/insert_ok.do")
	  public String boardReply_insert_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex){}
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  
		  BoardReplyVO vo=new BoardReplyVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  dao.boardReplyInsert(vo);
		  return "redirect:../boardreply/list.do";
	  }
	  @RequestMapping("boardreply/detail.do")
	  public String boardreply_detail(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  BoardReplyVO vo=dao.boardReplyDetailData(Integer.parseInt(no));
		  boolean bCheck=dao.boardReplyCheck(Integer.parseInt(no));
		  request.setAttribute("bCheck", bCheck);
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../boardreply/detail.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("boardreply/reply.do")
	  public String boardreply_reply(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  // db연동 
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  int group_id=dao.boardReplyGetGroupId(Integer.parseInt(no));
		  request.setAttribute("group_id", group_id);
		  request.setAttribute("no", no);
		  request.setAttribute("main_jsp", "../boardreply/reply.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("boardreply/reply_ok.do")
	  public String boardreply_reply_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex){}
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  String group_id=request.getParameter("group_id");
		  
		  BoardReplyVO vo=new BoardReplyVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  vo.setGroup_id(Integer.parseInt(group_id));
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  dao.boardReplyReplyInsert(vo);
		  return "redirect:../boardreply/list.do";
	  }
	  @RequestMapping("boardreply/update.do")
	  public String boardReply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  BoardReplyVO vo=dao.boardUpPrint(Integer.parseInt(no));
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../boardreply/update.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("boardreply/update_ok.do")
	  public String boardReply_update_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex){}
		  String no=request.getParameter("no");
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  
		  BoardReplyVO vo=new BoardReplyVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  BoardReplyDAO dao=BoardReplyDAO.newInstance();
		  boolean bCheck=dao.boardReplyUpdate(vo);
		  if(bCheck==false)
		  {
			  return "redirect:../boardreply/update.do?no="+no;
		  }
		  return "redirect:../boardreply/list.do";
	  }
}
