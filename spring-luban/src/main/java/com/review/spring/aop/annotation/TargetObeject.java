package com.review.spring.aop.annotation;

public class TargetObeject {

	public String  queryUserName(String id){
		if(id == "1"){
			System.out.println("查詢id=1 值為 kzhou");
			return "kzhou";
		}
		return "xiaoming";
	}
}
