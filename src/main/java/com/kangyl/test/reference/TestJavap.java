/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.reference;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
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
