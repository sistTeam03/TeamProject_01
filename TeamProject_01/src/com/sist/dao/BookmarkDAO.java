package com.sist.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.BookmarkVO;

public class BookmarkDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static BookmarkDAO dao;
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
	   public static BookmarkDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BookmarkDAO();
		   
		   return dao;
			   
	   }
	 //찜하기
	   public void bookmarkInsert(int recipeno, String id)
	   {
		   try {
			   getConnection();
			   String sql="INSERT INTO bookmark_list VALUES("
			   		+ "bm_no_seq.nextVal, SYSDATE,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, recipeno);
			   ps.setString(2, id);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
	   }
	   
	   //찜하기 체크
	   public int bookmarkCheck(int recipeno, String id)
	   {
		   int count=0;
		   try {
			   getConnection();
			   String sql="SELECT COUNT(*) FROM bookmark_list "
			   		+ "WHERE recipeno=? AND id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, recipeno);
			   ps.setString(2, id);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
		   return count;
	   }
	   
	   //찜 목록
	   public List<BookmarkVO> bookmarkListData(String id)
	   {
		   List<BookmarkVO> list=new ArrayList<BookmarkVO>();
		   try {
			   getConnection();
			   String sql="SELECT recipeno FROM bookmark_list "
			   		+ "WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BookmarkVO vo= new BookmarkVO();
				   vo.setRecipeno(rs.getInt(1));
				   list.add(vo);
			   }
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
		   return list;
	   }
	   //찜 삭제
	 //삭제
	   public void bookmarkDelete(int no,String id)
	   {
		   try {
			   getConnection();
			   String sql="DELETE bookmark_list WHERE recipeno=? AND id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.setString(2,id);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
	   }
	   
	   
}