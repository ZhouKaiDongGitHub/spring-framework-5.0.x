package com.luban.xml.service;

import com.luban.xml.dao.IndexDao;

public class IndexServiceImpl2 extends IndexServiceImpl1 {


	@Override
	public void delete() {
		//super.getDao().delete();
		System.out.println("IndexServiceImpl2:delete");
	}

}
