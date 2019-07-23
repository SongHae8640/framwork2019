package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * struts���� filter���� ����ϴ��Ͱ� ���� ���
 * */
public class DispatcherServlet extends HttpServlet {
	Map<String, Controller> map = new HashMap<String, Controller>();
	
	//mapping ������ init���� ����
	//container�� �����ɶ� �ѹ��� 
	public void init() throws ServletException {
		//properties ���Ϸ� �б�
		//���� ���Ŀ� ���� ���� ���� ��ο��� ���� �Ұ� > class�� �ε� ��ġ�� ã�� ����
		Properties prop = new Properties();
		Class<? extends DispatcherServlet> clz = getClass();
		ClassLoader loader = clz.getClassLoader();	//����� ��ü ������ ����
		InputStream is = loader.getResourceAsStream("bit.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set keys = prop.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String clInfo = prop.getProperty(key);
			HandlerMapping.setMap(key, clInfo);
		}
		

	};
	
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
		
		//url �ޱ�
		String root = req.getContextPath();	
		String path = req.getRequestURI().substring(root.length());
		System.out.println("path = "+path);
		
		//handle mapping
		Controller controller = null;
		controller = HandlerMapping.getController(path);		
		
		String viewName =null;
		
		try {
			viewName =controller.execute(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//viewResolver
		String prefix = "/WEB-INF/view/";
		String suffix = ".jsp";
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{
			viewName =prefix + viewName + suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
		
		
		
	}
}
