package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class BoardModel {
	@RequestMapping("board/chef.do")
	public String main_home(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("msg", "게시판"); 
		request.setAttribute("main_jsp", "../board/board.jsp");
		return "../main/main.jsp";
	}
}
