package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bit.framework.JdbcTemplate;
import com.bit.model.entity.Bbs02Vo;

public class Bbs02Dao2 {
	public List getList() throws SQLException{
		String sql = "SELECT * FROM bbs02 ORDER BY num DESC";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean = new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				return bean;
			}
		};
		
		return template.executeQuery(sql);
	}
	
	public Bbs02Vo getOne(int num) throws SQLException{
		String sql = "SELECT * FROM bbs02 WHERE num=?";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean = new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setContent(rs.getString("content"));
				return bean;
			}
		};
		
		return (Bbs02Vo) template.queryForObject(sql, new Object[]{num});
	}
	
	public int addOne(Bbs02Vo bean) throws SQLException{
		String sql = "INSERT INTO bbs02 VALUES (bbs02_num_seq.nextval,?,?,?,SYSDATE)";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				return null;
			}
		};
		
		return template.executeUpdate(sql, new Object[]{bean.getName(), bean.getSub(), bean.getContent()});
	}
	
	public int delOne(int num) throws SQLException{
		String sql = "DELETE FROM bbs02 WHERE num=?";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				return null;
			}
		};	
		return template.executeUpdate(sql, new Object[]{num});
	
	}

}
