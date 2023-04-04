package com.immoc.spring_intro.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 测试生命周期
 * 1，重写方法
 * 2，xml文件中init和destroy method
 * 3，default方法（有了1 2, 3就不生效）
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    public void defaultInit() {
        System.out.println("Bean defaultInit default-init-method.");
    }

    public void defaultDestroy() {
        System.out.println("Bean defaultDestroy default-destroy-method.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy override.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet override.");
    }

    public void start() {
        System.out.println("Bean start init-method.");
    }
    public void stop() {
        System.out.println("Bean stop destroy-method.");
    }
}
