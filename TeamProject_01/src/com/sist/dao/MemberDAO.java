package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static MemberDAO dao;
	public void getConnection()
	{	
		try {
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {ex.printStackTrace();}
	}
	//DAO객체를 클라이언트당 1개만- 싱글턴
	public static MemberDAO newInstance() {
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	//아이디 중복체크
	public int idCheck(String id) {
		int count=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return count;
	}
	//회원가입
	public void insertMember(MemberVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO member Values(?,?,?,?,?,?,?,?,?,?,?,'N')";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getBirth());
			ps.setString(5, vo.getTel());
			ps.setString(6, vo.getPhone());
			ps.setString(7, vo.getEmail());
			ps.setString(8, vo.getPost());
			ps.setString(9, vo.getNickname());
			ps.setString(10, vo.getAddr1());
			ps.setString(11, vo.getAddr2());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//주소 불러오기
	public List<ZipcodeVO> joinAddress(String dong){
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			getConnection();
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					+ "FROM zipcode "
					+ "WHERE dong like '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	//로그인
	public String loginCheck(String id,String pwd) {
		String result="";
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			if(count==1) {
				sql="SELECT pwd,name,NVL(nickname,'^'),admin " //로그인후 가져올 정보
						+"from member where id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String nickname=rs.getString(3);
				String admin=rs.getString(4);
				
				rs.close();
				if(db_pwd.equals(pwd)) {//로그인성공
					if(nickname.equals("^")) {//닉네임이 없으면 이름으로 출력
						result=name;
					}else {
						result=nickname;
					}
					if(admin.equals("Y")) {
						result=admin;
					}
				}else {
					result="NOPWD";
				}
				
			}else{//아이디 없음
				result="NOID";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return result;
	}
	//검색어 저장
		public void searchInsert(String msg) {
			try {
				getConnection();
				System.out.println("테스트1"+msg);
				String sql="INSERT INTO search_keyword "
						+ "VALUES(sk_no_seq.nextval,?,SYSDATE)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, msg);
				ps.executeUpdate();
				System.out.println("테스트2"+msg);
			} catch (Exception ex) {
				ex.printStackTrace();
			}finally {
				disConnection();
			}
		}
		//TOP10출력
	public List<String> searchTOP10(String today,String yesterday){
		List<String> list=new ArrayList<String>();
		
		try {
			int i=1;
			System.out.println("테스트");
			getConnection();
			String sql="SELECT keyword "
					+"FROM search_keyword "
					+"where TO_char(regdate,'YY/MM/DD')=? "
					+"GROUP BY keyword "
					+"ORDER BY count(keyword) DESC";
			ps=conn.prepareStatement(sql);
			ps.setString(1, today);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String keyword=rs.getString(1);
				sql="SELECT keyword,TO_NUMBER(rank()OVER( ORDER BY count(keyword) DESC, keyword)) as rank "
						+"FROM search_keyword "
						+"where TO_char(regdate,'YY/MM/DD')=? "
						+"GROUP BY keyword";
				ps=conn.prepareStatement(sql);
				ps.setString(1, yesterday);
				ResultSet rs2=ps.executeQuery();
				int k=0;
				while(rs2.next()){
					String yKeyword=rs2.getString(1);
					int yRank=rs2.getInt(2);
					if(keyword.equals(yKeyword)) {
						int upRank=yRank-i;
						list.add(keyword+","+upRank);//어제와 같은 검색어찾기
					System.out.println(k++);	
					}
					
				}
				if(list.size()+1==i)
				list.add(keyword+","+"New");
				i++;
				if(i==10)break;
			}
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return list;
	}
}
