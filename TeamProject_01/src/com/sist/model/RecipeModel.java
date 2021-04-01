package com.sist.model;

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
		int totalpage=dao.listTotalPage();
		int block=10;
		int startPage=(curpage-1/block*block)+1;
		int endPage=(curpage-1/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		List<ListVO> list=dao.listAllData(curpage);
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../recipe/recipe.jsp");
		return "../main/main.jsp";
	}
	
}
