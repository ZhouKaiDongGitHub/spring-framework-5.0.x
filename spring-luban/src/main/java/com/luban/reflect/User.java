package com.luban.reflect;

public class User {

	private String passward;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name:"+name+"  Passward:"+passward;
	}
}
