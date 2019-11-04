package com.luban.dao;

import org.springframework.stereotype.Component;

@Component
public class IndexDaoImpl2 implements  IndexDao {
	@Override
	public void query() {
		System.out.println("IndexDaoImpl2");
	}
}
