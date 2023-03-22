package com.immoc.spring_intro.ioc.interfaces;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

//注意是extends，不是implements
public class OneInterfaceImplTest extends UnitTestBase {

    public OneInterfaceImplTest() {
        super("classpath*:spring-ioc.xml");
    }

    @Test
    public void testSay() {
        OneInterface oneInterface = super.getBean("oneInterface");
        oneInterface.say("this is a test.");
    }
}