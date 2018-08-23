/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.proxy;


/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/25
 */
public class PagingPlugin implements Interceptor {

    public Object execute(Invocation invocation) throws Throwable {
        System.out.println("执行分页插件....");
        return invocation.procedd();
    }

    public Object plugin(Object object) {
        return ProxUtils.wrap(object, this);
    }


}
