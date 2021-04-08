package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String sort=request.getParameter("sort");
		System.out.println(sort);
		if(sort==null) {
			sort="2";
		}
		System.out.println(sort);
		String page=request.getParameter("page");
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		ListDAO dao=ListDAO.newInstance();
		DetailDAO dDao=DetailDAO.newInstance();
		int count=dao.listCount();//0406추가
		int totalpage=dao.listTotalPage();
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		List<ListVO> list=dao.listAllData(curpage,Integer.parseInt(sort));
		List<DetailVO> cList=new ArrayList<DetailVO>();//쿠키담을 그릇
		List<Integer> cList2=new ArrayList<Integer>(); //no 저장
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1; i>=0;i--) {
				if(cookies[i].getName().startsWith("m")) {
					cookies[i].setPath("/");
					int no=Integer.parseInt(cookies[i].getValue());
					cList2.add(no);
					if(cList2.size()>6)
						break;
				}
				
			}
		}
		System.out.println(sort);
		cList=dDao.detailCookie(cList2);
		request.setAttribute("count", count);//0406추가
		request.setAttribute("cList", cList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage); 
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("sort", sort);
		request.setAttribute("main_jsp", "../recipe/recipe.jsp");
		return "../main/main.jsp";
	}
	
	//쿠키
	@RequestMapping("recipe/detail_before.do")
	public String detail_before(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		  Cookie cookie=new Cookie("m"+no, no);
		  cookie.setMaxAge(60*60);
		  cookie.setPath("/");
		  response.addCookie(cookie);
		  return "redirect:../recipe/recipe_detail.do?no="+no;
	}
	
	//상세- 0405 수정
		@RequestMapping("recipe/recipe_detail.do")
		public String recipe_detail(HttpServletRequest request, HttpServletResponse response)
		{
			String no=request.getParameter("no");
			  DetailDAO dao=DetailDAO.newInstance();
			  DetailVO vo=dao.detailData(Integer.parseInt(no)); 
			  String[] poslist=vo.getContent_poster().split(",");
			 String[] conlist=vo.getContent().split("\\[]");
			  StringTokenizer st=new StringTokenizer(vo.getIngre()," ");
			
			  ArrayList<String> ingre_list_token=new ArrayList<String>();
	
			  while(st.hasMoreTokens()) {
				  String tmp=st.nextToken();
				  if(tmp.endsWith("개")||tmp.endsWith("T")||tmp.endsWith("푼")||tmp.endsWith("알")||tmp.endsWith("히")
						  ||tmp.endsWith("송")||tmp.endsWith("술")||tmp.endsWith("g")||tmp.endsWith("간")||tmp.endsWith("컵")
						  ||tmp.endsWith(")")||tmp.endsWith("줌")||tmp.endsWith("쪽")||tmp.startsWith("[0-9]")
						  ||tmp.endsWith("대")||tmp.endsWith("t")||tmp.endsWith("s")||tmp.endsWith("단")||tmp.endsWith("락")
						  ||tmp.endsWith("컵")||tmp.endsWith("줄")||tmp.endsWith("G")||tmp.endsWith("조금")||tmp.endsWith("약간")
						  ||tmp.endsWith("뿌리")||tmp.endsWith("마리")||tmp.endsWith("거"))
				  {
					  ingre_list_token.set(ingre_list_token.size()-1, ingre_list_token.get(ingre_list_token.size()-1)+" "+tmp);
					  continue;
				  }
				  ingre_list_token.add(tmp);
			  }
			  
			  BookmarkDAO bdao=BookmarkDAO.newInstance();
			  HttpSession session=request.getSession();
			  String id=(String)session.getAttribute("sesson_id");
			  int count=bdao.bookmarkCheck(Integer.parseInt(no), id);
			 
			  request.setAttribute("count", count);
			  request.setAttribute("length", conlist.length);
			  request.setAttribute("poslist", poslist);
			  request.setAttribute("conlist", conlist);
			  request.setAttribute("inglist", ingre_list_token);
			  request.setAttribute("vo", vo);
			 
			  request.setAttribute("main_jsp", "../recipe/recipe_detail.jsp");
			  return "../main/main.jsp";
		}
}
