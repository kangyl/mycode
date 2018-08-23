/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/25
 */
public class ProxUtils {

    public static Object wrap(Object object,Interceptor interceptor) {

        Class<?> aClass = object.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?>[] interfaces = aClass.getInterfaces();

        return Proxy.newProxyInstance(classLoader, interfaces, new Plugin(object, interceptor));
    }
}
