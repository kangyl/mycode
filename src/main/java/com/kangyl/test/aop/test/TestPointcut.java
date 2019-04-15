package com.kangyl.test.aop.test;

import com.kangyl.test.aop.ClassFilter;
import com.kangyl.test.aop.MethodFilter;
import com.kangyl.test.aop.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
@Component("pointcut")
public class TestPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {

        return new ClassFilter() {
            @Override
            public boolean match(Class<?> clazz) {
                return clazz.isAssignableFrom(TestInterface.class);
            }
        };
    }

    @Override
    public MethodFilter methodFilter() {
        return new MethodFilter() {
            @Override
            public boolean match(Method method, Class<?> targetClass) {
                return true;
            }

            @Override
            public boolean match(Method method, Class<?> targetClass, Object object) {
                return false;
            }
        };
    }
}
