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
		Assert.assertNotNull(conn);	//null이 아니면 성공
		Assert.assertNull(conn);	//null이면 성공
		Assert.assertEquals("1", "1");	//같으면 성공(equals메서드)
		Assert.assertSame("1", "1");	//같으면 성공(==)
		Assert.assertNotSame(1, 2);	//같지 않으면 성공
		Assert.assertTrue(true);	//true이면 성공
		Assert.assertFalse(false);	//false이면 성공
		
	}

}
