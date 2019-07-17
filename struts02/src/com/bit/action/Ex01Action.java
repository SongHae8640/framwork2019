package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

/*
 * Action이 MVC 모델에서 Controller의 역할을 한다.
 * 현재의 문제점이 3가지가 있다.
 * 문제점 1. Controller가 excute를 통해 실행 되더라도 인자가 없다.
 * 문제점 2. 받아온 정보를 처리하더라도 보낼 방법을 모른다.
 * 문제점 3. return 자료형으로 String을 사용하는데 이 정보가 View로 가는 것이 아니다.
 */


public class Ex01Action implements Action {
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		log.debug("호출");
		return "success";
	}

}
