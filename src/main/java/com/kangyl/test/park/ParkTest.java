/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.park;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/8
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {
//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程1,获取PART");
//                LockSupport.park();
//                System.out.println( "线程1,,获取PART成功");
//            }
//        });
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程2,,获取PART");
////                LockSupport.unpark(thread);
//                System.out.println("线程2,获取PART成功");
//                try {
//                    Thread.sleep(5*1000);
//                    LockSupport.unpark(thread);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
////                LockSupport.park();
//            }
//        });
//
//        thread.start();
//        thread1.start();
//        LockSupport.unpark(Thread.currentThread());
//        System.out.println("a");
//        LockSupport.park();
//        System.out.println("bb");
//        LockSupport.park();

        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        Thread.sleep(2000);

        // 中断线程
        t.interrupt();


        System.out.println("main over");
    }
}
