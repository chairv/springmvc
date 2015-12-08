package com.dao.mapper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by tancw on 2015/12/8.
 */
public class InitBeanTest implements InitializingBean,ApplicationContextAware ,BeanDefinitionRegistryPostProcessor {

    private ApplicationContext applicationContext;

    public InitBeanTest(){
        System.out.println("1. 实例化InitBeantest");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2. afterPropertiesSet");
    }

    public static void main(String[] args) {
        InitBeanTest initBeanTest = new InitBeanTest();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("3. postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("4. postProcessBeanFactory");
    }
}
