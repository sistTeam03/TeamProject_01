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
			String sql="SELECT no, title, poster "
					+ "FROM list_data_v4 "
					+ "ORDER BY hit DESC";
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
	
	
}
