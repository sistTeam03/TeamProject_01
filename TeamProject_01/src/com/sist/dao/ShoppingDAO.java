package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.ListVO;
import com.sist.vo.ShoppingVO;
import com.sist.vo.UserCartVO;

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
	
	public int listCount() {
		int count=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM shop_table";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return count;
	}
	
	public int listTotalPage() {
		int total=0;
		try {
			getConnection();

			String sql="SELECT CEIL(COUNT(*)/20.0) FROm shop_table";

			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return total;
	}
	
	public List<ShoppingVO> listAllData(int page){
		List<ShoppingVO> list=new ArrayList<ShoppingVO>();
		try {
			getConnection();
			String sql="SELECT no,title,price,poster,num "
					+ "FROM (SELECT no,title,price,poster,rownum as num "
					+ "FROM (SELECT no,title,price,poster FROM shop_table "
					+ "ORDER BY no ASC)) "
					+ "WHERE no between ? and ?";
			ps=conn.prepareStatement(sql);
			int rowSize=20;
			int start=1+(page-1)*rowSize;
			int end=page*rowSize;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ShoppingVO vo=new ShoppingVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setPoster(rs.getString(4));
				list.add(vo);
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
		
	}
	
	//장바구니 입력
	public void insertCart(int ino, String id) {
		try {
			getConnection();
			String sql="INSERT INTO user_cart VALUES("
					+ "?,uc_no_seq.nextVal,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setInt(2, ino);
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//장바구니 목록
	public List<UserCartVO> cartList(String id){
		List<UserCartVO> list=new ArrayList<UserCartVO>();
		try {
			getConnection();
			String sql="SELECT no, ino FROM user_cart "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserCartVO vo=new UserCartVO();
				vo.setId(id);
				vo.setNo(rs.getInt(1));
				vo.setIno(rs.getInt(2));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	//장바구니 삭제
	public void cartDelete(int no, String id) {
		try {
			getConnection();
			String sql="DELETE user_cart WHERE ino=? AND id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, id);
			ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}
