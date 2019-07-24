package com.bit.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.model.entity.Bbs02Vo;


/*
 * 각 테스트 케이스는 순서가 정해져 있지 않음
 * 	어노테이션 before , after 를 통해서 시작과 끝 메서드를 설정해 줄 수 있음
 * 	어노테이션 beforeClass :  Test 클래스에서는 생성자를 사용하지 않기 때문에 그 기능을 위해 사용. 반드시 static이여야 한다
 * 	beforeClass와 반대의 기능
 * 
 * */
public class Bbs02DaoTest {
	Bbs02Dao dao;
//	static Bbs02Dao dao;
	
	
	//before after는 모든 함수의 시작전 , 호출 후
	//beforeClass, afterClass는 Test클래스의 생성 직후, 종로 직전
	@Before
	public void setUP() throws SQLException{
		System.out.println("Bbs02DaoTest :: before()");
		dao = new Bbs02Dao();	//
	}
	
	@After
	public void tearDown(){
		System.out.println("Bbs02DaoTest :: after()");
	}
	
	@BeforeClass
	public static void setUPClass() throws SQLException{
		System.out.println("Bbs02DaoTest :: beforeClass()");
//		dao = new Bbs02Dao();	//하나의 객체를 돌려쓰게 된다.
	}
	
	@AfterClass
	public static void tearDownClass(){
		System.out.println("Bbs02DaoTest :: AfterClass()");
	}
	
//	@Test
//	public void testGetConnection(){
//		System.out.println("Bbs02DaoTest :: testGetConnection()");
//		try {
//			Connection conn = dao.getConnection();
//			Assert.assertNotNull(conn);	//null이 아니면 성공
//		} catch (SQLException e) {
//			Assert.assertTrue(false);
//		}
////		Assert.assertNull(conn);	//null이면 성공
////		Assert.assertEquals("1", "1");	//같으면 성공(equals메서드)
////		Assert.assertSame("1", "1");	//같으면 성공(==)
////		Assert.assertNotSame(1, 2);	//같지 않으면 성공
////		Assert.assertTrue(true);	//true이면 성공
////		Assert.assertFalse(false);	//false이면 성공
//		
//	}
	
//	@Test
	public void testInsertOne() throws SQLException{
		System.out.println("Bbs02DaoTest :: testInsertOne()");
		Bbs02Dao dao = new Bbs02Dao();
		Bbs02Vo bean = new Bbs02Vo();
		bean.setName("tester");
		bean.setSub("test title");
		bean.setContent("test content");
		
		Assert.assertSame(1, dao.insertOnde(bean));	// (예상치, 결과)

	}
	@Test
	public void testSelectAll() throws SQLException{
		Assert.assertNotNull(dao.selectAll("test"));
		Assert.assertTrue(dao.selectAll("test").size()>0);
//		Assert.assertSame(1, dao.selectAll("test").size());
	} 

}
