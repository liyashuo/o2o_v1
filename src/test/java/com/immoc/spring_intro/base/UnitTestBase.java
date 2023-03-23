package com.immoc.spring_intro.base;

import com.mysql.cj.util.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestBase {

    //ApplicationContext保存了Bean对象，也就是容器
    private ClassPathXmlApplicationContext context;

    private String springXmlpath;

    public UnitTestBase() {}

    //初始化方法，注意父方法可以接受子类的super函数传来的参数
    //注意extends的用法
    public UnitTestBase(String springXmlpath) {
        this.springXmlpath = springXmlpath;
    }

    @Before
    public void before() {
        //test执行之前，先判断springXmlpath是否为空，path根据构造器传入
        if(StringUtils.isNullOrEmpty(springXmlpath)){
            springXmlpath = "classpath*:spring_intro/spring-*.xml";
        }
        try {
            //下面是初始化Bean容器的方法 之一
            context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        context.destroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T)context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    //TODO: 复习泛型 T 的用法
    protected <T extends  Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e){
            e.printStackTrace();
            return null;
        }
    }

}

