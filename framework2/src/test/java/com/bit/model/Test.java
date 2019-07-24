package com.bit.model;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args){
		
		try {
			Bbs02Dao dao = new Bbs02Dao();
			Connection conn = dao.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
