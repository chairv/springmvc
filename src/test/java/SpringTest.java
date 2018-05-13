import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.service.UserService;

/**
 * Created by tancw on 2015/12/8.
 */
@ContextConfiguration("classpath:spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {


	@Autowired
	BeanFactory beanFactory;

	@Test
	public void test() {
		System.out.println("show");
		UserService userService = beanFactory.getBean(UserService.class);
		userService.show();
	}


	@Test
	public void test2(){

	}

	/**
	 * @param key 查找的值
	 * @param tableArea 查找的区间获取
	 * @param valueIndex 查找后,返回后面第几位
	 * @param dim  true: 非精确匹配,false:精确匹配
	 * @return
	 */
	public Object Vlookup(Object key, Collection tableArea,int valueIndex,boolean dim){
		return null;
	}
}
