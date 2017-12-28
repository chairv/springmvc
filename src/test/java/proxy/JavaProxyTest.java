package proxy;

import sun.misc.IOUtils;
import sun.misc.ProxyGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JavaProxyTest {

    @Test
    public void proxyTest() {
        System.out.println("begin");
        Map map = (Map) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(), new Class[]{}, new InvocationHandler() {
            Object target = new HashMap();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行前");
                Object result = method.invoke(target, args);
                System.out.println("执行后");
                return result;
            }
        });

        map.put("name", "lili");
        System.out.println(map);
    }


    @Test
    public void buildProxyByte() {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "HashMap$proxy", new Class[]{Map.class}, 1);
        System.out.println(Arrays.toString(proxyClassFile));
    }

    @Test
    public void testURL() throws IOException {
        URL url = new URL("http://www.ittun.con");
        URLConnection conn = url.openConnection();
        conn.connect();
        InputStream input = conn.getInputStream();
        byte[] bytes = IOUtils.readFully(input, -1, false);
        System.out.println(new String(bytes));
    }

}
