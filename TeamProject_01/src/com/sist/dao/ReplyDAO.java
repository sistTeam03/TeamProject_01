package com.sist.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.ReplyVO;

public class ReplyDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static ReplyDAO dao;
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
	   public static ReplyDAO newInstance()
	   {
		   if(dao==null)
			   dao=new ReplyDAO();
		   
		   return dao;
			   
	   }
	   
	   /*
	    * NO       NOT NULL NUMBER         
			ID                VARCHAR2(20)   
			NICKNAME          VARCHAR2(50)   
			MSG               VARCHAR2(1500) 
			REGDATE           DATE  
	    */
	   
	 //댓글 읽기
	   public List<ReplyVO> replyReadData(int recipeno)
	   {
		   List<ReplyVO> list=new ArrayList<ReplyVO>();
		   try {
			   getConnection();
			   String sql="SELECT no, recipeno, id, nickname, msg, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') "
			   		+ "FROM recipereply "
			   		+ "WHERE recipeno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, recipeno);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ReplyVO vo=new ReplyVO();
				   vo.setNo(rs.getInt(1));
				   vo.setRecipeno(rs.getInt(2));
				   vo.setId(rs.getString(3));
				   vo.setNickname(rs.getString(4));
				   vo.setMsg(rs.getString(5));
				   vo.setRegdate(rs.getString(6));
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
	   
	   //댓글 올리기
	   public void replyInsert(ReplyVO vo,int recipeno)
	   {
		   /*
		    * NO       NOT NULL NUMBER         
				ID                VARCHAR2(20)   
				NICKNAME          VARCHAR2(50)   
				MSG               VARCHAR2(1500) 
				REGDATE           DATE           
				RECIPENO          NUMBER  
		    */
		   try {
			   getConnection();
			   String sql="INSERT INTO recipereply VALUES("
			   		+ "rr_no_seq.nextVal,?,?,?,SYSDATE,?)";
			   ps=conn.prepareStatement(sql);
			  ps.setString(1, vo.getId());
			  ps.setString(2, vo.getNickname());
			  ps.setString(3, vo.getMsg());
			  ps.setInt(4, recipeno);
			   ps.executeUpdate();
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
	   }
	   
	   //댓글 수정
	   public void replyUpdate(ReplyVO vo)
	   {
		   try {
			   getConnection();
			   String sql="UPDATE recipereply SET "
			   		+ "msg=? "
			   		+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getMsg());
			   ps.setInt(2, vo.getNo());
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			  disConnection();
		   }
	   }
	   
	   public void replyDelete(int no)
	   {
		   try {
			   getConnection();
			   String sql="DELETE FROM recipereply "
			   		+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }finally {
			   disConnection();
		   }
	   }
}
