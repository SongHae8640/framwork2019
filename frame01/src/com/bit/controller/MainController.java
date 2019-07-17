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
//		//context-param에서 선언했기 때문에 사용가능
//		System.out.println("MainController :: contextParam.numMsg="+this.getServletContext().getInitParameter("numMsg"));		
//		
//		//two servlet에서 선언했기 때문에 사용 불가
//		System.out.println("MainController :: servlet msg="+getInitParameter("msg"));
		
		//log4j를 통한 log 찍기
//		 BasicConfigurator.configure();
		
		 logger.trace("trace : 확인");
	     logger.debug("debug : 개발자 모드");
	     logger.info("debug : 정보 제공");
	     logger.warn("warn : 주의 고지");
	     logger.error("error : 에러");
	     logger.fatal("fatal : 치명적 문제");
	     
	     //log4j.properties에서 설정한 값에 따라 실행
	     //설정한 값의 하위 내용이 실행 
	     //ex) log4j.logger.com.bit.controller=warn  는 warn , error, fatal
	     
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}

/*
 FaTAL : 가장 크리티컬한 에러가 일어 났을 때 사용합니다.
 ERROR : 일반 에러가 일어 났을 때 사용합니다.
 WARN : 에러는 아니지만 주의할 필요가 있을 때 사용합니다.
 INFO : 일반 정보를 나타낼 때 사용합니다.
 DEbUG : 일반 정보를 상세히 나타낼 때 사용합니다.

%p  debug, info, warn, error, fatal 등의 priority 가 출력된다.  
%m  로그내용이 출력됩니다 
%d  로깅 이벤트가 발생한 시간을 기록합니다.
  포맷은 %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}같은 형태로 사용하며 SimpleDateFormat에 따른 포맷팅을 하면 된다 
%%  % 표시를 출력하기 위해 사용한다.  
%n  플랫폼 종속적인 개행문자가 출력된다. \r\n 또는 \n 일것이다.  
%c  카테고리를 표시합니다 
  예) 카테고리가 a.b.c 처럼 되어있다면 %c{2}는 b.c가 출력됩니다. 
%C  클래스명을 포시합니다. 
  예)클래스구조가 org.apache.xyz.SomeClass 처럼 되어있다면 %C{2}는 xyz.SomeClass 가 출력됩니다 
%F  로깅이 발생한 프로그램 파일명을 나타냅니다. 
%l  로깅이 발생한 caller의 정보를 나타냅니다 
%L  로깅이 발생한 caller의 라인수를 나타냅니다 
%M  로깅이 발생한 method 이름을 나타냅니다. 
%r  어플리케이션 시작 이후 부터 로깅이 발생한 시점의 시간(milliseconds) 
%x  로깅이 발생한 thread와 관련된 NDC(nested diagnostic context)를 출력합니다. 
%X  로깅이 발생한 thread와 관련된 MDC(mapped diagnostic context)를 출력합니다. 
*/
