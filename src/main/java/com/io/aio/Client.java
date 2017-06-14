package com.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by tancw on 2017/6/13.
 */
public class Client {
    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 8013));
            future.get();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            client.read(buffer, null, new CompletionHandler<Integer, Void>() {
                @Override
                public void completed(Integer result, Void attachment) {
                    System.out.println("client received: " + new String(buffer.array()));
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    exc.printStackTrace();
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}