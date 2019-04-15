package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class DefaultPointcutAdvisor implements PointcutAdvisor {

    private Advice advice;
    private Pointcut pointcut;

    public DefaultPointcutAdvisor(Advice advice) {
        this.advice = advice;
        this.pointcut = new TruePointcut();
    }

    public DefaultPointcutAdvisor(Advice advice, Pointcut pointcut) {
        this.advice = advice;
        this.pointcut = pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
