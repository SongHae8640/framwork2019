package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Struts03Dao {
	Connection conn;
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user ="scott";
	private String password = "tiger";
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Connection getConnection(){
		try {
			if(conn==null|| conn.isClosed()){
				Class.forName(driver);
				conn= DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<Struts03Dto> getList(){
		ArrayList<Struts03Dto> list = new ArrayList<Struts03Dto>();
		String sql = "SELECT num, sub FROM struts03 ORDER BY num DESC";
		try(Connection conn = getConnection()){
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				Struts03Dto bean = new Struts03Dto();
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				list.add(bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
