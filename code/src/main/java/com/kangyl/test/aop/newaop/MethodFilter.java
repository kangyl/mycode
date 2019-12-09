package com.kangyl.test.aop.newaop;

import java.lang.reflect.Method;

/**
 *
 * 方法过滤器
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public interface MethodFilter {

    /**
     * 方法是否符合切面规则
     * @param method
     * @param clazz
     * @return
     */
    boolean match(Method method, Class clazz);
}
