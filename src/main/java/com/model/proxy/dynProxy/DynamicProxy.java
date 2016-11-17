package com.model.proxy.dynProxy;

/**
 * Created by tancw on 2016/10/25.
 */
public class DynamicProxy {
	public static void main(String[] args) {
		MyProxy myProxy = new MyProxy();
		HoseeDynamicImpl dynamic = new HoseeDynamicImpl();
		HoseeDynamic proxy = (HoseeDynamic) myProxy.bind(dynamic);
		System.out.println(proxy.sayHi());
	}
}
