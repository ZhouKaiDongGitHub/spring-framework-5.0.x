package com.review.spring.extention.impl7;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerExtention implements ApplicationListener<ApplicationEventExtention> {

	@Override
	public void onApplicationEvent(ApplicationEventExtention event) {
		if(event.getSource() instanceof ApplicationSourceExtention){
			ApplicationSourceExtention applicationSourceExtention = (ApplicationSourceExtention)event.getSource();
			System.out.println("监听到气候变化：");
			System.out.println(applicationSourceExtention.getTemp()+" "+applicationSourceExtention.getShidu()+" "+applicationSourceExtention.getQiya());

		}

	}
}
