package com.active;

import java.util.Stack;

/**
 * Created by qiao on 2016/11/9.
 */
public class ActiveQueue {

    public ActiveQueue() {
        this._queue = new Stack();
    }

    public synchronized void enqueue(MethodRequest mr) {
        while (_queue.size() > QUEUE_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _queue.push(mr);
        notifyAll();
        System.out.println("Leave Queue");
    }

    public synchronized MethodRequest dequeue() {
        MethodRequest mr;
        while (_queue.empty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mr = (MethodRequest) _queue.pop();
        notifyAll();
        return mr;
    }

    private Stack _queue;
    private final static int QUEUE_SIZE = 20;
}