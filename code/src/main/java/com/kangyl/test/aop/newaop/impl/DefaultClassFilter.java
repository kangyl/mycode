package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.ClassFilter;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class DefaultClassFilter implements ClassFilter {

    @Override
    public boolean match(Class clazz) {
        return true;
    }
}
