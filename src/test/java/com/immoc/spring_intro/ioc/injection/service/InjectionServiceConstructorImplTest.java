package com.immoc.spring_intro.ioc.injection.service;

import com.immoc.spring_intro.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectionServiceConstructorImplTest extends UnitTestBase {

    public InjectionServiceConstructorImplTest() {
        super("");
    }

    @Test
    public void save() {

        InjectionServiceConstructorImpl service = super.getBean("injectionServiceConstructor");
        service.save("这是要保存的数据");
    }
}