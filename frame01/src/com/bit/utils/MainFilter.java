package com.bit.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/next.do")
public class MainFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MainFilter :: destroy()");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//servlet, controller 없이 바로 매핑 가능 
		System.out.println("MainFilter :: doFilter()");
		req.getRequestDispatcher("main.jsp").forward(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MainFilter :: init()");

	}

}
