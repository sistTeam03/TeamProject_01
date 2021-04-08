package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//추가시작
				HttpSession session=request.getSession();
				//테스트를 위한 로그인 처리
				//session.setAttribute("name", "홍길동");
				//session.setAttribute("sesson_id", "hong");
				String id=(String)session.getAttribute("sesson_id");
				List<ListVO> ingreRecipe=new ArrayList<ListVO>();
				if(id==null) {//로그인 X -> 랜덤? 아니면 밑에 레시피 따로 있으니까 안띄우는 것도 방법?
					
				}
				else {//로그인
					UserIngreDAO udao=UserIngreDAO.newInstance();
					List<UserIngreVO> ulist=udao.ingreListNameData(id);
					List<String> uinglist=new ArrayList<String>();
					int size=ulist.size();
					while(true) {
						uinglist.clear();
						for(int i=0; i<3; i++) {
							int rand=(int)(Math.random()*size);
							uinglist.add(ulist.get(rand).getName());
							System.out.println(uinglist.get(i));
							if(i==size)
								break;
						}
						IngreRecipeDAO idao=IngreRecipeDAO.newInstance();
						ingreRecipe = idao.ingreSearchRecipe(uinglist);
						if(ingreRecipe.size()>4)
							break; 
					}
				}
				request.setAttribute("ingreRecipe", ingreRecipe);
				//추가종료
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
	
	
	
	@RequestMapping("main/search.do")
	public String main_search(HttpServletRequest request,HttpServletResponse response) {
		ListDAO dao=ListDAO.newInstance();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String page=request.getParameter("page");
		if(page==null) {
			page="1";
		}
		String msg=request.getParameter("msg");//검색어
		msg=msg.trim();
		StringTokenizer st=new StringTokenizer(msg," ");
		List<String> list=new ArrayList<String>();
		while(st.hasMoreTokens()) {
			String str=st.nextToken();
			str=str.trim();
			list.add(str);
		}
		int curpage=Integer.parseInt(page);
		List<ListVO> sList=dao.searchList(list, curpage);
		int totalpage=(int)(Math.ceil(sList.size()));
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		
		request.setAttribute("sList", sList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage); 
		request.setAttribute("endPage", endPage);
		request.setAttribute("msg", msg);
		request.setAttribute("main_jsp", "../main/search.jsp");
		return "../main/main.jsp";
	}
}
