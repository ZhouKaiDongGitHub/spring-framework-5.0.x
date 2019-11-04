package com.luban.service;

import com.luban.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexServiceImpl1 implements IndexService {

	@Autowired
	private IndexDao indexDaoImpl2;
	private String name;

	public IndexServiceImpl1(){

	}
	public IndexServiceImpl1(IndexDao indexDao,String name){
		this.indexDaoImpl2 = indexDao;
		this.name = name;
	}
	@Override
	public void query() {
		System.out.println("IndexServiceImpl1");
	}

}
