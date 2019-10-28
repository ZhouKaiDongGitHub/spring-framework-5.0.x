package com.luban.anno.proxyConfiguration;

public class Test  {
	public static void main(String[] args) {
		CostDaoImplCglib cglib = new CostDaoImplCglib();
		try {
			CostDaoImpl costDao = (CostDaoImpl) cglib.getInstance(new CostDaoImpl().getClass());
			costDao.queryCost();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
