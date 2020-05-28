package com.review.spring.extention.impl6;

import org.springframework.beans.factory.annotation.Value;

public class Test2 {

	@Value("test2")
	private String attribute1;

	public void printAttribute1(){
		System.out.println(attribute1);
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
}
