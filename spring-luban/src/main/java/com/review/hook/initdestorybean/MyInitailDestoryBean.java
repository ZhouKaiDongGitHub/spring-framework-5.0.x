package com.review.hook.initdestorybean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyInitailDestoryBean implements InitializingBean, DisposableBean {

	@Override
	public void destroy() throws Exception {
		//数据库链接池关闭
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//数据库连接池开启
	}
}
