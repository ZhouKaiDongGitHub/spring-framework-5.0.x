package com.luban.aop.demo.autowired;

public class XMLAutowiredB {

	private XMLAutowiredA xmlAutowiredA;

	public void getA(){
		System.out.println(xmlAutowiredA);
	}

	public XMLAutowiredA getXmlAutowiredA() {
		return xmlAutowiredA;
	}

	public void setXmlAutowiredA(XMLAutowiredA xmlAutowiredA) {
		this.xmlAutowiredA = xmlAutowiredA;
	}
}
