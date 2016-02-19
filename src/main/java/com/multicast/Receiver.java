package com.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by tancw on 2016/2/19.
 */
public class Receiver {
    public static void main(String[] args) {
        MulticastSocket s;
        InetAddress group;

        try {
            group = InetAddress.getByName("229.0.0.1");
            s = new MulticastSocket(3456);
            s.setTimeToLive(1);
            s.joinGroup(group);
            byte[] buf = new byte[200];
            DatagramPacket packet = new DatagramPacket(buf,buf.length);
            s.receive(packet);
            System.out.println(new String(buf));
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
