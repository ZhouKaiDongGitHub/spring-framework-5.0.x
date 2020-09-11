package com.luban.initializer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class IndexController {


	@RequestMapping("/index")
	public void handleRequest(){

	}

	@PostConstruct
	public void  test(){
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
	}
}
