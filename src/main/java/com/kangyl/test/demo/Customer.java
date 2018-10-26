/**
 * Copyright
 */
package com.kangyl.test.demo;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/26
 */
public class Customer extends Thread {
    private Queue<String> queue;

    public Customer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    queue.notify();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String poll = queue.poll();
                System.out.println("消费者消费了一条任务:" + poll);
                queue.notify();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
