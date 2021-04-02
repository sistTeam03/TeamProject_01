package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.MemberVO;

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
	
}
