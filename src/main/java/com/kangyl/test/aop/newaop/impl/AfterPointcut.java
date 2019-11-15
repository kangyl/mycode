package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.ClassFilter;
import com.kangyl.test.aop.newaop.MethodFilter;
import com.kangyl.test.aop.newaop.Pointcut;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/16
 */
public class AfterPointcut implements Pointcut {
    @Override
    public MethodFilter getMethodFilter() {
        return new MethodAfterFilter();
    }

    @Override
    public ClassFilter getClassFilter() {
        return new DefaultClassFilter();
    }
}
