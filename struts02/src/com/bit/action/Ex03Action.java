package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class Ex03Action implements Action {
	Logger log = Logger.getLogger(this.getClass());
	String id;
	
	//����ȯ�� ���� ������ �� ����. intercepter.Parametersinterceptor Ŭ�������� ����
	//���ͼ��͸� ���ؼ� �Ķ���� ����ȯ�� ó���ϴ� ���͸� �߰��� ����
	//before���� set000���� �ѹ�, view�� �����ϸ鼭 get000���� �ѹ� �ؼ� �� 2�� ��ġ�� ��
	int num;	
	
	public void setId(String id){
		this.id = id;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public int getNum() {
		return num;
	}

	@Override
	public String execute() throws Exception {
		log.debug("param : " +id);
		log.debug("param : "+ (num+1));
		
		return this.SUCCESS;
	}

}
