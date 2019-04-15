package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class DefaultClassFilter implements ClassFilter {

    @Override
    public boolean match(Class<?> clazz) {
        return true;
    }
}
