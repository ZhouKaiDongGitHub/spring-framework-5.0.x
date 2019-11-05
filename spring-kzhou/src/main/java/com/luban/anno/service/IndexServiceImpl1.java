package com.luban.anno.service;

import com.luban.anno.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl1 implements  IndexService {

	@Autowired
	private IndexDao indexDao;


	@Value("test")
	private String test;

	@Override
	public String getNameById(String id) {
		return indexDao.query(id);
	}


	public void setTest(String test) {
		this.test = test;
	}
}
