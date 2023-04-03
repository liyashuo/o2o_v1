package com.immoc.spring_intro.bean;

/**
 * 学习Bean的配置项及作用域
 */
public class BeanScope {
    public void say() {
        //这里使用hashcode来区分不同的实例
        System.out.println("BeanScope say : " + this.hashCode());
    }
}
