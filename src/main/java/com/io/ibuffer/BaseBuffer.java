package com.io.ibuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tancw on 2017/6/9.
 */
public class BaseBuffer {
    public static void main(String[] args) {
        CharBuffer cb = CharBuffer.allocate(1024);
        ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024);

        int[] bytes = new int[1024];
        IntBuffer ib = IntBuffer.wrap(bytes);

        try {
            FileChannel fc = new RandomAccessFile("test.data", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
