package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.framework.TemplateQuery;
import com.bit.framework.TemplateUpdate;
import com.bit.model.entity.Bbs02Vo;

public class Bbs02Dao1 {
	
	public List getList() throws SQLException{
		String sql = "SELECT num, name, sub, nalja FROM bbs02 ";
		TemplateQuery template = new TemplateQuery(){
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean =new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));		
				return bean;		
			}
			
		};
		return template.executeQuery(sql, new Object[]{});	//길이가 없는 배열이라도 줘야 함
	}

	public Bbs02Vo selectOne(int num) throws SQLException {
		String sql = "SELECT * FROM bbs02 WHERE num = ?";
		TemplateQuery template = new TemplateQuery() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean =new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));	
				bean.setContent(rs.getString("content"));
				return bean;	
			}
		};
		
		return (Bbs02Vo) template.executeQuery(sql, new Object[]{num}).get(0);
	}

	public int insertOne(String name, String sub, String content) throws SQLException {
		String sql = "INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,?,?,?,SYSDATE)";
		TemplateUpdate template = new TemplateUpdate();
		return template.executeUpdate(sql, new Object[]{name,sub,content});
	}
	public int updateOne(Bbs02Vo bean) throws SQLException{
		String sql = "UPDATE bbs02 SET sub=? , content=? WHERE num=?";
		TemplateUpdate template = new TemplateUpdate();
		return template.executeUpdate(sql, new Object[]{bean.getSub(),bean.getContent(),bean.getNum()});
	}
	
	public int deleteOne(int num) throws SQLException{
		String sql = "DELETE FROM bbs02 WHERE num=?";
		TemplateUpdate template = new TemplateUpdate();
		return template.executeUpdate(sql, new Object[]{num});
	}


	
	


}
