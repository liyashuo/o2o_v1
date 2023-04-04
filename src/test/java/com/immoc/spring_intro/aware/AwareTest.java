package com.immoc.spring_intro.aware;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

public class AwareTest extends UnitTestBase {

    public AwareTest(){
        super("classpath*:spring_intro/spring-aware.xml");
    }

    @Test
    public void setApplicationContext() {

        //这里会测试MoocApplicationContextAware类中的setApplicationContext方法，所以会执行方法并打印

        //这里也可以自己写，根据UnitTestBase来获取bean，并对比
        System.out.println("MoocApplicationContextAwareTest super: " + super.getBean("moocApplicationContextAware").hashCode());
    }

    @Test
    public void testMoocBeanNameAware() {
        //还是区分MoocBeanNameAware中打印的hashCode，和test打印的hashCode
        System.out.println("testMoocBeanNameAware super: " + super.getBean("moocBeanNameAware").hashCode());
    }
}