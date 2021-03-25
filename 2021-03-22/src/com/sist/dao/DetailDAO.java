package com.sist.dao;
import java.sql.*;
import java.util.*;
public class DetailDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.200:1521:XE";
	
	public DetailDAO() {
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
	public List<DetailVO> linkList() {
		List<DetailVO> list=new ArrayList<DetailVO>();
		try {
			getConnection();
			String sql="SELECT no,link FROM list_data "
					+ "ORDER BY no ASC ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				DetailVO vo=new DetailVO();
				vo.setNo(rs.getInt(1));
				vo.setLiked(rs.getString(2));
				list.add(vo);
				
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();

		}
		return list;
	}		
	public void insertList(DetailVO vo) {
		
		try {
			getConnection();
			String sql="INSERT INTO detail_data VALUES("
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getPoster());
			ps.setString(4, vo.getChef());
			ps.setString(5, vo.getChef_poster());
			ps.setString(6, vo.getInfo());
			ps.setString(7, vo.getInfo1());
			ps.setString(8, vo.getInfo2());
			ps.setString(9, vo.getInfo3());
			ps.setString(10, vo.getIngre());
			
			ps.setString(11, vo.getContent_poster());
			
			ps.setString(12, vo.getHit());
			ps.setString(13, vo.getLiked());
			ps.setString(14, vo.getRegdate());
			ps.setString(15, vo.getChef_msg());
			
			ps.setString(16, vo.getContent());
			 
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}//class		
		