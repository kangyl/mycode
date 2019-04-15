package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class TruePointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new DefaultClassFilter();
    }

    @Override
    public MethodFilter methodFilter() {
        return new DefaultMethodFilter();
    }

}
