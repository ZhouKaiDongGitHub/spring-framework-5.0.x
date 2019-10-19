package com.luban.service;

import com.luban.dao.IndexDao;

public class IndexServiceImpl1 implements  IndexService {

	private IndexDao indexDao;
	@Override
	public String getNameById(String id) {
		return indexDao.query(id);
	}

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
}
