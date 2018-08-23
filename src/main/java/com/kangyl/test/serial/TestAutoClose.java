/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.serial;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/3/10
 */
public class TestAutoClose implements AutoCloseable {



    @Override
    public void close() throws Exception {
        System.out.println(" my object close by jvm");
    }
}
