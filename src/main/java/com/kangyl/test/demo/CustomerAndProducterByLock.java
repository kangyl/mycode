/**
 * Copyright
 */
package com.kangyl.test.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/26
 */
public class CustomerAndProducterByLock {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<String>();
    private static final int MAX_SIZE = 10;

    class Customer extends Thread {

        @Override
        public void run() {

            while (true) {
                lock.lock();
                try{
                    while (queue.size() == 0) {
                        condition.signal();
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String poll = queue.poll();
                    System.out.println("消费消费了一条任务");
                    condition.signal();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }

            }
        }

    }

    class Producter extends Thread {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try{
                    while (queue.size() == MAX_SIZE) {
                        condition.signal();
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.offer("1");
                    System.out.println("生产者生成了一个任务");
                    condition.signal();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        CustomerAndProducterByLock producterByLock = new CustomerAndProducterByLock();
        Customer customer =  producterByLock.new Customer();
        Producter producter = producterByLock.new Producter();
        customer.start();
        producter.start();
    }

}
