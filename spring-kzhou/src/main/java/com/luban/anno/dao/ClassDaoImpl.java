package com.luban.anno.dao;

import org.springframework.stereotype.Component;

@Component
public class ClassDaoImpl implements ClassDao {
	@Override
	public void query() {
		System.out.println("ClassDaoImpl");
	}
}
