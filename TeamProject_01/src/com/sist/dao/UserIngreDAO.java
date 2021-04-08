//유저 재료 선택 추가/삭제/목록 불러오기 0406 생성추가
package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.*;
import java.util.*;
public class UserIngreDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static UserIngreDAO dao;
	   public void getConnection()
	   {
		   try
		   {
			   // JNDI초기화 : 탐색기를 연다
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex) {}
	   }
	   // 사용후에 반환 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex){}
	   }
	   // DAO  객체를 클라이언트당 1개씩만 사용 => 싱글턴 
	   public static UserIngreDAO newInstance()
	   {
		   if(dao==null)
			   dao=new UserIngreDAO();
		   
		   return dao;
			   
	   }
	   
	//추가
	   public void ingreInsert(String id, int ino)
	   {
		   try {
			   getConnection();
			   String sql="SELECT COUNT(*) FROM user_ingre_list "
			   		+ "WHERE id=? AND ino=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ps.setInt(2, ino);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   int count=rs.getInt(1);
			   rs.close();
			   
			   if(count==0) {
				   sql="INSERT INTO user_ingre_list VALUES("
				   		+ "il_no_seq.nextVal, ?,?)";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, ino);
				   ps.setString(2, id);
				   ps.executeUpdate();
			   }
			   else {

			   }
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
	   }
	   
	//삭제
	   public void ingreDelete(int no)
	   {
		   try {
			   getConnection();
			   String sql="DELETE user_ingre_list WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
	   }
	   
	   //목록 불러오기
	   public List<UserIngreVO> ingreListData(String id)
	   {
		   List<UserIngreVO> list=new ArrayList<UserIngreVO>();
		   try {
			   getConnection();
			   String sql="SELECT no, ino, id FROM user_ingre_list "
			   		+ "WHERE id=?";
			   ps=conn.prepareStatement(sql); 
			   ps.setString(1, id);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   UserIngreVO vo=new UserIngreVO();
				   vo.setNo(rs.getInt(1));
				   vo.setIno(rs.getInt(2));
				   vo.setId(rs.getString(3));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
		   return list;
	   }
	   
	   //데이터 전체 목록 출력하기
	   public List<IngreVO> ingreList(int start, int end)
	   {
		   List<IngreVO> list=new ArrayList<IngreVO>();
		   try {
			   getConnection();
			   String sql="SELECT num, ingre FROM ingre_v3 "
			   		+ "WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   IngreVO vo=new IngreVO();
				   vo.setNum(rs.getInt(1));
				   vo.setIngre(rs.getString(2));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
		   return list;
	   }
}
