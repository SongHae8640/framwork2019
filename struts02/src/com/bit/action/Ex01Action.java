package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

/*
 * Action이 MVC 모델에서 Controller의 역할을 한다.
 * 현재의 문제점이 3가지가 있다.
 * 문제점 1. Controller가 excute를 통해 실행 되더라도 인자가 없다.
 * 문제점 2. 받아온 정보를 처리하더라도 보낼 방법을 모른다.
 * 문제점 3. return 자료형으로 String을 사용하는데 이 정보가 View로 가는 것이 아니다.
 *	-> result의 name값
 *		아무 String이나 다 되는게 아니라 몇가지 정해진 String을 사용. 
 *			error, input, login, none, success( Actino에 정의되어 있기 때문에 this.을 통해서도 접근 가능)
 */


public class Ex01Action implements Action {
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		log.debug("호출");
		
//		return "input";
		return this.INPUT;
	}

}
