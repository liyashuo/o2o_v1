package com.immoc.spring_intro.bean;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanLifeCycleTest extends UnitTestBase {

    public BeanLifeCycleTest() {
        super("classpath*:spring_intro/spring-lifecycle.xml");
    }

    @Test
    public void testBeanLifeCycle(){
        super.getBean("beanLifeCycle");
    }
}