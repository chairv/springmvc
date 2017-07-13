package spring.anno.self;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * Created by tancw on 2017/7/13.
 */
@Component
public class BeanScannerConfigurer implements BeanFactoryPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        Scanner scanner = new Scanner((BeanDefinitionRegistry) beanFactory);
        scanner.setResourceLoader(this.applicationContext);
        scanner.scan("spring.anno.self");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
