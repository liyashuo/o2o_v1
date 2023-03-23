package com.immoc.spring_intro.ioc.injection.service;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectionServiceSetterImplTest extends UnitTestBase {


    public InjectionServiceSetterImplTest() {
        super("classpath:spring_intro/spring-injection-setter.xml");
    }

    @Test
    public void save() {
        InjectionServiceSetterImpl service = super.getBean("injectionServiceSetter");
        service.save("这是要保存的数据");
    }
}