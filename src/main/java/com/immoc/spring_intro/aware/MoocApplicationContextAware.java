package com.immoc.spring_intro.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoocApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //声明一个成员变量并赋值，就可以在其他方法中使用context
        this.applicationContext = applicationContext;
        System.out.println("MoocApplicationContextAware: " + applicationContext.getBean("moocApplicationContextAware").hashCode());
    }
}
