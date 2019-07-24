package com.bit.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcTemplate {
	DataSource dataSource;
	
	public JdbcTemplate(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public int executeUpdate(String sql, Object[] objs) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally{
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		}
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
