package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

public class MainController implements Controller  {
	
	public String execute(HttpServletRequest req){
		return "main";
	}

}
