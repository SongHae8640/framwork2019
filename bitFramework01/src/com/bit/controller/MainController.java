package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class MainController implements Controller  {
	
	public String execute(HttpServletRequest req) throws SQLException{
		return "main";
	}

}
