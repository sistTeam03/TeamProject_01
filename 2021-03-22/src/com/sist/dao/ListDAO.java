package com.sist.dao;
import java.sql.*;
import java.util.*;
public class ListDAO {
	private Connection conn;
	private PreparedStatement ps;
	//private final String URL="jdbc:oracle:thin:@211.238.142.200:1521:XE";
	
	public ListDAO() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr2","happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void insertList(ListVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO list_test VALUES("
					+ "list_no_seq.nextval,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getPoster());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getChef_poster());
			ps.setString(4, vo.getChef());
			ps.setInt(5, vo.getRating());
			ps.setInt(6, vo.getCount_review());
			ps.setString(7, vo.getLink());
			ps.setString(8, vo.getHit());
			
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}//class
