package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

public class IndexController {

	public String execute(HttpServletRequest req) {
		req.setAttribute("msg","ȯ���մϴ�.");
		return "index.jsp";
	}

}
