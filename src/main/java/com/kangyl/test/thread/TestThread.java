/**
 * Copyright
 */
package com.kangyl.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/14
 */
public class TestThread {

    public static void main(String[] args) {
        Integer i = 2 | 4;
        int state = 2 &i;

        System.out.println(Integer.toBinaryString(state));

    }
}
