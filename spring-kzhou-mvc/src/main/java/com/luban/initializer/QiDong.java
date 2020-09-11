package com.luban.initializer;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class QiDong {

	public static void main(String[] args) {
		try {
			LubanSpringApplication.run();
		} catch (LifecycleException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
