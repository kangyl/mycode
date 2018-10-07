/**
 * Copyright
 */
package com.kangyl.test.management;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/7
 */
public interface HelloMBean {

    String getName();

    void setName(String name);

    void printHello();

    void printHelloTo(String name);
}
