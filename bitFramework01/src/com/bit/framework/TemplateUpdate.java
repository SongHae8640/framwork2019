package com.bit.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TemplateUpdate {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver ="oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "scott";
	private String password = "tiger";
	
	public Connection getConnection(){
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
	
	public int executeUpdate(String sql, Object[] objs) throws SQLException{
		try {
			getConnection();
			pstmt= conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return -1;
			
	}
	
	public void closeAll() throws SQLException{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
	}
}
