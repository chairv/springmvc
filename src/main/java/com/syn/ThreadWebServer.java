package com.syn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tancw on 2017/4/1.
 */
public class ThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(connection.getInetAddress());
    }
}
