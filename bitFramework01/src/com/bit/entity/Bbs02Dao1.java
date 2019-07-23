package com.bit.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.Bbs02Vo;

public class Bbs02Dao1 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver ="oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "scott";
	private String password = "tiger";
	
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			if(conn==null || conn.isClosed()){
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public List getList() throws SQLException{
		String sql = "SELECT num, name, sub, nalja FROM bbs02";
		List list = new ArrayList();
		
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Bbs02Vo bean =new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				list.add(bean);
				
			}
		}finally{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		}
		
		
		return list;
	}

	public int insertOne(String name, String sub, String content) throws SQLException {
		String sql = "INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,?,?,?,SYSDATE)";
		int result = -1;
		
		try {
			Connection conn= getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sub);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		}
		
		return result;
	}


}
