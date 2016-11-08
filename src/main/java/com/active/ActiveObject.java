package com.active;

/**
 * Created by qiao on 2016/11/9.
 */
public class ActiveObject extends Thread {

    public ActiveObject() {
        _queue = new ActiveQueue();
        start();
    }

    public void enqueue(MethodRequest mr) {
        _queue.enqueue(mr);
    }

    public void run() {
        while (true) {
            MethodRequest mr = _queue.dequeue();
            mr.call();
        }
    }

    private ActiveQueue _queue;
}
