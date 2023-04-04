package com.immoc.spring_intro.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoocBeanNameAware implements BeanNameAware, ApplicationContextAware {

    //重写了BeanNameAware里面的方法，根据name获取bean实例
    private String beanName;

    @Override
    public void setBeanName(String name) {

        this.beanName = name;
        System.out.println("MoocBeanNameAware name: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext: " + applicationContext.getBean(this.beanName).hashCode());
    }
}
