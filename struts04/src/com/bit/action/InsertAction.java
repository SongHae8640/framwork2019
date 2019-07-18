package com.bit.action;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertAction implements Action, ModelDriven<Struts04Dto>,Preparable {
	//bean ��ü�� ������� �־�� ��( ModelDriven�� ����� �־�� �ϱ� ������)
	private Struts04Dto bean;
	
	public Struts04Dto getBean() {
		return bean;
	}


	@Override
	public String execute() throws Exception {	
		System.out.println(bean.toString());
		new Struts04Dao().insertOne(bean);
		
		return this.SUCCESS;
	}


	@Override
	public Struts04Dto getModel() {
		//���ͷ� �ۿ� > bean�� �Ѱ� �ش�.
		return bean;
	}


	@Override
	public void prepare() throws Exception {
		bean = new Struts04Dto();
	}
	

}
