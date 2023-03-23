package com.immoc.spring_intro.ioc.injection.service;

import com.immoc.spring_intro.ioc.injection.dao.InjectionDAO;

public class InjectionServiceSetterImpl implements InjectionService{

    private InjectionDAO injectionDAO1234;

    public InjectionServiceSetterImpl() {
    }

    //设值注入
    public void setInjectionDAO1234(InjectionDAO injectionDAO56789) {
        this.injectionDAO1234 = injectionDAO56789;
    }

    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ": " + this.hashCode();
        injectionDAO1234.save(arg);
    }
}
