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

public class IngreRecipeDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static IngreRecipeDAO dao;
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
	   public static IngreRecipeDAO newInstance()
	   {
		   if(dao==null)
			   dao=new IngreRecipeDAO();
		   
		   return dao;
	   }
	   
	   //입력된 식재료로 레시피 찾기
	   public List<ListVO> ingreSearchRecipe(List<String> slist){
		   List<ListVO> list=new ArrayList<ListVO>();
		   try {
			   getConnection();
			  /* String sql="SELECT detail_data_v3.no, list_data_v5.poster, list_data_v5.title, list_data_v5.chef_poster, "
			   		+ "list_data_v5.chef, list_data_v5.link, list_data_v5.hit, rownum "
			   		+ "FROM detail_data_v3, list_data_v5 "
			   		+ "WHERE detail_data_v3.ingre LIKE '%'||?||'%' ";*/
			   String sql="SELECT no, poster, title, chef_poster, chef, link, hit, rownum "
			   		+ "FROM listdata_with_ingre "
			   		+ "WHERE ingre LIKE  '%'||?||'%' ";
			   int size=slist.size();
			   System.out.println("slist_size: "+size);
			   if(size>0) {
				   for(int i=2; i<=size; i++) {
					   sql+="AND ingre LIKE '%'||?||'%' ";
				   }
			   }
			   sql+= "AND rownum<=10";
			   sql+= "ORDER BY hit DESC";
			   System.out.println(sql);
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, slist.get(0));
			   
			   if(size>0) {
				   for(int i=2; i<=size; i++) {
					   ps.setString(i, slist.get(i-1));
				   }
			   }
			   
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				  ListVO vo=new ListVO();
				  vo.setNo(rs.getInt(1));
				  vo.setPoster(rs.getString(2));
				  vo.setTitle(rs.getString(3));
				  vo.setChef_poster(rs.getString(4));
				  vo.setChef(rs.getString(5));
				  vo.setLink(rs.getString(6));
				  vo.setHit(rs.getInt(7));
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
