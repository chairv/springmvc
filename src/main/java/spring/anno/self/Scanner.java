package spring.anno.self;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * Created by tancw on 2017/7/13.
 */
public class Scanner extends ClassPathBeanDefinitionScanner {
    public Scanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(CustComp.class));
    }

    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        for(BeanDefinitionHolder holder: beanDefinitions){
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.getPropertyValues().add("innerClassName",definition.getBeanClass());

        }
        return beanDefinitions;
    }


}
