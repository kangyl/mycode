package com.kangyl.test.queue.object;

import com.kangyl.test.queue.Customer;
import com.kangyl.test.queue.IResource;
import com.kangyl.test.queue.Producer;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class Test {

    public static void main(String[] args) {
        IResource resource = new Resource();
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
