package com.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by tancw on 2016/2/19.
 */
public class Send {
	public static void main(String[] args) {
		MulticastSocket s;
		InetAddress group;
//		if (args.length != 1) {
//			System.out.println("需要命令行参数");
//			return;
//		}

		try {
			group = InetAddress.getByName("229.0.0.1");
			s = new MulticastSocket(3456);
			s.setTimeToLive(1);
			String msg = "hello world!";
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
			s.send(packet);
			System.out.println("发送成功");
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
