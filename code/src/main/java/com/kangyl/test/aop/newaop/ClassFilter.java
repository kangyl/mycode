package com.kangyl.test.aop.newaop;

/**
 * 类过滤器
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public interface ClassFilter {

    /**
     * 是否匹配
     * @param clazz
     * @return
     */
    boolean match(Class clazz);
}
