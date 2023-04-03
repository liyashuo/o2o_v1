package com.immoc.spring_intro.bean;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanScopeTest extends UnitTestBase {

    public BeanScopeTest() {
        super("classpath*:spring_intro/spring-beanscope.xml");
    }

    @Test
    public void testSay() {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope1 = super.getBean("beanScope");
        beanScope1.say();
        //单例模式下，bean和bean1的say应该都是一样的
    }

    @Test
    public void testSay2() {
        //单例模式下，test1和test2的hashcode不一样；
        // 因为单元测试中每个方法执行前就会执行before和after，
        // test1和test2是从两个ioc容器中获取的，所以不一样
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();
    }
}