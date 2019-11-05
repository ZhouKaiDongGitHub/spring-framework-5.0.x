package com.luban.anno.service;

import com.luban.anno.dao.ClassDao;
import com.luban.anno.dao.IndexDao;
import com.luban.anno.dao.StudentDao;
import com.luban.anno.proxyConfiguration.OrderDao;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl {

	private StudentDao studentDao;
	private ClassDao classDao;
	private OrderDao orderDao;
	/*public StudentServiceImpl(){

	}*/
	/*public StudentServiceImpl(StudentDao studentDao){
		this.studentDao = studentDao;
	}*/

	public StudentServiceImpl(StudentDao s ,ClassDao classDao,OrderDao orderDao){
		this.studentDao = s;
		this.classDao = classDao;
		this.orderDao = orderDao;
	}
	public void print(){
		studentDao.query();
		classDao.query();
		orderDao.queryOrder();
	}

}
