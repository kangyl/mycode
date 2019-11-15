package com.kangyl.test.aop.newaop.test;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/16
 */
public class TestInterfaceImpl implements TestInterface {

    @Override
    public void before() {
        System.out.println("执行before");
    }

    @Override
    public void after() {
        System.out.println("执行after");
    }
}
