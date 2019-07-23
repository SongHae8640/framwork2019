package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	public String execute(HttpServletRequest req);
}
