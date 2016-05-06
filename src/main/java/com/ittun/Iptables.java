package com.ittun;

import java.io.*;

/**
 * Created by tancw on 2016/4/16.
 */
public class Iptables {
	public static void main(String[] args) throws IOException {
		String ip = "192.168.42.18";
		String ipstr = "-A PREROUTING -p tcp -m tcp --dport %d -j DNAT --to-destination " + ip + ":%d";
		int i = 50000;
		StringBuffer sb = new StringBuffer();
		for (; i < 60000; i++) {
			String result = String.format(ipstr, i, i);
			sb.append(result).append("\n");
		}
		FileWriter fw = new FileWriter("D:/iptables.txt");
		try {
			fw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			fw.flush();
			fw.close();
		}

//		System.out.println(sb.toString());
	}
}
