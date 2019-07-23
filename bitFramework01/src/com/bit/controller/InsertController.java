package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.Bbs02Dao1;
import com.bit.model.Bbs02Dao2;
import com.bit.model.entity.Bbs02Vo;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		Bbs02Vo bean = new Bbs02Vo();
		bean.setSub(req.getParameter("sub"));
		bean.setName(req.getParameter("name"));
		bean.setContent(req.getParameter("content"));
		
		Bbs02Dao2 dao = new Bbs02Dao2();
		
		dao.addOne(bean);
		return "redirect:/list.bit";
	}

}
