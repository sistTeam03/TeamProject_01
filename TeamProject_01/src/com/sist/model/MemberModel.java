package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BookmarkDAO;
import com.sist.dao.DetailDAO;
import com.sist.dao.MemberDAO;
import com.sist.dao.UserIngreDAO;
import com.sist.vo.BookmarkVO;
import com.sist.vo.DetailVO;
import com.sist.vo.ListVO;
import com.sist.vo.MemberVO;
import com.sist.vo.UserIngreVO;
import com.sist.vo.ZipcodeVO;

@Controller
public class MemberModel {
	@RequestMapping("member/join.do")//회원가입 페이지 전송
	public String signPage(HttpServletRequest request,HttpServletResponse response) {
		
		
		request.setAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("member/idCheck_result.do")//회원 중복체크
	public String idCheck(HttpServletRequest request,HttpServletResponse response) {
			String id=request.getParameter("id");
			MemberDAO dao=MemberDAO.newInstance();
			int count=dao.idCheck(id);
			request.setAttribute("count", count);
			
		return "../member/idCheck_result.jsp";
	}
	@RequestMapping("member/join_ok.do") //회원가입 완료
	public String Signup(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {}
		//값받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nick");
		String email=request.getParameter("email");
		String birth=request.getParameter("birth");
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String phone1=request.getParameter("phone1");
		String phone2=request.getParameter("phone2");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		MemberDAO dao=MemberDAO.newInstance();
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNickname(nickname);
		vo.setName(name);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setTel(tel1+"-"+tel2);
		vo.setPhone(phone1+"-"+phone2);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		dao.insertMember(vo);
		
		
		return "redirect: ../main/main.do";
	}
	@RequestMapping("member/post_result.do")//주소 출력
	public String zipcodePrint(HttpServletRequest request,HttpServletResponse response) {
		String dong=request.getParameter("dong");
		MemberDAO dao=MemberDAO.newInstance();
		List<ZipcodeVO> list=dao.joinAddress(dong);
		
		request.setAttribute("list", list);
		return "../member/fost_find.jsp";
	}
	@RequestMapping("member/login.do")//로그인
	public String loginOk(HttpServletRequest request,HttpServletResponse response) {
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		MemberDAO dao=MemberDAO.newInstance();
		String result=dao.loginCheck(id, pwd);
		String admin="";
		if(result.equals("Y")) {
			admin="Y";//관리자일때
			HttpSession session=request.getSession();
			session.setAttribute("name", result);
			session.setAttribute("sesson_id", id);
			session.setAttribute("admin", admin);
			request.setAttribute("msg", result); //이름,닉네임
			request.setAttribute("admin", admin);
		}
		
		if(result.equals("NOID")) {
			request.setAttribute("msg", result);
		}else if(result.equals("NOPWD")){
			request.setAttribute("msg", result);
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("name", result);
			session.setAttribute("sesson_id", id);
			session.setAttribute("admin", admin);
			request.setAttribute("msg", result); //이름,닉네임
			request.setAttribute("admin", admin);
		}
		
		return "../member/login_ok.jsp";
	}
	@RequestMapping("member/logout.do")
	public String logOutOk(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		
		
		return "redirect: ../main/main.do";
	}
	//마이페이지 설정
	@RequestMapping("mypage/mypage.do")
	public String myPage(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session=request.getSession();

		String id=(String)session.getAttribute("sesson_id");

		//DB연동
		BookmarkDAO bookmarkdao =BookmarkDAO.newInstance();

		DetailDAO dao = DetailDAO.newInstance();

		//찜하기 목록
		List<BookmarkVO> jList=bookmarkdao.bookmarkListData(id);

		List<ListVO> dList = new ArrayList<ListVO>();

		if(!jList.isEmpty()) {

			for(BookmarkVO vo:jList)
			{

				ListVO dvo =dao.BookmarkData(vo.getRecipeno());

				String poster = dvo.getPoster();

				dvo.setPoster(poster);

				dList.add(dvo);
			}

		}

		//추가
		UserIngreDAO udao=UserIngreDAO.newInstance();

		List<UserIngreVO> ulist=udao.ingreListNameData(id);

		List<UserIngreVO> ulist_cut=new ArrayList<UserIngreVO>();

		if(!ulist.isEmpty()) {
			for(int i=0; i<6; i++) {

				ulist_cut.add(ulist.get(i));
				if(i==ulist.size()-1)
					break;
			}

		}

		request.setAttribute("ulist", ulist_cut);
		//추가 끝
		
		request.setAttribute("dList", dList);
		request.setAttribute("jList", jList);
		
		request.setAttribute("main_jsp", "../mypage/mypage.jsp");
		return "../main/main.jsp";
	}
	
	
}
