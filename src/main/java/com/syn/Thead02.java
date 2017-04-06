package com.syn;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tancw on 2017/4/1.
 */
public class Thead02 {
    private final AtomicLong count = new AtomicLong(0);  //原子变量
    int a = 0;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final Thead02 thead02 = new Thead02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thead02.service();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                thead02.service();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                thead02.service();
            }
        }).start();
        System.out.println(thead02.a);
    }

    public void service() {
        int c = this.count.intValue();
        System.out.println(Thread.currentThread().getName());
        lock.readLock();
        ++a;
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        if (c != this.count.intValue()) {
            throw new ConcurrentModificationException();
        }
        count.incrementAndGet();
    }
}
