/**
 * Copyright
 */
package com.kangyl.test.management;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/7
 */
public class Hello implements HelloMBean {

    private String name;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println(" hello the world");
    }

    @Override
    public void printHelloTo(String name) {
        System.out.println("hello " + name);
    }
}
