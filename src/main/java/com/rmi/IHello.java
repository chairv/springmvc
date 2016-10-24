package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tancw on 2016/9/29.
 */
public interface IHello extends Remote {
	public String helloWorld() throws RemoteException;

	public String sayHelloToSomeBody(String someBodyName) throws RemoteException;
}
