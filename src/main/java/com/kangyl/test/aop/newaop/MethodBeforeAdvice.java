package com.kangyl.test.aop.newaop;

import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public interface MethodBeforeAdvice  extends BeforeAdvice {

    void before(Method method,Object target);
}
