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
		request.setAttribute("msg", "레시피");
		request.setAttribute("main_jsp", "../recipe/recipe.jsp");
		return "../main/main.jsp";
	}
}
