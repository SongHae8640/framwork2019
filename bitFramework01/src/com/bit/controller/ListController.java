package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

public class ListController implements Controller {
	public String execute(HttpServletRequest req){
		return "bbs/list";
	}

}
