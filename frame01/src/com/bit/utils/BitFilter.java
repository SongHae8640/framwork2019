package com.bit.utils;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter(
//		value="/bit.do",
//		initParams={
//			@WebInitParam(name="strMsg" , value="xyz")
//		}
//)
public class BitFilter implements Filter {

	String msg;
	@Override
	public void destroy() {
		System.out.println("BitFilter :: destroy()...");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("BitFilter :: before doFilter()...");
		System.out.println("BitFilter :: doFilter() - init param="+msg);
		chain.doFilter(req, resp);
		System.out.println("BitFilter :: after doFilter()...");
		

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	//filter가 container에 실릴때 같이
		
		System.out.println("BitFilter :: init()...");
//		Enumeration<String> names = config.getInitParameterNames();
//		while (names.hasMoreElements()) {
//			System.out.println("BitFilter :: init() - ename="+(String) names.nextElement());
//			
//		}
		msg = config.getInitParameter("strMsg");

	}

}
