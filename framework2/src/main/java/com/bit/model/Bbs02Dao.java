package com.bit.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

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
		oracle.setPassword("1234");
		dataSource = oracle;
	}
	
	public Bbs02Dao(DataSource dataSource){
		this.dataSource = dataSource;
		
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}


}
