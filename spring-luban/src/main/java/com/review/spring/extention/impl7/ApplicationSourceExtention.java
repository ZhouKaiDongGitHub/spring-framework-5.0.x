package com.review.spring.extention.impl7;

public class ApplicationSourceExtention{
	private String temp;
	private String shidu;
	private String qiya;

	public ApplicationSourceExtention(){}

	public ApplicationSourceExtention(String temp, String shidu, String qiya) {
		this.temp = temp;
		this.shidu = shidu;
		this.qiya = qiya;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getShidu() {
		return shidu;
	}

	public void setShidu(String shidu) {
		this.shidu = shidu;
	}

	public String getQiya() {
		return qiya;
	}

	public void setQiya(String qiya) {
		this.qiya = qiya;
	}
}
