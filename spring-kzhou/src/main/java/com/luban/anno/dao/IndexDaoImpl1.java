package com.luban.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl1 implements  IndexDao {
	@Override
	public String query(String id) {
		return "IndexDaoImpl1";
	}
}
