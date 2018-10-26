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
public class Producer extends Thread {

    private static final int MAX_SIZE = 10;
    private Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {

        while (true) {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    queue.notify();

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add("1");
                queue.notify();
                System.out.println("生产者生产了一条任务");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
