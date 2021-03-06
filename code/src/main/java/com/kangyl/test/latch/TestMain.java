/**
 * Copyright  2018
 */
package com.kangyl.test.latch;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/28
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        LatchTest latchTest = new LatchTest();
        latchTest.testTime(20,runnable);

    }
}
