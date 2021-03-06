package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.MethodFilter;

import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class MethodBeforeFilter implements MethodFilter {
    @Override
    public boolean match(Method method, Class clazz) {
        String name = method.getName();
        return name.contains("before");
    }
}
