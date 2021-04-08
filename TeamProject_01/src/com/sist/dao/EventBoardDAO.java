package com.sist.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.EventBoardVO;

public class EventBoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static EventBoardDAO dao;
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
	public static EventBoardDAO newInstance() {
		if(dao==null)
			dao=new EventBoardDAO();
		return dao;
	}
	public List<EventBoardVO> eventBoardList(int page)
	{
		
		List<EventBoardVO> list=new ArrayList<EventBoardVO>();
		   try
		   {
			   getConnection();
			   System.out.println(4);
			   String sql="SELECT no,subject,name,regdate,hit "
					     +"FROM eboard ORDER BY no DESC ";
					    
			   int rowSize=10;
			   int start=1+(page-1)*rowSize;
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			  /* ps.setInt(1, start);
			   ps.setInt(2, end);*/
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   System.out.println(4);
				   EventBoardVO vo=new EventBoardVO();
				   vo.setNo(rs.getInt(1));
				   vo.setSubject(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setRegdate(rs.getDate(4));
				   vo.setHit(rs.getInt(5));
				   list.add(vo);
				   int i=0;
				   System.out.println(list.get(i));
				   i++;
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	}
	public int eboardTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM eboard";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   // 에러 처리
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 반환 
			   disConnection();
		   }
		   return total;
	   } 
	public EventBoardVO eventDetailData(int no)
	{
		EventBoardVO vo = new EventBoardVO();
		try
		{
			getConnection();
			String sql="SELECT no,name,subject,content,regdate,hit,filename,filesize "
					+ "FROM eboard WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			 rs.next();
			 vo.setNo(rs.getInt(1));
			 vo.setName(rs.getString(2));
			 vo.setSubject(rs.getString(3));
			 vo.setContent(rs.getString(4));
			 vo.setRegdate(rs.getDate(5));
			 vo.setHit(rs.getInt(6));
			 vo.setFilename(rs.getString(7));
			 vo.setFilesize(rs.getInt(8));
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
	public void eventInsertData(EventBoardVO vo)
	{
		try
		   {
			   getConnection();
			   String sql="INSERT INTO eboard(no,name,subject,content,pwd,filename,filesize) "
					     +"VALUES((SELECT NVL(MAX(no)+1,1) FROM databoard),?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   ps.setString(5, vo.getFilename());
			   ps.setInt(6, vo.getFilesize());
			   
			   ps.executeUpdate();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	}
	
	
	
	
}
