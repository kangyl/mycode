package com.kangyl.test.aop;

import org.springframework.stereotype.Component;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
@Component("methodBeforeInterceptor")
public class MethodBeforeInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBeforeInterceptor(MethodBeforeAdvice methodBeforeAdvice) {
        this.methodBeforeAdvice = methodBeforeAdvice;
    }

    @Override
    public Object intercept(MethodInvocation invocation) {
        return invocation.invoke();
    }
}
