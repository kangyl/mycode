package com.kangyl.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {


    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        if(classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }

        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
