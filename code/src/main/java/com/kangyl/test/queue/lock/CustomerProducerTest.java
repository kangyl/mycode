package com.kangyl.test.queue.lock;

import com.kangyl.test.queue.Customer;
import com.kangyl.test.queue.Producer;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class CustomerProducerTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Customer customer = new Customer(resource);
        Producer producer = new Producer(resource);
        Thread thread = new Thread(() -> {
            customer.consume();
        });
        Thread thread1 = new Thread(() -> {
            producer.produce();
        });
        thread.start();
        thread1.start();
    }
}
