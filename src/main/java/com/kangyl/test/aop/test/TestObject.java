package com.kangyl.test.aop.test;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class TestObject implements TestInterface {

    @Override
    public void testBeforeAdvice() {
        System.out.println("这是测试切面方法");
    }
}
