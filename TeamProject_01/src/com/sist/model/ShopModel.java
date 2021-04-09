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
public class ShopModel {
	@RequestMapping("recipe/shop.do")   
	public String shop_home(HttpServletRequest request,HttpServletResponse response)
	{	
		String page=request.getParameter("page");

		if(page==null) {
			page="1";
		}

		int curpage=Integer.parseInt(page);
		ShoppingDAO dao=ShoppingDAO.newInstance();
		int count=dao.listCount();
		int totalpage=dao.listTotalPage();
		int block=10;
		int startPage=((curpage-1)/block*block)+1;
		int endPage=((curpage-1)/block*block)+block;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		List<ShoppingVO> alllist=dao.shopListData();
		List<ShoppingVO> list=dao.listAllData(curpage);
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("sesson_id");
		List<UserCartVO> ulist=new ArrayList<UserCartVO>();
		List<ShoppingVO> printulist=new ArrayList<ShoppingVO>();
		if(id!=null) {
			ulist=dao.cartList(id);
			for(int i=0; i<ulist.size(); i++) {
				printulist.add(alllist.get(ulist.get(i).getIno()-1));
			}
		}
		
		request.setAttribute("printulist", printulist);
		request.setAttribute("count", count);//0406추가
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage); 
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../recipe/Shopping.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/shop_cart.do")
	public String shop_cart(HttpServletRequest request,HttpServletResponse response) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		System.out.println(1);
		int ino=Integer.parseInt(request.getParameter("no"));
		System.out.println(2);
		ShoppingDAO dao=ShoppingDAO.newInstance();
		System.out.println(3);
		HttpSession session=request.getSession();
		System.out.println(4);
		String id=(String) session.getAttribute("sesson_id");
		System.out.println(5);
		dao.insertCart(ino, id);
		System.out.println(6);
		return "redirect:../recipe/shop.do?page="+page;
	}
	
	@RequestMapping("recipe/cart_delete.do")
	public String shop_delete(HttpServletRequest request,HttpServletResponse response) {
		String page=request.getParameter("page");
		int no=Integer.parseInt(request.getParameter("no"));
		ShoppingDAO dao=ShoppingDAO.newInstance();
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("sesson_id");
		dao.cartDelete(no, id);
		return "redirect:../recipe/shop.do?page="+page;
	}

}