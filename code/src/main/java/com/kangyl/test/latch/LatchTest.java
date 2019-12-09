/**
 * Copyright  2018
 */
package com.kangyl.test.latch;

import java.util.concurrent.CountDownLatch;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/3/28
 */
public class LatchTest{

    private class TestRun implements Runnable{
        @Override
        public void run() {

        }
    }

    public void testTime(int threadNum, final Runnable runnable)throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGagte = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i ++) {
            Thread t = new Thread() {
                public void run() {
                    try{
                        startGate.await();
                        try{
                            runnable.run();
                        }finally {
                            endGagte.countDown();
                        }
                    }catch (InterruptedException e){

                    }
                }
            };
            t.start();
        }
        long start = System.currentTimeMillis();
        System.out.println("开始执行");
        startGate.countDown();
        endGagte.await();
        long end = System.currentTimeMillis();
        System.out.println("执行了"+threadNum+"个线程，总计用时"+(end-start));
    }
}
