package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//@WebServlet(
//		value="/main.do", 
//		initParams={
//				@WebInitParam(name="msg",value="abcd")
//		}
//)
@WebServlet("/")
public class MainController extends HttpServlet {
	// Define a static logger variable so that it references the
	static Logger logger = Logger.getLogger(MainController.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("MainController :: doGet() servlet...");
//		
//		//context-param���� �����߱� ������ ��밡��
//		System.out.println("MainController :: contextParam.numMsg="+this.getServletContext().getInitParameter("numMsg"));		
//		
//		//two servlet���� �����߱� ������ ��� �Ұ�
//		System.out.println("MainController :: servlet msg="+getInitParameter("msg"));
		
		//log4j�� ���� log ���
//		 BasicConfigurator.configure();
		
		 logger.trace("trace : Ȯ��");
	     logger.debug("debug : ������ ���");
	     logger.info("debug : ���� ����");
	     logger.warn("warn : ���� ����");
	     logger.error("error : ����");
	     logger.fatal("fatal : ġ���� ����");
	     
	     //log4j.properties���� ������ ���� ���� ����
	     //������ ���� ���� ������ ���� 
	     //ex) log4j.logger.com.bit.controller=warn  �� warn , error, fatal
	     
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}

/*
 FaTAL : ���� ũ��Ƽ���� ������ �Ͼ� ���� �� ����մϴ�.
 ERROR : �Ϲ� ������ �Ͼ� ���� �� ����մϴ�.
 WARN : ������ �ƴ����� ������ �ʿ䰡 ���� �� ����մϴ�.
 INFO : �Ϲ� ������ ��Ÿ�� �� ����մϴ�.
 DEbUG : �Ϲ� ������ ���� ��Ÿ�� �� ����մϴ�.

%p  debug, info, warn, error, fatal ���� priority �� ��µȴ�.  
%m  �α׳����� ��µ˴ϴ� 
%d  �α� �̺�Ʈ�� �߻��� �ð��� ����մϴ�.
  ������ %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}���� ���·� ����ϸ� SimpleDateFormat�� ���� �������� �ϸ� �ȴ� 
%%  % ǥ�ø� ����ϱ� ���� ����Ѵ�.  
%n  �÷��� �������� ���๮�ڰ� ��µȴ�. \r\n �Ǵ� \n �ϰ��̴�.  
%c  ī�װ��� ǥ���մϴ� 
  ��) ī�װ��� a.b.c ó�� �Ǿ��ִٸ� %c{2}�� b.c�� ��µ˴ϴ�. 
%C  Ŭ�������� �����մϴ�. 
  ��)Ŭ���������� org.apache.xyz.SomeClass ó�� �Ǿ��ִٸ� %C{2}�� xyz.SomeClass �� ��µ˴ϴ� 
%F  �α��� �߻��� ���α׷� ���ϸ��� ��Ÿ���ϴ�. 
%l  �α��� �߻��� caller�� ������ ��Ÿ���ϴ� 
%L  �α��� �߻��� caller�� ���μ��� ��Ÿ���ϴ� 
%M  �α��� �߻��� method �̸��� ��Ÿ���ϴ�. 
%r  ���ø����̼� ���� ���� ���� �α��� �߻��� ������ �ð�(milliseconds) 
%x  �α��� �߻��� thread�� ���õ� NDC(nested diagnostic context)�� ����մϴ�. 
%X  �α��� �߻��� thread�� ���õ� MDC(mapped diagnostic context)�� ����մϴ�. 
*/
