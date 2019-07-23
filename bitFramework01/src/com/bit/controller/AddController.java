package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class AddController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		return "bbs/add";
	}

}
