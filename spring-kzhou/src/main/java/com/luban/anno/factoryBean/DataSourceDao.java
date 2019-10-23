package com.luban.factoryBean;

/**
 * 依赖第三方，此第三方bean不需要Spring管理
 * 里面有无数的配置信息
 */
public class DataSourceDao {
	private String property1;
	private String property2;
	private String property3;
	private String property4;
	private String property5;

	private ThirdPart thirdPart;

	public DataSourceDao(String property1, String property2, String property3, String property4, String property5, ThirdPart thirdPart) {
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
		this.property4 = property4;
		this.property5 = property5;
		this.thirdPart = thirdPart;
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

	public String getProperty4() {
		return property4;
	}

	public void setProperty4(String property4) {
		this.property4 = property4;
	}

	public String getProperty5() {
		return property5;
	}

	public void setProperty5(String property5) {
		this.property5 = property5;
	}

	public ThirdPart getThirdPart() {
		return thirdPart;
	}

	public void setThirdPart(ThirdPart thirdPart) {
		this.thirdPart = thirdPart;
	}
}
