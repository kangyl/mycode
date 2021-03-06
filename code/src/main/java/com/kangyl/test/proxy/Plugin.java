/**
 * Copyright  2018
 */
package com.kangyl.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/25
 */
public class Plugin implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.execute(new Invocation(target, method, args));
    }
}
