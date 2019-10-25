package com.luban.anno.proxyConfiguration;

public class OrderDaoImpl implements OrderDao{

	public OrderDaoImpl(){
		System.out.println("construct OrderDaoImpl");
	}

	@Override
	public void queryOrder() {
		System.out.println("OrderDaoImpl");
	}
}
