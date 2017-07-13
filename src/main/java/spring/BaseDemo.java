package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.UserService;

/**
 * Created by tancw on 2017/7/13.
 */
public class BaseDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-all.xml"},true);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.show();
        System.out.println("over"+ context);
    }
}
