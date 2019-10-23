package com.luban.xml.dao;

public class IndexDaoImpl1 implements IndexDao {
	@Override
	public void query() {
		System.out.println("IndexDaoImpl1:query");
	}

	@Override
	public void delete() {
		System.out.println("IndexDaoImpl1:delete");
	}
}
