package com.immoc.spring_intro.ioc.injection.service;

import com.immoc.spring_intro.ioc.injection.dao.InjectionDAO;

public class InjectionServiceConstructorImpl implements InjectionService{

    private InjectionDAO injectionDAO1234;

    public InjectionServiceConstructorImpl() {
    }

    //构造器注入
    public InjectionServiceConstructorImpl(InjectionDAO injectionDAO5678) {
        this.injectionDAO1234 = injectionDAO5678;
    }

    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ": " + this.hashCode();
        injectionDAO1234.save(arg);
    }
}
