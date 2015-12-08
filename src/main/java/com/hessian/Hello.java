package com.hessian;

/**
 * Created by tancw on 2015/12/1.
 */
public interface Hello {
     String sayHello(String name);

    default void desp(){
        System.out.println("say hello method");
    }
}
