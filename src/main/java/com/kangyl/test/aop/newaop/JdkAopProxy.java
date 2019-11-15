package com.kangyl.test.aop.newaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class JdkAopProxy implements InvocationHandler {

    /**
     * 代理对象
     */
    private Object target;

    /**
     * 切面链
     */
    private AdvisorChain advisorChain;

    public JdkAopProxy(Object target,AdvisorChain advisorChain) {
        this.target = target;
        this.advisorChain = advisorChain;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advisorChain.doMethodBefore(method, target.getClass(), target);
        Object result = method.invoke(target, args);
        advisorChain.doMethodAfter(result,method,target.getClass(),args,target);
        return result;
    }
}
