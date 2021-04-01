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
		// 페이지가 있기 때문에 페이지를 받아야 함
		String page=request.getParameter("page");
		if(page==null)  // 첫 페이지
			page="1";
		int curpage=Integer.parseInt(page);
		ChefsDAO dao=ChefsDAO.newInstance();
		List<ChefsVO> cList=dao.chefsListData(curpage);
		int count=dao.chefsCount();  // 레시피 총 갯수
		int totalpage=(int)(Math.ceil(count/12.0));  // 올림해서 나올거야
				
		// 1~10 씩 페이지 블록 나누기
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
				
		if(endPage>totalpage)
			endPage=totalpage;   // endPage에서 110까지 나오는 것을 방지하기 위함
				
		request.setAttribute("count", count);  // ${count }
		request.setAttribute("cList", cList);
				
		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp","../main/chef.jsp");
		return "../main/main.jsp";
	}
}
