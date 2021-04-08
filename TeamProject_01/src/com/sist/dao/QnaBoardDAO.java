package com.sist.dao;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.sist.vo.*;

public class QnaBoardDAO {
	 private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static QnaBoardDAO dao;
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
	   public static QnaBoardDAO newInstance()
	   {
		   if(dao==null)
			   dao=new QnaBoardDAO();
		   
		   return dao;   
	   }
	   
	   ///////////////// 게시판 기능 /////////////////
	   // QnA 목록
	   public List<QnaboardVO> qnaListData(int page)
	   {
		   List<QnaboardVO> list=new ArrayList<QnaboardVO>();
		   /*
		    *  NO         NOT NULL NUMBER        
		   	ID                  VARCHAR2(20)  
		   	NAME                VARCHAR2(20)  
		   	SUBJECT             VARCHAR2(100) 
		   	CONTENT             CLOB          
		   	PWD                 VARCHAR2(30)  
		   	REGDATE             DATE          
		   	HIT                 NUMBER        
		   	GROUP_ID            NUMBER        
		   	GROUP_STEP          NUMBER        
		   	GROUP_TAB           NUMBER        
		   	ROOT                NUMBER        
		   	DEPTH               NUMBER  
		    */
		   try
		   {
			   getConnection();
			   String sql="SELECT no,id,name,subject,content,pwd,regdate,hit,group_tab,num "
			   		+ "FROM (SELECT no,id,name,subject,content,pwd,regdate,hit,group_tab,rownum as num "
			   		+ "FROM (SELECT no,id,name,subject,content,pwd,regdate,hit,group_tab "
			   		+ "FROM qnaBoard ORDER BY group_id DESC,group_step ASC)) "
			   		+ "WHERE num BETWEEN ? AND ?";
			   int rowSize=10;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   QnaboardVO vo=new QnaboardVO();
				   vo.setNo(rs.getInt(1));
				   vo.setId(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setSubject(rs.getString(4));
				   vo.setRegdate(rs.getDate(5));
				   vo.setHit(rs.getInt(6));
				   vo.setGroup_tab(rs.getInt(7));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   
	   // qna 총 페이지
	   public int qnaTotalCount()
	   {
		   int count=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM qnaBoard";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return count;
	   }
	   
	   // qna 글쓰기
	   public void qnaInsert(QnaboardVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO qnaBoard(no,id,name,subject,content,pwd,group_id) "
						+"VALUES(qb_no_seq.nextval,?,?,?,?,?,"
						+"(SELECT NVL(MAX(group_id)+1,1) FROM qnaBoard))";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getId());
			   ps.setString(2, vo.getName());
			   ps.setString(3, vo.getSubject());
			   ps.setString(4, vo.getContent());
			   ps.setString(5, vo.getPwd());
			   // 실행 요청. 미리 오류 방지하면서 코딩해야 함. 게시글이 아무 것도 없을 때도 생각해야 함
			   ps.executeUpdate();
		   }catch(Exception ex) {
				  ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }

	   }
	   
	   // 내용보기 => SQL문장:2개
		  public QnaboardVO qnaOneRowData(int no)
		  {
			  QnaboardVO vo=new QnaboardVO();
			  try
			  {
				  getConnection();
				  String sql="UPDATE qnaBoard SET "
					  		+ "hit=hit+1 "
					  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, no);
				  ps.executeUpdate();
				  
				  // 상세보기, 수정하기 동일하게 적용
				  sql="SELECT no,id,name,subject,content,regdate,hit "
				  		+ "FROM qnaBoard "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, no);
				  ResultSet rs=ps.executeQuery();
				  rs.next();
				  vo.setNo(rs.getInt(1));
				  vo.setId(rs.getString(2));
				  vo.setName(rs.getString(3));
				  vo.setSubject(rs.getString(4));
				  vo.setContent(rs.getString(5));
				  vo.setRegdate(rs.getDate(6));
				  vo.setHit(rs.getInt(7));
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
		  // 답변
		  public void qnaReplyInsert(QnaboardVO vo)
		  {
			  try
				{
					getConnection();
					String sql="INSERT INTO project_boardReply(no,id,name,subject,content,pwd,group_id,group_step,group_tab) "
							+ "VALUES((SELECT NVL(MAX(no)+1,1) FROM qnaBoard),?,?,?,?,?,"
							+ "?,1,1)";
					ps=conn.prepareStatement(sql);
					ps.setString(1, vo.getId());
					ps.setString(2, vo.getName());
					ps.setString(3, vo.getSubject());
					ps.setString(4, vo.getContent());
					ps.setString(5, vo.getPwd());
					ps.setInt(6, vo.getGroup_id());
					
					ps.executeUpdate();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				finally
				{
					disConnection();
				}
		  }
		  
		  // 답변 등록 확인
			public boolean boardReplyCheck(int no)
			{
				boolean bCheck=false;
				try
				{
					getConnection();
					String sql="SELECT COUNT(group_id) FROM qnaBoard "
							+ "WHERE group_id=(SELECT group_id FROM qnaBoard WHERE no=?)";
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
		  
		  // 수정(비밀번호 확인 필요 = boolean)
		  /*
		   *    라이브러리 메소드: Callback이 있는 경우도 있다
		   *    Callback메소드 => 시스템에 의해서 자동으로 호출되는 메소드
		   *       main(), doGet(), doPost()
		   *    사용자정의 메소드: Callback이 없다 => 반드시 호출 후에 사용
		   */
		  public boolean qnaUpdate(QnaboardVO vo)
		  {
			  boolean bCheck=false;
			  try
			  {
				  // 1. 연결
				  getConnection();
				  // 2. sql 문장
				  // 2-1. 비밀번호 검색
				  String sql="SELECT pwd FROM qnaBoard "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  //?에 값 채운다
				  ps.setInt(1, vo.getNo());
				  // 결과값을 갖고온다
				  ResultSet rs=ps.executeQuery();
				  rs.next();
				  String db_pwd=rs.getString(1);
				  rs.close();
				  // 본인 여부 확인
				  if(db_pwd.equals(vo.getPwd()))
				  {
					  bCheck=true;
					  // 수정하기
					  sql="UPDATE qnaBoard SET "
					  	+ "id=?,subject=?,content=? "
					  	+ "WHERE no=?";
					  ps=conn.prepareStatement(sql);
					  // ?에 값 채운다
					  ps.setString(1, vo.getId());
					  ps.setString(2, vo.getSubject());
					  ps.setString(3, vo.getContent());
					  ps.setInt(4, vo.getNo());
					  // 실행요청
					  ps.executeUpdate();
				  }
				  else
				  {
					  bCheck=false;
				  }
			
				 // 2-2. 실제 수정 
			  }catch(Exception ex) {
				  // 오류 체크
				  ex.printStackTrace();
			  }
			  finally
			  {
				  disConnection();
			  }
			  return bCheck;
		  }
		  
		  // 삭제 => SQL문장:4개
		  /*
		   *   1. 비밀번호 체크
		   *   2. 비밀번호가 맞는 경우: true
		   *      = depth: 0 => DELETE
		   *      = depth> 0 => UPDATE
		   *      = depth 1개 감소
		   *      틀린 경우: back
		   */
		  public boolean qnaDelete(int no,String pwd)
		  {
			  boolean bCheck=false;
			  try
			  {
				  getConnection();
				  conn.setAutoCommit(false);
				  // 처리
				  // 1. 비밀번호
				  String sql="SELECT pwd FROM qnaBoard "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, no);
				  ResultSet rs=ps.executeQuery();
				  rs.next();
				  String db_pwd=rs.getString(1);
				  rs.close();
				  
				  if(db_pwd.equals(pwd)) {
					  bCheck=true;
					  sql="SELECT group_step,group_tab FROM qnaBoard "
					  		+ "WHERE no=?";
					  ps=conn.prepareStatement(sql);
					  ps.setInt(1, no);
					  rs=ps.executeQuery();
					  rs.next();
					  int group_step=rs.getInt(1);
					  int group_tab=rs.getInt(2);
					  rs.close();
					  
					  if(group_tab==0)   // 댓글이 없는 상태
					  {
						  sql="DELETE FROM qnaBoard "
						  		+ "WHERE no=?";
						  ps=conn.prepareStatement(sql);
						  ps.setInt(1, no);
						  ps.executeUpdate();
					  }
					  else   // 댓글이 있는 상태
					  {
						  String msg="삭제된 게시물입니다";
						  sql="UPDATE qnaBoard Set "
						  		+ "subject=?,content=? "
						  		+ "WHERE no=?";
						  ps=conn.prepareStatement(sql);
						  ps.setString(1, msg);
						  ps.setString(2, msg);
						  ps.setInt(3, no);
						  
						  ps.executeUpdate();
					  }
					  sql="UPDATE qnaBoard SET "
					  		+ "group_tab=group_tab-1 "
					  		+ "WHERE no=?";
					  ps=conn.prepareStatement(sql);
					  ps.setInt(1, group_step);
					  ps.executeUpdate();
				  }
				  else {
					  bCheck=false;
				  }
				  conn.commit();
			  }catch(Exception ex) {
				  try {
					  conn.rollback();
				  }catch(Exception e) {}
				  ex.printStackTrace();
			  }
			  finally
			  {
				  try
				  {
					  conn.setAutoCommit(true);
				  }catch(Exception ex) {}
				  // 종료
				  disConnection();
			  }
			  return bCheck;
		  }
}