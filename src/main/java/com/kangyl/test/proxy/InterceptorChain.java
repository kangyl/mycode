/**
 * Copyright  2018
 */
package com.kangyl.test.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/25
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;

    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}
