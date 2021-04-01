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
	
}
