package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	public String execute(HttpServletRequest req) throws SQLException;
}
