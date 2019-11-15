package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class TestBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object target) {
        System.out.println("前置切面生效");
    }
}
