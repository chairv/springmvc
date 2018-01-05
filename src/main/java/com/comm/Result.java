package com.comm;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by tancw on 2015/11/26.
 */
public class Result {
    private boolean success;
    private String message;

    public Result(){}

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Result.class;
        Object obj = c.newInstance();
        BeanUtils.setProperty(obj,"message","1");
    }
}
