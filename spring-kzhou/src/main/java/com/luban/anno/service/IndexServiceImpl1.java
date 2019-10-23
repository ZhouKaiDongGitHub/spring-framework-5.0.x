package com.luban.service;

import com.luban.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl1 implements  IndexService {

	@Autowired
	private IndexDao indexDao;
	@Override
	public String getNameById(String id) {
		return indexDao.query(id);
	}

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
}
