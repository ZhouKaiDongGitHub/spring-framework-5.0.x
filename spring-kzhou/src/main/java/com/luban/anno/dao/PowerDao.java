package com.luban.anno.dao;


import com.luban.anno.annotation.SQLAnnotation;

public interface PowerDao {
	@SQLAnnotation("SELECT * FROM POWER;")
	public String queryPower();
}
