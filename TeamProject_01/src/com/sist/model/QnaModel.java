package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class QnaModel {
	// qna 목록
	@RequestMapping("board/qnaList.do")
	public String qnaListData(HttpServletRequest request,HttpServletResponse response)
	{
		String page = request.getParameter("page");
		if (page == null) // 첫 페이지
			page = "1";
		int curpage = Integer.parseInt(page);
		QnaBoardDAO dao = QnaBoardDAO.newInstance();
		List<QnaboardVO> list = dao.qnaListData(curpage);
		int count = dao.qnaTotalCount();

		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", count); // ${count }
		request.setAttribute("main_jsp", "../board/qnaList.jsp");
		return "../main/main.jsp";
	}
	// qna 작성
	@RequestMapping("board/qnaInsert.do")
	public String qnaInsert(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../board/qnaInsert.jsp");
		return "../main/main.jsp";
	}
	// qna 글등록
	
	
}
