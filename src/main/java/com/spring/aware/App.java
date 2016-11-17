package com.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by tancw on 2016/11/17.
 */
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		context.close();
	}
}
