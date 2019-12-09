/**
 * Copyright  2018
 */
package com.kangyl.test.deadlock;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/4/14
 */
public class TestMain {
//    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        final LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock(1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.left();
            }
        });

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.right();
            }
        });
        thread1.start();

        leftRightDeadLock.startTest();

    }
}
