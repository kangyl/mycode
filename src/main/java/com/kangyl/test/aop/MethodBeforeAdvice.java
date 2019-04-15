package com.kangyl.test.aop;

import java.lang.reflect.Method;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public interface MethodBeforeAdvice extends Advice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
