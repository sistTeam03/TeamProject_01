package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class ChefsModel {
	@RequestMapping("main/chef.do")
	public String main_home(HttpServletRequest request, HttpServletResponse response) {
		//String chef_name=request.getParameter("chef");
		// 페이지가 있기 때문에 페이지를 받아야 함
		String page = request.getParameter("page");
		if (page == null) // 첫 페이지
			page = "1";
		int curpage = Integer.parseInt(page);
		ChefsDAO dao = ChefsDAO.newInstance();
		List<ChefsVO> cList = dao.chefsListData(curpage);
		int count = dao.chefsCount(); // 레시피 총 갯수
		int totalpage = (int) (Math.ceil(count / 12.0)); // 올림해서 나올거야

		// 1~10 씩 페이지 블록 나누기
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalpage)
			endPage = totalpage; // endPage에서 110까지 나오는 것을 방지하기 위함

		request.setAttribute("count", count); // ${count }
		request.setAttribute("cList", cList);

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../main/chef.jsp");
		
		return "../main/main.jsp";
		//return "redirect:../recipe/chefs_recipe.do?no="+chef;
	}
	// 각 쉐프의 레시피
	@RequestMapping("recipe/chefs_recipe.do")
	public String chefsRecipeList(HttpServletRequest request,HttpServletResponse response) 
	{ 
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		String page=request.getParameter("page");
		String name=request.getParameter("name");
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		name=name.trim();
		System.out.println(name);
		ChefsDAO dao=ChefsDAO.newInstance();
		int totalpage=dao.chefListTotalPage(name);
		System.out.println(name);
		System.out.println(curpage);
		List<ListVO> list=dao.shefListData(name, curpage);
		// no,poster,title,chef,hit
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("list", list); 
	    request.setAttribute("name", name);
	   
	    return "../recipe/chefs_recipe.jsp";
	}
}
