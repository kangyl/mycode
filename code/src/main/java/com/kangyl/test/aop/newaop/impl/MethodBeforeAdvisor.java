package com.kangyl.test.aop.newaop.impl;

import com.kangyl.test.aop.newaop.Advice;
import com.kangyl.test.aop.newaop.Advisor;
import com.kangyl.test.aop.newaop.Pointcut;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class MethodBeforeAdvisor implements Advisor {

    @Override
    public Advice getAdvice() {
        return new TestBeforeAdvice();
    }

    @Override
    public Pointcut getPointcut() {
        return new BeforePointcut();
    }
}
