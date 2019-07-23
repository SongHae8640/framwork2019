package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.entity.Bbs02Dao1;
import com.bit.framework.Controller;

public class ListController implements Controller {
	public String execute(HttpServletRequest req) throws SQLException{
		Bbs02Dao1 dao = new Bbs02Dao1();
		req.setAttribute("aList", dao.getList());
		return "bbs/list";
	}

}
