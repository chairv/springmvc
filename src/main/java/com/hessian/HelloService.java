package com.hessian;

/**
 * Created by tancw on 2015/12/1.
 */
public class HelloService implements Hello {
	public String sayHello(String name) {
		System.out.println("Welcome you, " + name);
		return "Welcome you, " + name + "!";
	}
}
