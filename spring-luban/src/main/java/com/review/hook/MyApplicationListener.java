package com.review.hook;

import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {


	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("监听到事件"+ event.getSource().toString());
	}
}
