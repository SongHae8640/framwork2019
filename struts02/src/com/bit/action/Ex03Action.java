package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class Ex03Action implements Action {
	Logger log = Logger.getLogger(this.getClass());
	String id;
	
	//형변환한 값을 가져올 수 있음. intercepter.Parametersinterceptor 클래스에서 해줌
	//인터셉터를 통해서 파라미터 형변환을 처리하는 필터를 중간에 넣음
	//before에서 set000으로 한번, view로 위임하면서 get000으로 한번 해서 총 2번 거치게 됨
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
