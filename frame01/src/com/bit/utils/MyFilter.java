package com.bit.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/main.do")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter :: destroy()");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter :: before doFilter()");
		chain.doFilter(req, resp);
		System.out.println("MyFilter :: after doFilter()");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter :: init()");

	}

}
