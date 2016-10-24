package com.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.IHello;

/**
 * Created by tancw on 2016/9/29.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

	public HelloImpl() throws RemoteException {
	}

	@Override
	public String helloWorld() throws RemoteException {
		return "Hello World";
	}

	@Override
	public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
		return "你好," + someBodyName + "!";
	}
}
