package spring.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tancw on 2017/7/13.
 */
@Configuration
public class AnDemoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(AnDemoTest.class);
        ac.refresh();
        InjectClass injectClass = ac.getBean(InjectClass.class);
        injectClass.print();
    }

    @MyService
    public static class InjectClass {
        public void print() {
            System.out.println("hello spring anno");
        }
    }
}
