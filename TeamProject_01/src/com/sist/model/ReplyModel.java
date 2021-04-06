 
package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import java.util.*;
import com.sist.vo.*;

@Controller
public class ReplyModel {
	
	@RequestMapping("recipe/recipe_reply_print.do")
	public String recipe_reply_print(HttpServletRequest request,HttpServletResponse response) {
		ReplyDAO dao=ReplyDAO.newInstance();
		String no=request.getParameter("no");
		 String rcurpage=request.getParameter("page");
		 if(rcurpage==null|rcurpage=="null") {
			 rcurpage="1";
		 }
		int curpage=Integer.parseInt(rcurpage);
		int totalpage=dao.replyTotalPage(Integer.parseInt(no));
		HttpSession session=request.getSession();
		String id=(String)request.getAttribute("id");
		String nickname=(String)request.getAttribute("nickname");
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		  List<ReplyVO> rList=dao.replyReadData(Integer.parseInt(no), curpage);
		  request.setAttribute("rList", rList);
		  request.setAttribute("startPage", startPage);
		  request.setAttribute("endPage", endPage);
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("curpage", curpage);
		  request.setAttribute("recipeno", Integer.parseInt(no));
		return "../recipe/recipe_reply.jsp";
	}
	 @RequestMapping("recipe/recipe_reply_insert.do")
	  public String food_reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 댓글 데이터 등록 
		  try
		  {
			  request.setCharacterEncoding("UTF-8");	  
		  }catch(Exception ex) {}
		  String no=request.getParameter("no");
		  String msg=request.getParameter("msg");
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("sesson_id");
		  String name=(String)session.getAttribute("name");
		  ReplyVO vo=new ReplyVO();
		  vo.setNickname(name);
		  vo.setMsg(msg);
		  vo.setId(id);
		  vo.setRecipeno(Integer.parseInt(no));
		  //DAO연결 
		  ReplyDAO dao=ReplyDAO.newInstance();
		  dao.replyInsert(vo, Integer.parseInt(no));
		  return "redirect:../recipe/recipe_reply_print.do?no="+no;
	  }
	 
	  // 댓글 삭제
	  @RequestMapping("recipe/recipe_reply_delete.do")
	  public String food_reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("replyno");
		 String page=request.getParameter("page");
		  ReplyDAO dao=ReplyDAO.newInstance();
		  //DB연동 
		  dao.replyDelete(Integer.parseInt(no));
		  no=request.getParameter("no");//레시피번호
		  return "redirect:../recipe/recipe_reply_print.do?no="+no+"&?page="+page;
	  }

	  // 댓글 수정 
	  @RequestMapping("recipe/recipe_reply_update.do")
	  public String food_reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  System.out.println(1);
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String msg=request.getParameter("msg");
		  String no=request.getParameter("replyno");
		  String page=request.getParameter("page");
		  
		  
		  ReplyVO vo=new ReplyVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setMsg(msg);
		  ReplyDAO dao=ReplyDAO.newInstance();
		  dao.replyUpdate(vo);
		  no=request.getParameter("no");
		  System.out.println(no);
		  return "redirect:../recipe/recipe_reply_print.do?no="+no+"&?page="+page;
	  }
	  @RequestMapping("recipe/recipe_update_show.do")
	  public String recipe_upate_show(HttpServletRequest request,HttpServletResponse response) {
		  String no=request.getParameter("replyno");
		  
		  ReplyDAO dao=ReplyDAO.newInstance();
		  String msg=dao.detailReplyShow(Integer.parseInt(no));
		 System.out.println(msg);
		  request.setAttribute("msg", msg);
		  return "../recipe/recipe_update_show.jsp";
	  }
}