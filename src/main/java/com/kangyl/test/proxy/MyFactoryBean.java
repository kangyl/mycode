/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.proxy;

import java.util.List;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/25
 */
public class MyFactoryBean {

    private List<Interceptor> plugins;
    private InterceptorChain interceptorChain;

    public InterceptorChain getInterceptorChain() {
        return interceptorChain;
    }

    public void setInterceptorChain(InterceptorChain interceptorChain) {
        this.interceptorChain = interceptorChain;
    }

    public List<Interceptor> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Interceptor> plugins) {
        this.plugins = plugins;
    }

    public Object init(TestObject testObject) {
        if (plugins != null) {
            for (Interceptor plugin : plugins) {
                interceptorChain.addInterceptor(plugin);
            }
            return interceptorChain.pluginAll(testObject);
        }
        return null;
    }
}
