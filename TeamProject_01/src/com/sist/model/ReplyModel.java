 
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
	
	 @RequestMapping("recipe/recipe_reply_insert.do")
	  public String food_reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 댓글 데이터 받기 
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
		  System.out.println(1);
		  dao.replyInsert(vo, Integer.parseInt(no));
		  System.out.println(1);
		  return "redirect:../recipe/recipe_detail.do?no="+no;
	  }
	 
	  // 댓글 삭제
	  @RequestMapping("recipe/recipe_reply_delete.do")
	  public String food_reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  System.out.println(1);
		  String recipeno=request.getParameter("recipeno");
		  System.out.println(2);
		  ReplyDAO dao=ReplyDAO.newInstance();
		  System.out.println(3);
		  //DB연동 
		  dao.replyDelete(Integer.parseInt(no));
		  System.out.println(4);
		  return "redirect:../recipe/recipe_detail.do?no="+recipeno;
	  }

	  // 댓글 수정 
	  @RequestMapping("recipe/recipe_reply_update.do")
	  public String food_reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String msg=request.getParameter("msg");
		  String no=request.getParameter("no");
		  String recipeno=request.getParameter("recipeno");
		  ReplyVO vo=new ReplyVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setMsg(msg);
		  ReplyDAO dao=ReplyDAO.newInstance();
		  dao.replyUpdate(vo);
		  return "redirect:../recipe/recipe_detail.do?no="+recipeno;
	  }
}