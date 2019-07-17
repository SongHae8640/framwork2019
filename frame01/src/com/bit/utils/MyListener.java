package com.bit.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/*
 * WebContainer가 생성되고 소멸될때 각각 발동
 * 준비, 마무리 시점에 사용
 * 
 * ServletContextEvent를 통해서 인자 가능
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
