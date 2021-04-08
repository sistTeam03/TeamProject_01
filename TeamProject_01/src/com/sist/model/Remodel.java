package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.RecommendDAO;
import com.sist.vo.ListVO;
import com.sist.vo.RecomVO;


@Controller
public class Remodel {
	@RequestMapping("recom/recomlist.do")
	public String recomList(HttpServletRequest request, HttpServletResponse response) {
		
		RecommendDAO dao=RecommendDAO.newInstance();
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("sesson_id");
		String nickname=(String)session.getAttribute("nickname");
		String no=request.getParameter("no");
		
		List<ListVO> list=dao.userRandomList();
		int result=dao.recomInsertData(no, id);
		if(result==1) {//추천이 끝나면
			request.setAttribute("main_jsp", "../recommed/recommedOk.jsp");
			return "../main/main.jsp";
		}
		request.setAttribute("id", id);
		request.setAttribute("name", nickname);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../recommed/recommed.jsp");
		return "../main/main.jsp";
	}
}
/*
 * @RequestMapping("recom/recomlist_before.do") public String
 * recomList_before(HttpServletRequest request, HttpServletResponse response) {
 * HttpSession session=request.getSession(); String
 * id=(String)session.getAttribute("id"); String no=request.getParameter("no");
 * RecomVO vo=new RecomVO();
 * 
 * List<RecomVO> list=new ArrayList<RecomVO>();
 * 
 * return "redirect: ../recom/recomlist.do"; } 
 */