package com.bit.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.Controller;
import com.bit.controller.IndexController;
import com.bit.controller.ListController;
import com.bit.controller.MainController;

/*
 * struts에서 filter에서 사용하던것과 같은 기능
 * */
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//한글 처리
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req,resp);
	}
	
	//doGet, doPost 방식 모두 처리하기
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doDo 호출");
		
		String viewName ="";
		Controller controller = null;
		
		//url 받기
		String root = req.getContextPath();	
		String path = req.getRequestURI().substring(root.length());
		System.out.println("path = "+path);
		
		//controller 이동
		if(path.equals("/index.bit")){
			controller = new IndexController();
		}else if(path.equals("/main.bit")){
			controller = new MainController();
		}else if(path.equals("/list.bit")){
			controller = new ListController();
		}
		
		viewName ="/WEB-INF/view/"+ controller.execute(req)+".jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
}
