package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IndexController implements Controller {

	public String execute(HttpServletRequest req) throws SQLException{
		req.setAttribute("msg","ȯ���մϴ�.");
		return "index";
	}

}
