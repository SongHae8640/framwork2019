package com.bit.model.entity;

import java.sql.Date;

public class Struts04Dto {
	private int num;
	private String sub, name, content;
	private Date nalja;
	
	public Struts04Dto() {
		
	}


	public Struts04Dto(int num, String sub, String name, String content,
			Date nalja) {
		this.num = num;
		this.sub = sub;
		this.name = name;
		this.content = content;
		this.nalja = nalja;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	
	

}
