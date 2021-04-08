package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.ShoppingVO;

import java.util.*;

public class ShoppingDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static ShoppingDAO dao;
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
	public static ShoppingDAO newInstance() {
		if(dao==null)
			dao=new ShoppingDAO();
		return dao;
	}
	
	public List<ShoppingVO> shopListData(){
		List<ShoppingVO> list=new ArrayList<ShoppingVO>();
		try {
			getConnection();
			String sql="SELECT no, title, price, poster "
					+ "FROM shop_table";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ShoppingVO vo=new ShoppingVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setPoster(rs.getString(4));
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
	
	public String ingreToString(int no){
		String result="";
		try {
			getConnection();
			String sql="SELECT ingre FROM detail_data_v3 "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			result=rs.getString(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return result;
	}
}
