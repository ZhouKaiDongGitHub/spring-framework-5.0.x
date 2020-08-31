package com.luban.aop.demo.factory.method;

public class UserService {

	public static Object query(){
		return new Luban();
	}
}
