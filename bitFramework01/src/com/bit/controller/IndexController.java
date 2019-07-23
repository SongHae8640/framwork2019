package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

public class IndexController implements Controller {

	public String execute(HttpServletRequest req) {
		req.setAttribute("msg","환영합니다.");
		return "index";
	}

}
