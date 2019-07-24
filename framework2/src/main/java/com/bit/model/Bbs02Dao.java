package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.JdbcTemplate;
import com.bit.model.entity.Bbs02Vo;

import oracle.jdbc.pool.OracleDataSource;

public class Bbs02Dao {
	DataSource dataSource;
	
	public Bbs02Dao() throws SQLException{
		//DataSource를 이용한 설정
		//DataSource는 중간에 바뀌면 안되기 때문에 setter가 없다.
		OracleDataSource oracle = new OracleDataSource();
		oracle.setDriverType("oracle.jdbc.OracleDriver");
		oracle.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		oracle.setUser("scott");
		oracle.setPassword("tiger");
		dataSource = oracle;
	}
	
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	

	
	public int insertOnde(Bbs02Vo bean) throws SQLException{
		String sql = "INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,?,?,?,SYSDATE)";
		Object[] params = {bean.getName(), bean.getSub(), bean.getContent()};
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.executeUpdate(sql, params);
	}
	
	public List selectAll(String keyword) throws SQLException{
		String sql = "SELECT * FROM bbs02 WHERE sub like ? ORDER BY num DESC";
		List list = new ArrayList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Bbs02Vo bean = new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				list.add(bean);
			}
			
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return list;
	}


}
