package com.bit.model;

import java.sql.Date;

public class Bbs02Vo {
	private int num;
	private String name,sub,content;
	private Date nalja;
	
	public Bbs02Vo(){
		
	}
	
	
	//getter&setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
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
	
	
	//toString - test��
	@Override
	public String toString() {
		return "Bbs02Vo [num=" + num + ", name=" + name + ", sub=" + sub
				+ ", content=" + content + ", nalja=" + nalja + "]";
	}
}
