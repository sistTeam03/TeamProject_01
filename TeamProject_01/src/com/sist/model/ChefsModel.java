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
	public String main_home(HttpServletRequest request,HttpServletResponse response)
	{
		String id=request.getParameter("id");
		ChefsDAO dao=ChefsDAO.newInstance();
		List<ChefsVO> list=dao.chefsListData(Integer.parseInt(id));
		for(ChefsVO vo:list)
		{
			String chef_img=vo.getChef_img();
			vo.setChef_img(chef_img);
		}
		request.setAttribute("msg", "쉐프");
		request.setAttribute("main_jsp", "../main/chef.jsp");
		return "../main/main.jsp";
	}
}
