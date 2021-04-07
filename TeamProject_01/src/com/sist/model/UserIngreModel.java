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
public class UserIngreModel {
	//추가
	@RequestMapping("mypage/useringreinsert.do")
	public String user_ingre_insert(HttpServletRequest request, HttpServletResponse response)
	{
		
		String kono="";
		String ingno=request.getParameter("ino");
		int ino=Integer.parseInt(ingno);
		if(ino<113)
			kono="1";
		else if(ino<134)
			kono="2";
		else if(ino<234)
			kono="3";
		else if(ino<250)
			kono="4";
		else if(ino<339)
			kono="5";
		else if(ino<418)
			kono="6";
		else if(ino<527)
			kono="7";
		else if(ino<632)
			kono="8";
		else if(ino<685)
			kono="9";
		else if(ino<738)
			kono="10";
		else if(ino<781)
			kono="11";
		else if(ino<804)
			kono="12";
		else if(ino<846)
			kono="13";
		else
			kono="14";
		System.out.println(kono);
		UserIngreDAO dao=UserIngreDAO.newInstance();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("sesson_id");
		dao.ingreInsert(id, ino);
		return "redirect:../mypage/ingrelist.do?kono="+kono;
	}
	//삭제
	@RequestMapping("mypage/useringredelete.do")
	public String user_ingre_delete(HttpServletRequest request, HttpServletResponse response)
	{
		String kono="";
		String ingno=request.getParameter("ino");
		int ino=Integer.parseInt(ingno);
		if(ino<113)
			kono="1";
		else if(ino<134)
			kono="2";
		else if(ino<234)
			kono="3";
		else if(ino<250)
			kono="4";
		else if(ino<339)
			kono="5";
		else if(ino<418)
			kono="6";
		else if(ino<527)
			kono="7";
		else if(ino<632)
			kono="8";
		else if(ino<685)
			kono="9";
		else if(ino<738)
			kono="10";
		else if(ino<781)
			kono="11";
		else if(ino<804)
			kono="12";
		else if(ino<846)
			kono="13";
		else
			kono="14";
		int no=Integer.parseInt(request.getParameter("no"));
		UserIngreDAO dao=UserIngreDAO.newInstance();
		dao.ingreDelete(no);
		return "redirect:../mypage/ingrelist.do?kono="+kono;
	}
	//목록 불러오기- 마이페이지에서 처리?
	
	//데이터 출력
	@RequestMapping("mypage/ingrelist.do")
	public String ingre_list_select(HttpServletRequest request, HttpServletResponse response)
	{
		/*
		 * 1 가 1-112
		 * 2 나 113-133
		 * 3 다 134-233
		 * 4 라 234-249 (244x)
		 * 5 마 250-338
		 * 6 바 339-417
		 * 7 사 419-526
		 * 8 아 528-631
		 * 9 자 632-684
		 * 10 차 686-737
		 * 11 카 738-780
		 * 12 타 781-803
		 * 13 파 804-845
		 * 14 하 846-896
		 */
		String ko=request.getParameter("kono");
		
		//마이페이지와 아직 연결이 안됨 - 테스트를 위해 임의로 로그인 처리 
		HttpSession session=request.getSession();
		session.setAttribute("name", "홍길동");
		session.setAttribute("sesson_id", "hong");
		String id=(String)session.getAttribute("sesson_id");
		System.out.println(id);
		//마이페이지와 연결될시 수정 
		
		
		if(ko.equals(""))
			ko="1";	

		int start=0, end=0;

		int kono=Integer.parseInt(ko);

		if(kono==1) {
			start=1; end=112;}
		else if(kono==2){
			start=113; end=133;}
		else if(kono==3){
			start=134; end=233;}
		else if(kono==4){
			start=234; end=249;}
		else if(kono==5){
			start=250; end=338;}
		else if(kono==6){
			start=339; end=417;}
		else if(kono==7){
			start=419; end=526;}
		else if(kono==8){
			start=528; end=631;}
		else if(kono==9){
			start=632; end=684;}
		else if(kono==10){
			start=686; end=737;}
		else if(kono==11){
			start=738; end=780;}
		else if(kono==12){
			start=781; end=803;}
		else if(kono==13){
			start=804; end=845;}
		else if(kono==14){
			start=846; end=896;}

		UserIngreDAO dao=UserIngreDAO.newInstance();

		List<IngreVO> ilist=dao.ingreList(start, end);
		
		
		
		List<UserIngreVO> ulist=new ArrayList<UserIngreVO>();
		UserIngreDAO udao=UserIngreDAO.newInstance();
		ulist=udao.ingreListData(id);
		
		for(int i=0; i<ulist.size(); i++) {
			for(int j=0; j<ilist.size(); j++) {
				if(ulist.get(i).getIno()==ilist.get(j).getNum()) {
					ilist.get(j).setIngre_count(1);
					ilist.get(j).setUsr_num(ulist.get(i).getNo());
					break;
				}
			}
		}
		
		
		request.setAttribute("ulist", ulist);
		request.setAttribute("ko", ko);
		request.setAttribute("ilist", ilist);
		request.setAttribute("main_jsp", "../mypage/ingrelist.jsp");
		return "../main/main.jsp";
	}

}
