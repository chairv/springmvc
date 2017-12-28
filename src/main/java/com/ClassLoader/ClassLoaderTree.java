package com.ClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTree {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        String classDataRootPath = "D:\\workspace2017\\springmvc\\src\\main\\java\\com\\ClassLoader";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.ClassLoader.Sample";

        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();

            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample",java.lang.Object.class);
            setSampleMethod.invoke(obj1,obj2);
            System.out.println(obj1.equals(obj2));
        } catch (Exception e) {

        }
    }
}
