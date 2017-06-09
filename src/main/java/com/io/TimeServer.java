package com.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tancw on 2017/6/7.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 10000);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                pool.execute(new TimeserverHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
