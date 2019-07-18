package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.entity.Struts04Dto;

public class Struts04Dao {
	
	private String driver ="oracle.jdbc.OracleDriver";
	private Connection conn;
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user ="scott";
	private String password ="tiger";
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public Struts04Dao() {
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close(){
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Struts04Dto> getList() {
		List<Struts04Dto> list = new ArrayList<Struts04Dto>();
		String sql = "SELECT * FROM SCOTT.STRUTS04 ORDER BY num DESC";
		
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Struts04Dto(
						rs.getInt("num"), 
						rs.getString("sub"), 
						rs.getString("name"),
						rs.getString("content"),
						rs.getDate("nalja")
						)
				);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close();
		}
		return list;
	}


	public int insertOne(String sub, String name, String content) {
		String sql = "INSERT INTO struts04(num, sub, name, content,nalja) "
				+ "VALUES(struts04_seq.nextval,?,?,?,SYSDATE)";
		int result =-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return result;
	}
}
