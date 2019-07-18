package com.bit.action;

import com.bit.model.Struts04Dao;
import com.opensymphony.xwork2.Action;

public class InsertAction implements Action {
	private String sub,name,content;
	

	public void setSub(String sub) {
		this.sub = sub;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		if(new Struts04Dao().insertOne(sub,name,content) ==-1){
			return this.SUCCESS;
		}else{
			return this.SUCCESS;
		}
		
		
	}

}
