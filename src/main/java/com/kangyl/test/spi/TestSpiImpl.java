/**
 * Copyright
 */
package com.kangyl.test.spi;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/11
 */
public class TestSpiImpl implements TestSpi {
    @Override
    public void helloSpi() {
        System.out.println("hello spi");
    }

    @Override
    public String getName() {
        return "kent";
    }

}
