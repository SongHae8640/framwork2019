package com.bit.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/*
 * WebContainer�� �����ǰ� �Ҹ�ɶ� ���� �ߵ�
 * �غ�, ������ ������ ���
 * 
 * ServletContextEvent�� ���ؼ� ���� ����
 * 
 * */
@WebListener
public class MyListener implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("MyListener :: contextDestroyed()... ");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("MyListener :: contextInitialized()... ");
	}

}
