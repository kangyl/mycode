/**
 * Copyright  2018
 */
package com.kangyl.test.proxy;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/25
 */
public interface Interceptor {

    Object execute(Invocation invocation)throws Throwable;

    Object plugin(Object object);


}
