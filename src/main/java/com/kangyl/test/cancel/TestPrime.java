/**
 * Copyright  2018
 */
package com.kangyl.test.cancel;

/**
 * @author : kangyl(460720197@qq.com)
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
