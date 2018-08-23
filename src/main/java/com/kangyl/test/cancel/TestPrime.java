/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.cancel;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/11
 */
public class TestPrime {

    public static void main(String[] args) {

        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            generator.cancel();
        }

        System.out.println(generator.get());
    }
}
