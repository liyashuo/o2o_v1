package com.test.JavaGuide.Java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile 关键字能保证变量的可见性，但不能保证对变量的操作是原子性的。
 */
public class VolatileAtomicityDemo {

    public volatile static int inc = 0;

    /**
     * 第一种原子性方法：使用synchronized关键字
     */
    public volatile static int incAtomic_1 = 0;

    /**
     * 第二种原子性方法：使用AtomicInteger
     */
    public static AtomicInteger incAtomic_2 = new AtomicInteger();

    /**
     * 第三种原子性方法：使用ReentrantLock
     */
    public volatile static int incAtomic_3 = 0;
    /**
     * 第三种原子性方法：使用ReentrantLock
     */
    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                threadPool.execute(() -> {
                    for (int j = 0; j < 500; j++) {
                        volatileAtomicityDemo.increase();
                        //第一种原子性方法：使用synchronized关键字
                        volatileAtomicityDemo.increaseAtomic_1();
                        //第二种原子性方法：使用AtomicInteger
                        volatileAtomicityDemo.increaseAtomic_2();
                        //第三种原子性方法：使用ReentrantLock
                        volatileAtomicityDemo.increaseAtomic_3();
                    }
                });
            });
        }


        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println("非原子性：" + inc);
        System.out.println("synchronized关键字： " + incAtomic_1);
        System.out.println("使用AtomicInteger： " + incAtomic_2);
        System.out.println("使用ReentrantLock： " + incAtomic_3);
        threadPool.shutdown();
    }

    /**
     * 非原子性：每次输出结果都小于 2500
     */
    public void increase() {
        inc++;
    }

    /**
     * 第一种原子性方法：使用synchronized关键字
     */
    public synchronized void increaseAtomic_1() {
        incAtomic_1++;
    }

    /**
     * 第二种原子性方法：使用AtomicInteger
     */
    public void increaseAtomic_2() {
        incAtomic_2.getAndIncrement();
    }

    public void increaseAtomic_3() {
        lock.lock();
        try {
            incAtomic_3++;
        } finally {
            lock.unlock();
        }
    }

}
