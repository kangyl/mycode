/**
 * Copyright  2018
 */
package com.kangyl.test.reference;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/1
 */
public class TestJavap {


    public synchronized void test() {
        System.out.print(1);
    }

    public void test2() {
        String s = "11";
        synchronized (s) {
            System.out.print(s);
        }
    }
}
