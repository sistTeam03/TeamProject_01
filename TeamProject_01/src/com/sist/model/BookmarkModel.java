 
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
public class BookmarkModel {
	// 찜하기 
	  @RequestMapping("recipe/bookmark.do")
	  public String recipe_bookmark(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");//레시피번호
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("sesson_id");
		  
		  BookmarkDAO dao=BookmarkDAO.newInstance();
		  // 저장 
		  dao.bookmarkInsert(Integer.parseInt(no), id);
		  return "redirect:../recipe/recipe_detail.do?no="+no;
	  }
	  //찜하기 삭제
	//마이페이지에서 삭제 
		@RequestMapping("mypage/bookmarkDelete.do")
		public String bookmark_delete(HttpServletRequest request, HttpServletResponse response)
		{
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("sesson_id");
			int no=Integer.parseInt(request.getParameter("no"));
			BookmarkDAO dao=BookmarkDAO.newInstance();
			dao.bookmarkDelete(no,id);
			return "redirect:../mypage/mypage.do";
		}
	  
}
