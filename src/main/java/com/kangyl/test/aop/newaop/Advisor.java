package com.kangyl.test.aop.newaop;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public interface Advisor {

    /**
     * 获取切面
     * @return
     */
    Advice getAdvice();

    /**
     * 获取切点
     * @return
     */
    Pointcut getPointcut();
}
