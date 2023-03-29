package com.test.JavaGuide.Java;

/**
 * << :左移运算符，向左移若干位，高位丢弃，低位补零。x << 1,相当于 x 乘以 2(不溢出的情况下)。
 * >> :带符号右移，向右移若干位，高位补符号位，低位丢弃。正数高位补 0,负数高位补 1。x >> 1,相当于 x 除以 2。
 * >>> :无符号右移，忽略符号位，空位都以 0 补齐。
 * ------
 * 著作权归所有
 * 原文链接：https://javaguide.cn/java/basis/java-basic-questions-01.html
 */
public class ShiftOperator {
    public static void main(String[] args) {
        int i = -1;
        System.out.println("初始数据： " + i);
        System.out.println("初始数据对应的二进制字符串： " + Integer.toBinaryString(i));
        i <<= 10;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));
        i <<= 42;
        //int 32位
        //long 64位
        System.out.println("int 左移 42 位后的数据 " + i);
        System.out.println("int 左移 42 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));
        i = 1;
        System.out.println("初始数据： " + i);
        System.out.println("初始数据对应的二进制字符串： " + Integer.toBinaryString(i));
        //注意左移，低位是补0
        i <<= 10;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));

    }
}
