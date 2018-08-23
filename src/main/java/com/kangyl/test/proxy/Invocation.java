/**
 * Copyright  2018
 */
package com.kangyl.test.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/25
 */
public class Invocation {

    private Object target;

    private Method method;

    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object procedd() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, args);
    }
}
