package com.luban.anno.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TargetProgrome {

	public void query(){
		System.out.println("-----TargetProgrome---");
	}

}
