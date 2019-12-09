/**
 * Copyright
 */
package com.kangyl.test.spi;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/11
 */
public class SpiMainTest {


    public static void main(String[] args) {
        TestSpi spi = MyServiceLoader.load(TestSpi.class, ClassLoader.getSystemClassLoader());
        spi.helloSpi();
        System.out.println(spi.getName());
    }
}
