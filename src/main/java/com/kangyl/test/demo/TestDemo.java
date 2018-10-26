/**
 * Copyright
 */
package com.kangyl.test.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/26
 */
public class TestDemo {

    public static void main(String[] args) {
        Queue<String> task = new LinkedList<>();
        Producer producer = new Producer(task);
        Customer customer = new Customer(task);

        producer.start();
        customer.start();
    }
}
