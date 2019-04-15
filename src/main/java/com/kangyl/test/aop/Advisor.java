package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public interface Advisor {

    /**
     * 获取切面
     * @return
     */
    Advice getAdvice();
}
