package com.luban.factoryBean;

/**
 * 第三方类
 */
public class ThirdPart {
	private String property1;
	private String property2;
	private String property3;

	public ThirdPart(String property1, String property2, String property3) {
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
	}

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public String getProperty3() {
		return property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}
}
