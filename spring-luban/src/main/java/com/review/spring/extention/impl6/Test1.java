package com.review.spring.extention.impl6;

import org.springframework.beans.factory.annotation.Value;

public class Test1 {

	@Value("test1")
	private String attribute1;

	public void printAttribute1(){
		System.out.println(attribute1);
	}
}
