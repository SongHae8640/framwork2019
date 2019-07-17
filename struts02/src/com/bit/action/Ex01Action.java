package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

/*
 * Action�� MVC �𵨿��� Controller�� ������ �Ѵ�.
 * ������ �������� 3������ �ִ�.
 * ������ 1. Controller�� excute�� ���� ���� �Ǵ��� ���ڰ� ����.
 * ������ 2. �޾ƿ� ������ ó���ϴ��� ���� ����� �𸥴�.
 * ������ 3. return �ڷ������� String�� ����ϴµ� �� ������ View�� ���� ���� �ƴϴ�.
 */


public class Ex01Action implements Action {
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		log.debug("ȣ��");
		return "success";
	}

}
