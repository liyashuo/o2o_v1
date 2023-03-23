package com.immoc.spring_intro.ioc.injection.dao;

//模拟DAO层，对数据库进行操作
public class InjectionDAOImpl implements InjectionDAO{
    public void save(String arg) {
        //模拟数据库保存操作
        System.out.println("保存数据：" + arg);
    }
}
