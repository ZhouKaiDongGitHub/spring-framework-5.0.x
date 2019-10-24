package com.luban.anno.dao;


import com.luban.anno.annotation.SQLAnnotation;

public interface UserDao {
	@SQLAnnotation("SELECT * FROM USER;")
	public String queryUser();
}
