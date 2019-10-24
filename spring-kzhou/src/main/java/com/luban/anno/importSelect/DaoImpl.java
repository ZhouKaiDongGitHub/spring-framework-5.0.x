package com.luban.anno.importSelect;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements Dao {
	@Override
	public void query() {
		System.out.println("DaoImpl");
	}
}
