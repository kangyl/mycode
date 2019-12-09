package com.kangyl.test.aop.newaop;

import java.lang.reflect.Method;


/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public interface AdvisorChain {

    void doMethodBefore(Method method, Class clazz, Object target);

    void doMethodAfter(Object result, Method method, Class clazz, Object[] args, Object target);
}
