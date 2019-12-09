package com.kangyl.test.oom;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区内存溢出
 * 方法区主要存储类，方法等信息
 * -Xmx12m -Xms10m -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * jdk8以后PermSize和MaxPermSize已经不能使用
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/9
 */
public class MethodAreaOOMTest {

    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodAreaOOMTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args);
                }
            });
            enhancer.create();
        }
    }
}
