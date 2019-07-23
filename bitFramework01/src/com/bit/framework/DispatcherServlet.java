package com.bit.framework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.Controller;


/*
 * struts에서 filter에서 사용하던것과 같은 기능
 * */
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//한글 처리
		req.setCharacterEncoding("utf-8");
		try {
			doDo(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doDo(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//doGet, doPost 방식 모두 처리하기
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("doDo 호출");
		
		//url 받기
		String root = req.getContextPath();	
		String path = req.getRequestURI().substring(root.length());
		System.out.println("path = "+path);
		
		//handle mapping
		String viewName ="";
		String prefix = "/WEB-INF/view/";
		String suffix = ".jsp";
		com.bit.controller.Controller controller = null;
		String clInfo ="";
		Map<String, String> map = new HashMap<String, String>();
		map.put("/index.bit", "com.bit.controller.IndexController");
		map.put("/main.bit", "com.bit.controller.MainController");
		map.put("/list.bit", "com.bit.controller.ListController");
		map.put("/add.bit", "com.bit.controller.AddController");
		map.put("/insert.bit", "com.bit.controller.InsertController");
		
		
		
		
		clInfo = map.get(path);
		
		try {
			Class clazz = Class.forName(clInfo);
			controller = (Controller) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewName =controller.execute(req);
		
		//viewResolver
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{
			viewName =prefix + viewName + suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
		
		
		
	}
}
