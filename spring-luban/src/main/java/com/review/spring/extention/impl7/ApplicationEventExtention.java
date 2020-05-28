package com.review.spring.extention.impl7;

import org.springframework.context.ApplicationEvent;

public class ApplicationEventExtention extends ApplicationEvent {
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public ApplicationEventExtention(Object source) {
		super(source);
	}
}
