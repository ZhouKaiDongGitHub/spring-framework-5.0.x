package com.luban.aop.demo.autowired;

public class XMLAutowiredA {

	private String attribute1;
	private String attribute2;
	private String attribute3;

	public XMLAutowiredA(){

	}

	public XMLAutowiredA(String attribute1, String attribute2, String attribute3) {
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
	}

	public XMLAutowiredA(String attribute1) {
		this.attribute1 = attribute1;
	}
}
