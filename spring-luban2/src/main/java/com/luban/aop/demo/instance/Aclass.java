package com.luban.aop.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Aclass {

	private Bclass bclass;
	private Cclass cclass;

	//@Autowired
	public Aclass(Bclass bclass){
		this.bclass = bclass;
	}

	@Autowired
	public Aclass(Bclass bclass,Cclass cclass){
		this.bclass = bclass;
		this.cclass = cclass;
	}
	//@Autowired
	public Aclass(){};
}
