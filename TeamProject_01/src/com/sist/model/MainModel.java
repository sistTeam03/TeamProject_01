package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_home(HttpServletRequest request,HttpServletResponse response)
	{
		ListDAO dao=ListDAO.newInstance();
		List<ListVO> list=dao.recipeListData();
	
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("main/search.do")
	public String main_search(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		String msg=request.getParameter("msg");
		msg=msg.trim();
		StringTokenizer st=new StringTokenizer(msg," ");
		List<String> list=new ArrayList<String>();
		while(st.hasMoreTokens()) {
			String str=st.nextToken();
			str=str.trim();
			list.add(str);
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("main_jsp", "../main/search.jsp");
		return "../main/main.jsp";
	}
}
