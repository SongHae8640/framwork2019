package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IndexController implements Controller {
	
	//front controller pattern������ container�� init �ɶ� �����ȴ�. 
	//���Ŀ��� �̹� ����� controller�� �����
	public IndexController(){
		System.out.println("new IndexController");
	}

	public String execute(HttpServletRequest req) throws SQLException{
		req.setAttribute("msg","ȯ���մϴ�.");
		return "index";
	}

}
