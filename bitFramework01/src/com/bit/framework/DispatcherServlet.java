package com.bit.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.IndexController;

/*
 * struts���� filter���� ����ϴ��Ͱ� ���� ���
 * */
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�ѱ� ó��
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req,resp);
	}
	
	//doGet, doPost ��� ��� ó���ϱ�
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doDo ȣ��");
		
		String viewName ="";
		
		//context �ޱ�
		String root = req.getContextPath();
		System.out.println("getContextPath = "+root);
		
		//url �ޱ�
		String path = req.getRequestURI().substring(root.length());
		System.out.println("path = "+path);
		
		if(path.equals("/index.bit")){
			IndexController controller = new IndexController();
			viewName = controller.execute(req);
		}
		
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
}
