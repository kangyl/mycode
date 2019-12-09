/**
 * Copyright  2018
 */
package com.kangyl.test.deadlock;

import java.util.concurrent.CountDownLatch;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/4/14
 */
public class LeftRightDeadLock {

    private final Object left = new Object();
    private final Object right = new Object();
    private final CountDownLatch countDownLatch;

    public LeftRightDeadLock(int num) {
        countDownLatch = new CountDownLatch(num);
    }

    public void right() {
        synchronized (right) {
            try {
                countDownLatch.await();
                Thread.sleep(2000);
                synchronized (left){
                    System.out.println("this is right lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }


    public void left() {
        synchronized (left) {
            try{
                countDownLatch.await();
                Thread.sleep(2000);

                synchronized (right) {
                    System.out.println(" this is left lock");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public void startTest() {
        countDownLatch.countDown();
    }
}
