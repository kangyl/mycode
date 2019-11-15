package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.MethodAfterAdvice;

import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class TestAfterAdvice implements MethodAfterAdvice {

    @Override
    public void after(Object returnValue, Method method, Object[] args, Object target) {
        System.out.println("后置切面生效");
    }
}
