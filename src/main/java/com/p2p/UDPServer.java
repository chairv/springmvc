package com.p2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by tancw on 2016/9/27.
 */
public class UDPServer {

	public static void main(String[] args) {
		try {
			DatagramSocket server = new DatagramSocket(2008);
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			InetAddress address = null;
			for (;;) {
				System.out.println("start");
				server.receive(packet);
				String receiveMessage = new String(packet.getData(), 0, packet.getLength());
				System.out.println(receiveMessage);
				String sendMsg = String.format("host:s%,port%s", address.getHostAddress(), packet.getPort());
				System.out.println("端口信息" + sendMsg);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void send(String message, int port, InetAddress adress, DatagramSocket server) {
		try {
			byte[] sendBuf = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, adress, port);
			server.send(sendPacket);
			System.out.println("消息发送成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
