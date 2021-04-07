package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.ListVO;
import com.sist.vo.RecomVO;

public class RecommendDAO {
	 private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static RecommendDAO dao;
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
	   public static RecommendDAO newInstance()
	   {
		   if(dao==null)
			   dao=new RecommendDAO();
		   
		   return dao;
			   
	   }
	   
	   public List<ListVO> userRandomList(){
		   List<ListVO> list=new ArrayList<ListVO>();
		   try {
			getConnection();
			String sql="SELECT no,title,poster,num "
					+ "FROM(SELECT no,title,poster,rownum as num "
					+ "FROm(SELECT no,title,poster FROM list_data_v5 where no<=10000 order by dbms_random.value)) "
					+ "WHERE num between 1 and 15";
			ps=conn.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ListVO vo=new ListVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		   
		   return list;
	   }
	   
	   //저장
	   
	   public int recomInsertData(String box,String id) {
		   int result=0;
		   try {
			getConnection();
			String sql="SELECT COUNT(*) FROM recomm "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			if(count==50) {
				result=1;
			}else {
				sql="insert into recomm values("
						+ "(SELECT NVL(MAX(no)+1,1) From recomm),?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, box);
				ps.executeUpdate();
			}
				
		
					
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		   return result;
		   
	   }
}//class
