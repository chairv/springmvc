package spring.bean;

import spring.aware.App;

public class BeanDemo {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object o = factory.getBean("c");
        App app = (App) o;
        System.out.println(app);

//        BeanFactory f = (BeanFactory) new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//        Object o = f.getBean("c");
//        App app = (App) o;
//        System.out.println(app);
    }
}
