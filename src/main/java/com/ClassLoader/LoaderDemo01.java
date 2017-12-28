package com.ClassLoader;

public class LoaderDemo01 {


    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        try {
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
            Class<?> loader = Class.forName("com.ClassLoader.FileSystemClassLoader");
            System.out.println(loader.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
