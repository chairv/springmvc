package com.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmi.IHello;

/**
 * Created by tancw on 2016/9/29.
 */
public class HelloClient {

	public static void main(String[] args) {
		try {
			IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");
			System.out.println(rhello.helloWorld());
			System.out.println(rhello.sayHelloToSomeBody("熔岩"));
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
