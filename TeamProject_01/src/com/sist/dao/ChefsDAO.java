package com.sist.dao;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

import com.sist.vo.*;

public class ChefsDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static ChefsDAO dao;
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
	public static ChefsDAO newInstance() {
		if(dao==null)
			dao=new ChefsDAO();
		return dao;
	}
	
	public List<ChefsVO> chefsListData(int page){
		List<ChefsVO> list=new ArrayList<ChefsVO>();
		try {
			getConnection();
			/*
			 * 	private int id, ranking;
				private String chef_name, chef_img, cooking_count, cooking_clip, hit, follower;
			 */ 
			
			String sql="SELECT ranking, chef_name, chef_img, cooking_count, cooking_clip, hit, follower, num "
					+ "FROM (SELECT ranking, chef_name, chef_img, cooking_count, cooking_clip, hit, follower, rownum AS num "
					+ "FROM (SELECT ranking, chef_name, chef_img, cooking_count, cooking_clip, hit, follower "
					+ "FROM chefs ORDER BY ranking ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			
			ps=conn.prepareStatement(sql);
			
			int rowSize=20;
			int start=(page*rowSize)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end); 
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ChefsVO vo=new ChefsVO();
				vo.setRanking(rs.getInt(1));
				vo.setChef_name(rs.getString(2));
				vo.setChef_img(rs.getString(3));
				vo.setCooking_count(rs.getString(4));
				vo.setCooking_clip(rs.getString(5));
				vo.setHit(rs.getString(6));
				vo.setFollower(rs.getString(7));
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
	
	// chef 총 인원
	public int chefsCount()
	{
		int count=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM chefs";
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
	
}