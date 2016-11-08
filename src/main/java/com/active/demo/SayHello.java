package com.active.demo;

import com.active.MethodRequest;
import com.sun.deploy.services.Service;

/**
 * Created by qiao on 2016/11/9.
 */
public class SayHello implements MethodRequest {
    public SayHello(Service s) {
        _service = s;
    }

    public void call() {

    }

    private Service _service;
}
