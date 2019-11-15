package com.kangyl.test.aop.newaop;

import java.lang.reflect.Proxy;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class ProxyFactory {


    private ProxyFactory(){
    }

    public static <T> T getProxy(T t){
        JdkAopProxy jdkAopProxy = new JdkAopProxy(t, AdvisorChainBuilder.buildChain());
        Class<?>[] interfaces = t.getClass().getInterfaces();
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, jdkAopProxy);
    }

}
