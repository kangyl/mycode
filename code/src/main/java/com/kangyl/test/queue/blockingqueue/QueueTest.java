package com.kangyl.test.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;

public class QueueTest {

    private ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(100);


    class Consumer implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    Object take = blockingQueue.take();
                    System.out.println(String.valueOf(take));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费完毕");
            }
        }
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            produce("abc");
        }

        public void produce(String msg) {
            blockingQueue.offer(msg);
            System.out.println("生产完毕");
        }
    }


    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        Consumer consumer = queueTest.new Consumer();
        Producer producer = queueTest.new Producer();
        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);
        consumerThread.start();
        producerThread.start();

        for (int i = 0; i < 10; i++) {
            producer.produce("abc+" + i);
        }
    }
}
