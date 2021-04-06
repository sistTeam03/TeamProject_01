package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.BoardVO;

public class BoardDAO {
	 private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static BoardDAO dao;
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
	   public static BoardDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BoardDAO();
		   
		   return dao;
			   
	   }
	   public int boardCount()
	   {
		   int count=0;
		   try
		   {
			   getConnection();
			   String sql = "SELECT COUNT(*) FROM wboard";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
		   return count;
	   }
	   public List<BoardVO> boardListData(int page)
	   {
		   List<BoardVO> list = new ArrayList<BoardVO>();
		   try
		   {
			   getConnection();
			   String sql = "SELECT no , subject, name, regdate, hit, num "
			   			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			   			+ "FROM (SELECT no,subject,name,regdate,hit "
			   			+ "FROM wboard ORDER BY no DESC)) "
			   			+ "WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			  int rowsize=12;
			  int start=(rowsize*page)-(rowsize-1);
			  int end = (rowsize*page);
			  ps.setInt(1, start);
			  ps.setInt(2, end);
			  
			  ResultSet rs = ps.executeQuery();
			  while(rs.next())
			  {
				  BoardVO vo = new BoardVO();
				  vo.setNo(rs.getInt(1));
				  vo.setSubject(rs.getString(2));
				  vo.setName(rs.getString(3));
				  vo.setRegdate(rs.getDate(4));
				  vo.setHit(5);
				  list.add(vo);
						  
			  }
			  rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   public BoardVO boardDetailData(int no)
	   {
		   BoardVO vo = new BoardVO();
		   try
		   {
			   
			   getConnection();
			   String sql = "SELECT no,name,subject,content,regdate,hit "
			   			+ "FROM wboard "
			   			+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   vo.setRegdate(rs.getDate(5));
			   vo.setHit(rs.getInt(6));
			   
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   public void boardInsert(BoardVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO wboard VALUES(wb_no_seq.nextVal,?,?,?,?,SYSDATE,0)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   
			   ps.executeUpdate();
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
	   }
	   
	   public BoardVO boardUpdateData(int no)
	   {
		   BoardVO vo = new BoardVO();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,name,subject,content,regdate,hit "
			   			+ "FROM wboard "
			   			+ "WHERE no=?";
			   ps.setInt(1, no);
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   
	   public boolean boardUpdate(BoardVO vo)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   String sql="SELEC pwd FROM wboard "
			   			+ "WHERE no=?";
			   ps.setInt(1, vo.getNo());
			   ResultSet rs = ps.executeQuery();
			   rs.next();
			   String dbpwd=rs.getString(1);
			   rs.close();
			   
			   if(dbpwd.equals(vo.getPwd()))
			   {
				   bCheck=true;
				   sql="UPDATE wboard SET name=?,subject=?,content=? WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setString(1, vo.getName());
				   ps.setString(2, vo.getSubject());
				   ps.setString(3, vo.getContent());
				   ps.setInt(4, vo.getNo());
				   
				   ps.executeUpdate();
			   }
			   else
			   {
				   bCheck=false;
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
}














