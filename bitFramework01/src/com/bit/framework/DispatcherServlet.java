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
 * struts에서 filter에서 사용하던것과 같은 기능
 * */
public class DispatcherServlet extends HttpServlet {
	Map<String, Controller> map = new HashMap<String, Controller>();
	
	//mapping 관리를 init에서 선언
	//container가 생성될때 한번만 
	public void init() throws ServletException {
		//properties 파일로 읽기
		//배포 이후에 읽을 때는 절대 경로에서 접근 불가 > class의 로딩 위치를 찾기 위해
		Properties prop = new Properties();
		Class<? extends DispatcherServlet> clz = getClass();
		ClassLoader loader = clz.getClassLoader();	//실행시 객체 정보를 담음
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
		
		//url 받기
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
