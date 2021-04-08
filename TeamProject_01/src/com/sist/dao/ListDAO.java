package com.sist.dao;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

import com.sist.vo.*;

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
	//메인페이지 리스트
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
	public List<ListVO> listAllData(int page,int sort){
		List<ListVO> list=new ArrayList<ListVO>();
		try {
			getConnection();
			if(sort==0) {
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
			}else if(sort==1){
				String sql="SELECT no,poster,title,chef_poster,chef,hit,num "
						+ "FROM (SELECT no,poster,title,chef_poster,chef,hit,rownum as num "
						+ "FROM (SELECT no,poster,title,chef_poster,chef,hit FROM LIST_DATA_V5_DSORT "
						+ "ORDER BY regdate DESC)) "
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
	
	//0406추가
		//레시피 갯수 
		public int listCount() {
			int count=0;
			try {
				getConnection();
				String sql="SELECT COUNT(*) FROM list_data_v5";
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
	
	// 쉐프의 레시피
	public List<ListVO> chefsRecipeList(String no)
	{
//		List<ChefsVO> clist=new ArrayList<ChefsVO>();
		List<ListVO> list=new ArrayList<ListVO>();
		try {
			getConnection();
//			String sql="SELECT no,d.poster,d.title,d.chef_poster,d.chef,c.chef_name,d.hit "
//					+ "FROM list_data_v5 d INNER JOIN chefs c "
//					+ "ON c.chef_name=d.chef "
//					+ "ORDER BY d.hit;";
			String sql="SELECT * FROM list_data_v5 "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, no);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ListVO vo=new ListVO();
				//ChefsVO cvo=new ChefsVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setChef_poster(rs.getString(4));
				vo.setChef(rs.getString(5));
				//cvo.setChef_name(rs.getString(6));
				vo.setHit(rs.getInt(6));
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
	//검색용 리스트
	public List<ListVO> searchList(List<String> sList,int page){
		List<ListVO> list=new ArrayList<ListVO>();
		try {
			getConnection();
			int size=sList.size();
			for(int i=0;i<size;i++) {
				String sql="SELECT no,poster,title,chef_poster,chef,hit,num "
						+ "FROM(no,poster,title,chef_poster,chef,hit,rownum as num "
						+ "FROM(no,poster,title,chef_poster,chef,hit FROM list_data_v5 WHERE title like '%'||?||'%' order by no asc)) "
						+"WHERE num between ? and ?";	
				ps=conn.prepareStatement(sql);
				ps.setString(1, sList.get(0));
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
}
