package com.bit.framework;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * struts���� filter���� ����ϴ��Ͱ� ���� ���
 * */
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�ѱ� ó��
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
	
	//doGet, doPost ��� ��� ó���ϱ�
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("doDo ȣ��");
		
		String viewName ="";
		String prefix = "/WEB-INF/view/";
		String suffix = ".jsp";
		com.bit.controller.Controller controller = null;
		
		//url �ޱ�
		String root = req.getContextPath();	
		String path = req.getRequestURI().substring(root.length());
		System.out.println("path = "+path);
		
		//controller �̵�
		if(path.equals("/index.bit")){
			controller = new com.bit.controller.IndexController();
		}else if(path.equals("/main.bit")){
			controller = new com.bit.controller.MainController();
		}else if(path.equals("/list.bit")){
			controller = new com.bit.controller.ListController();
		}else if(path.equals("/add.bit")){
			controller = new com.bit.controller.AddController();
		}else if(path.equals("/insert.bit")){
			controller = new com.bit.controller.InsertController();
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
