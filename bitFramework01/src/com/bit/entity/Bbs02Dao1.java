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
	
	public void closeAll() throws SQLException{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
	}
	
	public List getList() throws SQLException{
		String sql = "SELECT num, name, sub, nalja FROM bbs02";
		List list = new ArrayList();
		
		
		try {
			getConnection();
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
			closeAll();
		}
		
		
		return list;
	}

	public int insertOne(String name, String sub, String content) throws SQLException {
		String sql = "INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,?,?,?,SYSDATE)";
		int result = -1;
		
		try {
			getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sub);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return result;
	}

	public Bbs02Vo selectOne(int num) throws SQLException {
		String sql = "SELECT * FROm bbs02 WHERE num = ?";
		Bbs02Vo bean = new Bbs02Vo();
		
		try {
			getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				bean.setName(rs.getString("name"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				
				return bean;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return null;
	}
	
	public int updateOne(Bbs02Vo bean) throws SQLException{
		int result = -1;
		String sql = "UPDATE bbs02 SET sub=? , content=? WHERE num=?";
		
		try {
			getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSub());
			pstmt.setString(2, bean.getContent());
			pstmt.setInt(3, bean.getNum());
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
	
	public int updateOne(int num) throws SQLException{
		int result = -1;
		String sql = "DELETE FROM bbs02 WHERE num=?";
		
		try {
			getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}


}
