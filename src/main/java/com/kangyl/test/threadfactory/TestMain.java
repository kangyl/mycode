/**
 * Copyright  2018
 */
package com.kangyl.test.threadfactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/4/14
 */
public class TestMain {

    public static void main(String[] args) {

        final TestThreadPoolFactory poolFactory = new TestThreadPoolFactory(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
//                throw new RuntimeException("sss");
                System.out.println("run");
            }

        };

        poolFactory.execute(runnable);
        poolFactory.shutdown();
    }


}
