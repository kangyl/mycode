package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class MethodBeforeAdviceAdapter implements AdvisorAdapter {

    @Override
    public boolean support(Advice advice) {
        return advice instanceof MethodBeforeAdvice;
    }

    @Override
    public MethodInterceptor getMethodInterceptor(Advisor advisor) {
        MethodBeforeAdvice advice = (MethodBeforeAdvice) advisor.getAdvice();
        return new MethodBeforeInterceptor(advice);
    }
}
