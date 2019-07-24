package com.bit.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class Bbs02DaoTest {
	@Test
	public void testGetConnection() throws SQLException{
		Bbs02Dao dao = new Bbs02Dao();
		Connection conn = dao.getConnection();
		Assert.assertNotNull(conn);
	}

}
