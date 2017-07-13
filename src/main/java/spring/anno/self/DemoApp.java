package spring.anno.self;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tancw on 2017/7/13.
 */
@Configuration
public class DemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(DemoApp.class);
        ac.refresh();
        ScanClass scanClass = ac.getBean(ScanClass.class);
        scanClass.print();
    }
}
