package com.luban.xml.service;

import com.luban.xml.dao.IndexDao;

public class IndexServiceImpl1 implements IndexService {

	private IndexDao dao;

	/*public IndexDao getDao() {
		return dao;
	}*/

	@Override
	public void query() {
		dao.query();
		System.out.println("IndexServiceImpl1:query");
	}

	@Override
	public void delete() {
		dao.delete();
		System.out.println("IndexServiceImpl1:delete");
	}

	public void setDao(IndexDao dao) {
		this.dao = dao;
	}
}
