package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class RecipeModel {
	@RequestMapping("recipe/recipe.do")  
	public String main_home(HttpServletRequest request,HttpServletResponse response)
	{	
		String page=request.getParameter("page");
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		
		ListDAO dao=ListDAO.newInstance();
		DetailDAO dDao=DetailDAO.newInstance();
		int totalpage=dao.listTotalPage();
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		List<ListVO> list=dao.listAllData(curpage);
		List<DetailVO> cList=new ArrayList<DetailVO>();//쿠키담을 그릇
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1; i>=0;i--) {
				if(cookies[i].getName().startsWith("m")) {
					cookies[i].setPath("/");
					String no=cookies[i].getValue();
					DetailVO vo=dDao.detailCookie(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
	
		request.setAttribute("cList", cList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../recipe/recipe.jsp");
		return "../main/main.jsp";
	}
	
	//쿠키
	@RequestMapping("recipe/detail_before.do")
	public String detail_before(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		  Cookie cookie=new Cookie("m"+no, no);
		  cookie.setMaxAge(60*60);
		  cookie.setPath("/");
		  response.addCookie(cookie);
		  return "redirect:../recipe/recipe_detail.do?no="+no;
	}
	
	//상세
	@RequestMapping("recipe/recipe_detail.do")
	public String recipe_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		  DetailDAO dao=DetailDAO.newInstance();
		  DetailVO vo=dao.detailData(Integer.parseInt(no));
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../recipe/recipe_detail.jsp");
		  return "../main/main.jsp";
	}
}
