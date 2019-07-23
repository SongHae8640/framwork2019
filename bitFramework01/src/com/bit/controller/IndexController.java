package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IndexController implements Controller {
	
	//front controller pattern에서는 container가 init 될때 생성된다. 
	//이후에는 이미 생헝된 controller를 사용함
	public IndexController(){
		System.out.println("new IndexController");
	}

	public String execute(HttpServletRequest req) throws SQLException{
		req.setAttribute("msg","환영합니다.");
		return "index";
	}

}
