package com.luban.anno.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl1 implements  IndexDao {

	@Value("test")
	private String test;

	@Override
	public String query(String id) {
		return "IndexDaoImpl1";
	}

	public void setTest(String test) {
		this.test = test;
	}
}
