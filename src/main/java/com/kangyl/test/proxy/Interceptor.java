/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.proxy;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/25
 */
public interface Interceptor {

    Object execute(Invocation invocation)throws Throwable;

    Object plugin(Object object);


}
