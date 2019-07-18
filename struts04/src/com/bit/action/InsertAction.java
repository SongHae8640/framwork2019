package com.bit.action;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertAction implements Action, ModelDriven<Struts04Dto> {
	//bean 객체가 만들어져 있어야 함( ModelDriven할 대상이 있어야 하기 때문에)
	private Struts04Dto bean;
	
	public Struts04Dto getBean() {
		return bean;
	}


	@Override
	public String execute() throws Exception {	
		System.out.println(bean.toString());
//		new Struts04Dao().insertOne(bean);
		
		return this.SUCCESS;
	}


	@Override
	public Struts04Dto getModel() {
		//필터로 작용 > bean을 넘겨 준다.
		return bean;
	}

}
