import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hessian.Hello;

import java.net.MalformedURLException;

/**
 * Created by tancw on 2015/12/1.
 */
public class HessianTest {

	@Test
	public void client() throws MalformedURLException {
		String url = "http://localhost:8080/springmvc5/hello.do";
		HessianProxyFactory factory = new HessianProxyFactory();
		Hello hello = (Hello) factory.create(Hello.class, url);
         System.out.println(hello.sayHello("Hessian"));
	}
}
