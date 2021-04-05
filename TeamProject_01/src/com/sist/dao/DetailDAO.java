package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.*;

public class DetailDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static DetailDAO dao;
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
	public static DetailDAO newInstance() {
		if(dao==null)
			dao=new DetailDAO();
		return dao;
	}
	
	//목록 불러오기 - 0402 수정
		public DetailVO detailData(int no) {
			DetailVO vo=new DetailVO();
			/*
			 * private int no, hit2;
				private String title, poster, chef, chef_poster, info, info1, info2, info3, ingre,
				content_poster, liked, regdate, chef_msg, content;
			 */
			try {
				getConnection();
				String sql="SELECT no,title,poster,chef,chef_poster,info,info1,info2,info3,ingre,content_poster,liked, "
						+ "regdate,chef_msg,content "
						+ "FROM detail_data_v3 "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ResultSet rs=ps.executeQuery();
				rs.next();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setChef(rs.getString(4));
				vo.setChef_poster(rs.getString(5));
				vo.setInfo(rs.getString(6));
				vo.setInfo1(rs.getString(7));
				vo.setInfo2(rs.getString(8));
				vo.setInfo3(rs.getString(9));
				vo.setIngre(rs.getString(10));
				vo.setContent_poster(rs.getString(11));
				vo.setLiked(rs.getString(12));
				vo.setRegdate(rs.getString(13));
				vo.setChef_msg(rs.getString(14));
				vo.setContent(rs.getString(15));
				rs.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				disConnection();
			}
			return vo;
		}
		
		
	//쿠키 데이터 전송 -레시피속도 개선시도(04/04)
	public List<DetailVO> detailCookie(List<Integer> list) { 
		 List<DetailVO> cList=new ArrayList<DetailVO>();
		try {
			getConnection();
			int k=1;
			
			for(int i=0; i<list.size();i++) {
			String sql="SELECT no,poster,title "
					+ "FROM list_data_v5 "
					+ "WHere no=?";
					
			ps=conn.prepareStatement(sql);
			ps.setInt(1, list.get(i));
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DetailVO vo=new DetailVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
				cList.add(vo);
			}
			rs.close();
			k++;
			if(k==7)	//쿠키 가져올 개수+1 
				return cList;
			}//for
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return cList;
	}
}