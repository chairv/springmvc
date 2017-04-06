package com.syn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by tancw on 2017/4/1.
 */
public class ExecutorWebServer {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            try {
                final Socket connection = socket.accept();
                System.out.println("begin");
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(connection);
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    System.out.println("task submission rejected");
                }
            }
        }
    }

    private void handleRequest(Socket connection) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(connection.getInetAddress());
    }
}
