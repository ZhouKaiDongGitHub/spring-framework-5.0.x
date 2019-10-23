package com.luban.anno.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 弥补Spring bean全部依赖配置的局限性
 */
public class DataSourceFactoryBean implements FactoryBean {

	DataSourceDao dataSourceDao;
	@Override
	public Object getObject() throws Exception {
		dataSourceDao = new DataSourceDao("parm1","parm2","parm3","parm4","parm5",
				new ThirdPart("parm1","parm2","parm3"));
		return dataSourceDao;
	}

	@Override
	public Class<?> getObjectType() {
		return dataSourceDao.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void print(){
		System.out.println(this.getClass());
		System.out.println(getObjectType());
	}
}
