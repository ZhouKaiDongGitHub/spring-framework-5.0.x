package com.luban.anno.dao;

import org.springframework.stereotype.Component;

@Component
public class StudentDaoImpl implements StudentDao {
	@Override
	public void query() {
		System.out.println("StudentDaoImpl");
	}
}
