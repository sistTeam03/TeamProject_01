package com.sist.dao;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

import com.sist.vo.ListVO;

import java.util.*;
public class ListDAO {

	private Connection conn;
	private PreparedStatement ps;
	
	private static ListDAO dao;
	
	public void getConnection()
	{
		try
		{
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
		
	}
	public static ListDAO newInstance()
	{
		if(dao==null)
			dao=new ListDAO();
		
		return dao;
	}
	public List<ListVO> recipeListData()
	{
		List<ListVO> list = new ArrayList<ListVO>();
		try
		{
			getConnection();
			String sql="SELECT no, title, poster,rownum "
					+ "FROM (SELECT no, title, poster from list_data_v5 "
					+ "ORDER BY hit DESC) "
					+ "WHERE rownum<=8";
			ps=conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ListVO vo = new ListVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
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
	//리스트 출력
	public List<ListVO> listAllData(int page){
		List<ListVO> list=new ArrayList<ListVO>();
		try {
			getConnection();
			String sql="SELECT no,poster,title,chef_poster,chef,hit,num "
					+ "FROM (SELECT no,poster,title,chef_poster,chef,hit,rownum as num "
					+ "FROM (SELECT no,poster,title,chef_poster,chef,hit FROM list_data_v5 "
					+ "ORDER BY no ASC)) "
					+ "WHERE num between ? and ?";
			ps=conn.prepareStatement(sql);
			int rowSize=20;
			int start=1+(page-1)*rowSize;
			int end=page*rowSize;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ListVO vo=new ListVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setChef_poster(rs.getString(4));
				vo.setChef(rs.getString(5));
				vo.setHit(rs.getInt(6));
				list.add(vo);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
		
	}
	public int listTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) FROm list_data_v5";
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return total;
	}
	
}
