package com.kangyl.test.remoteproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/19
 */
public class CglibProxyFactoryBean implements FactoryBean , InitializingBean{

    private Class[] proxyInterfaces;
    private Object proxy;
    public CglibProxyFactoryBean(Class[] proxyInterfaces) {
        this.proxyInterfaces = proxyInterfaces;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(proxyInterfaces);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if(method.getName().equals("queryDatas")){
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add("hello proxy");
                    return strings;
                }
                return null;
            }
        });
        this.proxy = enhancer.create();
    }

    @Override
    public Object getObject() throws Exception {
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return proxy.getClass();
    }
}
