package spring.anno.self;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created by tancw on 2017/7/13.
 */
public class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T> {
    private String innerClassName;

    public void setInnerClassName(String innerClassName) {
      this.innerClassName = innerClassName;
    }

    @Override
    public T getObject() throws Exception {
        Class innerClass = Class.forName(innerClassName);
        if (innerClass.isInterface()) {
            return (T) InterfaceProxy.newInstance(innerClass);
        }else{
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(innerClass);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(new MethodInterceptorImpl());
            return (T) enhancer.create();
        }
    }

    @Override
    public Class<?> getObjectType() {
        try{
         return Class.forName(innerClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public static class InterfaceProxy implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println("ObjectProxy execute:" + method.getName());
            return method.invoke(proxy, args);
        }

        public static <T> T newInstance(Class<T> innerInterface){
            ClassLoader classLoader = innerInterface.getClassLoader();
            Class[] interfaces = new Class[]{innerInterface};
            InterfaceProxy proxy = new InterfaceProxy();
            return (T) Proxy.newProxyInstance(classLoader,interfaces, (java.lang.reflect.InvocationHandler) proxy);
        }
    }

    public static class MethodInterceptorImpl implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("MethodIntereptorImpl: " + method.getName());
            return methodProxy.invokeSuper(o,objects);
        }
    }
}
