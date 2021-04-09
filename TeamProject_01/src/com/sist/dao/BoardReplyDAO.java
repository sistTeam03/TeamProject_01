package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.BoardReplyVO;

public class BoardReplyDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static BoardReplyDAO dao;
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
	   public static BoardReplyDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BoardReplyDAO();
		   
		   return dao;
			   
	   }
	   // 자료실 목록 출력 
	   public List<BoardReplyVO> boardReplyListData(int page)
	   {
		   List<BoardReplyVO> list=new ArrayList<BoardReplyVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,subject,name,regdate,hit,group_tab,num "
					     +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
					     +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
					     +"FROM project_BoardReply ORDER BY group_id DESC,group_step ASC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   int rowSize=10;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BoardReplyVO vo=new BoardReplyVO();
				   vo.setNo(rs.getInt(1));
				   vo.setSubject(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setRegdate(rs.getDate(4));
				   vo.setHit(rs.getInt(5));
				   vo.setGroup_tab(rs.getInt(6));
				   list.add(vo);
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
	   // 총페이지 구하기
	   public int boardReplyTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM project_BoardReply";
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
	   
	   public void boardReplyInsert(BoardReplyVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO project_boardReply(no,name,subject,content,pwd,group_id) "
					     +"VALUES((SELECT NVL(MAX(no)+1,1) FROM project_boardReply),?,?,?,?,"
					     +"(SELECT NVL(MAX(group_id)+1,1) FROM project_boardReply))";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   
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
	   // detail
	   public BoardReplyVO boardReplyDetailData(int no)
	   {
		   BoardReplyVO vo=new BoardReplyVO();
		   try
		   {
			   getConnection();
			   String sql="UPDATE project_boardReply SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
			   
			   sql="SELECT no,name,subject,content,regdate,hit "
				  +"FROM project_boardReply "
				  +"WHERE no=?";
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
		   }
           finally
           {
        	   disConnection();
           }
		   return vo;
	   }
	   public int boardReplyGetGroupId(int no)
	   {
		   int gi=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT group_id FROM project_boardReply "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   gi=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return gi;
	   }
	   public void boardReplyReplyInsert(BoardReplyVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO project_boardReply(no,name,subject,content,pwd,group_id,group_step,group_tab) "
					     +"VALUES((SELECT NVL(MAX(no)+1,1) FROM project_boardReply),?,?,?,?,"
					     +"?,1,1)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   ps.setInt(5, vo.getGroup_id());
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
	   public boolean boardReplyCheck(int no)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   String sql="SELECT COUNT(group_id) FROM project_boardReply "
					     +"WHERE group_id=(SELECT group_id FROM project_boardReply WHERE no=?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   int count=rs.getInt(1);
			   rs.close();
			   if(count==2)
			   {
				   bCheck=true;
			   }
			   else
			   {
				   bCheck=false;
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
	   
	   // 수정
	   public BoardReplyVO boardUpPrint(int no)
	   {
		   BoardReplyVO vo=new BoardReplyVO();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,name,subject,content "
			   		+ "FROM project_boardReply "
			   		+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   
	   
	   public boolean boardReplyUpdate(BoardReplyVO vo)
	   {
		   boolean bCheck=false;
		   try
		   {
//			   System.out.println(vo.getNo());
			   getConnection();
			   String sql="SELECT pwd FROM project_boardReply "
			   		+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getNo());
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   
			   if(db_pwd.equals(vo.getPwd()))
			   {
				   bCheck=true;
				   sql="UPDATE project_boardReply SET "
				   		+ "name=?,subject=?,content=? "
				   		+ "WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setString(1, vo.getName());
				   ps.setString(2, vo.getSubject());
				   ps.setString(3, vo.getContent());
				   ps.setInt(4, vo.getNo());
				   
				   ps.executeUpdate();
			   } 
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
}

