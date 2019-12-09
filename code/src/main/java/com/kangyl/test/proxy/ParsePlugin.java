/**
 * Copyright  2018
 */
package com.kangyl.test.proxy;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/25
 */
public class ParsePlugin implements Interceptor {

    public Object execute(Invocation invocation) throws Throwable {
        System.out.println("执行解析插件插件....");
        return invocation.procedd();
    }

    public Object plugin(Object object) {
        return ProxyUtils.wrap(object, this);
    }
}
