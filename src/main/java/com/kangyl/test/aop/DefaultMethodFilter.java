package com.kangyl.test.aop;

import java.lang.reflect.Method;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class DefaultMethodFilter implements MethodFilter {

    @Override
    public boolean match(Method method, Class<?> targetClass) {
        return true;
    }

    @Override
    public boolean match(Method method, Class<?> targetClass, Object object) {
        return true;
    }
}
