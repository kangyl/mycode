/**
 * Copyright  2018
 */
package com.kangyl.test.serial;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/10
 */
public class TestAutoClose implements AutoCloseable {



    @Override
    public void close() throws Exception {
        System.out.println(" my object close by jvm");
    }
}
