package spring.parser;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) bf.getBean("testbean");
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
    }
}
