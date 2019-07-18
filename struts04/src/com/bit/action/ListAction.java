package com.bit.action;

import java.util.List;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private List<Struts04Dto> list;
	
	public List<Struts04Dto> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		list = new Struts04Dao().getList();
		
		return this.SUCCESS;
	}

}
